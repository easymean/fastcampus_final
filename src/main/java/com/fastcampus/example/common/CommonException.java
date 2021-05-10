package com.fastcampus.example.common;

import com.fastcampus.example.domain.type.ErrorCode;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
public class CommonException extends RuntimeException{

  @Enumerated(value = EnumType.STRING)
  private ErrorCode errorCode;

  public CommonException(String message, ErrorCode errorCode){
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode(){
    return errorCode.getMessage();
  }


}
