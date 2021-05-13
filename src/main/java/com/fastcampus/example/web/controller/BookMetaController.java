package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonException;
import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.BookDto;
import com.fastcampus.example.domain.entity.BookMeta;
import com.fastcampus.example.exception.BookMetaInvalidParameterException;
import com.fastcampus.example.exception.BookMetaNotFoundException;
import com.fastcampus.example.exception.InvalidParameterException;
import com.fastcampus.example.web.service.BookMetaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookMetaController {

  private final BookMetaService bookMetaService;

  public BookMetaController(BookMetaService bookMetaService) {
    this.bookMetaService = bookMetaService;
  }

  @GetMapping("/{id}")
  public CommonResponse<BookDto.Response> getBookMeta(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", bookMetaService.findById(id));
  }

  @PostMapping("/")
  public CommonResponse<BookDto.Response> createBookMeta(@RequestBody BookDto.Create req) {
    return CommonResponse.ok("success", bookMetaService.createBookMeta(req));
  }

  @PutMapping("/{id}")
  public CommonResponse<BookDto.Response> updateBookMeta(@PathVariable Long id, @RequestBody BookDto.Update req) {
    return CommonResponse.ok("success", bookMetaService.updateBookMeta(id,req));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<BookDto.Response> handleBookMetaValidationException(IllegalArgumentException ex){
    BookMetaNotFoundException e = new BookMetaNotFoundException();
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }

  @ExceptionHandler({BookMetaNotFoundException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonResponse<BookDto.Response> handleBookMetaNotFoundException(CommonException e){
    log.error("", e);
    return CommonResponse.error(e.getMessage(), e.getErrorCode());
  }
}
