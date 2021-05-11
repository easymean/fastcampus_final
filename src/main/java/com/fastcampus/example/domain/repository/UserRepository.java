package com.fastcampus.example.domain.repository;

import com.fastcampus.example.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long id);
}
