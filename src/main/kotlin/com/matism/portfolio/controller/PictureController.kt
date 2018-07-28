package com.matism.portfolio.controller

import com.matism.portfolio.dto.ListOfPicturesDto
import com.matism.portfolio.model.Project
import com.matism.portfolio.service.PictureService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PictureController @Autowired constructor(
        private val pictureService: PictureService
) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(javaClass)
    }

    @PostMapping("/projects/{projectId}/pictures/")
    fun post(@PathVariable("projectId") projectId: String, @RequestBody pictureList: ListOfPicturesDto): Project {
        LOGGER.info("POST on /project/{}/pictures", projectId);
        return pictureService.postPicturesToProject(projectId, pictureList.pictures)

    }
}