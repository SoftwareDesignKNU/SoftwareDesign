package item.data

import data.database.Database
import item.data.entity.Condition
import item.data.entity.SearchQuery
import item.data.entity.item.*
import item.domain.ItemRepository

class LocalItemRepository(
    private val collectionIndex: Int,
    private val database: Database,
) : ItemRepository {
    override suspend fun getItemsByTitle(title: String): Result<List<ZoteroItem>> {
        println("LocalRepository: getItemByTitle(title)")
        return Result.success(database.libraries[collectionIndex].items.filter { zoteroItem ->
            when (zoteroItem) {
                is Book -> {
                    zoteroItem.bookRelatedSubData.itemSubData.title == title
                }
                is BookSection -> {
                    zoteroItem.bookRelatedSubData.itemSubData.title == title
                }
                is Document -> {
                    zoteroItem.itemSubData.title == title
                }
                else -> false
            }
        })
    }

    override suspend fun addItem(item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: addItem(item)")
        return Result.success(Unit)
    }

    override suspend fun deleteItem(item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: deleteItem(item)")
        return Result.success(Unit)
    }

    override suspend fun updateItem(title: String, item: ZoteroItem): Result<Unit> {
        println("LocalItemRepository: updateItem(title, item)")
        return Result.success(Unit)
    }

    override suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>): Result<List<ZoteroItem>> {
        return try {
            Result.success(database.libraries[collectionIndex].items.filter { zoteroItem ->
                matchAll && searchQueries.all { searchQuery ->
                    when (searchQuery.condition) {
                        Condition.Is -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.equals(searchQuery.query) == true
                        Condition.IsNot -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.equals(searchQuery.query) != true
                        Condition.BeginsWith -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }
                            ?.get(zoteroItem)?.toString()?.startsWith(searchQuery.query) == true
                        Condition.Contains -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.contains(searchQuery.query) == true
                        Condition.DoesNotContain -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }
                            ?.get(zoteroItem)?.toString()?.contains(searchQuery.query) != true
                    }
                }
                !matchAll && searchQueries.any { searchQuery ->
                    when (searchQuery.condition) {
                        Condition.Is -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.equals(searchQuery.query) == true
                        Condition.IsNot -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.equals(searchQuery.query) != true
                        Condition.BeginsWith -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }
                            ?.get(zoteroItem)?.toString()?.startsWith(searchQuery.query) == true
                        Condition.Contains -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }?.get(zoteroItem)
                            ?.toString()?.contains(searchQuery.query) == true
                        Condition.DoesNotContain -> zoteroItem::class.java.fields.find { it.name.contains(searchQuery.searchField) }
                            ?.get(zoteroItem)?.toString()?.contains(searchQuery.query) != true
                    }                }
            })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}