package com.fastcampus.example.domain.repository;

import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.entity.BookSalesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.Optional;

public interface BookMetaRepository extends JpaRepository<BookMeta, Long> {
  Optional<BookMeta> findById(Long id);
  BookMeta findFirstById(Long id);
}
