package com.matism.portfolio.repository

import com.matism.portfolio.model.Project
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository: MongoRepository<Project, String> {
}