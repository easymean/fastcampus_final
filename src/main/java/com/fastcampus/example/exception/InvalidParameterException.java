package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class InvalidParameterException extends CommonException {
  public InvalidParameterException(){
    super("필요한 정보가 누락되었습니다.", ErrorCode.INVALID_PARAMETER);
  }
}
