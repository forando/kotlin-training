package com.malencur.kotlin.training.ui.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ClientInfo(
    val id: Int,
    val service: Int = 0,
    val terminal: String? = null,
    val registerTime: String? = null,
    val servedTime: String? = null
)