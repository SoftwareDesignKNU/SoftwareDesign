package main.main

import collection.domain.ICollectionRepository
import item.domain.ItemRepository
import sync.domain.ISyncRepository

class MainComponent(
    private val collectionRepository: ICollectionRepository,
    private val itemRepository: ItemRepository,
    private val syncRepository: ISyncRepository,
) {
    var mainState = MainState()

    fun reduce(mainEvent: MainEvent) {
        when (mainEvent) {
            is MainEvent.AddCollectionMainEvent -> TODO()
            is MainEvent.AddItemByIDMainEvent -> TODO()
            is MainEvent.AddItemMainEvent -> TODO()
            is MainEvent.DeleteCollectionMainEvent -> TODO()
            is MainEvent.DeleteItemMainEvent -> TODO()
            is MainEvent.RenameCollectionMainEvent -> TODO()
            MainEvent.SyncLibraryMainEvent -> TODO()
            is MainEvent.UpdateItemMainEvent -> TODO()
        }
    }
}