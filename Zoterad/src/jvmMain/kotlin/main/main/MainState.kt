package main.main

import collection.data.entity.ZoteroCollection

data class MainState(
    val collections: List<ZoteroCollection> = emptyList(),
)