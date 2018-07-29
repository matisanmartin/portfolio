package com.matism.portfolio.service

import com.matism.portfolio.dto.ProjectDto
import com.matism.portfolio.exception.ResourceNotFoundException
import com.matism.portfolio.exception.UnprocessableEntityException
import com.matism.portfolio.model.Project
import com.matism.portfolio.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service

@Service
class ProjectService @Autowired constructor(
        val projectRepository: ProjectRepository
) {

    fun get(id: String): Project {
        var project = projectRepository.findById(id)
        project.orElseThrow { ResourceNotFoundException("error.message.resourceNotFound", "Resource not found") }
        return project.get()
    }

    fun post(origin: ProjectDto): Project {
        var destiny = Project(origin.name)
        destiny.description = origin.description

        try {
            return projectRepository.save(destiny)
        } catch (e: DuplicateKeyException) {
            throw UnprocessableEntityException("error.message.repeatedKey", "Project Key already exists")
        }
    }
}

