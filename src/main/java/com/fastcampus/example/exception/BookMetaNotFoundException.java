package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class BookMetaNotFoundException extends CommonException {
  public BookMetaNotFoundException(){
    super("책을 찾을 수 없습니다.", ErrorCode.BOOK_META_NOT_FOUND);
  };

}
