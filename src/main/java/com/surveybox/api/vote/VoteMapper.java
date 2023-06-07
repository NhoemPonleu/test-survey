package com.surveybox.api.vote;

import com.surveybox.api.vote.web.VoteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VoteMapper {
 VoteMapper INSTANCE=Mappers.getMapper(VoteMapper.class);
  Vote toEntity(VoteDto voteDto);
  VoteDto toDto(Vote vote);
}
