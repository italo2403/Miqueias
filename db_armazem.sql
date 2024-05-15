create database armazem;
use armazem;

create table tb_usuarios(
 iduser int primary key auto_increment,
 usuario varchar(50) not null,
 fone varchar(15),
 login varchar(15) not null unique,
 senha varchar(15) not null
);
select * from tb_usuarios;
alter table tb_usuarios add column perfil varchar(15) not null;
update tb_usuarios set perfil='admin'  where iduser=1;
update tb_usuarios set perfil='admin'  where iduser=2;
update tb_usuarios set perfil='user'  where iduser=3;
INSERT INTO tb_usuarios(usuario,fone,login,senha)
values('italo','9999-9999','italo','1234'),
('gessica','9999-8888','gessica','123')
;
DELETE FROM tb_usuarios WHERE iduser='5';
describe tb_usuarios;
INSERT INTO tb_usuarios(usuario,fone,login,senha, perfil)
values('paulo','9999-9999','paulo','12345', 'user');
INSERT INTO tb_usuarios(usuario,fone,login,senha, perfil)
values('paulo','9999-9999','paulo','12345', 'user');
select * from tb_usuarios;


create table tbclientes(
idcli int primary key auto_increment,
nomecli varchar(150)not null,
endcli varchar(150),
fonecli varchar(150) not null,
emailcli varchar(150) not null
);
select idcli as id, nomecli as nome, endcli as endereço, fonecli as fone, emailcli as email
from tbclientes;


select * from tbclientes;
create table tbos(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
produto varchar(150) not null,
defeito varchar(150),
serviço varchar(150),
vendedor varchar(150),
valor decimal(10,2),
idcli int,
foreign key(idcli) references tbclientes(idcli)
);
select * from tbos;
alter table tbos add situacao varchar(30) NOT NULL AFTER tipo;
alter table tbos add tipo varchar(15) NOT NULL AFTER data_os;
alter table tbos add servico varchar(15) NOT NULL AFTER defeito;
alter table tbos add quantidade varchar(50) not null after servico;
describe tbos;

select idcli as id,nomecli as nome,fonecli as fone from tbclientes where nomecli like 'it%';

ALTER TABLE tbos DROP COLUMN serviço;
drop database armazem
