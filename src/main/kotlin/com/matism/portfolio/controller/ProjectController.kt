package com.matism.portfolio.controller

import com.matism.portfolio.annotation.LoggableExecutionTime
import com.matism.portfolio.annotation.ValidateRequest
import com.matism.portfolio.dto.ProjectDto
import com.matism.portfolio.model.Project
import com.matism.portfolio.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/projects")
class ProjectController @Autowired constructor(
        private val projectService: ProjectService
) {

    @GetMapping("{id}")
    @LoggableExecutionTime
    fun get(@PathVariable("id") id: String) =
            projectService.get(id)

    @PostMapping
    @ValidateRequest
    @LoggableExecutionTime
    fun post(@RequestBody @Valid project: ProjectDto, bindingResult: BindingResult): Project {
        return projectService.post(project)
    }


}