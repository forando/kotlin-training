package com.malencur.kotlin.training.ui.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

data class ServiceListItem(val title: String, val index: Int)

class ServiceListItemModel : ItemViewModel<ServiceListItem>() {
    val title = bind { SimpleStringProperty(item?.title ?: "") }
}