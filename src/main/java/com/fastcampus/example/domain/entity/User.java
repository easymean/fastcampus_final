package com.fastcampus.example.domain.entity;

import com.fastcampus.example.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
@Accessors(chain=true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDateTime deletedAt;

    @Builder
    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
