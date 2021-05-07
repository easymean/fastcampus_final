package com.fastcampus.example.web.service;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.BookResponse;
import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.repository.BookMetaRepository;
import com.fastcampus.example.domain.type.BookMetaStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookMetaService {

  private final BookMetaRepository bookMetaRepository;

  public BookMetaService(BookMetaRepository bookMetaRepository) {
    this.bookMetaRepository = bookMetaRepository;
  }

  public BookResponse findById(Long id) {

    return bookMetaRepository.findById(id)
        .map(bookMeta -> BookResponse.builder()
            .id(bookMeta.getId())
            .name(bookMeta.getName())
            .price(bookMeta.getPrice())
            .isbn(bookMeta.getIsbn())
            .build())
        .orElseGet(()-> {
          throw new CommonException("데이터가 존재하지 않습니다.", BookMetaStatus.BOOK_META_NOT_FOUND);
        });

  }

}
