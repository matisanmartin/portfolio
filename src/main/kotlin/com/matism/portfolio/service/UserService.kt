package com.matism.portfolio.service

import com.matism.portfolio.dto.UserDTO
import com.matism.portfolio.exception.ResourceNotFoundException
import com.matism.portfolio.exception.UnprocessableEntityException
import com.matism.portfolio.model.User
import com.matism.portfolio.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
        private val userRepository: UserRepository
) {

    fun get(id: String): User {
        var user = userRepository.findById(id)
        user.orElseThrow { ResourceNotFoundException("error.message.userNotFound", "User wasn't found") }
        return user.get()
    }

    fun post(user: UserDTO): User {
        val entity = User()
        entity.userName = user.userName

        try {
            return userRepository.save(entity)
        } catch (exception: DuplicateKeyException) {
            throw UnprocessableEntityException("error.message.existingUser", "User already exists")
        }
    }

    fun put(user: UserDTO): User {
        return User()
    }

    fun delete(id: String) {
        try {
            userRepository.deleteById(id)
        } catch (exception: DataAccessException) {
            throw UnprocessableEntityException("error.message.dataAccess", "Couldnt delete user")
        }
    }
}