package com.example.demo.dto;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;

/**
 * 글 조회(목록·단건) 응답 DTO
 */
@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;

    // 생성자
    public BoardResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    /** 엔티티 → DTO 변환 편의 메서드 */
    public static BoardResponse from(BoardEntity e) {
        return new BoardResponse(e.getId(), e.getTitle(), e.getContent());
    }
}
