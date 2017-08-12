create database if not exists AdultLiteracy;
use AdultLiteracy;
create table if not exists tutor(tutor_id int unsigned not null auto_increment, cert_date date, status enum('Active', 'Temp Stop', 'Dropped'), primary key(tutor_id))engine=innodb;
create table if not exists student(student_id int unsigned not null auto_increment, score double(8,2), primary key(student_id))engine=innodb;
create table if not exists match_history(match_id int unsigned not null auto_increment, tutor_id int unsigned not null, student_id int unsigned not null, start_date date, end_date date, primary key(match_id))engine=innodb;
alter table match_history add constraint fk_match_history foreign key (tutor_id) references tutor(tutor_id) on delete no action on update restrict;
alter table match_history add constraint fk_match_history2 foreign key (student_id) references student(student_id) on delete no action on update restrict;





