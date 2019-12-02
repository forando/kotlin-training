package com.malencur.kotlin.training.ui.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel
import tornadofx.getValue
import tornadofx.setValue

class QmsService(val index: Int, name: String, totalStr: String, var total: Int, active: Boolean = false) {
    val nameProperty = SimpleStringProperty(name)
    val totalProperty = SimpleStringProperty(totalStr)
    val activeProperty = SimpleBooleanProperty(active)
    val name by nameProperty
    var totalStr by totalProperty
    var active by activeProperty
}

class QmsServiceModel : ItemViewModel<QmsService>() {
    val name = bind { item?.nameProperty }
    val total = bind(autocommit = true) { item?.totalProperty }
    val active = bind(autocommit = true) { item?.activeProperty }
}