package main.main

import collection.data.entity.ZoteroCollection

data class MainState(
    val collections: MutableList<ZoteroCollection> = mutableListOf(),
    val collectionIndex: Int = 0,
)