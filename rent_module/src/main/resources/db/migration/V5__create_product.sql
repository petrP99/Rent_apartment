CREATE table if not exists product
(
    id        BIGSERIAL Primary key,
    cleaning  BOOLEAN,
    breakfast BOOLEAN,
    dinner    BOOLEAN,
    bar       BOOLEAN,
    transfer  BOOLEAN,
    insurance BOOLEAN
);

insert into product(cleaning, breakfast, dinner, bar, transfer, insurance)
VALUES (true, false, true, false, false, false),
       (false, false, true, false, false, true);