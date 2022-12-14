package item.data

import data.database.Database
import item.data.entity.SearchQuery
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem
import item.domain.ItemRepository

class LocalItemRepository(
    collectionIndex: Int,
    database: Database,
) : ItemRepository {
    override suspend fun getItemByTitle(title: String): Result<ZoteroItem> {
        println("LocalRepository: getItemByTitle(title)")
        return Result.success(Book(bookRelatedSubData = BookRelatedSubData()))
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