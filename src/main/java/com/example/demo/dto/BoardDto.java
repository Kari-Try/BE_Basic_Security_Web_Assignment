package com.example.demo.dto;

/** 글 작성·수정 요청 DTO */
public record BoardDto(
        String title,
        String content
) {}
