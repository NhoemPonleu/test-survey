package com.surveybox.api.feedBack;


import com.surveybox.api.feedBack.web.FeedBackDto;

import java.util.List;

public interface FeedBackService {
    FeedBack create(FeedBackDto feedBackDto);

    void deleteById(Long id);

    void deleteAll();

    List<FeedBack> findAllFeedback();
}
