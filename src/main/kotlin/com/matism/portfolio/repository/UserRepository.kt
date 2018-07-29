package com.matism.portfolio.repository

import com.matism.portfolio.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {

    fun findByUserName(userName: String)
}