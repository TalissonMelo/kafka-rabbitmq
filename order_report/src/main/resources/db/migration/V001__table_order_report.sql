create table order_reports (
	id varchar(225) not null, 
	id_order varchar(225) not null, 
	id_order_payment varchar(225) not null, 
	title varchar(80) not null,
	description varchar(250) not null,
	status varchar(80) not null,
	price decimal(10,2) not null,
	observation varchar(225) not null,
	created_at datetime not null,
	updated_at datetime not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;