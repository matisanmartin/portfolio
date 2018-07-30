package com.matism.portfolio.model

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "users")
class User : MongoModel() {

    val creationDate: Date = Date()

    @Indexed(unique = true)
    var userName: String = ""

    var portfolio: Portfolio = Portfolio()
}