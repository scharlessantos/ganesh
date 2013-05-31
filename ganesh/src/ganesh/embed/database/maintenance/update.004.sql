create table picking(

	id_picking bigint primary key,
	
	codigo varchar(32) not null unique,
	
	descricao varchar(84) not null

);

create table produto_picking(

	id_picking bigint not null,
	
	id_embalagem bigint not null,
	
	qtd int not null,
	
	constraint pkProdutoPicking primary key (id_picking, id_embalagem),
	constraint fkProdutoPickingEmbalagem foreign key (id_embalagem) references embalagem(id_embalagem)

);