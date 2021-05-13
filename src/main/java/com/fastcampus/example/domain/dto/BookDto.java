package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class BookDto {

  @Getter
  public static class Create{
    private String name;

    private Long price;

    private String isbn;
  }

  @Getter
  public static class Update{
    private String name;
  }

  @Getter
  @Builder
  public static class Response{
    private Long id;
    private String name;
    private Long price;
    private String isbn;
  }
}
