package com.fastcampus.example.domain.entity;

import com.fastcampus.example.domain.BaseEntity;
import com.fastcampus.example.domain.type.SalesStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Entity
@DynamicUpdate
@Table(name = "book_sales_info")
@NoArgsConstructor
public class BookSalesInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "product_meta_id")
    private BookMeta bookMeta;

    @Column
    private Long quantity;

    @Column
    private Long salesVolume;

    @Column
    @Enumerated(value = EnumType.STRING)
    private SalesStatus status;
}
