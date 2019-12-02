package com.malencur.kotlin.training.utils

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory

class StringUtils {

    fun <T> convertToString(obj: T): String {
        return MAPPER.writeValueAsString(obj)
    }

    companion object {
        private val MAPPER = ObjectMapper().findAndRegisterModules()
        private val log = LoggerFactory.getLogger(StringUtils::class.java)
    }
}