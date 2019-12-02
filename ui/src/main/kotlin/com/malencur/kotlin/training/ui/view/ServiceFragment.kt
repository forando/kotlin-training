package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.config.UiSettings
import com.malencur.kotlin.training.ui.controller.QmsServiceController
import com.malencur.kotlin.training.ui.model.QmsServiceModel
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class ServiceFragment(val model: QmsServiceModel) : Fragment("Service") {
    private val controller: QmsServiceController by inject()
    private val backgrColor = Color.valueOf(UiSettings.backgroundColor)

    override val root = stackpane {
        alignment = Pos.TOP_CENTER
        style {
            padding = box(15.px, 10.px, 5.px, 10.px)
            backgroundColor += backgrColor
        }
        borderpane {
            setPrefSize(600.0, 100.0)
            setMinSize(400.0, 70.0)

            style {
                borderColor += box(Color.valueOf(UiSettings.borderColor))
                padding = box(0.px, 10.px)
            }
            left {
                vbox {
                    style {
                        alignment = Pos.CENTER
                    }
                    fButton("Insert") {
                        enableWhen { model.active }
                        style {
                            textFill = Color.WHITE
                            backgroundColor += Color.valueOf(UiSettings.primaryButtonColor)
                            fontSize = 14.px
                        }
                        prefWidth = 200.0
                        prefHeight = 50.0

                        action {
                            runAsync {
                                controller.insertNewClient(model.item.index)
                            }
                        }
                    }
                }
            }
            center {
                label(model.total) {
                    textFill = Color.valueOf(UiSettings.fontColor)
                    font = Font("Arial", 36.0)
                }
            }

            right {
                vbox {
                    style {
                        alignment = Pos.CENTER
                    }
                    fButton("Take") {
                        enableWhen { model.active }
                        style {
                            textFill = Color.WHITE
                            backgroundColor += Color.valueOf(UiSettings.secondaryButtonColor)
                        }
                        prefWidth = 150.0
                        prefHeight = 30.0

                        action {
                            runAsync {
                                controller.takeClient(model.item.index)
                            }
                        }
                    }
                }
            }
        }
        label(model.name) {
            textFill = Color.valueOf("#5264AE")
            font = Font("Arial", 20.0)
            style {
                backgroundColor += backgrColor
                padding = box(0.px, 10.px)
                translateY = Dimension(-12.0, Dimension.LinearUnits.px)
            }
        }
    }
}