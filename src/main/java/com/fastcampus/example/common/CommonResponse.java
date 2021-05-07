package com.fastcampus.example.common;

import com.fastcampus.example.domain.dto.BookResponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class CommonResponse<T> {

  private final LocalDateTime transactionTime;
  private final String error_code;
  private final String message;
  private final T data;

  private CommonResponse(String message, String error_code, T data){
    this.message = message;
    this.data = data;
    this.error_code = error_code;
    this.transactionTime = LocalDateTime.now();
  }

  public static <T> CommonResponse<T> ok(T data){
    return new CommonResponse<>("",null, data);
  }

  public static <T> CommonResponse<T> ok(String message, T data){
    return new CommonResponse<>(message, null, data);
  }

  public static <T> CommonResponse<T> error(String message, String error_code){
    return new CommonResponse<>(message, error_code, null);
  }

}
