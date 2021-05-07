package com.fastcampus.example.common;

import com.fastcampus.example.domain.type.ErrorStatusInf;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CommonException extends RuntimeException{

  @Getter
  @Enumerated(value = EnumType.STRING)
  private final ErrorStatusInf errorCode;

  public CommonException(String message, ErrorStatusInf errorCode){
    super(message);
    this.errorCode = errorCode;
  }

}
