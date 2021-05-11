package com.fastcampus.example.domain.dto;

import lombok.Getter;

@Getter
public class UserId {
  private Long userId;

  public UserId(Long id){
    this.userId = id;
  }
}
