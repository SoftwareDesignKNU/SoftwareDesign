package item.data.entity.item

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class Book(
    val title: String,
    val people: List<Person>,
    val abstract: String,
    val publisher: String,
    val date: LocalDate,
    val numberOfPages: UInt,
    val isbn: String,
    val shortTitle: String,
    val url: String,
    val accessed: LocalDate,
    val archive: String,
    val locationInArchive: String,
    val libraryCatalog: String,
    val callNumber: String,
    val rights: String,
    val extra: String,
    val dateAdded: LocalDateTime,
    val modifier: LocalDateTime,
    val series: String,
    val volume: UInt,
    val numberOFVolumes: UInt,
    val edition: String,
    val place: String,
)