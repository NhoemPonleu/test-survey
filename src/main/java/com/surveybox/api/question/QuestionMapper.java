package com.surveybox.api.question;

import com.surveybox.api.question.web.QuestionDto;
import com.surveybox.api.questiontype.QuestionTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    QuestionDto toDto(Question question);
    Question toEntity(QuestionDto questionDto);
}
