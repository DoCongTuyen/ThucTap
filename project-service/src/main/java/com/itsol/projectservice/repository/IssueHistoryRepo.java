package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepo extends JpaRepository<IssueHistory, Long> {


}
