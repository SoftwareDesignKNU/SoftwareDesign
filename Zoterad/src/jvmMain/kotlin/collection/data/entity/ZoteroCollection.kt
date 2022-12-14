package collection.data.entity

import item.data.entity.item.ZoteroItems

data class ZoteroCollection(
    val title: String,
    val items: MutableList<ZoteroItems>
)
