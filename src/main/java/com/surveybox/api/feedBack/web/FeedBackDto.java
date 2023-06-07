package com.surveybox.api.feedBack.web;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FeedBackDto(
        String title,
        String description,
        LocalDateTime timestamp
) {
}
