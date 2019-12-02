package com.malencur.kotlin.training.ui.view

import com.jfoenix.controls.JFXButton
import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.scene.Node
import tornadofx.opcr

fun EventTarget.fButton(text: ObservableValue<String>, graphic: Node? = null, op: JFXButton.() -> Unit = {}): JFXButton {
    val button = JFXButton()
    button.textProperty().bind(text)
    if (graphic != null) button.graphic = graphic
    return opcr(this, button, op)
}

fun EventTarget.fButton(text: String = "", graphic: Node? = null, op: JFXButton.() -> Unit = {}): JFXButton {
    val button = JFXButton(text)
    if (graphic != null) button.graphic = graphic
    return opcr(this, button, op)
}