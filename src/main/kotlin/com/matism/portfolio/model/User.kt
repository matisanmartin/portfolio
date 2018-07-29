package com.matism.portfolio.model

import java.util.*

class User: MongoModel() {
    val creationDate: Date = Date()
    var userName: String = ""
    var portfolio: Portfolio = Portfolio()
}