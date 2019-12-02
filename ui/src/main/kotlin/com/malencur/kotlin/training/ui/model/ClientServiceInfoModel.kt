package com.malencur.kotlin.training.ui.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class ClientInfoModel : ItemViewModel<ClientInfo>() {
    val id = bind { SimpleIntegerProperty(item?.id ?: 0) }
    val service = bind { SimpleIntegerProperty(item?.service ?: 0) }
    val terminal = bind { SimpleStringProperty(item?.terminal ?: "") }
    val registerTime = bind { SimpleStringProperty(item?.registerTime ?: "") }
    val servedTime = bind { SimpleStringProperty(item?.servedTime ?: "") }
}