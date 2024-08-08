CREATE table if not exists address
(
    id           BIGSERIAL Primary key,
    city         varchar,
    street       varchar,
    house        varchar
);

insert into address(city, street, house)
VALUES  ('Moscow', 'Red Square', '1d'),
        ('Moscow','Dmitrovka','57'),
        ('Moscow','Zelenograd','447')

