package com.malencur.kotlin.training.ui

import tornadofx.*

class Styles : Stylesheet() {

    init {

        about {
            padding = box(25.px)

            label {
                fontSize = Dimension(14.0, Dimension.LinearUnits.px)
                padding = box(5.px, 10.px)
            }
        }

        info {
            padding = box(20.px)
            label {
                fontSize = Dimension(14.0, Dimension.LinearUnits.px)
            }
        }

        areYouSure {
            padding = box(15.px)
            label {
                fontSize = Dimension(18.0, Dimension.LinearUnits.px)
            }

            button {
                insets(20, 0)
            }
        }

        wrapper {
            prefHeight = 400.px
            prefWidth = 550.px
        }
    }

    companion object {
        val wrapper by cssclass()
        val about by cssclass()
        val info by cssclass()
        val areYouSure by cssclass()
    }
}