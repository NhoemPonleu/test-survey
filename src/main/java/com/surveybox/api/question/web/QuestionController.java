package com.surveybox.api.question.web;

import com.surveybox.api.question.Question;
import com.surveybox.api.question.QuestionMapper;
import com.surveybox.api.question.QuestionService;
import com.surveybox.base.BaseApi;
import com.surveybox.util.PageMapper;
import com.surveybox.util.dto.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public BaseApi<?> createQuestion(@RequestBody QuestionDto questionDto) {
        Question question = QuestionMapper.INSTANCE.toEntity(questionDto);
        return BaseApi.builder()
                .data(questionService.createQuestion(question))
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @GetMapping
    public BaseApi<?> findAll(Map<String, String> params) {
        Page<Question> questions = questionService.findAll(params);
        PageDTO dto = PageMapper.INSTANCE.toDTO(questions);
        dto.setList(questions.get().map(QuestionMapper.INSTANCE::toDto).toList());
        return BaseApi.builder()
                .data(questions)
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @PutMapping("{id}")
    public BaseApi<?> updateByIdQuestion(@RequestBody QuestionDto questionDto, @PathVariable Long id) {
        Question question = QuestionMapper.INSTANCE.toEntity(questionDto);
        question = questionService.updateByIdQuestion(id, question);
        return BaseApi.builder()
                .data(question)
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public BaseApi<?> deleteByIdQuestion(@PathVariable Long id) {
        questionService.deleteById(id);
        return BaseApi.builder()
                .data("you have have delete by id: " + id)
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @GetMapping("{id}")
        public BaseApi<?> getUserById(@PathVariable Long id){
        Question question = questionService.getById(id);
        return BaseApi.builder()
                .data(question)
                .message("your have do it good")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }
}
