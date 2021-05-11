package com.fastcampus.example.domain.dto;

import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

public class SalesDto {

  @Getter
  public static class Update{
    private Long id;

    private Long stock;

    private Boolean purchasable;

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
