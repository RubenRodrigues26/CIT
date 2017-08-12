create database if not exists classschedule;
use classschedule;
create table if not exists student(student_id int(5) unsigned not null, student_name varchar(25), primary key(student_id))engine=innodb;
create table if not exists qualified(faculity_id int(5) unsigned not null, course_id varchar(8) not null, date_qualified date, primary key(faculity_id, course_id))engine=innodb;
create table if not exists faculity(faculity_id int(5) unsigned not null, faculty_name varchar(25), primary key(faculity_id))engine=innodb;
create table if not exists section(section_no int(5) unsigned not null auto_increment, semester varchar(8) not null, course_id varchar(8) not null, primary key(section_no, semester, course_id))engine=innodb;
create table if not exists course(course_id char(5) not null, course_name varchar(15), primary key(course_id))engine=innodb;
create table if not exists registration(student_id int(5) unsigned not null, section_no int(5) unsigned not null, semester varchar(8) not null, primary key(student_id, section_no, semester))engine=innodb;
alter table qualified add constraint fk_qualified foreign key (faculity_id) references faculity(faculity_id) on delete restrict on update restrict;
alter table qualified add constraint fk_qualified0 foreign key (course_id) references course(course_id) on delete cascade on update cascade;
alter table section add constraint fk_section foreign key (course_id) references course(course_id) on delete cascade on update cascade;
alter table registration add constraint fk_registration foreign key (student_id) references student(student_id) on delete cascade on update cascade;
alter table registration add constraint fk_registration0 foreign key (section_no, semester) references section(section_no, semester) on delete no action on update no action;
desc student;
desc qualified;
desc faculity;
desc section;
desc course;
desc registration;

insert into student values (38214,'Letersky'),(54907,'Altvater'),(66324,'Aiken'),(70542,'Marra');
insert into faculity values (2143,'Birkin'),(3467,'Berndt'),(4756,'Collins');
insert into course values ('ISM 3112','Syst Design'),('ISM 3113', 'Syst Analysis'),('ISM 4212','Database'),('ISM 4930','Networking');
insert into qualified values (2143,'ISM 3112','1988-09-01'),(2143,'ISM 3113','1988-09-01'),(3467,'ISM 4212','1995-09-01'),(3467,'ISM 4930','1996-09-01'),(4756,'ISM 3113','1991-09-01'),(4756,'ISM 3112','1991-09-01');
alter table section auto_increment=2712;
insert into section(semester,course_id) values ('I-2008','ISM 3113'),('I-2009','ISM 3113'),('I-2008','ISM 4212'),('I-2010','ISM 4930');
insert into registration values (38214,2714,'I-2008'),(54907,2714,'I-2009'),(54907,2715,'I-2010'),(66324,2713,'I-2008');
select * from student;
select * from faculity;
select * from course;
select * from qualified;
select * from section;
select * from registartion;

select * from student where student_id < 50000;
select * from faculity where faculity_id = 4756;
select * from qualified where date_qualified > '1993-01-00';
select distinct course_id from section;

select min(section_no) as SmallestSectionNo from section where semester='I-2008';
select count(section_no) as studentCount from section where semester='I-2008' and section_no='2714';
select student_name from student order by student_name;

select * from student where student_id not in (select distinct student_id from registration where semester = 'I-2008');
select course_name,course.course_id from qualified,course where exists(select * from faculty where qualified.course_id=course.course_id and faculty.faculty_id=qualified.faculty_id and faculty_name like '%Berndt%');

select student.student_name, section.section_no, section.course_id from student, section, registration where student.student_id = registration.student_id and registration.section_no = section.section_no and course_id = 'ISM 4212';
