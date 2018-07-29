package com.matism.portfolio.model

import java.util.*

abstract class Model {
    var id: String = UUID.randomUUID().toString()
}