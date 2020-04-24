package com.itsol.projectservice.service;

import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProject();

    void create(Project project);
    void update(Project project);
    void delete(long projectId);
    ProjectDto getProjectById(Long projectId);

}
