package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {}