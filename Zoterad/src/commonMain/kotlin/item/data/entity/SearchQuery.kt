package item.data.entity

data class SearchQuery(
    val searchField: String = "",
    val condition: Condition = Condition.Contains,
    val query: String = "",
)
