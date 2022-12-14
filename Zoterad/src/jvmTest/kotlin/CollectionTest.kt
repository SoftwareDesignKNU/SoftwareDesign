import collection.data.LocalCollectionRepository
import item.data.LocalItemRepository
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class CollectionTest {
    @Test
    fun createCollectionBasic(){
        val title = "Title"
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.AddCollectionMainEvent(title))
    }

    @Test
    fun createCollectionAlternate() {
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.AddCollectionMainEvent(""))
    }

    @Test
    fun deleteCollectionBasic() {
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )
        component.reduce(MainEvent.DeleteCollectionMainEvent("title"))
    }

    @Test
    fun deleteCollectionAlternate() {
        val component = MainComponent(
                collectionRepository = LocalCollectionRepository(),
                itemRepository = LocalItemRepository(0),
                syncRepository = SyncRepository()
        )

        component.reduce(MainEvent.DeleteCollectionMainEvent("title"))
        println("Cancel pressed. deleteCollectionAlternate()")
    }
}