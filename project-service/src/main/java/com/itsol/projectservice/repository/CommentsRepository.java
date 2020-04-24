package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
