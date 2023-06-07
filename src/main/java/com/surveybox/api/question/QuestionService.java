package com.surveybox.api.question;

import org.springframework.data.domain.Page;

import java.util.Map;

public interface QuestionService {
    Question createQuestion(Question question);

    Page<Question> findAll(Map<String, String> params);

    Question updateByIdQuestion(Long id, Question question);

    Question getById(Long id);

    void deleteById(Long id);
}
