insert into `user`(`id`, `name`, `created_at`, `updated_at`, `deleted_at`)
values (1, '한빛미디어', now(), now(), null),
       (2, '위키북스', now(), now(), null),
       (3, '인사이트', now(), now(), null),
       (4, '에이콘', now(), now(), null),
       (5, '중고상인', now(), now(), null),
       (6, '탈퇴유저', now(), now(), now()),
       (7, '개명하고싶은유저', now(), now(), null);

insert into `book_meta` (`id`, `price`, `name`, `isbn13`, `created_at`, `updated_at`)
values (1, 30000, '리팩토링', '9788979149715', now(), now()),
       (2, 35000, '리팩토링2', '9791162242742', now(), now()),
       (3, 35000, '엔터프라이즈 애플리케이션 아키텍처 패턴', '9791158390174', now(), now()),
       (4, 33000, 'Clean Code 클린 코드', '9788966260959', now(), now()),
       (5, 29000, '클린 아키텍처', '9788966262472', now(), now()),
       (6, 43000, '자바 ORM 표준 JPA 프로그래밍', '9788960777330', now(), now()),
       (7, 45000, '새로쓴 대용량 데이터베이스 솔루션', '9788995062920', now(), now()),
       (8, 30000, '테스트 주도 개발', '9788979147261', now(), now());


insert into `book_sales_info`(`id`, `user_id`, `product_meta_id`, `quantity`, `sales_volume`, `status`, `created_at`, `updated_at`)
values (1, 1, 1, 1000, 0, 'END_SALE', now(), now()),
       (2, 1, 2, 1000, 0, 'ON_SALE', now(), now()),
       (3, 2, 3, 1000, 0, 'HIDDEN', now(), now()),
       (4, 3, 4, 1000, 0, 'ON_SALE', now(), now()),
       (5, 3, 5, 1000, 0, 'ON_SALE', now(), now()),
       (6, 4, 6, 1000, 0, 'ON_SALE', now(), now()),
       (7, 5, 7, 2, 0, 'ON_SALE', now(), now()),
       (8, 5, 8, 2, 0, 'ON_SALE', now(), now()),
       (9, 5, 1, 2, 0, 'SUSPEND_SALE', now(), now());
