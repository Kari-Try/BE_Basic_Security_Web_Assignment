package com.example.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardResponse;
import com.example.demo.entity.BoardEntity;
import com.example.demo.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public Long create(BoardDto dto) {
        BoardEntity post = BoardEntity.builder()
                .title(dto.title())
                .content(dto.content())
                .build();
        return boardRepository.save(post).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll().stream()
                .map(BoardResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse findById(Long id) {
        BoardEntity post = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post not found"));
        return BoardResponse.from(post);
    }

    public void update(Long id, BoardDto dto) {
        BoardEntity post = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post not found"));
        post.update(dto.title(), dto.content());
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
