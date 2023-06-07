package com.surveybox.api.feedBack.web;

import com.surveybox.api.feedBack.FeedBackMapper;
import com.surveybox.api.feedBack.FeedBackService;
import com.surveybox.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feedbacks")
public class FeedBackController {
    private final FeedBackService feedBackService;

    @PostMapping()
    public BaseApi<?> createFeedBack(@RequestBody FeedBackDto feedBackDto) {
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data(feedBackService.create(feedBackDto))
                .status(true)
                .build();
    }


    @DeleteMapping("{id}")
    public BaseApi<?> feedbackDeleteById(@PathVariable Long id) {
        feedBackService.deleteById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data("your delete id : " + id)
                .status(true)
                .build();
    }


    @DeleteMapping("/delete-all")
    public BaseApi<?> feedbackDeleteAll() {
        feedBackService.deleteAll();

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data("delete all")
                .status(true)
                .build();
    }


    @GetMapping
    public BaseApi<?> findAllFeedback() {
        List<FeedBackDto> feedBacksDto = feedBackService.findAllFeedback().stream().map(FeedBackMapper.INSTANCE::toDto).toList();
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data(feedBacksDto)
                .status(true)
                .build();
    }
}
