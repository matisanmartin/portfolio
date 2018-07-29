package com.matism.portfolio.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.reflect.Method

@Aspect
@Component
class LoggingAspect {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(LoggingAspect::class.java)
    }

    @Around("@annotation(com.matism.portfolio.aspect.annotation.ExecutionTimeLoggable)")
    fun logExecutionTime(proceedingJoinPoint: ProceedingJoinPoint): Any {
        var starTime = System.currentTimeMillis()
        LOGGER.info("Beginning of method {}", getMethod(proceedingJoinPoint)?.name)
        var returnValue = proceedingJoinPoint.proceed()
        var executionTime = System.currentTimeMillis() - starTime
        LOGGER.info("End of method: Execution time {}ms", executionTime)
        return returnValue
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

    private fun getMethod(proceedingJoinPoint: ProceedingJoinPoint): Method? {
        var signature = proceedingJoinPoint.signature as MethodSignature
        return signature.method
    }
}