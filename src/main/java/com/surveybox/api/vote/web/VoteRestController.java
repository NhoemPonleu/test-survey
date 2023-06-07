package com.surveybox.api.vote.web;

import com.surveybox.api.vote.Vote;
import com.surveybox.api.vote.VoteMapper;
import com.surveybox.api.vote.VoteService;
import com.surveybox.base.BaseApi;
import com.surveybox.util.PageMapper;
import com.surveybox.util.dto.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteRestController {
    private final VoteService voteService;

    @GetMapping
    public BaseApi<?> getVotes(Map<String,String> params) {
        Page<Vote> votes = voteService.getAllVote(params);
//        Page<User> page = accountProfileService.findAllAccount(params);
//
       PageDTO dto = PageMapper.INSTANCE.toDTO(votes);
        dto.setList(votes.get().map(VoteMapper.INSTANCE::toDto).toList());
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("you have been get all votes")
                .timeStamp(LocalDateTime.now())
                .data(votes)
                .status(true)
                .build();
    }
    @PostMapping
    public ResponseEntity<?>createVote(@RequestBody VoteDto voteDto){
       Vote vote= VoteMapper.INSTANCE.toEntity(voteDto);
       Vote voteDto1=voteService.CreateVote(vote);
        return ResponseEntity.ok(voteDto1);

    }
}
