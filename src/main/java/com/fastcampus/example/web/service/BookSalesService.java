package com.fastcampus.example.web.service;

import com.fastcampus.example.domain.dto.SalesDto;
import com.fastcampus.example.domain.entity.BookSalesInfo;
import com.fastcampus.example.domain.repository.BookSalesInfoRepository;
import com.fastcampus.example.domain.type.SalesStatus;
import com.fastcampus.example.exception.InvalidRequestException;
import com.fastcampus.example.exception.SalesNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookSalesService {
  private final BookSalesInfoRepository bookSalesInfoRepository;

  public boolean isHidden(SalesStatus status){
    return status.equals(SalesStatus.HIDDEN);
  }

  public boolean isPurchasable(SalesStatus status){
    return status.equals(SalesStatus.ON_SALE);
  }

  public SalesDto.Response findById(Long id) {
    return bookSalesInfoRepository.findById(id)
        .map(salesInfo -> {
          if(isHidden(salesInfo.getStatus())){
            throw new SalesNotFoundException();
          }
          return salesInfo;
        })
        .map(BookSalesInfo::mapper)
        .orElseGet(() -> {
          throw new SalesNotFoundException();
        });
  }

  public SalesDto.Response updateSalesInfo(Long userId, Long salesId, SalesDto.Update req) {
    Optional<BookSalesInfo> optional = bookSalesInfoRepository.findById(salesId);
    SalesStatus status = !req.getExposable() ? SalesStatus.HIDDEN : req.getPurchasable() ? SalesStatus.ON_SALE : SalesStatus.END_SALE;

    return optional
        .map(salesInfo -> {
         if(!salesInfo.getUser().getId().equals(userId)) {
           throw new InvalidRequestException();
         }
         return salesInfo;
        })
        .map(salesInfo -> {
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
