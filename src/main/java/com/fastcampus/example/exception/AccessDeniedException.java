package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class AccessDeniedException extends CommonException {
  public AccessDeniedException(){
    super("접근 권한이 없습니다.", ErrorCode.ACCESS_DENIED);
  }
}
