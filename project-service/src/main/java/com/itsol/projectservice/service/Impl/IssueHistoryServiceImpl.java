package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Issue;
import com.itsol.projectservice.domain.IssueHistory;
import com.itsol.projectservice.dto.IssueHistoryDto;
import com.itsol.projectservice.repository.IssueHistoryRepo;
import com.itsol.projectservice.service.IssueHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    @Autowired
    private IssueHistoryRepo issueHistoryRepo;
    @Autowired
    private ModelMapper modelMapper;//truyen data giữa 2 object

    @Override
    public List<IssueHistoryDto> getAllIssueHistory() {
        List<IssueHistory> list = issueHistoryRepo.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(issueHistory ->
            modelMapper.map(issueHistory,IssueHistoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(IssueHistoryDto issueHistoryDto) {
        IssueHistory issue = modelMapper.map(issueHistoryDto,IssueHistory.class);
        issueHistoryRepo.save(issue);
    }
}
