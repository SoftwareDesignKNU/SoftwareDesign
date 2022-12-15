package collection.data

import collection.data.entity.ZoteroCollection
import collection.domain.ICollectionRepository
import data.database.Database
import item.data.entity.item.*

class LocalCollectionRepository(
    private val database: Database,
) : ICollectionRepository {
    override suspend fun getCollection(title: String): Result<ZoteroCollection> {
        println("LocalCollectionRepository: getCollection(title)")
        return Result.success(
            ZoteroCollection(
                "title",
                mutableListOf(ZoteroItem.ComplexZoteroItem(hashMapOf("Language" to ZoteroItem.ZoteroItemField("English"))))
            )
        )
    }

    override suspend fun addCollection(title: String): Result<Unit> {
        return try {
            database.libraries.add(ZoteroCollection(title, mutableListOf()))
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteCollection(item: String): Result<String> {
        println("LocalCollectionRepository: deleteCollection(item)")
        return Result.success("Deleted")
    }

    override suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Unit> {
        println("LocalCollectionRepository: updateCollection(title, newCollection)")
        return Result.success(Unit)
    }

    override suspend fun getItemByTitle(zoteroItemTitle: String): Result<ZoteroItem> {
        database.libraries.forEach {
            it.items.find { zoteroItem ->
                zoteroItem is ZoteroItem.ComplexZoteroItem && zoteroItem.values["title"]?.equals(zoteroItemTitle) == true
            }?.let { Result.success(it) } ?: Result.failure(Exception("There is not such item"))
        }
        return Result.failure(Exception("There is not such item"))
    }
}