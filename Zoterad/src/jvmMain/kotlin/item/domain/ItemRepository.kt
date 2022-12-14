package item.domain

import item.data.entity.SearchQuery
import item.data.entity.item.ZoteroItems

interface ItemRepository {
    suspend fun getItemByTitle(title: String): Result<ZoteroItems>
    suspend fun addItem(item: ZoteroItems): Result<Unit>
    suspend fun deleteItem(item: ZoteroItems): Result<Unit>
    suspend fun updateItem(title: String, item: ZoteroItems): Result<Unit>
    suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>)
}