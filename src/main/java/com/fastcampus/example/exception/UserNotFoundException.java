package com.fastcampus.example.exception;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.domain.type.ErrorCode;

public class UserNotFoundException extends CommonException {

  public UserNotFoundException(){
    super("유저 정보가 존재하지 않습니다.", ErrorCode.USER_NOT_FOUND);
  }
}
