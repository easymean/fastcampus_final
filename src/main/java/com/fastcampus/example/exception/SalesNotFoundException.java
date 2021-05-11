package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class SalesNotFoundException extends CommonException {
  public SalesNotFoundException(){
    super("판매 정보가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
  }
}
