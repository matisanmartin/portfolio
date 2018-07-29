package com.matism.portfolio.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class HttpEndpointAspect {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(HttpEndpointAspect::class.java)
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    fun logGetEndpoint(joinPoint: JoinPoint) = logHttpEndpoint("GET", joinPoint)

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    fun logPostEndpoint(joinPoint: JoinPoint) = logHttpEndpoint("POST", joinPoint)

    @Before("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    fun logPutEndpoint(joinPoint: JoinPoint) = logHttpEndpoint("PUT", joinPoint)

    @Before("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    fun logDeleteEndpoint(joinPoint: JoinPoint) = logHttpEndpoint("DELETE", joinPoint)

    private fun logHttpEndpoint(verb: String, joinPoint: JoinPoint) {
        var signature = joinPoint.signature as MethodSignature
        var method = signature.method
        LOGGER.info("Executing {} call {} with arguments {}", verb, method, joinPoint.args)
    }
}