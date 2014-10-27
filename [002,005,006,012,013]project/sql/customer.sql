drop table customer;

create table customer(
	cust_id varchar2(20),
	cust_name varchar2(20),
	cust_pwd varchar2(20),
	address varchar2(100),
	constraint customer_pk_cust_id primary key(cust_id)
);

insert into customer values('admin','admin','admin','admin');
commit;
