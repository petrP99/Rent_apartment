CREATE table if not exists user_info
(
    id          BIGSERIAL Primary key,
    nick_name   varchar,
    login_value varchar,
    pass        varchar,
    token       varchar
);

insert into user_info (nick_name, login_value, pass, token)
values ('test', 'test', 'test', '62271c30-0070-4e6d-9372-3b5670f61a4c|2034-07-21T10:13:21.786558400');


