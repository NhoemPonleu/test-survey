package com.surveybox.api.questiontype.web;

import com.surveybox.api.questiontype.QuestionType;
import com.surveybox.api.questiontype.QuestionTypeMapper;
import com.surveybox.api.questiontype.QuestionTypeService;
import com.surveybox.base.BaseApi;
import com.surveybox.util.PageMapper;
import com.surveybox.util.dto.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/v1/question-types")
@RestController
public class QuestionTypeController {
    private final QuestionTypeService questionTypeService;
    @GetMapping
    public BaseApi<?> findAll(Map<String,String> params) {
        Page<QuestionType> questionTypes = questionTypeService.findAll(params);
        PageDTO dto = PageMapper.INSTANCE.toDTO(questionTypes);
        dto.setList(questionTypes.get().map(QuestionTypeMapper.INSTANCE::toDto).toList());
        return BaseApi.builder()
                .data(questionTypes)
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }



    @PostMapping
    public BaseApi<?> create(@RequestBody QuestionTypeDto questionTypeDto) {
        QuestionType questionType = QuestionTypeMapper.INSTANCE.toEntity(questionTypeDto);
        questionTypeService.create(questionType);
        QuestionType questionType1 = questionTypeService.create(questionType);
        return BaseApi.builder()
                .data(questionType1)
                .message("your have do it nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }



    @GetMapping("{id}")
    public BaseApi<?> findById(@PathVariable("id") Long id) {
        QuestionType questionType = questionTypeService.getById(id);
        return BaseApi.builder()
                .data(questionType)
                .message("your have findById it nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }



    @PutMapping("{id}")
    public BaseApi<?> updateByid(@PathVariable("id") Long id, @RequestBody QuestionTypeDto questionTypeDto) {
        QuestionType questionType = QuestionTypeMapper.INSTANCE.toEntity(questionTypeDto);
        questionType = questionTypeService.updateById(id, questionType);
        return BaseApi.builder()
                .data(questionType)
                .message("your have updateByid it nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }



    @DeleteMapping("{id}")
    public BaseApi<?> deleteById(@PathVariable("id") Long id) {
        questionTypeService.deleteById(id);
        return BaseApi.builder()
                .data(id)
                .message("your have updateByid it nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }
}
