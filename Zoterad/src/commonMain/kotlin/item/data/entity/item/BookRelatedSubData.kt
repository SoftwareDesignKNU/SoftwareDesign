package item.data.entity.item

data class BookRelatedSubData(
    val series: String,
    val seriesNumber: String,
    val volume: UInt,
    val numberOFVolumes: UInt,
    val edition: String,
    val place: String,
    val itemSubData: ItemSubData
)
