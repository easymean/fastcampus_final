package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv3. GET /sales/{id} 테스트")
public class BookSalesControllerTest_GET extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("판매중인 상품이 조회된다")
    void success__when__판매중인_상품이_조회될떄() throws Exception {
        long id = 2L;

        mvc.perform(get("/sales/" + id))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.seller").exists())
                .andExpect(jsonPath("$.seller.id").exists())
                .andExpect(jsonPath("$.seller.name").exists())
                .andExpect(jsonPath("$.book").exists())
                .andExpect(jsonPath("$.book.id").exists())
                .andExpect(jsonPath("$.book.name").exists())
                .andExpect(jsonPath("$.book.price").exists())
                .andExpect(jsonPath("$.book.isbn").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andExpect(jsonPath("$.purchasable").exists())
                .andExpect(jsonPath("$.exposable").exists());
    }

    @Test
    @DisplayName("판매중인 상품이 없을때, 404 NOT_FOUND 를 응답한다")
    void fail__when__판매중인_상품이_없을때() throws Exception {
        mvc.perform(get("/sales/-1"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("NOT_FOUND"))
                .andExpect(jsonPath("$.message").exists());

    }

    @Test
    @DisplayName("판매중인 상품이 숨기처리되었을때, 404 NOT_FOUND 를 응답한다")
    void fail__when__판매중인_상품을_숨김처리했을때() throws Exception {
        mvc.perform(get("/sales/3"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("NOT_FOUND"))
                .andExpect(jsonPath("$.message").exists());

    }
}
