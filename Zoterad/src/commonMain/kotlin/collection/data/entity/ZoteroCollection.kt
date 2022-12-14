package collection.data.entity

import item.data.entity.item.ZoteroItem

data class ZoteroCollection(
    val title: String,
    val items: MutableList<ZoteroItem>,
)
