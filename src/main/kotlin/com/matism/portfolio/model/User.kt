package com.matism.portfolio.model

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "users")
class User : MongoModel() {

    val creationDate: Date = Date()

    @Indexed(unique = true)
    var userName: String = ""

    var dateOfBirth: Date? = null

    var profilePicturePath: String = ""

    var description: String = ""

    var portfolio: Portfolio = Portfolio()

    var modificationDate: Date? = null

    var deletionDate: Date? = null

    var following: MutableList<String> = mutableListOf()

    var followers: MutableList<String> = mutableListOf()


}