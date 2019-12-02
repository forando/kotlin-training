package com.malencur.kotlin.training.ui.config

import com.malencur.file.properties.PropertyName
import com.malencur.file.properties.factory.InternalPropertiesFactory
import com.malencur.kotlin.training.commons.Introduction
import com.malencur.kotlin.training.commons.QmsServer
import com.malencur.kotlin.training.commons.ServiceSettings
import com.malencur.kotlin.training.ui.mock.QmsServerMock
import com.malencur.kotlin.training.ui.mock.ServiceSettingsMock
import com.malencur.kotlin.training.utils.IntroductionService

val qmsServer: QmsServer = QmsServerMock()
val serviceSettings: ServiceSettings = ServiceSettingsMock()
val introductionService: Introduction = IntroductionService()

object UiSettings: InternalPropertiesFactory("ui.properties") {
    @PropertyName("primaryButton")
    val primaryButtonColor by stringProperty("ui.service.backgroundColor", "#5264AE")
    @PropertyName("secondaryButton")
    val secondaryButtonColor by stringProperty("ui.service.backgroundColor", "#ff6600")

    val backgroundColor by stringProperty("ui.service", "#ffffff")
    val fontColor by stringProperty("ui.service", "#000000")
    val borderColor by stringProperty("ui.service", "#000000")

    val serviceNames by stringListProperty("qms")
}