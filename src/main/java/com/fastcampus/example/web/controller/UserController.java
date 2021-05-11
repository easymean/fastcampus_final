package com.fastcampus.example.web.controller;

import com.fastcampus.example.common.CommonResponse;
import com.fastcampus.example.domain.dto.UserDto;
import com.fastcampus.example.domain.dto.UserId;
import com.fastcampus.example.domain.entity.LoginUser;
import com.fastcampus.example.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users/me")
  public CommonResponse<UserDto.Response> getMyInfo(@LoginUser UserId user) {
    Long myId = user.getUserId();
    return CommonResponse.ok("유저 정보 조회 성공", userService.findByMyself(myId, myId));
  }

  @GetMapping("/users/{id}")
  public CommonResponse<UserDto.Response> getUserById(@PathVariable("id") Long id) {
    return CommonResponse.ok("유저 정보 조회 성공", userService.findById(id));
  }

  @PostMapping("/users")
  public CommonResponse<UserDto.Response> signUp(@RequestBody @Valid UserDto.SignUp req) {
    return CommonResponse.ok("회원가입 성공", userService.createUser(req));
  }

  @PutMapping("/users")
  public CommonResponse<UserDto.Response> updateUserInfo(@LoginUser UserId user, @RequestBody @Valid UserDto.Update req) {
    Long myId = user.getUserId();
    return CommonResponse.ok("유저 정보 수정 성공", userService.updateUserInfo(myId, req));
  }

  @DeleteMapping("/users")
  public CommonResponse<UserDto.Response> deleteUser(@LoginUser UserId user) {
    Long id = user.getUserId();
    return CommonResponse.ok("유저 삭제 성공", userService.deleteUser(id));
  }
}
