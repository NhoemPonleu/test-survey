package com.surveybox.api.user;

import com.surveybox.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User accountProfile);

    User toEntity(UserDto accountProfileDto);
}
