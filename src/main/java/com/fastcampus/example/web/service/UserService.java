package com.fastcampus.example.web.service;

import com.fastcampus.example.domain.dto.UserDto;
import com.fastcampus.example.domain.entity.User;
import com.fastcampus.example.domain.repository.UserRepository;
import com.fastcampus.example.exception.AccessDeniedException;
import com.fastcampus.example.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;


  public UserDto.Response findById(Long myId, Long id) {

    return userRepository.findById(id)
        .map(user -> {
              if (user.getDeletedAt().isBefore(LocalDateTime.now()) && myId.equals(id)) {
                throw new AccessDeniedException();
              }
              if (user.getDeletedAt().isBefore(LocalDateTime.now()) && !myId.equals(id)) {
                throw new UserNotFoundException();
              }
              return user;
            }
        )
        .map(User::mapper)
        .orElseGet(() -> {
          throw new UserNotFoundException();
        });
  }

  public UserDto.Response createUser(UserDto.SignUp req){
    User user = User.builder()
        .name(req.getName())
        .build();

    User newUser = userRepository.save(user);
    return newUser.mapper();
  }

  public UserDto.Response updateUserInfo(Long myId, UserDto.Update req){
    return userRepository.findById(myId)
        .map(user -> {
          user.setName(req.getName());
          return user;
        })
        .map(userRepository::save)
        .map(User::mapper)
        .orElseGet(() -> {
          throw new UserNotFoundException();
        });
  }
}
