package com.matism.portfolio.controller

import com.matism.portfolio.annotation.LoggableExecutionTime
import com.matism.portfolio.annotation.ValidateRequest
import com.matism.portfolio.dto.ListOfPicturesDto
import com.matism.portfolio.model.Project
import com.matism.portfolio.service.PictureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PictureController @Autowired constructor(
        private val pictureService: PictureService
) {

    @PostMapping("/projects/{projectId}/pictures/")
    @ValidateRequest
    @LoggableExecutionTime
    fun post(@PathVariable("projectId") projectId: String, @RequestBody @Valid pictureList: ListOfPicturesDto, bindingResult: BindingResult): Project {
        return pictureService.postPicturesToProject(projectId, pictureList.pictures)
    }
}