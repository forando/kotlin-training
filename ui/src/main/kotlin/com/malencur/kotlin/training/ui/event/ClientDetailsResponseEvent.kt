package com.malencur.kotlin.training.ui.event

import com.malencur.kotlin.training.ui.model.ClientInfo
import tornadofx.FXEvent

class ClientDetailsResponseEvent(val clientsInfo: List<ClientInfo>) : FXEvent()