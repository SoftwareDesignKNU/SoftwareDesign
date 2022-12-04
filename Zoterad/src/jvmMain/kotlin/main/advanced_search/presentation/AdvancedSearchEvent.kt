package main.advanced_search.presentation

import item.data.entity.Condition

sealed interface AdvancedSearchEvent {
    object AddQuerySearchEvent : AdvancedSearchEvent

    @JvmInline
    value class MatchAllChangeSearchEvent(val marchAll: Boolean) : AdvancedSearchEvent

    data class QueryConditionChangeSearchEvent(val queryId: UInt, val queryCondition: Condition)

    data class QuerySearchFieldChangeSearchEvent(val queryId: UInt, val searchField: String)

    data class QuerySearchValueChangeSearchEvent(val queryId: UInt, val searchValue: String)
}