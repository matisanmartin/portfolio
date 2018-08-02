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

    fun followUser(currentUserId: String, userId: String): User {
        if (currentUserId == userId)
            throw UnprocessableEntityException("error.message.cantFollowItself", "A user cannot follow itself")

        var user = findUser(currentUserId, "error.message.userDoesntExist", "Current user doesnt exist")
        var userToBeFollowed = findUser(userId, "error.message.userDoesntExist", "Cannot follow non-existing user")

        val userAlreadyFollows = user.following.any { it == currentUserId}

        if(userAlreadyFollows)
            throw UnprocessableEntityException("error.message.alreadyFollows", "User already follows the desired user")

        user.following.add(userId)
        userToBeFollowed.followers.add(currentUserId)

        return user
    }

    fun unFollowUser(currentUserId: String, userId: String): User {
        if (currentUserId == userId)
            throw UnprocessableEntityException("error.messsage.cantUnFollowItself", "A user cannot unfollow itself")

        var user = findUser(currentUserId, "error.message.userDoesntExist", "Cannot follow non-existing user")
        var userToBeFollowed = findUser(userId, "error.message.userDoesntExist", "Cannot follow non-existing user")

        return user
    }

    private fun findUser(userId: String, errorKey: String, errorMessage: String) = userRepository.findById(userId).orElseThrow { ResourceNotFoundException(errorKey, errorMessage) }
}