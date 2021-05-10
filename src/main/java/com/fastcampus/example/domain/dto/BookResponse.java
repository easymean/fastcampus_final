package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponse {
  private final Long id;
  private final String name;
  private final Long price;
  private final String isbn;

  @Builder
  public BookResponse(Long id, String name, Long price, String isbn){
    this.id = id;
    this.name = name;
    this.price = price;
    this.isbn = isbn;
  }
}
