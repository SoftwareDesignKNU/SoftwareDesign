package item.data.entity.item

data class BookRelatedSubData(
    val series: String = "2134",
    val seriesNumber: String = "fe14",
    val volume: UInt = 2u,
    val numberOFVolumes: UInt = 4u,
    val edition: String = "Edition",
    val place: String = "Library",
    val itemSubData: ItemSubData = ItemSubData()
)
