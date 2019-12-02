package com.malencur.kotlin.training.ui.mock

import com.malencur.kotlin.training.commons.ServiceSettings

class ServiceSettingsMock : ServiceSettings {
    override val serviceNames: List<String> = listOf("LEGAL", "FINANCE", "IT")
}