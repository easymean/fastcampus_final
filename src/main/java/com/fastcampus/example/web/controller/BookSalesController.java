package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.SalesDto;
import com.fastcampus.example.web.service.BookSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookSalesController {

  private final BookSalesService bookSalesService;

  @GetMapping("/sales/{id}")
  public CommonResponse<SalesDto.Response> getSalesById(@PathVariable("id") Long id){
    return CommonResponse.ok("success", bookSalesService.findById(id));
  }

  @PutMapping("/sales/{id}")
  public CommonResponse<SalesDto.Response> updateSales(@PathVariable("id") Long id, @RequestBody SalesDto.Update req){
    return CommonResponse.ok("success", bookSalesService.updateSalesInfo(id, req));
  }
}
