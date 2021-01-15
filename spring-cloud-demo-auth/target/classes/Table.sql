create table user(
    ID INT primary key auto_increment,
    real_name varchar(10) not null,
    user_name varchar(30) not null unique,
    password varchar(30) not null unique commont '密码',
    role varchar (5) not null default 'user'
)