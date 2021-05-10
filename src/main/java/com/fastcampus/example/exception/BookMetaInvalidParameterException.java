package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class BookMetaInvalidParameterException extends CommonException {
  public BookMetaInvalidParameterException(){
    super("필요한 정보가 모두 적혀있지 않습니다.", ErrorCode.BOOK_META_INVALID_PARAMETER);
  }
}
