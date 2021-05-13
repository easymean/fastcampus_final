package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.SalesDto;
import com.fastcampus.example.domain.dto.UserId;
import com.fastcampus.example.domain.entity.LoginUser;
import com.fastcampus.example.web.service.BookSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookSalesController {

  private final BookSalesService bookSalesService;

  @GetMapping("/sales/{id}")
  public CommonResponse<SalesDto.Response> getSalesById(@PathVariable("id") Long id){
    return CommonResponse.ok("success", bookSalesService.findById(id));
  }

  @PutMapping("/sales/{id}")
  public CommonResponse<SalesDto.Response> updateSales(@LoginUser UserId user, @PathVariable("id") Long salesId, @RequestBody @Valid SalesDto.Update req){
    Long userId = user.getUserId();
    return CommonResponse.ok("success", bookSalesService.updateSalesInfo(userId, salesId, req));
  }
}
