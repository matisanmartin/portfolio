package com.matism.portfolio.service

import com.matism.portfolio.dto.ProjectDto
import com.matism.portfolio.model.Project
import com.matism.portfolio.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class ProjectService @Autowired constructor(
        val projectRepository: ProjectRepository
){
    var id = AtomicLong()

    fun get(id: Long) : Project {
        return projectRepository.get(id)
    }

    fun post(project: ProjectDto): Project {
        return Project(id.incrementAndGet(), project.name)
    }
}

