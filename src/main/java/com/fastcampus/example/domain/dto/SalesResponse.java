package com.fastcampus.example.domain.dto;

import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.domain.entity.User;
import com.fastcampus.example.domain.type.SalesStatus;
import lombok.Getter;

import javax.persistence.*;

@Getter
public class SalesResponse {
  private Long id;

  private User seller;

  private BookMeta book;

  private Long stock;

  private Long purchasable;

  private Long exposable;
}
