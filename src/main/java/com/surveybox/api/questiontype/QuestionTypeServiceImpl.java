package com.surveybox.api.questiontype;
import com.surveybox.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionTypeService {
  private final QuestionTypeRepository questionTypeRepository;
    @Override
    public Page<QuestionType> findAll(Map<String,String> params) {
        Pageable pageUtil = PageUtils.getPageable(params);
        return questionTypeRepository.findAll(pageUtil);
    }

    @Override
    public QuestionType create(QuestionType questionType) {

        return questionTypeRepository.save(questionType);
    }

    @Override
    public QuestionType getById(Long id) {

        QuestionType questionType = questionTypeRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus
                        .NOT_FOUND,String.format("not found your {}"+id)));
        return questionType;
    }

    @Override
    public QuestionType updateById(Long id, QuestionType questionType) {

            QuestionType questionTypeUpdate = getById(id);
            BeanUtils.copyProperties(questionType,questionTypeUpdate,"id");
        return questionTypeRepository.save(questionTypeUpdate);
    }

    @Override
    public void deleteById(Long id) {
        QuestionType questionType =getById(id);
        questionTypeRepository.delete(questionType);
    }


}
