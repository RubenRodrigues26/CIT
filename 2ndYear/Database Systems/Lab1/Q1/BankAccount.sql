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

