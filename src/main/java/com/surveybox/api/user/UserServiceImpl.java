package com.surveybox.api.user;

import com.surveybox.api.user.spec.UserFilter;
import com.surveybox.api.user.spec.UserSpec;
import com.surveybox.api.user.web.UserDto;
import com.surveybox.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository accountProfileRepository;

    @Override
    public User create(User accountProfile) {

        return accountProfileRepository.save(accountProfile);
    }



    @Override
    public Page<User> findAllAccount(Map<String, String> params) {

        Pageable pageable = PageUtils.getPageable(params);

        UserFilter userFillter = new UserFilter();

        if (params.containsKey(com.surveybox.api.user.spec.property.UserFilter.ID)) {
            userFillter.setUserId(params.get(com.surveybox.api.user.spec.property.UserFilter.ID));
        }



        if (params.containsKey(com.surveybox.api.user.spec.property.UserFilter.FIRST_NAME)) {
            userFillter.setFirstName(params.get(com.surveybox.api.user.spec.property.UserFilter.FIRST_NAME));
        }



        if (params.containsKey(com.surveybox.api.user.spec.property.UserFilter.LAST_NAME)) {
            userFillter.setLastName(params.get(com.surveybox.api.user.spec.property.UserFilter.LAST_NAME));
        }



        if (params.containsKey(com.surveybox.api.user.spec.property.UserFilter.FULL_NAME)) {
            userFillter.setFullName(params.get(com.surveybox.api.user.spec.property.UserFilter.FULL_NAME));
        }



        UserSpec userSpec = new UserSpec(userFillter);

        Page<User> accountProfiles = accountProfileRepository.findAll(userSpec, pageable);

        return accountProfiles;
    }

    @Override
    public UserDto getById(Long id) {


        User accountProfile = accountProfileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND
                        , String.format("not found your {}", id)));
        UserDto accountProfileDto = UserMapper.INSTANCE.toDto(accountProfile);

        return accountProfileDto;
    }



    @Override
    public void deleteById(Long id) {
        if (getById(id) != null) {
            accountProfileRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found your id that you want to see");
        }
    }



    @Override
    public User updateById(Long id, User accountProfile) {
        User existingAccountProfile = accountProfileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User not found with ID: " + id)));
        if (getById(id) != null) {
            existingAccountProfile.setLastName(accountProfile.getLastName());
            existingAccountProfile.setFirstName(accountProfile.getFirstName());
            existingAccountProfile.setId(accountProfile.getId());
            existingAccountProfile.setCompany(accountProfile.getCompany());
            existingAccountProfile.setAvatar(accountProfile.getAvatar());
            existingAccountProfile.setAddress(accountProfile.getAddress());
            existingAccountProfile.setDob(accountProfile.getDob());
            existingAccountProfile.setPassword(accountProfile.getPassword());
            existingAccountProfile.setPosition(accountProfile.getPosition());
            existingAccountProfile.setPhoneNumber(accountProfile.getPhoneNumber());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("not found ID:" + id));
        }
        return accountProfileRepository.save(existingAccountProfile);

    }


}
