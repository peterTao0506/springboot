create database springboot;

use springboot;

create table user(userId varchar(32) primary key,
 	userName varchar(32) not null,
 	passWord varchar(32) not null,
 	age int,
 	sex varchar(2) not null,
 	email varchar(32),
 	descs varchar(255)
 )default charset=utf8; 
 
