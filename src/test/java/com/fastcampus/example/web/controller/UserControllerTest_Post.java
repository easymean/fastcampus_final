package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv2. POST /users 테스트")
public class UserControllerTest_Post extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("유저가 등록된다")
    void success__when__유저가_등록된다() throws Exception {
        // given
        String name = "패스트캠퍼스 수강생";
        MockHttpServletRequestBuilder request = post("/users")
                .contentType(APPLICATION_JSON).content(toJson(Map.of("name", name)));
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(name));
    }

    @Test
    @DisplayName("파라미터가 비어있을때, 400 INVALID_PARAMETER 를 응답한다")
    void fail_400__when__파라미터가_비어있을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = post("/users")
                .contentType(APPLICATION_JSON).content(JSON_EMPTY_STRING);

        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_PARAMETER"))
                .andExpect(jsonPath("$.message").exists());
    }
}
