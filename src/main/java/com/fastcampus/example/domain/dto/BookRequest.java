package com.fastcampus.example.domain.dto;

import lombok.Getter;

@Getter
public class BookRequest {
  private String name;
  private Long price;
  private String isbn;
}
