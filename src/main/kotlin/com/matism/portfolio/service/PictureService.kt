package com.matism.portfolio.service

import com.matism.portfolio.dto.PictureDto
import com.matism.portfolio.model.Picture
import com.matism.portfolio.model.Project
import com.matism.portfolio.repository.ProjectRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PictureService @Autowired constructor(
        private val projectRepository: ProjectRepository
) {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(javaClass)
    }

    fun postPicturesToProject(projectId: String, pictures: List<PictureDto>): Project {
        LOGGER.info("Adding pictures to project")
        var project = projectRepository.get(projectId)

        var pictures = pictures.map {
            var picture = Picture()
            picture.title = it.title
            picture
        }

        project.pictures.addAll(pictures)

        projectRepository.put(project)
        return project
    }
}