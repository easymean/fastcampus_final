package com.fastcampus.example.domain.type;

import lombok.Getter;

@Getter
public enum ErrorCode {
  INVALID_PARAMETER(1001, "INVALID_PARAMETER"),
  INVALID_HEADER(1002, "INVALID_HEADER"),
  INVALID_REQUEST(1003, "INVALID_REQUEST"),

  ACCESS_DENIED(1004, "ACCESS_DENIED"),

  NOT_FOUND(1005, "NOT_FOUND"),

  USER_NOT_FOUND(1006, "USER_NOT_FOUND"),

  BOOK_META_NOT_FOUND(1007, "BOOK_META_NOT_FOUND"),
  BOOK_META_INVALID_PARAMETER(1008, "BOOK_META_INVALID_PARAMETER"),
  ;

  private String message;
  private int code;

  ErrorCode(int code, String message){

    this.code = code;
    this.message = message;
  }
}
