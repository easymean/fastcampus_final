package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.BookDto;
import com.fastcampus.example.exception.BookMetaInvalidParameterException;
import com.fastcampus.example.exception.InvalidParameterException;
import com.fastcampus.example.web.service.BookMetaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
  public CommonResponse<BookDto.Response> createBookMeta(@RequestBody @Valid BookDto.Create req) {
    if(req == null)
      throw new BookMetaInvalidParameterException();
    return CommonResponse.ok("success", bookMetaService.createBookMeta(req));
  }

  @PutMapping("/{id}")
  public CommonResponse<BookDto.Response> updateBookMeta(@PathVariable Long id, @RequestBody @Valid BookDto.Update req) {
    if(req == null)
      throw new InvalidParameterException();
    return CommonResponse.ok("success", bookMetaService.updateBookMeta(id,req));
  }
}
