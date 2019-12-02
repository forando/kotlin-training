package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.controller.ClientInfoController
import com.malencur.kotlin.training.ui.model.*
import javafx.scene.control.ListView
import javafx.scene.layout.Priority
import tornadofx.*

class ServiceListView : View("ServiceListView") {
    private val controller: ClientInfoController by inject()
    private var listView: ListView<ServiceListItem>? = null

    override val root = borderpane {
        top {
            hbox {
                style {
                    padding = box(10.px, 10.px, 0.px, 10.px)
                }
                label("clients:") {
                    hgrow = Priority.ALWAYS
                }
            }
        }
        center {
            listView = listview {
                prefWidth = 100.0
                prefHeight = 100.0
                cellFormat { text = it.title }
                bindSelected(controller.serviceListItemModel)
                controller.clientsModel.itemProperty.onChange {
                    if (it != null) {
                        items.setAll(controller.services)
                    }
                }
            }
        }
    }

    override fun onUndock() {
        listView?.selectionModel?.clearSelection()
        listView?.items?.clear()
        controller.clientsModel.item = null
    }
}

class ServiceDetailedView : View("ServiceDetailedView") {
    val model: ClientInfoModel by inject()

    override val root = form {
        minWidth = 250.0
        fieldset("title") {
            field("service") {
                label(model.service)
            }
            field("terminal") {
                label(model.terminal)
            }
            field("registered") {
                label(model.registerTime)
            }
            field("served") {
                label(model.servedTime)
            }
        }
    }
}