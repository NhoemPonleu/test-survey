package com.surveybox.api.vote.web;

import lombok.Data;

@Data
public class VoteDto{
        Integer id;
        String title;
        String choose;
        Boolean status;
}
