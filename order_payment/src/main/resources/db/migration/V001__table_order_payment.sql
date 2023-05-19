create table order_payments (
	id varchar(225) not null, 
	id_order varchar(225) not null, 
	title varchar(80) not null,
	description varchar(250) not null,
	status varchar(80) not null,
	price decimal(10,2) not null,
	observation varchar(225) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;