package com.ngashley.a11y.listItems

enum class ListListItem: ListRow {
    Reorderable,
    Carousel,
    Collection;

    override val titleString: String
        get() {
            return when (this) {
                Reorderable -> "Reorderable"
                Carousel -> "Carousel"
                Collection -> "Collection"
            }
        }

    override val destinationKey: String
        get() {
            return when (this) {
                Reorderable -> "reorderable"
                Carousel -> "carousel"
                Collection -> "collection"
            }
        }
}