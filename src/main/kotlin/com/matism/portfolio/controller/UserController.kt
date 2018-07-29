package com.matism.portfolio.controller

import com.matism.portfolio.annotation.LoggableExecutionTime
import com.matism.portfolio.annotation.ValidateRequest
import com.matism.portfolio.dto.UserDTO
import com.matism.portfolio.model.User
import com.matism.portfolio.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
        private val userService: UserService
) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): User {
        return userService.get(id)
    }

    @PostMapping
    @ValidateRequest
    @LoggableExecutionTime
    fun post(@RequestBody @Valid user: UserDTO, bindingResult: BindingResult): User {
        return userService.post(user)
    }

    @PutMapping
    @ValidateRequest
    @LoggableExecutionTime
    fun put(@RequestBody @Valid user: UserDTO, bindingResult: BindingResult): User {
        return userService.put(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        userService.delete(id)
    }

}