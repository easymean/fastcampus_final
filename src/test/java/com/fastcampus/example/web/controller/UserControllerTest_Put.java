package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv2. PUT /users 테스트")
public class UserControllerTest_Put extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("유저 이름이 변경된다")
    void success__when__유저이름을_변경할떄() throws Exception {
        // given
        long id = 7;
        String changedName = "김패스트캠퍼스";

        MockHttpServletRequestBuilder request = put("/users")
                .header(USER_HEADER, id)
                .contentType(APPLICATION_JSON).content(toJson(Map.of("name", changedName)));

        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(changedName));
    }

    @Test
    @DisplayName("헤더를 넣지 않으면 400 INVALID_HEADER 를 응답한다")
    void fail_400__when__헤더가_유효하지_않을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/users")
                .contentType(APPLICATION_JSON).content(JSON_EMPTY_STRING);
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_HEADER"))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("파라미터가 비어있을때, 400 INVALID_PARAMETER 를 응답한다")
    void fail_400__when__파라미터가_비어있을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/users")
                .header(USER_HEADER, 7)
                .contentType(APPLICATION_JSON).content(JSON_EMPTY_STRING);
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_PARAMETER"))
                .andExpect(jsonPath("$.message").exists());
    }
}
