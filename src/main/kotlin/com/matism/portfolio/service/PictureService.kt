package com.matism.portfolio.service

import com.matism.portfolio.dto.PictureDto
import com.matism.portfolio.exception.ResourceNotFoundException
import com.matism.portfolio.model.Picture
import com.matism.portfolio.model.Project
import com.matism.portfolio.repository.ProjectRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class PictureService @Autowired constructor(
        private val projectRepository: ProjectRepository,
        @Value("\${paths.images.basePath}") private val basePath: String = "/data/",
        @Value("\${paths.images.picturesPath}") private val picturesPath: String = "/pictures/",
        @Value("\${paths.images.separator}") private val separator: String = "/"
) {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(PictureService::class.java)
    }

    fun postPicturesToProject(userId: String, projectId: String, pictures: List<PictureDto>): Project {
        LOGGER.info("Adding pictures to project")
        var project = projectRepository.findById(projectId)

        project.orElseThrow { ResourceNotFoundException("message.error.resourceNotFound", "Project not found") }

        project.get().pictures.addAll(pictures.map {
            var picture = Picture()
            picture.title = it.title
            picture.createPath(basePath, picturesPath, separator, userId, projectId)
            picture
        })

        return projectRepository.save(project.get())
    }
}