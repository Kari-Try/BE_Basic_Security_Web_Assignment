package com.example.demo.dto;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 글 조회(목록·단건) 응답 DTO
 */
@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;   // ★ 추가

    public BoardResponse(Long id, String title, String content,
                         LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;          // ★
    }

    public static BoardResponse from(BoardEntity e) {
        return new BoardResponse(
                e.getId(),
                e.getTitle(),
                e.getContent(),
                e.getCreatedAt()                 // ★
        );
    }
}
