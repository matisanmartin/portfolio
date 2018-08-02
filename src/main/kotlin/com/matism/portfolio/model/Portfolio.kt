package com.matism.portfolio.model

class Portfolio : MongoModel() {

    var projects: List<Project> = mutableListOf()
}