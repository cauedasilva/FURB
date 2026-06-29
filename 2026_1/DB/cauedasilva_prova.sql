-- Questão 1

CREATE TABLE ramo_atuacao (
cd_ramo INT PRIMARY KEY,
ds_ramo VARCHAR(50)
);

CREATE TABLE fornecedor (
cd_fornecedor INT PRIMARY KEY,
nm_fornecedor VARCHAR(50),
ds_email VARCHAR(50) UNIQUE,
ds_website VARCHAR(50),
cd_ramo INT REFERENCES ramo_atuacao(cd_ramo)
);

CREATE TABLE nota_fiscal_entrada (
nr_nf_entrada INT PRIMARY KEY,
dt_emissao DATE,
vl_total DECIMAL(8,2) DEFAULT 0,
cd_fornecedor INT REFERENCES fornecedor(cd_fornecedor)
);

CREATE TABLE titulo_pagar (
nr_titulo INT PRIMARY KEY,
dt_emissao DATE,
dt_vencimento DATE,
dt_pagamento DATE,
vl_titulo DECIMAL(8,2),
vl_multa DECIMAL(8,2),
nr_nf_entrada INT REFERENCES nota_fiscal_entrada(nr_nf_entrada),
cd_fornecedor INT REFERENCES fornecedor(cd_fornecedor)
);

-- Questão 2

INSERT INTO ramo_atuacao(cd_ramo, ds_ramo)
VALUES
	(1, "TI"),
	(2, "Livraria"),
	(3, "Restaurante");

INSERT INTO fornecedor(cd_fornecedor, nm_fornecedor, ds_email, ds_website, cd_ramo)
VALUES
	(1, 'Ana', 'ana@gmail.com', 'ana.com.br', 1),
	(2, 'Bruno', 'bruno@gmail.com', 'bruno.com.br', 2),
	(3, 'Carla', 'carla@gmail.com', 'carla.com.br', 1),
	(4, 'Diego', 'diego@gmail.com', 'diego.com.br', 3),
	(5, 'Elisa', 'elisa@gmail.com', 'elisa.com.br', 3);
	
INSERT INTO nota_fiscal_entrada(nr_nf_entrada, dt_emissao, vl_total, cd_fornecedor)
VALUES
	(1, '2025-05-10', 500, 1),
	(2, '2025-04-20', 150, 2),
	(3, '2025-12-01', 800, 3),
	(4, '2025-01-15', 300, 4),
	(5, '2025-07-25', 7000, 5);
	(6, '2025-07-30', 8000, 5);

INSERT INTO titulo_pagar(nr_titulo, dt_emissao, dt_vencimento, dt_pagamento, vl_titulo, vl_multa, nr_nf_entrada, cd_fornecedor)
VALUES 
	(1, '2025-05-11', '2025-06-11', '2025-06-01', 500, 0, 1, 1),
	(2, '2025-04-21', '2025-05-15', '2025-05-10', 150, 0, 2, 2),
	(3, '2025-12-02', '2025-12-25', '2025-12-10', 800, 0, 3, 3),
	(4, '2025-01-16', '2025-03-30', '2025-04-01', 300, 10, 4, 4),
	(5, '2025-07-26', '2025-09-10', '2025-10-20', 7000, 500, 5, 5),
	(6, '2025-05-11', '2025-06-11', NULL, 700, 0, 1, 1),
	(7, '2025-05-11', '2025-06-11', NULL, 8000, 0, 2, 2),
	(8, '2025-05-11', '2025-06-11', NULL, 300, 0, 3, 3),
	(9, '2025-05-11', '2025-06-11', NULL, 50, 0, 4, 4),
	(10, '2025-05-11', '2025-06-11', NULL, 900, 0, 5, 5);

-- Questão 3
	
SELECT f.nm_fornecedor, COUNT(*) AS qtde_nf, SUM(nf.vl_total)
FROM fornecedor f JOIN nota_fiscal_entrada nf ON f.cd_fornecedor = nf.cd_fornecedor
GROUP BY nf.cd_fornecedor
ORDER BY nf.vl_total DESC;

-- Questão 4

SELECT t.dt_emissao, COUNT(*) AS qtde_titulos_pagos, SUM(vl_titulo) AS montante_pago
FROM titulo_pagar t
WHERE t.dt_pagamento IS NOT NULL
	AND t.dt_pagamento > '2025-05-31'
	AND t.dt_pagamento < '2025-12-31'
GROUP BY t.dt_emissao;

-- Questão 5

SELECT f.nm_fornecedor, f.ds_email, r.ds_ramo
FROM fornecedor f JOIN ramo_atuacao r ON f.cd_ramo = r.cd_ramo
ORDER BY f.nm_fornecedor;

