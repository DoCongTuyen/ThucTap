package com.itsol.projectservice.rest;

import com.itsol.projectservice.domain.Issue;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.StatusTypeDto;
import com.itsol.projectservice.dto.request.SearchIssueDto;
import com.itsol.projectservice.dto.response.GetListDataResponseDTO;
import com.itsol.projectservice.service.Impl.IssueServiceImpl;
import com.itsol.projectservice.service.IssueService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/issue")
@CrossOrigin("*")
public class IssueController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IssueServiceImpl issueService;
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/get-all")
    ResponseEntity<List<IssueDto>> getAllIssue() {
        logger.trace("REST to request get all issue.");
        List<IssueDto> data = issueService.getAllIssue();
        return new ResponseEntity<>(data, HttpStatus.OK);
        //tra ve doi tuong ResponseEntity chua du lieu tao ra va httpstatus
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveIssue(@RequestBody IssueDto issueDto) {
        logger.trace("REST to request create issue: {}", issueDto);
        try {
            issueService.create(issueDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{issueId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long issueId) {
        logger.trace("REST to request delete product: {}", issueId);
        try {
            issueService.delete(issueId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-one/{issueId}")
    public ResponseEntity<IssueDto> getIssue(@PathVariable Long issueId) {
        IssueDto issueDto = issueService.getIssueID(issueId);
        if (issueDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(issueDto, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<IssueDto> updateIssue(@RequestBody IssueDto issueDto) {
        try {
            issueService.update(issueDto);
            return new ResponseEntity<>(issueDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/issue-by-params", method = RequestMethod.POST)
    public ResponseEntity<GetListDataResponseDTO<IssueDto>> getListByParams(@RequestBody SearchIssueDto requestDTO) {
        logger.info("--- Rest request to get employees by params: {} " + requestDTO.toString());
        GetListDataResponseDTO<IssueDto> result = issueService.getListByParams(requestDTO);
        logger.info("Rest response of get employees by params: " + result.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<IssueDto> deleteByIds(@RequestBody Long[] ids) {
        issueService.deleteIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
