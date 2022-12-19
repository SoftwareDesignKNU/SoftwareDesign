import collection.data.LocalCollectionRepository
import data.database.Database
import main.word_processor.domain.CitationStyle
import main.word_processor.presentation.WordProcessorComponent
import org.junit.jupiter.api.Test

class GenerateCitationsTest {
    //T6 - UC12 - SD6 Basic Scenario
    @Test
    fun generaCitationsBasicFlowTest() {
        val wordProcessorComponent = WordProcessorComponent(LocalCollectionRepository(Database()))
        wordProcessorComponent.generateCitations("Differential Geometry", CitationStyle.AmericanChemicalSociety)
    }
     //T6.2 - UC12 - SD6 Alternative Scenario
    @Test
    fun generaCitationsAlternativeFlowTest() {
        val wordProcessorComponent = WordProcessorComponent(LocalCollectionRepository(Database()))
        wordProcessorComponent.generateCitations("Does not exist", CitationStyle.AmericanChemicalSociety)
    }
}