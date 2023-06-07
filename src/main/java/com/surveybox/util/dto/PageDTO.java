package com.surveybox.util.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDTO {
    private List<?> list;
    private PaginationDTO pagination;
}