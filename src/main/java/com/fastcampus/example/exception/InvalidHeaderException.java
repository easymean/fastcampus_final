package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class InvalidHeaderException extends CommonException {
  public InvalidHeaderException(){
    super("로그인이 필요한 서비스입니다.", ErrorCode.INVALID_HEADER);
  }
}
