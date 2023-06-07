package com.surveybox.api.user.web;

import com.surveybox.api.user.User;
import com.surveybox.api.user.UserMapper;
import com.surveybox.api.user.UserService;
import com.surveybox.base.BaseApi;
import com.surveybox.api.user.web.UserDto;
import com.surveybox.util.dto.PageDTO;
import com.surveybox.util.PageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account-profiles")
public class UserController {
    public final UserService accountProfileService;
    @PostMapping
    public BaseApi<?> createAccountProfile(@RequestBody User accountProfile){
        User accountProfileCreate = accountProfileService.create(accountProfile);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("everything is good")
                .timeStamp(LocalDateTime.now())
                .data(accountProfileCreate)
                .status(true)
                .build();
    }
    @GetMapping
    public BaseApi<?> accountProfileFindAll(@RequestParam Map<String,String>params){
        Page<User> page = accountProfileService.findAllAccount(params);

        PageDTO dto = PageMapper.INSTANCE.toDTO(page);
        dto.setList(page.get().map(UserMapper.INSTANCE::toDto).toList());
       // List<UserDto> findAllAccount =accountProfileService.findAllAccount(params).stream().map(UserMapper.INSTANCE::toDto).toList();
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("everything is good")
                .timeStamp(LocalDateTime.now())
                .data(dto)
                .status(true)
                .build();
    }

    @GetMapping("get/{id}")
    public BaseApi<?> accountProfileFindById(@PathVariable Long id){
       UserDto accountProfileDto = accountProfileService.getById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("everything is good")
                .timeStamp(LocalDateTime.now())
                .data(accountProfileDto)
                .status(true)
                .build();
    }
@DeleteMapping("{id}")
    public BaseApi<?> deleteAccountProfileById(@PathVariable Long id){
      accountProfileService.deleteById(id);
      return BaseApi.builder()
              .code(HttpStatus.OK.value())
              .message("everything is good")
              .timeStamp(LocalDateTime.now())
              .data(id)
              .status(true)
              .build();
}

@PutMapping("{id}")
    public BaseApi<?> updateById(@PathVariable("id") Long id ,@RequestBody User accountProfile){
    User updatedAccountProfile = accountProfileService.updateById(id, accountProfile);
    return BaseApi.builder()
            .code(HttpStatus.OK.value())
            .message("everything is good")
            .timeStamp(LocalDateTime.now())
            .data(updatedAccountProfile)
            .status(true)
            .build();
}

}
