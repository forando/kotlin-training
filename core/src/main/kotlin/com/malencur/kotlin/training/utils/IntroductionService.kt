package com.malencur.kotlin.training.utils

import com.malencur.kotlin.training.commons.Introduction

class IntroductionService : Introduction {
    override val greeting: String
        get() {
            return ""
        }

    override fun listNames(): List<String> {
        return emptyList()
    }

    override fun listNumbers(): List<Int> {
        return emptyList()
    }

    override fun createComplexString(): String {
        return ""
    }

}