package com.fastcampus.example.common;

import com.fastcampus.example.exception.BookMetaInvalidParameterException;
import com.fastcampus.example.exception.BookMetaNotFoundException;
import com.fastcampus.example.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler()
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleBookMetaException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }

  @ExceptionHandler({LoginException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleLoginException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleValidationException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleException(Exception e){
    log.error("", e);
    return CommonResponse.error("일시적인 문제가 발생했습니다. 잠시후 다시 시도해 주세요", "INTERNAL_SERVER_ERROR");
  }

}
