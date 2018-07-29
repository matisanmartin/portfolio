package com.matism.portfolio.repository

import com.matism.portfolio.model.Project
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ProjectRepository::class.java)
    }

    fun get(id: String) =
            Project("Test")

    fun post(project: Project): Project {
        return project
    }

    fun put(project: Project): Project {
        LOGGER.info("PUT on entity")
        return project
    }
}