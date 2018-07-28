package com.matism.portfolio.service

import com.matism.portfolio.dto.ProjectDto
import com.matism.portfolio.model.Project
import com.matism.portfolio.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService @Autowired constructor(
        val projectRepository: ProjectRepository
) {

    fun get(id: String): Project {
        return projectRepository.get(id)
    }

    fun post(origin: ProjectDto): Project {
        var destiny = Project(origin.name)
        destiny.description = origin.description
        return projectRepository.post(destiny)
    }
}

