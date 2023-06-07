package com.surveybox.api.questiontype;


import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface QuestionTypeService {
    Page<QuestionType> findAll(Map<String,String> params);
    QuestionType create(QuestionType questionType);

    QuestionType getById(Long id );

    QuestionType updateById(Long id,QuestionType questionType);

    void deleteById(Long id);


}
