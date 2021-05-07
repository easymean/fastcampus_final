package com.fastcampus.example.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleException(Exception e){
    log.error("", e);
    return CommonResponse.error("일시적인 문제가 발생했습니다. 잠시후 다시 시도해 주세요", );
  }
}
