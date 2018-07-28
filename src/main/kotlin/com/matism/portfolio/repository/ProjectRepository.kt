package com.matism.portfolio.repository

import com.matism.portfolio.model.Project
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository {

    fun get(id: Long) =
            Project(id, "Test")
}