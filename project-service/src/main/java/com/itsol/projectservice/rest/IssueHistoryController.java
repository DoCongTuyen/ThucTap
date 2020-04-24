package com.itsol.projectservice.rest;

import com.itsol.projectservice.domain.IssueHistory;
import com.itsol.projectservice.dto.IssueHistoryDto;
import com.itsol.projectservice.service.Impl.IssueHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/issueHistory")
public class IssueHistoryController {

    @Autowired
    private IssueHistoryServiceImpl issueHistoryService;

    @GetMapping("/")
    ResponseEntity<List<IssueHistoryDto>> getList(){
        List<IssueHistoryDto> list = issueHistoryService.getAllIssueHistory();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Void> create(@RequestBody IssueHistoryDto issueHistoryDto){
        try {
//            issueHistoryDto.setUpdateDate(new Timestamp(System.currentTimeMillis()));
            issueHistoryService.create(issueHistoryDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
