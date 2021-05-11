package com.fastcampus.example.domain.entity;

import com.fastcampus.example.domain.BaseEntity;
import com.fastcampus.example.domain.dto.UserDto;
import lombok.*;
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

    @Column @Setter
    private String name;

    @Column @Setter
    private LocalDateTime deletedAt;

    @Builder
    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public UserDto.Response mapper(){
        return UserDto.Response.builder()
            .id(this.id)
            .name(this.name)
            .build();
    }
}
