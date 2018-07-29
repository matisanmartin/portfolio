package com.matism.portfolio.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class ExceptionHandlerAspect {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(ExceptionHandlerAspect::class.java)
    }

    @Before("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
    fun logException(joinPoint: JoinPoint) {
        LOGGER.error(joinPoint.signature.name, (joinPoint.args[0] as Throwable))
    }
}