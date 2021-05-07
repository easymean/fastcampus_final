package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv1. GET /books/{id} 테스트")
public class BookMetaControllerTest_GET extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("책정보가 조회된다")
    void success__when__책정보가_조회된다() throws Exception {
        // given
        long id = 1L;
        // when then
        mvc.perform(get("/books/" + id))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.price").exists())
                .andExpect(jsonPath("$.data.name").exists())
                .andExpect(jsonPath("$.data.isbn").exists());
    }

    @Test
    @DisplayName("책이 존재하지 않을때, 500 BOOK_META_NOT_FOUND 를 응답한다")
    void fail_500__when__유저를_찾을_수_없을때() throws Exception {
        mvc.perform(get("/books/-1"))
                .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("BOOK_META_NOT_FOUND"))
                .andExpect(jsonPath("$.message").exists());
    }
}
