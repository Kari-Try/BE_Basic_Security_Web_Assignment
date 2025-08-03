package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dto.*;
import com.example.demo.service.BoardService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardPageController {

    private final BoardService boardService;

    /** 목록 페이지 */
    @GetMapping
    public String list(Model m) {
        m.addAttribute("posts", boardService.findAll());
        return "board/list";
    }

    /** 작성 폼 */
    @GetMapping("/new")
    public String form() {
        return "board/post";
    }

    /** 저장 (폼 전송) */
    @PostMapping
    public String save(@ModelAttribute BoardDto dto) {
        Long id = boardService.create(dto);
        return "redirect:/board/" + id;
    }

    /** 상세 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model m) {
        m.addAttribute("post", boardService.findById(id));
        return "board/detail";
    }

    /** 수정 폼 */
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model m) {
        m.addAttribute("post", boardService.findById(id));
        return "board/update";
    }

    /** 수정 처리 */
    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute BoardDto dto) {
        boardService.update(id, dto);
        return "redirect:/board/" + id;
    }

    /** 삭제 */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/board";     // 목록으로 이동
    }
}
