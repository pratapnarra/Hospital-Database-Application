drop database hos_database;
create database hos_database;
use hos_database;
create table patient_new (
p_n_name varchar(40),
pno bigint ,
city varchar(30),
branch varchar(20),
specialization varchar(30),
appoint_date date,
ref_doc varchar(30)
 );
 
 create table patient_old (
p_o_name varchar(40),
pno bigint ,
city varchar(30),
branch varchar(20),
specialization varchar(30),
appoint_date date,
ref_doc varchar(30)
 );
 
 create table doctor(
 doc_name varchar(30),
 branch varchar(30),
 specialization varchar(40),
 id int primary key,
 timings varchar(30)
 );
 
 create table patient_records(
 pname varchar(40),
 pno bigint,
 medication varchar(100),
 prev_history varchar(100),
 sign_sym varchar(100),
 dname varchar(30),
 rec_date date,
 compliant varchar(100)
 );
 
 insert into doctor 
 values ( "Suresh" ,"MG Road", "Cardiology" , 1000, "9am - 1pm" );
 
 insert into doctor 
 values ( "Ramesh" ,"MG Road", "Cardiology" , 1001, "5pm - 9pm" );
 
 insert into doctor 
 values ( "Kamesh" ,"MG Road", "ENT Specialist" , 1002, "9am - 1pm" );
 
 insert into doctor 
 values ( "Naresh" ,"MG Road", "ENT Specialist" , 1003, "5pm - 9pm" );
 
 insert into doctor 
 values ( "Pramesh" ,"MG Road", "General Physician" , 1004, "9am - 1pm" );
 
 insert into doctor 
 values ( "karmesh" ,"MG Road", "General Physician" , 1005, "5pm - 9pm" );
 
 insert into doctor values ("Samaram", "MG Road","Pediatrician",1006,"9am - 1pm");
insert into doctor values ("Venkat", "MG Road","Pediatrician",1007,"5pm - 9pm");
insert into doctor values ("Keerthan", "MG Road","Psychiatrist",1008,"9am - 1pm");
insert into doctor values ("KV Teja", "MG Road","Psychiatrist",1009,"5pm - 9pm");


insert into doctor values("Suseel", "Mugalraj Puram","Cardiology",1010,"9am-1pm");
insert into doctor values("Srihari", "Mugalraj Puram","Cardiology",1011,"5pm-9pm");
insert into doctor values("Prasanth", "Mugalraj Puram","ENT Specialist",1012,"9am-1pm");
insert into doctor values("Prasanth K", "Mugalraj Puram","ENT Specialist",1013,"5pm-9pm");
insert into doctor values("Prasiddhi", "Mugalraj Puram","General Physician",1014,"9am-1pm");
insert into doctor values("Pramod", "Mugalraj Puram","General Physician",1015,"5pm-9pm");
insert into doctor values("Narendra","Mugalraj Puram","Pediatrician",1016,"9am-1pm");
insert into doctor values("Sai Krishna","Mugalraj Puram","Pediatrician",1017,"5pm-9pm");
insert into doctor values("Swaroop" , "Mugalraj Puram","Psychiatrist",1018,"9am-1pm");
insert into doctor values("Swaroop Krishna" , "Mugalraj Puram","Psychiatrist",1019,"5pm-9pm");

insert into doctor values("Guru", "SeethaRam Puram","Cardiology",1020,"9am-1pm");
insert into doctor values("Shanmuk", "SeethaRam Puram","Cardiology",1021,"5pm-9pm");
insert into doctor values("Harsha", "SeethaRam Puram","ENT Specialist",1022,"9am-1pm");
insert into doctor values("Aakash", "SeethaRam Puram","ENT Specialist",1023,"5pm-9pm");
insert into doctor values("Rahul", "SeethaRam Puram","General Physician",1024,"9am-1pm");
insert into doctor values("Ram", "SeethaRam Puram","General Physician",1025,"5pm-9pm");
insert into doctor values("Rama Krish","SeethaRam Puram","Pediatrician",1026,"9am-1pm");
insert into doctor values("Krish J","SeethaRam Puram","Pediatrician",1027,"5pm-9pm");
insert into doctor values("Rajamouli" , "SeethaRam Puram","Psychiatrist",1028,"9am-1pm");
insert into doctor values("Tarak" , "SeethaRam Puram","Psychiatrist",1029,"5pm-9pm");

insert into doctor values("Ramarao", "Patamata","Cardiology",1030,"9am-1pm");
insert into doctor values("Krishnarao", "Patamata","Cardiology",1031,"5pm-9pm");
insert into doctor values("Kumar Varma", "Patamata","ENT Specialist",1032,"9am-1pm");
insert into doctor values("Kattappa", "Patamata","ENT Specialist",1033,"5pm-9pm");
insert into doctor values("Raghu", "Patamata","General Physician",1034,"9am-1pm");
insert into doctor values("Rohan", "Patamata","General Physician",1035,"5pm-9pm");
insert into doctor values("Raju","Patamata","Pediatrician",1036,"9am-1pm");
insert into doctor values("Murali","Patamata","Pediatrician",1037,"5pm-9pm");
insert into doctor values("Lakshman" , "Patamata","Psychiatrist",1038,"9am-1pm");
insert into doctor values("Bhargav" , "Patamata","Psychiatrist",1039,"5pm-9pm");






