package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv1. PUT /books/{id} 테스트")
public class BookMetaControllerTest_PUT extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("책정보가 변경된다")
    void success__when__책정보를_변경할떄() throws Exception {
        // given
        long id = 1;
        String changedName = "바꿀 책 이름";

        MockHttpServletRequestBuilder request = put("/books/" + id)
                .contentType(APPLICATION_JSON).content(toJson(Map.of("name", changedName)));

        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(id))
                .andExpect(jsonPath("$.data.name").value(changedName));
    }

    @Test
    @DisplayName("파라미터가 비어있을때, 500 INVALID_PARAMETER 를 응답한다")
    void fail_500__when__파라미터가_비어있을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/books/1")
                .contentType(APPLICATION_JSON).content(JSON_EMPTY_STRING);
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("BOOK_META_INVALID_PARAMETER"))
                .andExpect(jsonPath("$.message").exists());
    }
}
