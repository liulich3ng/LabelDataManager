package com.liulich3ng.controller;

import com.liulich3ng.dto.request.ProjectCreateDTO;
import com.liulich3ng.entity.Project;
import com.liulich3ng.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/projects")
    public Page<Project> findAll() {
        // todo: 硬编码获取第一页数据
        return projectService.findAllProjects(0, 10);
    }

    @GetMapping("/projects/{id}")
    public Project findOne(@PathVariable int id) {
        return projectService.findById(id);
    }

    @PostMapping("/projects")
    public void createProject(@RequestBody @Valid ProjectCreateDTO projectCreateDTO) {
        // todo: 随便写了一个只依靠名字就能创建项目
        String projectName = projectCreateDTO.getProjectName();
        projectService.createProject(projectName);
    }
}
