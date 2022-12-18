package item.data.entity.item

import item.data.entity.Condition
import item.data.entity.SearchQuery

sealed interface ZoteroItem {
    data class ComplexZoteroItem(val values: HashMap<String, ZoteroItem>) : ZoteroItem
    data class ZoteroItemField(val value: String) : ZoteroItem

    private fun compare(
        fieldName: String? = null,
        predicate: (String, ZoteroItemField) -> Boolean,
    ): Boolean {
        return when (this) {
            is ComplexZoteroItem -> {
                values.any {
                    it.value.compare(it.key, predicate)
                }
            }
            is ZoteroItemField -> fieldName != null && predicate(fieldName, this)
        }
    }

    fun search(query: SearchQuery): Boolean = when (query.condition) {
        Condition.Is -> compare { fieldName, simpleValue ->
            simpleValue.value == query.query && fieldName == query.searchField
        }
        Condition.IsNot -> compare(query.searchField) { fieldName, simpleValue ->
            simpleValue.value != query.query && fieldName == query.searchField
        }
        Condition.BeginsWith -> compare(query.searchField) { fieldName, simpleValue ->
            simpleValue.value.startsWith(query.query) && fieldName == query.searchField
        }
        Condition.Contains -> compare(query.searchField) { fieldName, simpleValue ->
            simpleValue.value.contains(query.query) && fieldName == query.searchField
        }
        Condition.DoesNotContain -> compare(query.searchField) { fieldName, simpleValue ->
            !simpleValue.value.contains(query.query) && fieldName == query.searchField
        }
    }
}