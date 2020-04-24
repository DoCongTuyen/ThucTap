package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
