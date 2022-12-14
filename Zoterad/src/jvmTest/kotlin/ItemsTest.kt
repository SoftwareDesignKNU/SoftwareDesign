import collection.data.LocalCollectionRepository
import item.data.LocalItemRepository
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class ItemsTest {
    @Test
    fun addItemToLibraryBasic() {
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(),
            itemRepository = LocalItemRepository(0),
            syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }

    @Test
    fun addItemToLibraryAlternate() {

        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }

    @Test
    fun updateItemBasic() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")

        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item) )
    }

    @Test
    fun updateItemAlternate() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")

        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item) )
    }

    @Test
    fun deleteItemFromLibraryBasic() {
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))
    }

    @Test
    fun deleteItemFromLibraryAlternate() {
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))

        println("Cancel pressed.")
    }

}