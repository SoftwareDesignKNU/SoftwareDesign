package collection.domain

import collection.data.entity.ZoteroCollection
import item.data.entity.item.ZoteroItem

interface ICollectionRepository {
    suspend fun getCollection(title: String): Result<ZoteroCollection>
    suspend fun addCollection(title: String): Result<Nothing>
    suspend fun deleteCollection(item: ZoteroCollection): Result<Nothing>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Nothing>;
    suspend fun getItemByTitle(zoteroItemTitle: String): Result<ZoteroItem>
}