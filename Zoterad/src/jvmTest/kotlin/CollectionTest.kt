import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class CollectionTest {
    //T2 - UC3 - SDA2 Basic Scenario
    @Test
    fun createCollectionBasic() {
        val database = Database()
        val client = HttpClient()
        val title = "Title"
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddCollectionMainEvent(title))
    }

    //T2.2 - UC3 - SDA2 Alternate Scenario
    @Test
    fun createCollectionAlternate() {
        val database = Database()
        val client = HttpClient()
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.AddCollectionMainEvent(""))
    }

    @Test
    fun deleteCollectionBasic() {
        val database = Database()
        val client = HttpClient()
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        component.reduce(MainEvent.DeleteCollectionMainEvent("title"))
    }

    @Test
    fun deleteCollectionAlternate() {
        val database = Database()
        val client = HttpClient()
        val component = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )

        component.reduce(MainEvent.DeleteCollectionMainEvent("title"))
        println("Cancel pressed. deleteCollectionAlternate()")
    }
}