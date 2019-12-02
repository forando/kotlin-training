package com.malencur.kotlin.training.ui.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.malencur.kotlin.training.commons.QmsServer
import com.malencur.kotlin.training.ui.config.qmsServer
import com.malencur.kotlin.training.ui.config.serviceSettings
import com.malencur.kotlin.training.ui.event.ClientDetailsResponseEvent
import com.malencur.kotlin.training.ui.model.ClientInfo
import com.malencur.kotlin.training.ui.model.QmsService
import com.malencur.kotlin.training.ui.model.QmsServiceModel
import jdk.internal.org.objectweb.asm.TypeReference
import org.slf4j.LoggerFactory
import tornadofx.Controller
import java.util.HashMap

class QmsServiceController : Controller() {
    val services: Map<Int, QmsServiceModel>

    private val server: QmsServer

    init {
        val mutableMap = mutableMapOf<Int, QmsServiceModel>()
        var i = 0
        serviceSettings.serviceNames.forEach {
            mutableMap[i] = createModel(i, it)
            ++i
        }
        services = HashMap(mutableMap)

        server = qmsServer
    }

    private fun createModel(index: Int, name: String): QmsServiceModel {
        return QmsServiceModel()
            .apply { item = QmsService(index, name, "total 0", 0) }
    }

    fun requestClientDetails(query: String) {
        val resultString = server.requestClientDetails(query)
        val result: List<ClientInfo> = MAPPER.readValue(resultString)
        fire(ClientDetailsResponseEvent(result))
    }

    fun insertNewClient(serviceIndex: Int) {
        val total = server.insertNewClient(serviceIndex)
        changeTotalForService(serviceIndex, total)
    }

    fun takeClient(serviceIndex: Int) {
        val total = server.takeClient(serviceIndex)
        changeTotalForService(serviceIndex, total)
    }

    private fun changeTotalForService(serviceIndex: Int, newTotal: Int) {
        val model = services[serviceIndex]
        val service = model?.item

        if (model == null) {
            logger.error("Cannot find service model for index = $serviceIndex")
            return
        }

        if (service == null) {
            logger.error("Service model with index = $serviceIndex has a bean == NULL")
            return
        }

        setNewServiceTotal(service, newTotal)
    }

    private fun setNewServiceTotal(service: QmsService, newTotal: Int) {
        service.total = newTotal
        service.totalStr = "Total $newTotal"
    }

    companion object {
        private val logger = LoggerFactory.getLogger(QmsServiceController::class.java)
        private val MAPPER = ObjectMapper().findAndRegisterModules()
    }
}