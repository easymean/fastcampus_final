package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class InvalidRequestException extends CommonException {
  public InvalidRequestException(){
    super("잘못된 접근입니다.", ErrorCode.INVALID_REQUEST);
  }
}
