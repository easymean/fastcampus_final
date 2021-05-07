package com.fastcampus.example.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookMetaStatus implements ErrorStatusInf {
  BOOK_META_NOT_FOUND;
}
