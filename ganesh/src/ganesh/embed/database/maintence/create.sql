create table dbver (
	module varchar(10) primary key,
	version int
);

create table grupo(
	id_grupo int primary key,
	codigo varchar(20),
	descricao varchar(84)
);

create table grupo_role(
	id_grupo int,
	rolename varchar(15)
);
