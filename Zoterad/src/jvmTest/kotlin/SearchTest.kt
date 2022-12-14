import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import main.main.MainComponent
import main.main.MainEvent
import sync.data.SyncRepository
import kotlin.test.Test

class SearchTest {
    @Test
    fun quickSearchBasicFlow() {
        val database = Database()
        val client = HttpClient()
        val mainComponent = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        mainComponent.reduce(MainEvent.QuickSearchMainEvent("Title"))
    }
}