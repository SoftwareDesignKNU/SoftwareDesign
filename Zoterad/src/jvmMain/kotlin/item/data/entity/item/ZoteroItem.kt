package item.data.entity.item

import item.data.entity.Condition
import item.data.entity.SearchQuery

sealed interface ZoteroItem {
    data class ComplexZoteroItem(val values: HashMap<String, ZoteroItem>) : ZoteroItem
    data class ZoteroItemField(val value: String) : ZoteroItem

    fun hasValue(
        fieldName: String? = null,
        predicate: (fieldName: String, ZoteroItemField) -> Boolean,
    ): Boolean {
        return when (this) {
            is ComplexZoteroItem -> {
                values.any {
                    it.value.hasValue(it.key, predicate)
                }
            }
            is ZoteroItemField -> fieldName != null && predicate(fieldName, this)
        }
    }

    fun comparison(query: SearchQuery): Boolean = when (query.condition) {
        Condition.Is -> hasValue { fieldName, simpleValue ->
            simpleValue.value == query.query && fieldName == query.searchField
        }
        Condition.IsNot -> hasValue(query.searchField) { fieldName, simpleValue ->
            simpleValue.value != query.query && fieldName == query.searchField
        }
        Condition.BeginsWith -> hasValue(query.searchField) { fieldName, simpleValue ->
            simpleValue.value.startsWith(query.query) && fieldName == query.searchField
        }
        Condition.Contains -> hasValue(query.searchField) { fieldName, simpleValue ->
            simpleValue.value.contains(query.query) && fieldName == query.searchField
        }
        Condition.DoesNotContain -> hasValue(query.searchField) { fieldName, simpleValue ->
            !simpleValue.value.contains(query.query) && fieldName == query.searchField
        }
    }
}