package com.surveybox.api.questiontype;

import com.surveybox.api.questiontype.web.QuestionTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionTypeMapper {
    QuestionTypeMapper INSTANCE = Mappers.getMapper(QuestionTypeMapper.class);
    QuestionTypeDto toDto(QuestionType questionType);
    QuestionType toEntity(QuestionTypeDto questionTypeDto);
}
