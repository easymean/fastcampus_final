package com.fastcampus.example.domain.repository;

import com.fastcampus.example.domain.entity.BookSalesInfo;
import com.fastcampus.example.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSalesInfoRepository extends JpaRepository<BookSalesInfo, Long> {
}
