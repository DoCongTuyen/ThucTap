package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Issue;
import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.repository.ProjectRepository;
import com.itsol.projectservice.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProjectDto> getAllProject() {
        List<Project> list= projectRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(project ->
                modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(long projectId) {

    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        return null;
    }

}
