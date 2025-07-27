package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /** 글 작성 */
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody BoardDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(boardService.create(dto));
    }

    /** 전체 글 조회 */
    @GetMapping
    public List<BoardResponse> findAll() {
        return boardService.findAll();
    }

    /** 글 상세 */
    @GetMapping("/{id}")
    public BoardResponse findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    /** 글 수정 */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody BoardDto dto) {
        boardService.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    /** 글 삭제 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
