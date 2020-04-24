package com.itsol.projectservice.repository;

import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.request.SearchIssueDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepositoryCustom {
    Page<IssueDto> getListByParams(SearchIssueDto requestDto);
}
