package com.diegolucasb

import com.diegolucasb.components.NewsComponent
import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.onload = {
        render(document.getElementById("root")!!) {
            child(NewsComponent::class) {}
        }
    }
}