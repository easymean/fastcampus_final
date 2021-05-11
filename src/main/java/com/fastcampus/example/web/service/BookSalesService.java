package com.fastcampus.example.web.service;

import com.fastcampus.example.domain.dto.SalesDto;
import com.fastcampus.example.domain.entity.BookSalesInfo;
import com.fastcampus.example.domain.repository.BookSalesInfoRepository;
import com.fastcampus.example.domain.type.SalesStatus;
import com.fastcampus.example.exception.SalesNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookSalesService {
  private final BookSalesInfoRepository bookSalesInfoRepository;

  public SalesDto.Response findById(Long id) {
    return bookSalesInfoRepository.findById(id)
        .map(BookSalesInfo::mapper)
        .orElseGet(() -> {
          throw new SalesNotFoundException();
        });
  }

  public SalesDto.Response updateSalesInfo(Long id, SalesDto.Update req) {
    Optional<BookSalesInfo> optional = bookSalesInfoRepository.findById(id);
    SalesStatus status = !req.getExposable() ? SalesStatus.HIDDEN : req.getPurchasable() ? SalesStatus.ON_SALE : SalesStatus.END_SALE;

    return optional.map(salesInfo -> {
      salesInfo.setQuantity(req.getStock())
          .setStatus(status);
      return salesInfo;
    })
        .map(bookSalesInfoRepository::save)
        .map(BookSalesInfo::mapper)
        .orElseGet(() -> {
          throw new SalesNotFoundException();
        });
  }

}
