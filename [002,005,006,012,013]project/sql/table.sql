

drop table schedule cascade constraint;
create table schedule(
			code number primary key,
			year varchar2(10) not null,
			month varchar2(10) not null,
			day varchar2(10)not null,
			hour varchar2(10) not null,
			firstTeam varchar2(10) not null,
			secondTeam varchar2(10) not null,
			firstScore number default -1,
			secondScore number default -1
);
drop SEQUENCE SCHEDULE_SEQ ;
CREATE SEQUENCE SCHEDULE_SEQ ; 

insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','10','LG','SAMSUNG');
insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','11','NC','NEXEN');
insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','12','LG','NC');
insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','13','LG','NEXEN');
insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','14','SAMSUNG','NEXEN');
insert into schedule (code,year,month,day,hour,firstTeam,secondTeam)
values(SCHEDULE_SEQ.nextVal,'2014','10','27','15','SAMSUNG','NC');
select * from schedule;
commit;
