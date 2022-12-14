package collection.domain

import collection.data.entity.ZoteroCollection

interface ICollectionRepository {
    suspend fun getCollection(title: String): Result<ZoteroCollection>
    suspend fun addCollection(item: ZoteroCollection): Result<Nothing>
    suspend fun deleteCollection(item: ZoteroCollection): Result<Nothing>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Nothing>;
}