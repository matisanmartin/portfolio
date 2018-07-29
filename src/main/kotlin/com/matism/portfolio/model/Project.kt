package com.matism.portfolio.model

data class Project(var name: String): Model() {
    var description: String = ""
    var pictures = mutableListOf<Picture>()
}