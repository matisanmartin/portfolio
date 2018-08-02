package com.matism.portfolio.model

class Portfolio : MongoModel() {

    var projects: MutableList<Project> = mutableListOf()
}