package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class BookDto {

  @Getter
  public static class Create{
    @NotEmpty
    private String name;

    @NotEmpty
    private Long price;

    @NotEmpty
    private String isbn;
  }

  @Getter
  public static class Update{
    @NotEmpty
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
