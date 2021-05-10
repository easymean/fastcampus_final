package com.fastcampus.example.web.config;

import com.fastcampus.example.domain.dto.LoginRequest;
import com.fastcampus.example.exception.LoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return LoginRequest.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String xUserId = webRequest.getParameter("X-USER-ID");
    if(xUserId == null){
      throw new LoginException();
    }
    Long id = Long.parseLong(xUserId);
    return LoginRequest.builder()
        .userId(id)
        .build();
  }
}