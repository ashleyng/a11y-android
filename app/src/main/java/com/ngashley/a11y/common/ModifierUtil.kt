package com.ngashley.a11y.common

import androidx.compose.ui.Modifier


fun Modifier.conditional(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}

fun <T: Any> Modifier.ifLet(optional: T?, modifier : Modifier.(T) -> Modifier) : Modifier {
    return optional?.let {
        then(modifier(it))
    } ?: run {
        this
    }
}