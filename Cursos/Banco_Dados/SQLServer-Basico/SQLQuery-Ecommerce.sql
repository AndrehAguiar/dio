create database Ecommerce;

use Ecommerce;

create table Produtos
(
	Codigo int not null,
	Nome varchar(100) not null,
	Descricao varchar(200) not null,
	Preco float not null
);

create table Pedidos
(
	Codigo int not null,
	DataSolicitacao datetime not null,
	FlagPAgo bit not null,
	TotalPedido float not null,
	CodigoCliente int not null
);

create table PedidoItem
(
	CodigoPedido int not null,
	CodigoProduto int not null,
	Preco float not null,
	Quantidade int not null
);

SELECT * from CLIENTES;

insert into clientes (codigo, nome, TipoPessoa) values (1,'Andre', 'F');
insert into clientes (codigo, nome, TipoPessoa) values (2,'Alex', 'J');
insert into clientes (codigo, nome, TipoPessoa) values (3,'Aline', 'F');
insert into clientes (codigo, nome, TipoPessoa) values (4,'Cristiano', 'F');
insert into clientes (codigo, nome, TipoPessoa) values (5,'Daniel', 'F');
insert into clientes (codigo, nome, TipoPessoa) values (6,'Felipe', 'J');
insert into clientes (codigo, nome, TipoPessoa) values (7,'Bruno', 'F');
insert into clientes (codigo, nome, TipoPessoa) values (8,'Tiago', 'J');
insert into clientes (codigo, nome, TipoPessoa) values (9,'Aline', 'J');

select nome from clientes;
select codigo from clientes;
select tipopessoa from clientes;

SELECT * from clientes where tipopessoa = 'J';
SELECT * from clientes where tipopessoa = 'F';

update clientes set tipopessoa = 'F' where nome = 'Aline';

SELECT * from clientes where nome = 'Aline';

SELECT * from Clientes where nome = 'Aline' and tipopessoa = 'J';

SELECT * from CLIENTES where nome = 'Aline' OR tipopessoa = 'J';

SELECT * from PRODUTOS;

INSERT INTO PRODUTOS (Codigo, Nome, Descricao, Preco)
VALUES (1, 'Caneta', 'Cor Azul', 1.5);
INSERT INTO PRODUTOS (Codigo, Nome, Descricao, Preco)
VALUES (2, 'Caneta', 'Cor Vermelha', 1.5);
INSERT INTO PRODUTOS (Codigo, Nome, Descricao, Preco)
VALUES (3, 'Caderno', 'Dez Matérias', 10.90);
INSERT INTO PRODUTOS (Codigo, Nome, Descricao, Preco)
VALUES (4, 'Lápis', 'Número 2', 0.5);

SELECT * from PEDIDOS;

INSERT INTO PEDIDOS (Codigo, DataSolicitacao, FlagPAgo, TotalPedido, CodigoCliente)
VALUES (1, GETDATE(), 0, 4.5, 7);
INSERT INTO PEDIDOS (Codigo, DataSolicitacao, FlagPAgo, TotalPedido, CodigoCliente)
VALUES (2, GETDATE(), 0, 5.0, 2);

SELECT * from PedidoItem;

INSERT INTO PEDIDOITEM (CodigoPedido, CodigoProduto, Preco, Quantidade)
VALUES (1, 2, 1.5, 3);
INSERT INTO PEDIDOITEM (CodigoPedido, CodigoProduto, Preco, Quantidade)
VALUES (2, 1, 1.5, 2);
INSERT INTO PEDIDOITEM (CodigoPedido, CodigoProduto, Preco, Quantidade)
VALUES (2, 2, 1.5, 1);
INSERT INTO PEDIDOITEM (CodigoPedido, CodigoProduto, Preco, Quantidade)
VALUES (2, 4, 0.5, 1);

SELECT *,
	CASE
		WHEN TIPOPESSOA = 'J' THEN 'JURÍDICA'
		WHEN TIPOPESSOA = 'F' THEN 'FÍSICA'
		ELSE 'PESSOA INDEFINIDA'
	END
FROM CLIENTES;

SELECT *, CONVERT(varchar, DataSolicitacao) FROM Pedidos;
SELECT *, CONVERT(varchar, DataSolicitacao, 103) as 'DATA' FROM Pedidos;

ALTER TABLE PEDIDOITEM ADD CONSTRAINT fk_pedido
FOREIGN KEY (CodigoPedido) REFERENCES Pedidos(Codigo);

ALTER TABLE PEDIDOITEM ADD CONSTRAINT fk_produto
FOREIGN KEY (CodigoProduto) REFERENCES Produtos(Codigo);

SELECT	cli.Nome as nome, ped.TotalPedido as total
FROM	Clientes cli
JOIN	Pedidos ped
ON		ped.CodigoCliente = cli.Codigo
WHERE	cli.Codigo = 7;

SELECT	cli.Nome as nome, ped.TotalPedido as total
FROM	Clientes cli
JOIN	Pedidos ped
ON		ped.CodigoCliente = cli.Codigo
WHERE	cli.Codigo = 2;

SELECT	*
FROM	Clientes cli
INNER	JOIN Pedidos ped
ON		ped.CodigoCliente = cli.Codigo;

SELECT	*
FROM	Clientes cli
LEFT	JOIN Pedidos ped
ON		ped.CodigoCliente = cli.Codigo;

SELECT	*
FROM	Pedidos ped
RIGHT	JOIN Clientes cli
ON		ped.CodigoCliente = cli.Codigo;

SELECT	cli.Nome as nome, ped.TotalPedido as total
FROM	Clientes cli
JOIN	Pedidos ped
ON		ped.CodigoCliente = cli.Codigo
WHERE	ped.TotalPedido > 4.5;