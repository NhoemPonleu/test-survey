package com.surveybox.api.questiontype.web;

import jakarta.validation.constraints.NotNull;

public record QuestionTypeDto(@NotNull String name) {

}
