package collection.domain

import collection.data.entity.ZoteroCollection
import item.data.entity.item.ZoteroItem

interface ICollectionRepository {
    suspend fun getCollection(title: String): Result<ZoteroCollection>
    suspend fun deleteCollection(item: String): Result<String>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Unit>
    suspend fun addCollection(title: String): Result<Unit>
    suspend fun getItemByTitle(zoteroItemTitle: String): Result<ZoteroItem>
}