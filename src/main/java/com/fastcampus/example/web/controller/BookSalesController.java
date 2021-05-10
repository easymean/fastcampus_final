package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.SalesResponse;
import com.fastcampus.example.domain.dto.SalesUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookSalesController {

  @GetMapping("/sales/{id}")
  public CommonResponse<SalesResponse> getSalesById(@PathVariable("id") Long id){
    return null;
  }

  @PutMapping("/sales/{id}")
  public CommonResponse<SalesResponse> updateSales(@PathVariable("id") Long id, @RequestBody SalesUpdateRequest req){
    return null;
  }
}
