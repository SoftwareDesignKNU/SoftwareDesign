package main.advanced_search.presentation

import item.data.entity.SearchQuery

data class AdvancedSearchState(
    val matchAll: Boolean = false,
    val searchQueries: List<SearchQuery> = emptyList(),
)
