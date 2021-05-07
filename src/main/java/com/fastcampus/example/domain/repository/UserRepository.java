package com.fastcampus.example.domain.repository;

import com.fastcampus.example.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
