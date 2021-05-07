package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.BookRequest;
import com.fastcampus.example.domain.dto.BookResponse;
import com.fastcampus.example.web.service.BookMetaService;
import org.springframework.web.bind.annotation.*;


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
    return null;
  }

  @PutMapping("/{id}")
  public CommonResponse<BookResponse> updateBookMeta(@PathVariable Long id, @RequestBody BookRequest req) {
    return null;
  }
}
