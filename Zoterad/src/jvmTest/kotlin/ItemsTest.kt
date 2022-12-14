import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class ItemsTest {
     //T7 - UC1 - SDA7 Basic 
    @Test
    fun addItemToLibraryBasic() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }
    
    //T7.2 - UC1 - SDA7 Alternate Scenario
    @Test
    fun addItemToLibraryAlternate() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddItemMainEvent("title", item))
    }
    //T9 - UC2 - SDA9 Basic Scenario
    @Test
    fun updateItemBasic() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item))
    }
     //T9.2 - UC2 - SDA9 Alternate Scenario
    @Test
    fun updateItemAlternate() {
//        val rep = LocalItemRepository(0)
//        val updatedItem: ZoteroItem = rep.getItemByTitle("title")
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.UpdateItemMainEvent("title", item, item))
    }

      //T4 - UC4 - SDA4 Basic Scenario
    @Test
    fun deleteItemFromLibraryBasic() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))
    }

    @Test
    //T4.2 - UC4 - SDA4 Alternate Scenario
    fun deleteItemFromLibraryAlternate() {
        val database = Database()
        val client = HttpClient()
        val item: ZoteroItem = Book(bookRelatedSubData = BookRelatedSubData())
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )

        component.reduce(MainEvent.DeleteItemMainEvent("title", item))

        println("Cancel pressed.")
    }

}