package com.surveybox.api.feedBack;

import com.surveybox.api.feedBack.web.FeedBackDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string")
public interface FeedBackMapper {
    FeedBackMapper INSTANCE = Mappers.getMapper(FeedBackMapper.class);

    FeedBackDto toDto(FeedBack feedBack);

    FeedBack toEntity(FeedBackDto feedBackDto);

}
