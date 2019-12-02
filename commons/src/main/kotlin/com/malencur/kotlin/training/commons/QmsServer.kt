package com.malencur.kotlin.training.commons

interface QmsServer {
    fun requestClientDetails(query: String): String
    fun insertNewClient(service: Int): Int
    fun takeClient(service: Int): Int
}