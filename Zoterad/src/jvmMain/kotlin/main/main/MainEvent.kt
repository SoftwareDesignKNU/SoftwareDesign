package main.main

import item.data.entity.item.ZoteroItems

sealed interface MainEvent {
    object SyncLibraryMainEvent : MainEvent

    @JvmInline
    value class AddCollectionMainEvent(val title: String) : MainEvent

    data class RenameCollectionMainEvent(val title: String, val newTitle: String) : MainEvent

    @JvmInline
    value class DeleteCollectionMainEvent(val title: String) : MainEvent

    @JvmInline
    value class AddItemByIDMainEvent(val id: String) : MainEvent

    data class DeleteItemMainEvent(val collectionTitle: String, val item: ZoteroItems) : MainEvent

    data class AddItemMainEvent(val collectionTitle: String, val item: ZoteroItems) : MainEvent

    data class UpdateItemMainEvent(
        val collectionTitle: String,
        val item: ZoteroItems,
        val newItem: ZoteroItems,
    ) : MainEvent
}