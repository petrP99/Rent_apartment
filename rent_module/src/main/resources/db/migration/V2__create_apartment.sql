CREATE table if not exists apartment
(
    id
            INT8 Primary key,
    number  int4,
    status  BOOLEAN,
    price   int4,
    user_id int8 references user_info (id)
);
create sequence apartment_sequence start 2 increment 1;

insert into apartment(id, number, status, price, user_id)
VALUES (1, 11, true, 100, 1),
       (2, 17, true, 140, 1),
       (3, 45, true, 170, 1),
       (4, 48, true, 200, 1)
