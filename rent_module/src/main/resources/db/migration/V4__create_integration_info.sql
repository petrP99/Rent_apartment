CREATE table if not exists integration_info
(
    id        varchar,
    path_info varchar,
    token     varchar
);


insert into integration_info (id, path_info, token)
VALUES ('GEO', 'https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s',
        'MWQ4MTc2OWQ5ZGJiNGI1ZThkOWQzMmFkZmY3MDYzNGE=')
