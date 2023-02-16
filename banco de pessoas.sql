create database alexandre;
use alexandre;
create table pessoa (
	cpf INT PRIMARY KEY,
    nome varchar(100)
);

insert into pessoa (cpf, nome) values (123, "alexandre")