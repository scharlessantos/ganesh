--Controle de versão do banco de dados
create table dbver (
	module varchar(10) primary key,
	version int
);

--Tabelas do sistema
create table empresa(
	id_empresa bigint primary key,
	codigo varchar(25) not null unique,
	nome varchar(56) not null,
	cnpj varchar(14) not null
);

create table caminhao(
	id_caminhao bigint primary key,
	id_empresa bigint not null,
	codigo varchar(25) not null unique,
	placa varchar(10) not null,
	tipo bigint not null,
	
	constraint fkCaminhaoEmpresa foreign key (id_empresa) references empresa(id_empresa)
);

create table pessoa(
	id_pessoa bigint primary key,
	codigo varchar(25) not null unique,
	nome varchar(56) not null,
	documento varchar(14) not null,
	contato varchar(56),
	endereco varchar(56)
);

create table motorista(
	id_motorista bigint primary key,
	id_empresa bigint not null,
	id_pessoa bigint not null,
	
	constraint fkMotoristaEmpresa foreign key (id_empresa) references empresa(id_empresa),
	constraint fkMotoristaPessoa foreign key (id_pessoa) references pessoa(id_pessoa)
);

create table entrega(
	id_entrega bigint primary key,
	id_motorista bigint not null,
	id_caminhao bigint not null,
	dia date not null,
	
	constraint fkEntregaMotorista foreign key (id_motorista) references motorista(id_motorista),
	constraint fkEntregaCaminhao foreign key (id_caminhao) references caminhao(id_caminhao)
);

create table cliente(
	id_cliente bigint primary key,
	codigo varchar(25) not null unique,
	responsavel bigint not null,
	endereco varchar(84) not null,
	contato varchar(56) not null,
	
	constraint fkClientePessoa foreign key (responsavel) references pessoa(id_pessoa)
);

create table nota(
	id_nota bigint primary key,
	codigo varchar(25) not null unique,
	id_entrega bigint not null,
	id_cliente bigint not null,
	
	constraint fkNotaCliente foreign key (id_cliente) references cliente(id_cliente),
	constraint fkNotaEntrega foreign key (id_entrega) references entrega(id_entrega)
);

create table produto(
	id_produto bigint primary key,
	codigo varchar(25) not null unique,
	nome varchar(56),
	complemento varchar(56),
	pesavel bigint not null default 0 check (pesavel in (0, 1))
);

create table embalagem(
	id_embalagem bigint primary key,
	id_produto bigint not null,
	qtd bigint not null,
	
	constraint fkEmbalagemProduto foreign key (id_produto) references produto(id_produto)
);

create table produto_nota(
	id_embalagem bigint,
	id_nota bigintbigint,
	qtd bigint not null,
	
	constraint pkProdutoNota primary key (id_embalagem, id_nota),
	constraint fkProdutoNotaEmbalagem foreign key (id_embalagem) references embalagem(id_embalagem),
	constraint fkProdutoNotaNota foreign key (id_nota) references nota(id_nota)
);

--Controle de Acesso
create table grupo(
	id_grupo bigint primary key,
	codigo varchar(20) not null unique,
	descricao varchar(84) not null
);

create table grupo_role(
	id_grupo bigint,
	rolename varchar(15),
	
	constraint pkGrupoRole primary key (id_grupo, rolename),
	constraint fkGrupoRoleGrupo foreign key (id_grupo) references grupo(id_grupo)
);

create table usuario(
	id_usuario bigint primary key,
	id_pessoa bigint not null,
	username varchar(25) not null unique,
	senha varchar(25) not null,
	nome varchar(56) not null,

	constraint fkUsuarioPessoa foreign key (id_pessoa) references pessoa(id_pessoa)
);

create table usuario_grupo(
	id_grupo bigint,
	id_usuario bigint,
	
	constraint pkUsuarioGrupo primary key (id_usuario, id_grupo),
	constraint fkUsuarioGrupoUsuario foreign key (id_usuario) references usuario(id_usuario),
	constraint fkUsuarioGrupoGrupo foreign key (id_grupo) references grupo(id_grupo)
);
