package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.IssueHistoryDto;

import java.util.List;

public interface IssueHistoryService {
    List<IssueHistoryDto> getAllIssueHistory();

    void create(IssueHistoryDto issueHistoryDto);
}
