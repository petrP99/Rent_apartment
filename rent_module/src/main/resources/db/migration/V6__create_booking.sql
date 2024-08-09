CREATE table if not exists booking
(
    id           BIGSERIAL Primary key,
    start_time   DATE not null,
    end_time     DATE not null,
    days         int4 not null,
    cost         int4 not null,
    user_id      BIGINT references user_info (id),
    apartment_id BIGINT references apartment (id),
    product_id   BIGINT references product (id)
    );

insert into booking(start_time, end_time, days, cost, user_id, apartment_id, product_id)
VALUES ('2024-08-09', '2024-08-12', 3, 600, 1, 1, 1);