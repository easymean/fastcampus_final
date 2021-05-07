package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("Lv1. POST /books 테스트")
public class BookMetaControllerTest_POST extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("책정보가 등록된다")
    void success__when__책정보가_등록된다() throws Exception {
        // given
        String name = "패스트캠퍼스 샘플책";
        Long price = 1000L;
        String isbn = "mock";
        String requestBody = toJson(Map.of("name", name, "price", price, "isbn", isbn));

        MockHttpServletRequestBuilder request = post("/books")
                .contentType(APPLICATION_JSON).content(requestBody);

        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.price").value(price))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.isbn").value(isbn));
    }

    @Test
    @DisplayName("파라미터가 비어있을때, 500 BOOK_META_INVALID_PARAMETER 를 응답한다")
    void fail_500__when__파라미터가_비어있을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = post("/books")
                .contentType(APPLICATION_JSON).content(JSON_EMPTY_STRING);

        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("BOOK_META_INVALID_PARAMETER"))
                .andExpect(jsonPath("$.message").exists());
    }
}
