package main.main

import collection.data.entity.ZoteroCollection
import collection.domain.ICollectionRepository
import item.domain.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sync.domain.ISyncRepository

// wtf is going on?
class MainComponent(
    private val collectionRepository: ICollectionRepository,
    private val itemRepository: ItemRepository,
    private val syncRepository: ISyncRepository,
) {
    var mainState = MainState()

    fun reduce(mainEvent: MainEvent) {
        CoroutineScope(Dispatchers.Unconfined).launch {
            when (mainEvent) {
                is MainEvent.AddCollectionMainEvent -> {
                    val collection = ZoteroCollection(mainEvent.title, mutableListOf())
                    collectionRepository.addCollection(mainEvent.title)
                    mainState.collections.add(collection)
                }
                is MainEvent.AddItemByIDMainEvent -> TODO()
                is MainEvent.AddItemMainEvent -> {
                    if (itemRepository.addItem(mainEvent.item).isSuccess) {
                        if (mainState.collections.isEmpty()) {
                            println("Need to create a collection")
                            return@launch
                        }
                        mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                    }
                }
                is MainEvent.DeleteCollectionMainEvent -> {
                    collectionRepository.deleteCollection(mainEvent.title)
                    mainState.collections.remove(mainState.collections.find { it.title == mainEvent.title })
                }
                is MainEvent.DeleteItemMainEvent -> {
                    itemRepository.deleteItem(mainEvent.item)
                        .onSuccess {
                            mainState.collections[mainState.collectionIndex].items.removeAt(0)
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is MainEvent.RenameCollectionMainEvent -> {

                }
                MainEvent.SyncLibraryMainEvent -> {
                    syncRepository.syncLibrary()
                        .onSuccess {
                            println("Library successfully synced")
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is MainEvent.UpdateItemMainEvent -> {
                    itemRepository
                        .updateItem(mainEvent.collectionTitle, mainEvent.item)
                        .onSuccess {
                            if (mainState.collections.isEmpty()) {
                                println("Need to create a collection")
                                return@launch
                            }
                            if (mainState.collections[mainState.collectionIndex].items.isEmpty()) {
                                println("Need to add items")
                                return@launch
                            }
                            mainState.collections[mainState.collectionIndex].items.removeAt(0)
                            mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                        }
                }
                is MainEvent.QuickSearchMainEvent -> {
                    itemRepository.getItemsByTitle(mainEvent.itemTitle)
                        .onSuccess {
                            println("Items found: $it")
                        }
                        .onFailure {
                            it.printStackTrace()
                        }
                }
            }
        }
    }
}