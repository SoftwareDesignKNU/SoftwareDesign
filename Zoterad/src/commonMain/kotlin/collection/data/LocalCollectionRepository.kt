package collection.data

import collection.data.entity.ZoteroCollection
import collection.domain.ICollectionRepository
import common.data.database.Database
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem

class LocalCollectionRepository(
    private val database: Database = Database()
) : ICollectionRepository {
    override suspend fun getCollection(title: String): Result<ZoteroCollection> {
        println("LocalCollectionRepository: getCollection(title)")
        return Result.success(ZoteroCollection("title", mutableListOf(Book(bookRelatedSubData = BookRelatedSubData()))))
    }

    override suspend fun addCollection(item: ZoteroCollection): Result<Unit> {
        println("LocalCollectionRepository: addCollection(item)")
        return Result.success(Unit)
    }

    override suspend fun deleteCollection(item: String): Result<String> {
        println("LocalCollectionRepository: deleteCollection(item)")
        return Result.success("Deleted")
    }

    override suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Unit> {
        println("LocalCollectionRepository: updateCollection(title, newCollection)")
        return Result.success(Unit)
    }
}