package com.matism.portfolio.model

import java.util.UUID

class Picture {
    val id : String = UUID.randomUUID().toString()
    var title : String = ""
}