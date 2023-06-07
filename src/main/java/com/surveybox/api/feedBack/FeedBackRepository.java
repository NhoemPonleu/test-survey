package com.surveybox.api.feedBack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {

    @Query("SELECT e FROM FeedBack e WHERE e.timestamp >= CURRENT_TIMESTAMP()")
    List<FeedBack> findRecentExamples();
}
