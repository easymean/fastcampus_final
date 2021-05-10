package com.fastcampus.example.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
  private Long userId;
}
