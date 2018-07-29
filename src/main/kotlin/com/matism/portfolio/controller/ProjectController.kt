package com.matism.portfolio.controller

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
) : AbstractController() {

    @GetMapping("{id}")
    fun get(@PathVariable("id") id: String) =
            projectService.get(id)

    @PostMapping
    fun post(@RequestBody @Valid project: ProjectDto, bindingResult: BindingResult): Project {
        validateRequest(bindingResult)
        return projectService.post(project)
    }


}