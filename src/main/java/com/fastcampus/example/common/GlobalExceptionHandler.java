package com.fastcampus.example.common;

import com.fastcampus.example.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  //400 ERROR
  @ExceptionHandler({MethodArgumentNotValidException.class, InvalidParameterException.class, InvalidHeaderException.class, InvalidRequestException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleValidationException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }


  //403 ERROR
  @ExceptionHandler({AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public CommonResponse<Object> handleAccessDeniedException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }


  //404 ERROR
  @ExceptionHandler({UserNotFoundException.class, SalesNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CommonResponse<Object> handleNotFoundException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }



  //500 ERROR
  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<Object> handleException(Exception e){
    log.error("", e);
    return CommonResponse.error("일시적인 문제가 발생했습니다. 잠시후 다시 시도해 주세요", "INTERNAL_SERVER_ERROR");
  }

}
