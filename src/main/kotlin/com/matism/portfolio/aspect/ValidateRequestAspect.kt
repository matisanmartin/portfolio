package com.matism.portfolio.aspect

import com.matism.portfolio.exception.BadRequestException
import com.matism.portfolio.exception.InternalServerException
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult

@Aspect
@Component
class ValidateRequestAspect {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ValidateRequestAspect::class.java)
    }

    @Before("execution(* *(.., @javax.validation.Valid (*), ..))")
    fun validateRequest(joinPoint: JoinPoint) {
        try {
            if ((joinPoint.args[1] as BindingResult).hasErrors())
                throw BadRequestException("message.error.badRequest", "Invalid parameters")
        } catch (exception: Exception) {
            LOGGER.error("Error obtaining bindingResult argument, check argument order in method. BindingResult should be second argument")
            throw InternalServerException("message.error.internalServer", "Error obtaining bindingResult")
        }
    }
}