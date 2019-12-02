package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.Styles
import javafx.scene.control.TabPane
import tornadofx.*

class MainView : View("Kotlin Application") {

    override val root = tabpane {
        addClass(Styles.wrapper)

        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

        tab(IntroductionView::class)
        tab(ServicesView::class)
        tab(ClientInfoView::class)
    }
}