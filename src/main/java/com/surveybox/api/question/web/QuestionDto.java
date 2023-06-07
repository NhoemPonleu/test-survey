package com.surveybox.api.question.web;

import lombok.Builder;

@Builder
public record QuestionDto(
        String title
) {
}
