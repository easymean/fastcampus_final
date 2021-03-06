package com.fastcampus.example.domain.entity;

import com.fastcampus.example.domain.BaseEntity;
import com.fastcampus.example.domain.dto.BookDto;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "book_meta")
@NoArgsConstructor
@Accessors(chain=true)
public class BookMeta extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private Long price;

    @Setter
    @Column(name = "isbn13")
    private String isbn;

    // image category 등등...다양한 정보

    @Builder
    public BookMeta(String name, Long price, String isbn){
        Assert.hasText(name, "필수 요소가 존재하지 않습니다.");
        Assert.hasText(isbn, "필수 요소가 존재하지 않습니다.");
        this.name = name;
        this.isbn = isbn;
        this.price = price;
    }

    public BookDto.Response mapper(){
        return BookDto.Response.builder()
            .id(this.id)
            .name(this.name)
            .price(this.price)
            .isbn(this.isbn)
            .build();
    }
}
