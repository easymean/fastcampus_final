package com.fastcampus.example.common;

import lombok.*;

@Getter
public class CommonResponse<T>{

  private final String error_code;
  private final String message;
  private final T data;

  private CommonResponse(String message, String error_code, T data){
    this.message = message;
    this.data = data;
    this.error_code = error_code;
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
