package com.surveybox.api.user.web;

public record UserDto(

        String firstName,
        String lastName,
        Integer phoneNumber,
        String avatar,
        String dob,
        String address,
        String company,
        String position
) {
}
