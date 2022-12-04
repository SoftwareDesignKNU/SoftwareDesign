package main.word_processor

import collection.domain.ICollectionRepository
import item.domain.ItemRepository

class WordProcessorComponent(
    private val collectionRepository: ICollectionRepository,
    private val itemRepository: ItemRepository,
) {
    fun generateCitations() {
        // Generates citations in word
    }
}