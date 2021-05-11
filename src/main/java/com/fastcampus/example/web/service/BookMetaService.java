package com.fastcampus.example.web.service;

import com.fastcampus.example.domain.dto.BookDto;
import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.repository.BookMetaRepository;
import com.fastcampus.example.exception.BookMetaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookMetaService {

  private final BookMetaRepository bookMetaRepository;

  public BookMetaService(BookMetaRepository bookMetaRepository) {
    this.bookMetaRepository = bookMetaRepository;
  }

  public BookDto.Response findById(Long id) {

    return bookMetaRepository.findById(id)
        .map(BookMeta::mapper)
        .orElseGet(() -> {
          throw new BookMetaNotFoundException();
        });
  }

  public BookDto.Response createBookMeta(BookDto.Create req) {
    BookMeta bookMeta = BookMeta.builder()
        .name(req.getName())
        .price(req.getPrice())
        .isbn(req.getIsbn())
        .build();

    BookMeta newBookMeta = bookMetaRepository.save(bookMeta);
    return newBookMeta.mapper();
  }

  public BookDto.Response updateBookMeta(Long id, BookDto.Update req) {
    Optional<BookMeta> optional = bookMetaRepository.findById(id);

    return optional.map(
        book -> {
          book.setName(req.getName());
          return book;
        }
    ).map(bookMetaRepository::save)
        .map(BookMeta::mapper)
        .orElseGet(() -> {
          throw new BookMetaNotFoundException();
        });
  }

}
