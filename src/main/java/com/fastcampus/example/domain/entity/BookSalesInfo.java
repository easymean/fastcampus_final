package com.fastcampus.example.domain.entity;

import com.fastcampus.example.domain.BaseEntity;
import com.fastcampus.example.domain.dto.SalesDto;
import com.fastcampus.example.domain.type.SalesStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter @Builder
@DynamicUpdate
@Entity @Table(name = "book_sales_info")
@NoArgsConstructor
@Accessors(chain=true)
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
    @Setter
    private Long quantity;

    @Column
    private Long salesVolume;

    @Column @Setter
    @Enumerated(value = EnumType.STRING)
    private SalesStatus status;

    public SalesDto.Response mapper(){
        return SalesDto.Response.builder()
            .id(this.id)
            .seller(this.user)
            .book(this.bookMeta)
            .stock(this.quantity)
            .purchasable(this.status == SalesStatus.ON_SALE)
            .exposable(this.status != SalesStatus.HIDDEN)
            .build();
    }
}
