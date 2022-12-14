package collection.domain

import collection.data.entity.ZoteroCollection

interface ICollectionRepository {
    suspend fun getCollection(title: String): Result<ZoteroCollection>
    suspend fun addCollection(item: ZoteroCollection): Result<Unit>
    suspend fun deleteCollection(item: String): Result<String>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Unit>
}