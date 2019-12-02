package com.malencur.kotlin.training.ui.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class IntroductionBean(
    val greeting: String = "",
    val complexString: String = "",
    val names: List<String> = emptyList(),
    val numbers: List<Int> = emptyList()
)

class IntroductionModel: ItemViewModel<IntroductionBean>() {
    val greeting = bind { SimpleStringProperty(item?.greeting ?: "") }
    val complexString = bind { SimpleStringProperty(item?.complexString ?: "") }
    val names = bind { SimpleStringProperty(item?.names?.toString() ?: "") }
    val numbers = bind { SimpleStringProperty(item?.numbers?.toString() ?: "") }
}