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
}