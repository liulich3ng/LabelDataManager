package com.liulich3ng.service;

import com.liulich3ng.entity.Project;
import com.liulich3ng.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Page<Project> findAllProjects(int pageNum, int pageSize) {
        return projectRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public void createProject(String name) {
        Project project = Project.builder()
                .name(name)
                .build();
        projectRepository.save(project);
    }

    public Project findById(int id) {
        return projectRepository.findById(id).orElseThrow();
    }
}
