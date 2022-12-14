package item.domain

import item.data.entity.SearchQuery
import item.data.entity.item.ZoteroItem

interface ItemRepository {
    suspend fun getItemByTitle(title: String): Result<ZoteroItem>
    suspend fun addItem(item: ZoteroItem): Result<Unit>
    suspend fun deleteItem(item: ZoteroItem): Result<Unit>
    suspend fun updateItem(title: String, item: ZoteroItem): Result<Unit>
    suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>)
}