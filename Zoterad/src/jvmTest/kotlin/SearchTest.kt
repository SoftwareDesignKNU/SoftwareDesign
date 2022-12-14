import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import item.data.entity.Condition
import item.data.entity.SearchQuery
import main.advanced_search.presentation.AdvancedSearchComponent
import main.advanced_search.presentation.AdvancedSearchEvent
import main.advanced_search.presentation.AdvancedSearchState
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
        mainComponent.reduce(MainEvent.QuickSearchMainEvent("Differential Geometry"))
    }

    @Test
    fun quickSearchAlternativeFlow() {
        val database = Database()
        val client = HttpClient()
        val mainComponent = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        mainComponent.reduce(MainEvent.QuickSearchMainEvent("Does not exist"))
    }

    @Test
    fun advancedSearchBasicFlow() {
        val database = Database()
        val advancedSearchComponent = AdvancedSearchComponent(LocalItemRepository(0, database))
        advancedSearchComponent.advancedSearchState = AdvancedSearchState(
            matchAll = true,
            searchQueries = listOf(
                SearchQuery(
                    searchField = "language",
                    condition = Condition.Contains,
                    query = "Eng"
                )
            )
        )
        advancedSearchComponent.reduce(AdvancedSearchEvent.SearchClickAdvancedSearchEvent)
    }

    @Test
    fun advancedSearchAlternativeFlow() {
        val database = Database()
        val advancedSearchComponent = AdvancedSearchComponent(LocalItemRepository(0, database))
        advancedSearchComponent.advancedSearchState = AdvancedSearchState(
            matchAll = true,
            searchQueries = listOf(
                SearchQuery(
                    searchField = "language1",
                    condition = Condition.Contains,
                    query = "Eng"
                )
            )
        )
        advancedSearchComponent.reduce(AdvancedSearchEvent.SearchClickAdvancedSearchEvent)
    }
}