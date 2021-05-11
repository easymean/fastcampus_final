package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

public class UserDto {

  @Getter @Builder
  public static class Response{
    private final Long id;
    private final String name;
  }

  @Getter
  public static class Update{
    private String name;
  }

  @Getter
  public static class SignUp{
    private String name;
  }
}
