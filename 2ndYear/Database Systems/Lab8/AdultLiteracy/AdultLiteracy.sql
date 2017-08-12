create database if not exists AdultLiteracy;
use AdultLiteracy;
create table if not exists tutor(tutor_id int unsigned not null auto_increment, cert_date date, status enum('Active', 'Temp Stop', 'Dropped'), primary key(tutor_id))engine=innodb;
create table if not exists student(student_id int unsigned not null auto_increment, score double(8,2), primary key(student_id))engine=innodb;
create table if not exists match_history(match_id int unsigned not null auto_increment, tutor_id int unsigned not null, student_id int unsigned not null, start_date date, end_date date, primary key(match_id))engine=innodb;
alter table match_history add constraint fk_match_history foreign key (tutor_id) references tutor(tutor_id) on delete no action on update restrict;
alter table match_history add constraint fk_match_history2 foreign key (student_id) references student(student_id) on delete no action on update restrict;

alter table tutor auto_increment=100;


insert into tutor(cert_date,status) values ('2008-05-01','Active'),('2008-05-01','Temp Stop'),('2008-05-01','Dropped'),('2008-05-22','Active'),('2008-05-22','Active'),('2008-05-22','Temp Stop'),('2008-05-22','Active');


alter table student auto_increment=3000;

insert into student(score) values (2.3),(5.6),(1.3),(3.3),(2.7),(4.8),(7.8),(1.5);


insert into match_history(tutor_id,student_id,start_date,end_date) values (100,3000,'2008-10-01',null),(101,3001,'2008-01-15','2008-05-15'),(102,3002,'2008-02-10','2008-03-01'),(106,3003,'2008-05-28',null),(103,3004,'2008-06-01','2008-06-15'),(104,3005,'2008-06-01','2008-06-28'),(104,3006,'2008-06-01',null);

select count(tutor_id) as tutorCount from tutor where status='Temp Stop'; 
select count(match_id) as matchCount from match_history where end_date between '2008-01-00' and '2008-05-31';
select max(score) as highestRead from student;

select tutor.tutor_id from tutor,match_history where tutor.tutor_id = match_history.tutor_id and start_date between '2008-07-01' and '2008-07-31';
select tutor_id from tutor where status = 'Active';
select tutor_id from match_history where end_date is null;



