CREATE table if not exists apartment
(
    id BIGSERIAL Primary key,
    number  int4,
    status  BOOLEAN,
    price   int4,
    address_id BIGINT REFERENCES address(id),
    user_id BIGSERIAL references user_info (id)
);

insert into apartment(number, status, price, address_id, user_id)
VALUES (11,false,100,1,1),
       (45,true,170,1,1),
       (48,true,200,2,1),
       (99,true,800,2,1),
       (17,true,140,3,1),
       (7,true,200,3,1),
       (6,true,157,1,1)

