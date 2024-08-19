create table write_tb(
	id int primary key auto_increment,
    author varchar(100) not null,
    title varchar(255) not null,
    content text not null
);