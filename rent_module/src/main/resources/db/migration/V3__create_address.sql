CREATE table if not exists address
(
    id           INT8 Primary key,
    city         varchar,
    street       varchar,
    house        varchar,
    apartment_id int8 references address (id)
);
create sequence address_sequence start 2 increment 1;

insert into address(id, city, street, house, apartment_id)
VALUES (1, 'Moscow', 'Red Square', '1d', 1)
