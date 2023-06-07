package com.surveybox.api.vote;

import com.surveybox.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService{
    private final VoteRepository voteRepository;

    @Override
    public Page<Vote> getAllVote(Map<String,String>params) {
        Pageable pageUtil= PageUtils.getPageable(params);
        return  voteRepository.findAll(pageUtil);
    }

    @Override
    public Vote CreateVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
