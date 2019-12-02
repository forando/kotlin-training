package com.malencur.kotlin.training.ui.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel
import tornadofx.getValue
import tornadofx.setValue

class ClientsRequest(query: String = "all") {
    val queryProperty = SimpleStringProperty(query)
    var query: String by queryProperty
}

class ClientsRequestModel : ItemViewModel<ClientsRequest>() {
    val query = bind(autocommit = true) { item?.queryProperty }
}