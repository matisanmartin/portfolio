package com.matism.portfolio.model

import java.util.UUID

data class Project(var name: String) {

    var id: String = UUID.randomUUID().toString()
    var description: String = ""

}