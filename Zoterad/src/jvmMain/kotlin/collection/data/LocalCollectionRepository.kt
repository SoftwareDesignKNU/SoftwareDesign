package collection.data

import collection.data.entity.ZoteroCollection
import collection.domain.ICollectionRepository
import data.database.Database
import item.data.entity.item.Book
import item.data.entity.item.BookSection
import item.data.entity.item.Document
import item.data.entity.item.ZoteroItem

class LocalCollectionRepository(
    private val database: Database,
) : ICollectionRepository {
    override suspend fun getCollection(title: String): Result<ZoteroCollection> {
        TODO("Not yet implemented")
    }

    override suspend fun addCollection(title: String): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCollection(item: ZoteroCollection): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun getItemByTitle(zoteroItemTitle: String): Result<ZoteroItem> {
        database.libraries.forEach {
            return it.items.find { zoteroItem ->
                when (zoteroItem) {
                    is Book -> {
                        zoteroItem.bookRelatedSubData.itemSubData.title == zoteroItemTitle
                    }
                    is BookSection -> {
                        zoteroItem.bookRelatedSubData.itemSubData.title == zoteroItemTitle
                    }
                    is Document -> {
                        zoteroItem.itemSubData.title == zoteroItemTitle
                    }
                    else -> false
                }
            }?.let { Result.success(it) } ?: Result.failure(Exception("There is not such item"))
        }
        return Result.failure(Exception("There is not such item"))
    }
}