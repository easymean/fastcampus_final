package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {

  @Getter @Builder
  public static class Response{
    private final Long id;
    private final String name;
    private final LocalDateTime deletedAt;
  }

  @Getter
  public static class Update{
    @NotEmpty
    private String name;
  }

  @Getter
  public static class SignUp{
    @NotEmpty
    private String name;
  }
}
