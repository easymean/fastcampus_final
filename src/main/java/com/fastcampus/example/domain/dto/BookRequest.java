package com.fastcampus.example.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;


@Getter
public class BookRequest {

  @NotEmpty
  private String name;

  @NotEmpty
  private Long price;

  @NotEmpty
  private String isbn;
}
