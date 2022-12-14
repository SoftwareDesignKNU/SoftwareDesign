package item.data.entity.item

data class BookSection(
    val bookRelatedSubData: BookRelatedSubData,
    val pages: IntRange,
    val language: String,
) : ZoteroItems
