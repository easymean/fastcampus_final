package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv2. DELETE /users 테스트")
public class UserControllerTest_Delete extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("유저가 삭제된다")
    void success__when__유저가_삭제될때() throws Exception {
        mvc.perform(delete("/users").header(USER_HEADER, 7))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.deleted_at").exists());
    }

    @Test
    @DisplayName("헤더를 넣지 않으면 400 INVALID_HEADER 를 응답한다")
    void fail_400__when__헤더가_유효하지_않을때() throws Exception {
        mvc.perform(delete("/users"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_HEADER"))
                .andExpect(jsonPath("$.message").exists());
    }
}
