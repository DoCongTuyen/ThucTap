package com.itsol.projectservice.service;


import com.itsol.projectservice.domain.Issue;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.request.SearchIssueDto;
import com.itsol.projectservice.dto.response.GetListDataResponseDTO;

import java.util.List;

public interface IssueService {

    List<IssueDto> getAllIssue();

    void create(IssueDto issueDto);

    void update(IssueDto issueDto);

    void delete(long issueId);

    void deleteIds(Long[] ids);
    IssueDto getIssueID(Long issueId);
    GetListDataResponseDTO<IssueDto> getListByParams(SearchIssueDto requestDTO);
}

