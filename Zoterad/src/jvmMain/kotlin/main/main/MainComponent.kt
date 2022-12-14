package main.main

import collection.data.entity.ZoteroCollection
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
                is MainEvent.AddCollectionMainEvent -> {
                    val collection = ZoteroCollection("title", mutableListOf())
                    collectionRepository.addCollection(collection)
                    mainState.collections.add(collection)
                }
                is MainEvent.AddItemByIDMainEvent -> TODO()
                is MainEvent.AddItemMainEvent -> {
                    if (itemRepository.addItem(mainEvent.item).isSuccess) {
                        mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                    }
                }
                is MainEvent.DeleteCollectionMainEvent -> {
                        collectionRepository.deleteCollection(mainEvent.title)
                        mainState.collections.remove(mainState.collections.find { it.title == mainEvent.title })
                }
                is MainEvent.DeleteItemMainEvent -> {
                    if(itemRepository.deleteItem(mainEvent.item).isSuccess) {
                        mainState.collections[mainState.collectionIndex].items.removeAt(0)
                    }
                }
                is MainEvent.RenameCollectionMainEvent -> {
                    
                }
                MainEvent.SyncLibraryMainEvent -> TODO()
                is MainEvent.UpdateItemMainEvent -> {
                    if(itemRepository.updateItem(mainEvent.collectionTitle, mainEvent.item).isSuccess) {
                        mainState.collections[mainState.collectionIndex].items.removeAt(0)
                        mainState.collections[mainState.collectionIndex].items.add(mainEvent.item)
                    }
                }
            }
        }
    }
}