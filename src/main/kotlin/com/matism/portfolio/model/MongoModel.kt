package com.matism.portfolio.model

import org.springframework.data.annotation.Id
import java.util.*

abstract class MongoModel {

    @Id
    var id: String = UUID.randomUUID().toString()
}