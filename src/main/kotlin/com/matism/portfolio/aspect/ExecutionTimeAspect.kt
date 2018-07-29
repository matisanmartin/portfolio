package com.matism.portfolio.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.reflect.Method

@Aspect
@Component
class ExecutionTimeAspect {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(ExecutionTimeAspect::class.java)
    }

    @Around("@annotation(com.matism.portfolio.annotation.LoggableExecutionTime)")
    fun logExecutionTime(proceedingJoinPoint: ProceedingJoinPoint): Any {
        var starTime = System.currentTimeMillis()
        LOGGER.info("Beginning of method {}", getMethod(proceedingJoinPoint)?.name)
        var returnValue = proceedingJoinPoint.proceed()
        var executionTime = System.currentTimeMillis() - starTime
        LOGGER.info("End of method: Execution time {}ms", executionTime)
        return returnValue
    }

    private fun getMethod(proceedingJoinPoint: ProceedingJoinPoint): Method? {
        var signature = proceedingJoinPoint.signature as MethodSignature
        return signature.method
    }
}