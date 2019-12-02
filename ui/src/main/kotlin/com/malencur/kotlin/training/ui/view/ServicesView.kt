package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.controller.QmsServiceController
import tornadofx.View
import tornadofx.vbox

class ServicesView : View("Services") {

    private val serviceController: QmsServiceController by inject()

    override val root = vbox {
        val parent = this
        serviceController.services.values.forEach {
            parent.add(ServiceFragment(it))
        }
    }
}