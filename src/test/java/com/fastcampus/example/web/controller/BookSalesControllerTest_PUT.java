package com.fastcampus.example.web.controller;

import com.fastcampus.example.web.AbstractMockMvcTestBoilerplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Lv3. PUT /sales/{id} 테스트")
public class BookSalesControllerTest_PUT extends AbstractMockMvcTestBoilerplate {

    @Test
    @DisplayName("판매중인 상품이 수정된다")
    void success__when__판매중인_상품이_조회될떄() throws Exception {
        // given
        long id = 1L;
        MockHttpServletRequestBuilder request = put("/sales/" + id)
                .header(USER_HEADER, 1L)
                .contentType(APPLICATION_JSON).content(toJson(createRequest(1000, true, true)));
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.stock").exists())
                .andExpect(jsonPath("$.purchasable").exists())
                .andExpect(jsonPath("$.exposable").exists());
    }

    @Test
    @DisplayName("헤더를 넣지 않으면 400 INVALID_HEADER 를 응답한다")
    void fail_400__when__헤더가_유효하지_않을때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/sales/2")
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
        MockHttpServletRequestBuilder request = put("/sales/2")
                .header(USER_HEADER, 1L)
                .contentType(APPLICATION_JSON).content("{}");
        // when then
        mvc.perform(request.content("{}"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_PARAMETER"))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("잘못된 상품판매 정보를 수정하려 했을때, 404 NOT_FOUND 를 응답한다")
    void fail_404__when__존재하지_않는_상품을_수정하려했을떄() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/sales/-1")
                .header(USER_HEADER, 1L)
                .contentType(APPLICATION_JSON).content(toJson(createRequest(1000, true, true)));
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("NOT_FOUND"))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("다른사람 판매정보를 수정하려할때, 400 INVALID_REQUEST 를 응답한다")
    void fail_400__when__다른사람_판매정보를_수정하려할때() throws Exception {
        // given
        MockHttpServletRequestBuilder request = put("/sales/5")
                .header(USER_HEADER, 1L)
                .contentType(APPLICATION_JSON).content(toJson(createRequest(1000, true, true)));
        // when then
        mvc.perform(request)
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.error_code").value("INVALID_REQUEST"))
                .andExpect(jsonPath("$.message").exists());
    }


    private Map<String, String> createRequest(long stock, Boolean purchasable, Boolean exposable) {
        HashMap<String, String> map = new HashMap<>();
        map.put("stock", String.valueOf(stock));
        if (nonNull(purchasable))
            map.put("purchasable", String.valueOf(purchasable));
        if (nonNull(exposable))
            map.put("exposable", String.valueOf(exposable));
        return map;
    }
}
