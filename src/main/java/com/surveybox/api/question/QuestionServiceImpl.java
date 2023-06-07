package com.surveybox.api.question;

import com.surveybox.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        Question question1 = questionRepository.save(question);
        return question1;
    }

    @Override
    public Page<Question> findAll(Map<String, String> params) {
        Pageable pageable = PageUtils.getPageable(params);
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question updateByIdQuestion(Long id, Question question) {
        Question question1 = getById(id);
        BeanUtils.copyProperties(question, question1, "id");
        return questionRepository.save(question1);
    }

    @Override
    public Question getById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Not found this id:" + id)));

        return question;
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(
                id
        );
    }
}
