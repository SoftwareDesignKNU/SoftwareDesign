package item.data

import data.database.Database
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
            zoteroItem is ZoteroItem.ComplexZoteroItem && zoteroItem.values["title"]?.equals(title) == true
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
        try {
            return Result.success(
                database
                    .libraries
                    .flatMap { collection ->
                        collection
                            .items
                            .filter { item ->
                                if (matchAll) {
                                    searchQueries
                                        .all { query ->
                                            item.comparison(query)
                                        }
                                } else {
                                    searchQueries
                                        .any { query ->
                                            item.comparison(query)
                                        }
                                }
                            }
                    }
            )
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}

