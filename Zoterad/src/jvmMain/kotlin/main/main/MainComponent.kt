package main.main

import collection.domain.ICollectionRepository
import item.domain.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sync.domain.ISyncRepository

class MainComponent(
    private val collectionRepository: ICollectionRepository,
    private val itemRepository: ItemRepository,
    private val syncRepository: ISyncRepository,
) {
    var mainState = MainState()

    fun reduce(mainEvent: MainEvent) {
        CoroutineScope(Dispatchers.Unconfined).launch {
            when (mainEvent) {
                is MainEvent.AddCollectionMainEvent -> TODO()
                is MainEvent.AddItemByIDMainEvent -> TODO()
                is MainEvent.AddItemMainEvent -> {
                    if (itemRepository.addItem(mainEvent.item).isSuccess) {
                        mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                    }
                }
                is MainEvent.DeleteCollectionMainEvent -> TODO()
                is MainEvent.DeleteItemMainEvent -> {
                    itemRepository.deleteItem(mainEvent.item).onSuccess {
                        mainState.collections[mainState.collectionIndex].items.removeAt(0)
                    }
                }
                is MainEvent.RenameCollectionMainEvent -> TODO()
                MainEvent.SyncLibraryMainEvent -> {
                    syncRepository.syncLibrary()
                        .onSuccess {
                            println("Library successfully synced")
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is MainEvent.UpdateItemMainEvent -> {
                    if (itemRepository.updateItem(mainEvent.collectionTitle, mainEvent.item).isSuccess) {
                        mainState.collections[mainState.collectionIndex].items.removeAt(0)
                        mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                    }
                }
            }
        }
    }
}