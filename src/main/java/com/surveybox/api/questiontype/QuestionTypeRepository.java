package com.surveybox.api.questiontype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
