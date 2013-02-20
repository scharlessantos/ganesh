--Controle de versão do banco de dados
create table dbver (
	module varchar(10) primary key,
	version int
);

--Tabelas do sistema
create table empresa(
	id_empresa int primary key,
	codigo varchar(25) not null unique,
	nome varchar(56) not null,
	cnpj varchar(14) not null
);

create table caminhao(
	id_caminhao int primary key,
	id_empresa int not null,
	codigo varchar(25) not null unique,
	placa varchar(10) not null,
	tipo int not null,
	
	constraint fkCaminhaoEmpresa foreign key (id_empresa) references empresa(id_empresa)
);

create table pessoa(
	id_pessoa int primary key,
	codigo varchar(25) not null unique,
	nome varchar(56) not null,
	documento varchar(14) not null,
	contato varchar(56),
	endereco varchar(56)
);

create table motorista(
	id_motorista int primary key,
	id_empresa int not null,
	id_pessoa int not null,
	
	constraint fkMotoristaEmpresa foreign key (id_empresa) references empresa(id_empresa),
	constraint fkMotoristaPessoa foreign key (id_pessoa) references pessoa(id_pessoa)
);

create table entrega(
	id_entrega int primary key,
	id_motorista int not null,
	id_caminhao int not null,
	dia date not null,
	
	constraint fkEntregaMotorista foreign key (id_motorista) references motorista(id_motorista),
	constraint fkEntregaCaminhao foreign key (id_caminhao) references caminhao(id_caminhao)
);

create table cliente(
	id_cliente int primary key,
	codigo varchar(25) not null unique,
	responsavel int not null,
	endereco varchar(84) not null,
	contato varchar(56) not null,
	
	constraint fkClientePessoa foreign key (responsavel) references pessoa(id_pessoa)
);

create table nota(
	id_nota int primary key,
	codigo varchar(25) not null unique,
	id_entrega int not null,
	id_cliente int not null,
	
	constraint fkNotaCliente foreign key (id_cliente) references cliente(id_cliente),
	constraint fkNotaEntrega foreign key (id_entrega) references entrega(id_entrega)
);

create table produto(
	id_produto int primary key,
	codigo varchar(25) not null unique,
	nome varchar(56),
	complemento varchar(56),
	pesavel int not null default 0 check (pesavel in (0, 1))
);

create table embalagem(
	id_embalagem int primary key,
	id_produto int not null,
	qtd int not null,
	
	constraint fkEmbalagemProduto foreign key (id_produto) references produto(id_produto)
);

create table produto_nota(
	id_embalagem int,
	id_nota int,
	qtd int not null,
	
	constraint pkProdutoNota primary key (id_embalagem, id_nota),
	constraint fkProdutoNotaEmbalagem foreign key (id_embalagem) references embalagem(id_embalagem),
	constraint fkProdutoNotaNota foreign key (id_nota) references nota(id_nota)
);

--Controle de Acesso
create table grupo(
	id_grupo int primary key,
	codigo varchar(20) not null unique,
	descricao varchar(84) not null
);

create table grupo_role(
	id_grupo int,
	rolename varchar(15),
	
	constraint pkGrupoRole primary key (id_grupo, rolename),
	constraint fkGrupoRoleGrupo foreign key (id_grupo) references grupo(id_grupo)
);

create table usuario(
	id_usuario int primary key,
	id_pessoa int not null,
	username varchar(25) not null unique,
	senha varchar(25) not null,
	nome varchar(56) not null,

	constraint fkUsuarioPessoa foreign key (id_pessoa) references pessoa(id_pessoa)
);

create table usuario_grupo(
	id_grupo int,
	id_usuario int,
	
	constraint pkUsuarioGrupo primary key (id_usuario, id_grupo),
	constraint fkUsuarioGrupoUsuario foreign key (id_usuario) references usuario(id_usuario),
	constraint fkUsuarioGrupoGrupo foreign key (id_grupo) references grupo(id_grupo)
);
