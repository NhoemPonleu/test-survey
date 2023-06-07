package com.surveybox.api.vote;

import com.github.pagehelper.PageInfo;
import com.surveybox.api.vote.web.VoteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapStruct {
    PageInfo<VoteDto> votePageInfoToVoteDtoPageInfo(PageInfo<Vote> votePageInfo);
}
