package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv2. GET /users/{id} or /users/me 테스트")
public class UserControllerTest_Get extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("유저가 조회된다")
    void success__when__유저가_조회될떄() throws Exception {
        mvc.perform(get("/users/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").exists());
    }

    @Test
    @DisplayName("유저가 존재하지 않을때, 404 USER_NOT_FOUND 를 응답한다")
    void fail_404__when__유저를_찾을_수_없을때() throws Exception {
        mvc.perform(get("/users/-1"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("USER_NOT_FOUND"))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("헤더를 넣지 않으면 400 INVALID_HEADER 를 응답한다")
    void fail_400__when__헤더가_유효하지_않을때() throws Exception {
        mvc.perform(get("/users/me"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_HEADER"))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("탈퇴한 회원이 본인 정보를 조회하려할때, 403 ACCESS_DENIED 를 응답한다")
    void fail_403__when__탈퇴한_회원일떄() throws Exception {
        mvc.perform(get("/users/me").header(USER_HEADER, 6))
                .andExpect(status().is(HttpStatus.FORBIDDEN.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("ACCESS_DENIED"))
                .andExpect(jsonPath("$.message").exists());
    }
}
