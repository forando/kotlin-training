package com.malencur.kotlin.training.ui.view

import com.malencur.kotlin.training.ui.Styles
import com.malencur.kotlin.training.ui.controller.QmsServiceController
import com.malencur.kotlin.training.ui.model.ClientsRequestModel
import javafx.geometry.Pos
import tornadofx.*

class ClientInfoView : View("Clients Info") {
    private val serviceController: QmsServiceController by inject()
    private val model: ClientsRequestModel by inject()

    override val root = borderpane {
        addClass(Styles.about)
        top {
            borderpane {
                center {
                    vbox {
                        style {
                            alignment = Pos.CENTER
                            padding = box(0.px, 15.px)
                        }
                        form {
                            style {
                                padding = box(0.px)
                                insets(0)
                            }
                            fieldset {
                                style {
                                    padding = box(0.px)
                                }
                                field("query") {
                                    textfield(model.query) {
                                        prefWidth = 100.0
                                    }.validator {
                                        if (it.isNullOrBlank()) {
                                            error("query required")
                                        } else {
                                            null
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                right {
                    vbox {
                        style {
                            alignment = Pos.CENTER
                            padding = box(0.px, 15.px)
                        }
                        button("get data") {
                            enableWhen(model.valid)
                            action {
                                serviceController.requestClientDetails(model.item.query)
                            }
                        }
                    }
                }
            }
        }
        center {
            borderpane {
                center(ServiceListView::class)
                right(ServiceDetailedView::class)
            }
        }
    }
}