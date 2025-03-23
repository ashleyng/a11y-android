package com.ngashley.a11y.common

import com.ngashley.a11y.R

enum class PizzaTopping(val stringResId: ResId) {
    Cheese(R.string.cheese),
    Pepperoni(R.string.pepperoni),
    Peppers(R.string.peppers),
    Pineapple(R.string.pineapple),
    Mushrooms(R.string.mushrooms);
}

enum class Activities(val stringKey: ResId, val iconRes: ResId) {
    Soccer(R.string.soccer_ball, R.drawable.sports_soccer_24px),
    Basketball(R.string.basketball, R.drawable.sports_basketball_24px),
    Snowboarding(R.string.snowboarding, R.drawable.snowboarding_24px),
    MartialArts(R.string.martial_arts, R.drawable.sports_martial_arts_24px),
    Diving(R.string.diving, R.drawable.scuba_diving_24px),
    ESports(R.string.esports, R.drawable.sports_esports_24px)
}