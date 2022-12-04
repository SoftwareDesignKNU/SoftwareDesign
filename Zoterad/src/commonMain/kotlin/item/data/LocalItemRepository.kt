package item.data

import item.data.entity.SearchQuery
import item.data.entity.item.ZoteroItem
import item.domain.ItemRepository

class LocalItemRepository : ItemRepository {
    override suspend fun getItemByTitle(title: String): Result<ZoteroItem> {
        TODO("Not yet implemented")
    }

    override suspend fun addItem(item: ZoteroItem): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: ZoteroItem): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem(title: String, item: ZoteroItem): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>) {
        TODO("Not yet implemented")
    }
}