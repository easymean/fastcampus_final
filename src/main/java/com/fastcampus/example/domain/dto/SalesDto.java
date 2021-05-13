package com.fastcampus.example.domain.dto;

import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SalesDto {

  @Getter
  public static class Update{
    @NotNull
    private Long stock;
    @NotNull
    private Boolean purchasable;
    @NotNull
    private Boolean exposable;
  }

  @Getter
  @Builder
  public static class Response{
    private Long id;

    private User seller;

    private BookMeta book;

    private Long stock;

    private Boolean purchasable;

    private Boolean exposable;
  }

}
