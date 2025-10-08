drop database if exists Imobiliaria;
create database Imobiliaria;
use Imobiliaria;
create table Imobiliaria.Condominio(
idCondominio int,
sigla varchar(45) not null,
nome varchar(80) not null,
telefone varchar(20) not null,
nomeSindico varchar(80) not null,
enderecoLogradouro varchar(80) not null,
enderecoNome varchar(45) not null,
enderecoNumero varchar(10) not null,
primary key(idCondominio)
);
