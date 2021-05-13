package com.fastcampus.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
public class WebConfig implements WebMvcConfigurer {
  private final UserArgumentResolver userArgumentResolver;

  public WebConfig(UserArgumentResolver userArgumentResolver) {
    this.userArgumentResolver = userArgumentResolver;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolverList){
    resolverList.add(userArgumentResolver);
  }
}
