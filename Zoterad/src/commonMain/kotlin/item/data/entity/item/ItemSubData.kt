package item.data.entity.item

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class ItemSubData(
    val title: String = "title",
    val people: List<Person> = emptyList(),
    val abstract: String = "abstract",
    val publisher: String = "publisher",
    val date: LocalDate = LocalDate.fromEpochDays((Clock.System.now().epochSeconds / 36000 / 24).toInt()),
    val numberOfPages: UInt = 100u,
    val isbn: String = "3242fadsf",
    val shortTitle: String = "Short title",
    val url: String = "https://google.com",
    val accessed: LocalDate = LocalDate.fromEpochDays((Clock.System.now().epochSeconds / 36000 / 24).toInt()),
    val archive: String = "Archive",
    val locationInArchive: String = "Somewhere",
    val libraryCatalog: String = "Catalog",
    val callNumber: String = "+7 (800) 555 35-35",
    val rights: String = "Human",
    val extra: String = "Sous",
    val dateAdded: LocalDateTime = LocalDateTime(2022, 12, 14, 2, 12, 30),
    val modifier: LocalDateTime = LocalDateTime(2022, 12, 14, 2, 2, 2),
)
