package item.data

import data.database.Database
import item.data.entity.SearchQuery
<<<<<<< HEAD:Zoterad/src/commonMain/kotlin/item/data/LocalItemRepository.kt
import item.data.entity.item.*
=======
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ZoteroItem
>>>>>>> 17e68413d7dcc1b9327eef9849fd13add2378197:Zoterad/src/jvmMain/kotlin/item/data/LocalItemRepository.kt
import item.domain.ItemRepository

class LocalItemRepository(
    collectionIndex: Int,
    database: Database,
) : ItemRepository {
    override suspend fun getItemByTitle(title: String): Result<ZoteroItem> {
        println("LocalRepository: getItemByTitle(title)")
<<<<<<< HEAD:Zoterad/src/commonMain/kotlin/item/data/LocalItemRepository.kt
        return Result.success(Book(bookRelatedSubData = BookRelatedSubData()))
=======
        return Result.success(Book(BookRelatedSubData()))
>>>>>>> 17e68413d7dcc1b9327eef9849fd13add2378197:Zoterad/src/jvmMain/kotlin/item/data/LocalItemRepository.kt
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

    override suspend fun searchItem(matchAll: Boolean, searchQueries: List<SearchQuery>) {
        TODO("Not yet implemented")
    }
}