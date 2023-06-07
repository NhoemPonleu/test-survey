package com.surveybox.api.user;

import com.surveybox.api.user.web.UserDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface UserService {
    User create(User accountProfile);

    Page<User> findAllAccount(Map<String, String> params);

    UserDto getById(Long id);

    void deleteById(Long id);

    User updateById(Long id, User accountProfile);


}
