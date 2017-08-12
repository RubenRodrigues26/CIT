create database if not exists HotelBooking;
use HotelBooking;
create table if not exists Hotel(hotelNo varchar(9) NOT NULL, hotelName varchar(30), city varchar(10))engine=innodb;
create table if not exists Room(roomNo varchar(9) NOT NULL, hotelNo varchar(9) NOT NULL, hoteltype varchar(6), price double(8,2))engine=innodb;
create table if not exists Booking(hotelNo varchar(9) NOT NULL, guestNo varchar(9) NOT NULL DEFAULT '', dateFrom date NOT NULL, dateTo date, roomNo varchar(9) NOT NULL)engine=innodb;
create table if not exists Guest(guestNo varchar(9) NOT NULL DEFAULT '', guestName varchar(20) DEFAULT '', guestAddress varchar(30) DEFAULT '')engine=innodb;
alter table Hotel add constraint pk_hotel primary key(hotelNo);
alter table Room add constraint pk_room primary key(roomNo, hotelNo);
alter table Guest add constraint pk_guest primary key(guestNo);
alter table Booking add constraint pk_booking primary key(guestNo, hotelNo, dateFrom);
alter table Room add constraint fk_room foreign key (hotelNo) references Hotel(hotelNo) on update restrict on delete cascade;
alter table Booking add constraint fk_booking foreign key (roomNo, hotelNo) references Room(roomNo, hotelNo) on update restrict on delete restrict;
alter table Booking add constraint fk_booking2 foreign key (guestNo) references Guest(guestNo) on update restrict on delete restrict;
desc Hotel;
desc Room;
desc Booking;
desc Guest;

set foreign_key_checks = 0;
INSERT INTO Hotel VALUES('H001', 'Meteor Garden', 'Washington');
INSERT INTO Hotel VALUES('H002', 'Hilton', 'Texas');
INSERT INTO Hotel VALUES('H003', 'Grosvenor', 'Boston');
INSERT INTO Hotel VALUES('H004', 'Imperical', 'New York');
INSERT INTO Room VALUES('R001', 'H001 ', 'single', 30.0);
INSERT INTO Room VALUES('R104', 'H002 ', 'double', 90.0);
INSERT INTO Room VALUES('R210', 'H003 ', 'family', 200.0);
INSERT INTO Room VALUES('R907', 'H004 ', 'family', 200.0);
INSERT INTO Room VALUES('R101', 'H001', 'double', 25.0);
INSERT INTO Room VALUES('R110', 'H003', 'double', 35.0);
INSERT INTO Room VALUES('R302', 'H001', 'family', 40.0);
INSERT INTO Room VALUES('R101', 'H002', 'single', 57.0);
INSERT INTO Room VALUES('R302', 'H002', 'family', 150.0);
INSERT INTO Booking VALUES('H001', 'G001', '2012-08-02', NULL, 'R001');
INSERT INTO Booking VALUES('H002', 'G002', '2013-01-01', '2013-01-03', 'R104');
INSERT INTO Booking VALUES('H003', 'G001', '2013-07-15', NULL, 'R210');
INSERT INTO Booking VALUES('H004', 'G003', '2013-12-31', '2013-01-14', 'R907');
INSERT INTO Booking VALUES('H002', 'G005', '0000-00-00', NULL, 'R101');
INSERT INTO Booking VALUES('H002', 'G004', '0000-00-00', NULL, 'R302');
INSERT INTO Guest VALUES('G001', 'Mary', 'Cork, Ireland');
INSERT INTO Guest VALUES('G002', 'Tom', 'NY, USA');
INSERT INTO Guest VALUES('G003', 'John', 'Dublin, Ireland');
INSERT INTO Guest VALUES('G004', 'Stephenie', 'Paris, France');
INSERT INTO Guest VALUES('G005', '', '');
set foreign_key_checks = 1;
select * from Hotel;
select * from Room;
select * from Guest;
select * from Booking;


select * from Hotel, Guest, Booking, Room;
select * from Hotel where city='London';
select * from Booking where dateTo is null;

select guestname, guestaddress from Guest where guestaddress like 'London%' order by guestname desc;
select hoteltype, price from Room where price < 40 order by price;
select count(distinct hotelNo) as sumHotel from Hotel;
select avg(price) as avgPrice from Room;
select sum(price) as doublePrice from Room where hoteltype='double';
select count(distinct guestNo) as guestCount from Booking where dateFrom between '2012-08-01' and '2012-08-31';

select roomNo,hoteltype,price from Room where exists(select * from Hotel where Room.hotelNo = Hotel.hotelNo and hotelName like '%Grosvenor%');
select * from Guest,Hotel where exists(select * from Booking where Guest.guestNo=Booking.guestNo and Booking.hotelNo=Hotel.hotelNo and hotelName like '%Grosvenor%');

select Hotel.hotelName, count(*) as numRooms from Hotel, Room where Hotel.hotelno=Room.hotelNo and city='London' group by hotelName;
select Hotel.hotelname, count(*) as numRooms from Hotel, Room where Hotel.hotelno=Room.hotelNo group by hotelName;
select Guest.guestNo, Guest.guestName, Guest.guestAddress, Booking.roomNo, Hotel.hotelName from Hotel,Booking,Guest where Booking.guestNo = Guest.guestNo and Booking.hotelNo = Hotel.hotelNo and hotelName = 'Grosvenor';
select Hotel.hotelName,Room.hotelNo,Room.roomNo from Booking,Room,Hotel where Booking.roomNo != Room.roomNo and Booking.hotelNo = Room.hotelNo and Booking.hotelNo = Hotel.hotelNo and hotelName = 'Grosvenor';

create view hotelANDguest(guestName, hotelName) as select guestName, hotelName from Hotel,Booking,Guest where Booking.guestNo = Guest.guestNo and Booking.hotelNo = Hotel.hotelNo;
select * from hotelANDguest;
create view guestInfo(guestName,guestAddress,guestNo,hotelName,hotelNo,roomNo) as select guestName,guestAddress,Guest.guestNo,hotelName,Hotel.hotelNo,Room.roomNo from Hotel,Booking,Guest,Room where Booking.guestNo = Guest.guestNo and Booking.hotelNo = Hotel.hotelNo and Room.hotelNo = Hotel.hotelNo;
select * from guestInfo;
select sum(price) as sumGrosvenorBookings from Hotel,Booking,Room where Booking.hotelNo = Room.hotelNo and  Booking.hotelNo = Hotel.hotelNo and Hotel.hotelName = 'Grosvenor'and Booking.dateFrom = '2016-11-28';
select Room.roomNo from Hotel,Room,Booking where Room.hotelNo not in (select Booking.hotelNo) and Booking.hotelNo = Hotel.hotelNo and Hotel.hotelName = 'Grosvenor';
select sum(price) as sumLostIncome from Hotel,Room,Booking where Room.hotelNo in (select Booking.hotelNo) and Booking.hotelNo = Hotel.hotelNo and Hotel.hotelName = 'Grosvenor';
select sum(price) as sumLostIncome from Hotel,Room,Booking where Room.hotelNo in (select Booking.hotelNo) and Booking.hotelNo = Hotel.hotelNo and dateFrom = '2016-11-29';