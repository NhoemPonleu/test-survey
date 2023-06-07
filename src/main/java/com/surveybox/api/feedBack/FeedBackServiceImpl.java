package com.surveybox.api.feedBack;

import com.surveybox.api.feedBack.web.FeedBackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackRepository feedBackRepository;

    @Override
    public FeedBack create(FeedBackDto feedBackDto) {
        FeedBack feedBack = FeedBackMapper.INSTANCE.toEntity(feedBackDto);
        feedBackRepository.findRecentExamples();
        return feedBackRepository.save(feedBack);
    }

    @Override
    public void deleteById(Long id) {
        feedBackRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        feedBackRepository.deleteAll();
    }

    @Override
    public List<FeedBack> findAllFeedback() {

        return feedBackRepository.findAll();
    }


}
