insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (1,'martin','martin@fastcampus.com',now(),now());

insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (2,'dennis','denis@fastcampus.com',now(),now());

insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (3,'sophia','sophia@slowcampus.com',now(),now());

insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (4,'james','james@slowcampus.com',now(),now());

insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (5,'martin','martin@another.com',now(),now());

insert into publisher(`id`,`name`) values (1, '패스트캠퍼스');

insert into book(`id`,`name`,`publisher_id`, `deleted`,`status`) values (1, 'JPA 초격차 패키지',1,false,100);

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (2, 'Spring Security 초격차 패키지',1,false,200);

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (3, 'Spring Boot 올인원 패키지',1, true,100);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (1,'내 인생을 바꾼책','너무너무 좋았어요',5.0 ,1,1);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (2,'조금 속도가 빨라요','별로였던거 같기도하고?',3.0,2,2);

insert into comment(`id`,`comment`,`review_id`) values (1, '저도 좋았어요',1);

insert into comment(`id`,`comment`,`review_id`) values (2, '저는 그냥 그랬어요',1);
insert into comment(`id`,`comment`,`review_id`) values (3, '아니 왜만든거에요???',2);
