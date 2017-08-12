create database if not exists hotelbooking;
use hotelbooking;
create table if not exists hotel(hotelno varchar(10) not null, hotelname varchar(30), city varchar(10))engine=innodb;
create table if not exists room(roomno varchar(10) not null, hotelno varchar(10) not null, type varchar(10), price double(8,2))engine=innodb;
create table if not exists booking(hotelno varchar(10) not null, guestno varchar(10) not null, datefrom date not null, dateto date, roomno varchar(5) not null)engine=innodb;
create table if not exists guest(guestno varchar(10) not null default '', guestname varchar(20) default '', guestaddress varchar(30) default '')engine=innodb;
alter table hotel add constraint pk_hotel primary key(hotelno);
alter table room add constraint pk_room primary key(roomno, hotelno);
alter table guest add constraint pk_guest primary key(guestno);
alter table booking add constraint pk_booking primary key(guestno, hotelno, datefrom);
alter table room add constraint fk_room foreign key (hotelno) references hotel(hotelno) on update restrict on delete cascade;
alter table booking add constraint fk_booking foreign key (roomno, hotelno) references room(roomno, hotelno) on update restrict on delete restrict;
alter table booking add constraint fk_booking0 foreign key (guestno) references guest(guestno) on update restrict on delete restrict;
desc hotel;
desc room;
desc booking;
desc guest;
load data local infile '/home/r00144165/DB/hotel.txt' into table hotel fields terminated by ',' lines terminated by '|' ignore 1 lines;
load data local infile '/home/r00144165/DB/room.txt' into table room fields terminated by ',' lines terminated by '|' ignore 1 lines;
load data local infile '/home/r00144165/DB/booking.txt' into table booking fields terminated by ',' lines terminated by '|' ignore 1 lines;
load data local infile '/home/r00144165/DB/guest.txt' into table guest fields terminated by ',' lines terminated by '|' ignore 1 lines;
select * from hotel;
select * from room;
select * from booking;
select * from guest;


