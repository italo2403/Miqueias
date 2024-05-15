create database dbarmazem;

use dbarmazem;

create table tbusuario(
idUser integer primary key auto_increment ,
login varchar(100) not null,
fone varchar (20) not null,
senha varchar(20) not null
);

insert into tbusuario(login, fone, senha) values('Admin', '1234-56789', 'admin');
insert into tbusuario(login, fone, senha) values('italo', '1234-98765', '12345');
drop table tbusuario
describe tbusuario;


 
update tbusuario set perfil='admin' where idUser=1;
update tbusuario set perfil='user' where idUser=2;

alter table tbusuario add column perfil varchar(20) not null;
alter table tbusuario add column usuario varchar(50) not null;


create table tbclientes(
idcli int primary key auto_increment,
nomecli varchar (100) not null,
endcli varchar (100),
fonecli varchar(50) not null,
emailcli varchar(50)
);

insert into tbclientes(nomecli, endcli, fonecli, emailcli) values('Ítalo Nunes', 'Rua Dois,23','1234-56789', 'italo@italo.com');
drop table tbclientes


select * from tbclientes