package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Issue;
import com.itsol.projectservice.domain.StatusType;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.dto.StatusDto;
import com.itsol.projectservice.dto.StatusTypeDto;
import com.itsol.projectservice.dto.request.SearchIssueDto;
import com.itsol.projectservice.dto.response.GetListDataResponseDTO;
import com.itsol.projectservice.repository.IssueRepository;
import com.itsol.projectservice.repository.IssueRepositoryCustom;
import com.itsol.projectservice.repository.ProjectRepository;
import com.itsol.projectservice.repository.StatusRepository;
import com.itsol.projectservice.service.IssueService;
import com.itsol.projectservice.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)//xay ra exception thi quay lai
public class IssueServiceImpl implements IssueService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private  ModelMapper modelMapper;//truyen data giữa 2 object
    @Autowired
    private IssueRepositoryCustom issueRepositoryCustom;

    @Override
    @Transactional(readOnly = true)
    public List<IssueDto> getAllIssue() {
        logger.trace("Service to get all Issue");
        List<Issue> issueList= issueRepository.findAll();
        modelMapper = new ModelMapper();
        return issueList.stream().map(issue ->
                modelMapper.map(issue, IssueDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(IssueDto issueDto) {
        logger.trace("Service   1qto create issue: {}", issueDto);
        Issue issue = modelMapper.map(issueDto,Issue.class);
        issueRepository.save(issue);
        System.out.println(issue);
    }

    @Override
    public void update(IssueDto issueDto) {
        Issue issue = issueRepository.getOne(issueDto.getId());
        issue.setName(issueDto.getName());
        issue.setDescription(issueDto.getDescription());
        issue.setDonePercent(issueDto.getDonePercent());
        issue.setPriority(issueDto.getPriority());
        issue.setDueDate(issueDto.getDueDate());
        issue.setStartDate(issueDto.getStartDate());
        issue.setReason(issueDto.getReason());
        issue.setType(issueDto.getType());
        issue.setStatus(statusRepository.getOne(issueDto.getStatusId()));
        issue.setProject(projectRepository.getOne(issueDto.getProjectId()));
    }

    @Override
    public void delete(long issueId) {
        issueRepository.deleteById(issueId);
    }

    @Override
    public void deleteIds(Long[] ids) {
        for(Long id: ids){
            issueRepository.deleteById(id);
        }
    }

    @Override
    public IssueDto getIssueID(Long issueId) {
        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        return issueOptional
                .map(issue->modelMapper.map(issue, IssueDto.class))
                .orElse(null);
    }

    @Override
    public GetListDataResponseDTO<IssueDto> getListByParams( SearchIssueDto requestDTO) {
        logger.info("--- Request to get list employees by params: {} " + requestDTO.toString());
        GetListDataResponseDTO<IssueDto> result = new GetListDataResponseDTO<>();
        Page<IssueDto> rawDatas = issueRepositoryCustom.getListByParams(requestDTO);
        result.setResult(rawDatas.getContent(), rawDatas.getTotalElements(), rawDatas.getTotalPages());
        logger.info("Response to get list employees by params: " + result.getMessage());
        return result;
    }


}
