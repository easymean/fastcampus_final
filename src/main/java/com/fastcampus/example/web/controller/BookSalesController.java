package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.SalesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookSalesController {

  @GetMapping("/sales/{id}")
  public CommonResponse<SalesResponse> getBookSalesById(@PathVariable("id") Long id){
    return null;
  }
//    @PutMapping("/sales/{id}") // FIXME
}
