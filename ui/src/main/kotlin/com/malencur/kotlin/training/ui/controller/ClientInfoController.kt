package com.malencur.kotlin.training.ui.controller

import com.malencur.kotlin.training.ui.event.ClientDetailsResponseEvent
import com.malencur.kotlin.training.ui.model.*
import tornadofx.Controller
import tornadofx.onChange

class ClientInfoController : Controller() {
    private val clientsRequestModel: ClientsRequestModel by inject()
    val clientsModel: ClientsModel by inject()
    val serviceListItemModel: ServiceListItemModel by inject()
    private val clientInfoModel: ClientInfoModel by inject()

    var services = emptyList<ServiceListItem>()

    init {
        clientsRequestModel.item = ClientsRequest()

        serviceListItemModel.itemProperty.onChange {
            if (it == null) {
                clientInfoModel.item = null
            } else {
                clientInfoModel.item = clientsModel.item[it.index]
            }
        }

        subscribe<ClientDetailsResponseEvent> { event ->

            val clientServices = ArrayList<ServiceListItem>()
            for ((index, client) in event.clientsInfo.withIndex()) {
                val clientName = "Client ${client.id}"
                clientServices.add(ServiceListItem(clientName, index))
            }
            services = clientServices
            clientsModel.item = event.clientsInfo

        }
    }
}