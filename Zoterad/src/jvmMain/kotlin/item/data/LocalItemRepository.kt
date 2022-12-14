package item.data

import data.database.Database
import item.data.entity.SearchQuery
import item.data.entity.item.*
import item.domain.ItemRepository

class LocalItemRepository(
    private val collectionIndex: Int,
    private val database: Database,
) : ItemRepository {
    override suspend fun getItemsByTitle(title: String): Result<List<ZoteroItem>> {
        println("LocalRepository: getItemByTitle(title)")
        return Result.success(database.libraries[collectionIndex].items.filter { zoteroItem ->
            when (zoteroItem) {
                is Book -> {
                    zoteroItem.bookRelatedSubData.itemSubData.title == title
                }
                is BookSection -> {
                    zoteroItem.bookRelatedSubData.itemSubData.title == title
                }
                is Document -> {
                    zoteroItem.itemSubData.title == title
                }
                else -> false
            }
        })
    }

    override suspend fun addItem(item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: addItem(item)")
        return Result.success(Unit)
    }

    override suspend fun deleteItem(item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: deleteItem(item)")
        return Result.success(Unit)
    }

    override suspend fun updateItem(title: String, item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: updateItem(title, item)")
        return Result.success(Unit)
    }

    override suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>) {
        TODO("Not yet implemented")
    }
}