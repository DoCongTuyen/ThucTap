package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.service.Impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping("/getAll")
    ResponseEntity<List<ProjectDto>> getAll(){
        return  new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }
}
