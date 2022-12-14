package main.word_processor.presentation

import collection.data.LocalCollectionRepository
import collection.domain.ICollectionRepository
import item.domain.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.word_processor.domain.CitationStyle

class WordProcessorComponent(
    private val collectionRepository: ICollectionRepository,
) {
    fun generateCitations(
        zoteroItemTitle: String,
        citationStyle: CitationStyle,
        displayCitationsAsFootnotes: Boolean = false,
        displayCitationsAsEndnotes: Boolean = false,
        storeCitationsAsFields: Boolean = true,
        useMedlineJournalAbbreviation: Boolean = true,
        automaticallyUpdateCitations: Boolean = true,
    ) {
        CoroutineScope(Dispatchers.Unconfined).launch {
            collectionRepository.getItemByTitle(zoteroItemTitle)
                .onSuccess {
                    println("Citations had been generated successfully")
                }.onFailure {
                    it.printStackTrace()
                }
        }
    }
}