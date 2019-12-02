package com.malencur.kotlin.training.ui.mock

import com.fasterxml.jackson.databind.ObjectMapper
import com.malencur.kotlin.training.commons.QmsServer
import com.malencur.kotlin.training.ui.model.ClientInfo

class QmsServerMock : QmsServer {
    override fun requestClientDetails(query: String): String {

        return """
            [ {"id": 1, "service": 10} ]
        """.trimIndent()
    }

    override fun insertNewClient(service: Int) = 0

    override fun takeClient(service: Int) = 0

    private fun createClient(index: Int): ClientInfo = ClientInfo(index + 1, index, "${index + 5}", "12:00", "12:20")

    companion object {
        private val MAPPER = ObjectMapper().findAndRegisterModules()
    }
}