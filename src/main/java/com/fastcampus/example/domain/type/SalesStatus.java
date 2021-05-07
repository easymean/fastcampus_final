package com.fastcampus.example.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SalesStatus {
    ON_SALE,
    SUSPEND_SALE,
    HIDDEN,
    END_SALE,
    ;
}
