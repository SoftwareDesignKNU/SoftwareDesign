package collection.data

import collection.data.entity.ZoteroCollection
import collection.domain.ICollectionRepository

class LocalCollectionRepository : ICollectionRepository {
    override suspend fun getCollection(title: String): Result<ZoteroCollection> {
        TODO("Not yet implemented")
    }

    override suspend fun addCollection(item: ZoteroCollection): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCollection(item: ZoteroCollection): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCollection(title: String, newCollection: ZoteroCollection): Result<Nothing> {
        TODO("Not yet implemented")
    }
}