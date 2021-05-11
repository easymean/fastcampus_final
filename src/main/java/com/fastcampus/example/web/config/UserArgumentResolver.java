package com.fastcampus.example.web.config;

import com.fastcampus.example.domain.dto.UserId;
import com.fastcampus.example.exception.InvalidHeaderException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return UserId.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

    String xUserId = request.getHeader("X-USER-ID");
    if(xUserId == null){
      throw new InvalidHeaderException();
    }
    Long id = Long.parseLong(xUserId);
    return new UserId(id);
  }
}
