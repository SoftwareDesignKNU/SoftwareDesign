import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItems
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class ItemsTest {
    @Test
    fun addItemToLibraryBasic() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }

    @Test
    fun addItemToLibraryAlternate() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }

    @Test
    fun updateItemBasic() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item))
    }

    @Test
    fun updateItemAlternate() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item))
    }

    @Test
    fun deleteItemFromLibraryBasic() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))
    }

    @Test
    fun deleteItemFromLibraryAlternate() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItems = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))

        println("Cancel pressed.")
    }

}