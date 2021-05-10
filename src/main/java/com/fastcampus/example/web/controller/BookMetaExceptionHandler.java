package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.exception.BookMetaInvalidParameterException;
import com.fastcampus.example.exception.BookMetaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice("com.fastcampus.example.web.controller.BookMetaController")
public class BookMetaExceptionHandler {

  @ExceptionHandler()
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleBookMetaException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }
}
