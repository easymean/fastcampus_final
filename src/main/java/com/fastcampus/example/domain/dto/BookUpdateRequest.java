package com.fastcampus.example.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;


@Getter
public class BookUpdateRequest {

  @NotEmpty
  private String name;
}
