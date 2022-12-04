package item.data.entity

data class SearchQuery(
    val searchField: String,
    val condition: String,
    val query: String,
)
