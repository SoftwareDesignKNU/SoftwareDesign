package collection.domain

import collection.data.entity.ZoteroCollection
import item.data.entity.item.ZoteroItem

interface ICollectionRepository {
    suspend fun getCollection(title: String): Result<ZoteroCollection>
<<<<<<< HEAD:Zoterad/src/commonMain/kotlin/collection/domain/ICollectionRepository.kt
    suspend fun addCollection(item: ZoteroCollection): Result<Unit>
    suspend fun deleteCollection(item: String): Result<String>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Unit>
=======
    suspend fun addCollection(title: String): Result<Nothing>
    suspend fun deleteCollection(item: ZoteroCollection): Result<Nothing>
    suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Nothing>;
    suspend fun getItemByTitle(zoteroItemTitle: String): Result<ZoteroItem>
>>>>>>> 17e68413d7dcc1b9327eef9849fd13add2378197:Zoterad/src/jvmMain/kotlin/collection/domain/ICollectionRepository.kt
}