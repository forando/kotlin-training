package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.Styles
import com.malencur.kotlin.training.ui.controller.IntroductionController
import com.malencur.kotlin.training.ui.model.IntroductionModel
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*

class IntroductionView : View("Introduction View") {
    private val controller: IntroductionController by inject()
    private val model: IntroductionModel by inject()

    override val root = vbox {
        addClass(Styles.about)
        vgrow = Priority.ALWAYS
        hbox {
            alignment = Pos.CENTER
            vgrow = Priority.ALWAYS
            label("Greeting:")
            label(model.greeting)
        }
        hbox {
            alignment = Pos.CENTER
            vgrow = Priority.ALWAYS
            label("Complex String:")
            label(model.complexString)
        }
        hbox {
            alignment = Pos.CENTER
            vgrow = Priority.ALWAYS
            label("Names:")
            label(model.names)
        }
        hbox {
            alignment = Pos.CENTER
            vgrow = Priority.ALWAYS
            label("Numbers:")
            label(model.numbers)
        }
        hbox {
            alignment = Pos.BASELINE_RIGHT
            button("Get Data").action {
                controller.getData()
            }
        }
    }

}