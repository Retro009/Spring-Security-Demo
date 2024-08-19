create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert ignore into users values('user','{noop}Jami@12345','1');
insert ignore into authorities values('user','read');

insert ignore into users values('admin','{bcrypt}$2a$12$FaXVz53Z5j5nBav7191M..MTc2M5PICduRoYoVTvSoTh1.M/.FSVC','1');
insert ignore into authorities values('admin', 'admin');

create table customer (
	id int not null auto_increment,
    email varchar(45) not null,
    password varchar(200) not null,
    role varchar(45) not null,
    primary key(id)
);

insert into customer (email, password, role) values('user@example.com','{noop}Jami@12345','user');
insert into customer (email, password, role) values('admin@example.com','{bcrypt}$2a$12$FaXVz53Z5j5nBav7191M..MTc2M5PICduRoYoVTvSoTh1.M/.FSVC','admin');
