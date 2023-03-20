package com.liulich3ng.repository;

import com.liulich3ng.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Override
    Page<Project> findAll(Pageable pageable);
}
