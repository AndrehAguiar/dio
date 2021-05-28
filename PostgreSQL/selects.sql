SELECT numero, nome, ativo FROM banco;
SELECT banco_numero, numero, nome FROM agencia;
SELECT numero, nome, email FROM cliente;
SELECT id, nome FROM tipo_transacao;
SELECT banco_numero, agencia_numero, numero, cliente_numero FROM conta_corrente;
SELECT banco_numero, agencia_numero, cliente_numero FROM cliente_transacoes;

SELECT numero, nome FROM banco;

SELECT column_name, data_type 
	FROM information_schema.columns 
	WHERE table_name = 'banco';

SELECT column_name, data_type 
	FROM information_schema.columns 
	WHERE table_name = 'cliente_transacoes';
	
SELECT AVG(valor) FROM cliente_transacoes;

SELECT COUNT(numero), email
	FROM cliente
	WHERE email LIKE '%@gmail.com'
	GROUP BY email;
	
SELECT MAX(numero) FROM cliente;
SELECT MIN(numero) FROM cliente;
SELECT MAX(valor) FROM cliente_transacoes;
SELECT MIN(valor) FROM cliente_transacoes;

SELECT MAX(valor), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id;
	
SELECT MIN(valor), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id;	
	
SELECT COUNT(id), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id
	HAVING COUNT(id) > 150;
	
SELECT SUM(valor) FROM cliente_transacoes;

SELECT SUM(valor), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id;
	
SELECT SUM(valor), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id
	ORDER BY tipo_transacao_id;
	
SELECT SUM(valor), tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id
	ORDER BY tipo_transacao_id DESC;
	
SELECT SUM(valor) as soma, tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id
	ORDER BY soma;
	
SELECT SUM(valor) as soma, tipo_transacao_id
	FROM cliente_transacoes
	GROUP BY tipo_transacao_id
	ORDER BY soma DESC;	
	
SELECT COUNT(1) FROM banco;
SELECT COUNT(1) FROM agencia;

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
	FROM banco
	JOIN agencia ON agencia.banco_numero = banco.numero;
	
SELECT banco.numero
	FROM banco
	JOIN agencia ON agencia.banco_numero = banco.numero
	GROUP BY banco.numero;

SELECT COUNT(DISTINCT banco.numero)
	FROM banco
	JOIN agencia ON agencia.banco_numero = banco.numero;
	
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
	FROM banco
	LEFT JOIN agencia ON agencia.banco_numero = banco.numero;
	
SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
	FROM agencia
	RIGHT JOIN banco ON banco.numero = agencia.banco_numero;
	
SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
	FROM agencia
	LEFT JOIN banco ON banco.numero = agencia.banco_numero;	
	
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
	FROM banco
	FULL JOIN agencia ON agencia.banco_numero = banco.numero;
	
SELECT 	banco.nome,
		agencia.nome,
		conta_corrente.numero,
		conta_corrente.digito,
		cliente.nome
		FROM banco
		JOIN agencia 
			ON agencia.banco_numero = banco.numero
		JOIN conta_corrente
			ON conta_corrente.banco_numero = banco.numero
			AND conta_corrente.agencia_numero = agencia.numero
		JOIN cliente
			ON cliente.numero = conta_corrente.cliente_numero;
	
SELECT 	banco.nome,
		agencia.nome,
		conta_corrente.numero,
		conta_corrente.digito,
		cliente.nome,
		cliente_transacoes.valor,
		tipo_transacao.nome
		FROM banco
		JOIN agencia
			ON agencia.banco_numero = banco.numero
		JOIN conta_corrente
			ON conta_corrente.banco_numero = banco.numero
			AND conta_corrente.agencia_numero = agencia.numero
		JOIN cliente
			ON cliente.numero = conta_corrente.cliente_numero
		JOIN cliente_transacoes
			ON cliente_transacoes.cliente_numero = cliente.numero
		JOIN tipo_transacao
			ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id;
	
WITH tbl_tmp_banco AS (
	SELECT numero, nome
	FROM banco
)
SELECT numero, nome 
FROM tbl_tmp_banco;
	
	
WITH params AS (
	SELECT 213 AS banco_numero
), tbl_tmp_banco AS (
	SELECT numero, nome
		FROM banco
		JOIN params ON params.banco_numero = banco.numero
)
SELECT numero, nome
	FROM tbl_tmp_banco;
	
WITH clientes_e_transacoes AS (
	SELECT  cliente.nome AS cliente_nome,
			tipo_transacao.nome AS tipo_transacao_nome,
			cliente_transacoes.valor AS tipo_transacao_valor
		FROM cliente_transacoes
			JOIN cliente
				ON cliente.numero = cliente_transacoes.cliente_numero
			JOIN tipo_transacao
				ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
	FROM clientes_e_transacoes;


WITH clientes_e_transacoes AS (
	SELECT  cliente.nome AS cliente_nome,
			tipo_transacao.nome AS tipo_transacao_nome,
			cliente_transacoes.valor AS tipo_transacao_valor
		FROM cliente_transacoes
			JOIN cliente
				ON cliente.numero = cliente_transacoes.cliente_numero
			JOIN tipo_transacao
				ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
			JOIN banco
				ON banco.numero = cliente_transacoes.banco_numero
				AND banco.nome ILIKE '%Itaú%'
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
	FROM clientes_e_transacoes;








