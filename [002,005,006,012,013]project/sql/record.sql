drop table baseball cascade constraints;

create table baseball(
	teamname varchar(10) primary key,
	gamecount number(4),
	win number(4),
	moo number(2),
	lose number(2),
	percent varchar(30)
);

insert into baseball values('LG',0,0,0,0,0);
insert into baseball values('SAMSUNG',0,0,0,0,0);
insert into baseball values('NEXEN',0,0,0,0,0);
insert into baseball values('NC',0,0,0,0,0);

commit;


