package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType,Long> {
}
