package com.fastcampus.example.web.service;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.dto.BookRequest;
import com.fastcampus.example.domain.dto.BookResponse;
import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.repository.BookMetaRepository;
import com.fastcampus.example.domain.type.ErrorCode;
import com.fastcampus.example.exception.BookMetaNotFoundException;
import com.fastcampus.example.exception.InvalidParameterException;
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
        .map(BookMeta::mapper)
        .orElseGet(() -> {
          throw new BookMetaNotFoundException();
        });
  }

  public BookResponse createBookMeta(BookRequest req) {
    BookMeta bookMeta = BookMeta.builder()
        .name(req.getName())
        .price(req.getPrice())
        .isbn(req.getIsbn())
        .build();

    BookMeta newBookMeta = bookMetaRepository.save(bookMeta);
    return newBookMeta.mapper();
  }

  public BookResponse updateBookMeta(Long id, BookRequest req) {
    Optional<BookMeta> optional = bookMetaRepository.findById(id);

    return optional.map(
        book -> {
          book.setName(req.getName());
          return book;
        }
    ).map(bookMetaRepository::save)
        .map(BookMeta::mapper)
        .orElseGet(() -> {
          throw new InvalidParameterException();
        });
  }

}
