package com.matism.portfolio.model

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "project")
class Project(@Indexed(unique = true) var name: String) : MongoModel() {
    var description: String = ""
    var pictures = mutableListOf<Picture>()
}