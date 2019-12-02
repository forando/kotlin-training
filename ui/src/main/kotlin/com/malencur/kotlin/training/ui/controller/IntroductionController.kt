package com.malencur.kotlin.training.ui.controller

import com.malencur.kotlin.training.commons.Introduction
import com.malencur.kotlin.training.ui.config.introductionService
import com.malencur.kotlin.training.ui.model.IntroductionBean
import com.malencur.kotlin.training.ui.model.IntroductionModel
import tornadofx.Controller

class IntroductionController  : Controller() {
    private val model: IntroductionModel by inject()

    private val service: Introduction = introductionService

    fun getData() {
        val greeting = service.greeting
        val complexString = service.createComplexString()
        val names = service.listNames()
        val numbers = service.listNumbers()

        model.item = IntroductionBean(greeting, complexString, names, numbers)
    }
}