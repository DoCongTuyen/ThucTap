package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.StatusDto;
import com.itsol.projectservice.service.Impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;

    @RequestMapping("/getAll")
    ResponseEntity<List<StatusDto>> getAll(){
        return new ResponseEntity<>(statusService.getAllStatus(), HttpStatus.OK);
    }
}
