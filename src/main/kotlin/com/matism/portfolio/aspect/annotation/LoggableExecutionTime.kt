package com.matism.portfolio.aspect.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class LoggableExecutionTime {
}