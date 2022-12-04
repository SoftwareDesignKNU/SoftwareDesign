package main.advanced_search.presentation

import item.data.entity.SearchQuery
import item.domain.ItemRepository

class AdvancedSearchComponent(
    private val itemRepository: ItemRepository,
) {
    var advancedSearchState = AdvancedSearchState()
    fun reduce(advancedSearchEvent: AdvancedSearchEvent) {
        when (advancedSearchEvent) {
            AdvancedSearchEvent.AddQuerySearchEvent -> {
                advancedSearchState = advancedSearchState.copy(
                    searchQueries = advancedSearchState.searchQueries + listOf(SearchQuery())
                )
            }
            is AdvancedSearchEvent.MatchAllChangeSearchEvent -> {
                advancedSearchState = advancedSearchState.copy(
                    matchAll = advancedSearchEvent.marchAll
                )
            }
            is AdvancedSearchEvent.QueryConditionChangeSearchEvent -> {
                val searchQueries = advancedSearchState.searchQueries.toMutableList()
                val changedQuery = searchQueries[advancedSearchEvent.queryId.toInt()].copy(
                    condition = advancedSearchEvent.queryCondition
                )
                searchQueries[advancedSearchEvent.queryId.toInt()] = changedQuery
                advancedSearchState = advancedSearchState.copy(
                    searchQueries = searchQueries
                )
            }
            is AdvancedSearchEvent.QuerySearchFieldChangeSearchEvent -> TODO()
            is AdvancedSearchEvent.QuerySearchValueChangeSearchEvent -> TODO()
        }
    }
}