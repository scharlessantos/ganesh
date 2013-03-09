alter table usuario drop nome;

insert into pessoa (id_pessoa, codigo, nome, documento) values (0, 'root', 'Super Usuário', '');
insert into usuario (id_usuario, id_pessoa, username, senha) values (0, 0, 'root', '123456');