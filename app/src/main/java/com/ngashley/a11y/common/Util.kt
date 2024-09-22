package com.ngashley.a11y.common

typealias ResId = Int

fun String.Companion.shortLoremIpsum(): String {
    return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum dapibus."
}

fun String.Companion.longLoremIpsum(): String {
    return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi semper felis at velit facilisis, a ornare mi elementum. Proin consequat diam suscipit facilisis " +
            "condimentum. Suspendisse potenti. Cras sit amet justo auctor, aliquet justo quis, imperdiet tortor. Cras fermentum lacinia massa, at suscipit nulla pellentesque in. " +
            "Phasellus pharetra lectus eget commodo feugiat. Nullam commodo porta metus, ut feugiat turpis condimentum vitae. Vestibulum auctor ex tortor, eu auctor ex tempus " +
            "vitae. Phasellus semper justo orci, et viverra lectus laoreet a. Proin efficitur tellus eu orci vulputate pellentesque. Donec in tristique enim, vitae dictum ligula."
}