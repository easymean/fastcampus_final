package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.BookRequest;
import com.fastcampus.example.domain.dto.BookResponse;
import com.fastcampus.example.domain.entity.LoginUser;
import com.fastcampus.example.domain.entity.User;
import com.fastcampus.example.exception.BookMetaInvalidParameterException;
import com.fastcampus.example.exception.InvalidParameterException;
import com.fastcampus.example.exception.LoginException;
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
  public CommonResponse<BookResponse> getBookMeta(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", bookMetaService.findById(id));
  }

  @PostMapping("/")
  public CommonResponse<BookResponse> createBookMeta(@RequestBody BookRequest req) {
    if(req == null)
      throw new BookMetaInvalidParameterException();
    return CommonResponse.ok("success", bookMetaService.createBookMeta(req));
  }

  @PutMapping("/{id}")
  public CommonResponse<BookResponse> updateBookMeta(@PathVariable Long id, @RequestBody BookRequest req) {
    if(req == null)
      throw new InvalidParameterException();
    return CommonResponse.ok("success", bookMetaService.updateBookMeta(id,req));
  }
}
