create table if not exists user (
	id identity,
	name varchar(255) not null,
	age integer
);

create table if not exists role (
	id identity,
	name varchar(255) not null
);
