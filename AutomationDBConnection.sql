create database if not exists AutomationDBConnection;
use AutomationDBConnection;

create table WebTable(
	idWebTable integer not null auto_increment,
    firstnamevalue varchar(50),
    prenume varchar(50),
    emailvalue varchar(50),
    varsta varchar(50),
    salariuvaloare varchar(50),
    departamentvaloare varchar(50),
    entrydate varchar(50),
    primary key(idWebTable)
);