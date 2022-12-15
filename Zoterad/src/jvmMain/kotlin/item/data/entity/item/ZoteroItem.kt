package item.data.entity.item

import item.data.entity.Condition
import item.data.entity.SearchQuery

sealed interface ZoteroItem {
    data class ComplexZoteroItem(val values: HashMap<String, ZoteroItem>) : ZoteroItem
    data class SimpleZoteroItem(val value: String) : ZoteroItem

}

fun ZoteroItem.hasValue(
    fieldName: String? = null,
    predicate: (fieldName: String, ZoteroItem.SimpleZoteroItem) -> Boolean,
): Boolean {
    return when (this) {
        is ZoteroItem.ComplexZoteroItem -> {
            values.any {
                it.value.hasValue(it.key, predicate)
            }
        }
        is ZoteroItem.SimpleZoteroItem -> fieldName != null && predicate(fieldName, this)
    }
}

fun ZoteroItem.comparison(query: SearchQuery): Boolean = when (query.condition) {
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
