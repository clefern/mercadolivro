CREATE TABLE customers(
    id int auto_increment primary key,
    name varchar(120) not null,
    email varchar(160) not null unique
)