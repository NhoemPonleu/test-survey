package com.surveybox.api.vote;

import org.springframework.data.domain.Page;

import java.util.Map;

public interface VoteService {
     Page<Vote> getAllVote(Map<String,String>params);
     Vote CreateVote(Vote vote);
}
