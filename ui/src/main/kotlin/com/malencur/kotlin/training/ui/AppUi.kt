package com.malencur.kotlin.training.ui

import com.malencur.kotlin.training.ui.view.MainView
import javafx.application.Application
import tornadofx.App
import tornadofx.importStylesheet

class AppUi : App() {
    override val primaryView = MainView::class
    init {
        importStylesheet(Styles::class)
    }
}

fun main(args: Array<String>) {
    Application.launch(AppUi::class.java, *args)
}