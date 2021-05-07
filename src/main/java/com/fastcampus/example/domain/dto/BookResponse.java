package com.fastcampus.example.domain.dto;

import com.fastcampus.example.domain.entity.BookMeta;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponse {
  private final Long id;
  private final String name;
  private final Long price;
  private final String isbn;

  public BookResponse(BookMeta bookMeta){
    this.id = bookMeta.getId();
    this.price = bookMeta.getPrice();
    this.name = bookMeta.getName();
    this.isbn = bookMeta.getIsbn();
  }

  @Builder
  public BookResponse(Long id, String name, Long price, String isbn){
    this.id = id;
    this.name = name;
    this.price = price;
    this.isbn = isbn;
  }
}
