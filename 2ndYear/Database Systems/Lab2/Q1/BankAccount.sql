create database if not exists BankAccount;
use BankAccount;
create table if not exists customer(cust_id int unsigned not null auto_increment, fname varchar(15), lname varchar(15), primary key(cust_id))engine=innodb;
create table if not exists account(account_id int unsigned not null auto_increment, product_cd varchar(5) not null, cust_id int unsigned not null, balance double(6,2), primary key(account_id))engine=innodb;
create table if not exists product(product_cd varchar(5) not null, name varchar(15))engine=innodb;
create table if not exists transaction(txn_id int unsigned not null auto_increment, txn_type_cd char(5), account_id int unsigned not null, amount double(6,2), txn_date date, primary key(txn_id))engine=innodb;
create table if not exists mail(sentDateTime datetime not null, srcuser char(8) not null, srchost char(20) not null, dstuser char(8) not null, dsthost char(20) not null, size int)engine=innodb;
alter table product add constraint pk_product primary key(product_cd);
alter table mail add constraint pk_mail primary key(sentDateTime, srcuser, dstuser);
alter table account add constraint fk_account foreign key (product_cd) references product(product_cd) on update cascade on delete cascade;
alter table account add constraint fk_account0 foreign key (cust_id) references customer(cust_id) on update restrict on delete restrict;
alter table transaction add constraint fk_transaction foreign key (account_id) references account(account_id) on update restrict on delete restrict;

desc customer;
desc account;
desc product;
desc transaction;
desc mail;

alter table account auto_increment=103;
alter table transaction auto_increment=978;

load data local infile '/home/r00144165/DB/customer.txt' into table customer fields terminated by '|' lines terminated by '\n' ignore 1 lines;

load data local infile '/home/r00144165/DB/account.txt' into table account fields terminated by '|' lines terminated by '\n' ignore 1 lines;

load data local infile '/home/r00144165/DB/product.txt' into table product fields terminated by '|' lines terminated by '\n' ignore 1 lines;

load data local infile '/home/r00144165/DB/transaction.txt' into table transaction fields terminated by '|' lines terminated by '\n' ignore 1 lines;

load data local infile '/home/r00144165/DB/mail.txt' into table mail fields terminated by '|' lines terminated by '\n' ignore 1 lines;

select * from customer;
select * from account;
select * from product;
select * from transaction;
select * from mail;