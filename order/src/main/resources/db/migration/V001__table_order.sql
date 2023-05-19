create table orders (
	id varchar(225) not null, 
	title varchar(80) not null,
	description varchar(250) not null,
	status varchar(80) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;