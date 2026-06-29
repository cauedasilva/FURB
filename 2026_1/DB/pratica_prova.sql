CREATE TABLE supervisor(
cd_supervisor INT PRIMARY KEY,
nm_supervisor VARCHAR(50)
);

CREATE TABLE vendedor (
cd_vendedor INT PRIMARY KEY,
nm_vendedor VARCHAR(50),
dt_nascimento DATE,
nr_telefone varchar(15),
pc_comissao DECIMAL(3,1),
cd_supervisor INT REFERENCES supervisor(cd_supervisor)
);

CREATE TABLE municipio (
cd_municipio INT PRIMARY KEY,
nm_municipio VARCHAR(50),
sg_uf CHAR(2)
);

CREATE TABLE cliente (
cd_cliente INT PRIMARY key,
nm_cliente VARCHAR(50),
nr_telefone VARCHAR(15),
ds_email VARCHAR(50),
vl_limite DECIMAL(8,2)
);

CREATE TABLE endereco (
cd_endereco INT PRIMARY KEY,
nm_logradouro VARCHAR(50),
ds_complemento VARCHAR(30),
nm_bairro VARCHAR(30),
nr_cep CHAR(8),
cd_municipio INT REFERENCES municipio(cd_municipio),
cd_cliente INT REFERENCES cliente(cd_cliente)
);

CREATE TABLE nota_fiscal (
nr_nota_fiscal INT PRIMARY KEY,
dt_emissao DATE,
vl_total DECIMAL(8,2),
cd_cliente INT REFERENCES cliente(cd_cliente),
cd_vendedor INT REFERENCES vendedor(cd_vendedor)
);

CREATE TABLE classificacao (
id_classificacao INT PRIMARY KEY,
nm_classificacao VARCHAR(100),
vl_limite_inf DECIMAL(8,2),
vl_limite_sup DECIMAL(8,2)
);

CREATE TABLE categoria (
cd_categoria INT PRIMARY KEY,
nm_categoria VARCHAR(30)
);

CREATE TABLE produto (
cd_produto INT PRIMARY KEY,
ds_produto VARCHAR(50),
qt_estoque INT,
vl_produto DECIMAL(8,2),
vl_custo DECIMAL(8,2),
cd_categoria INT REFERENCES categoria(cd_categoria)
);

CREATE TABLE item_nota_fiscal (
nr_nota_fiscal INT,
cd_produto INT,
qt_vendida INT,
vl_produto DECIMAL(8,2),

PRIMARY KEY (nr_nota_fiscal, cd_produto),
FOREIGN KEY (nr_nota_fiscal) REFERENCES nota_fiscal(nr_nota_fiscal),
FOREIGN KEY (cd_produto) REFERENCES produto(cd_produto)
);


ALTER TABLE classificacao
	ADD constraint uk_nm_classificacao UNIQUE(nm_classificacao);
	

ALTER TABLE categoria
	ADD constraint uk_nm_categoria UNIQUE(nm_categoria);
	
SELECT p.ds_produto, c.nm_cliente, i.qt_vendida, nf.dt_emissao
FROM nota_fiscal nf
JOIN cliente c ON c.cd_cliente = nf.cd_cliente
JOIN item_nota_fiscal i  ON i.nr_nota_fiscal = nf.nr_nota_fiscal
JOIN produto p ON p.cd_produto = i.cd_produto
WHERE YEAR(nf.dt_emissao) = 2024

SELECT c.nm_cliente
FROM nota_fiscal nf
JOIN cliente c ON c.cd_cliente = nf.cd_cliente
JOIN item_nota_fiscal i  ON i.nr_nota_fiscal = nf.nr_nota_fiscal
JOIN produto p ON p.cd_produto = i.cd_produto
WHERE p.ds_produto = "smartphone";
 
SELECT p.ds_produto, v.nm_vendedor, i.qt_vendida, nf.dt_emissao
FROM nota_fiscal nf
JOIN vendedor v ON v.cd_vendedor = nf.cd_vendedor
JOIN item_nota_fiscal i  ON i.nr_nota_fiscal = nf.nr_nota_fiscal
JOIN produto p ON p.cd_produto = i.cd_produto
WHERE YEAR(nf.dt_emissao) = 2024
ORDER BY v.nm_vendedor

SELECT c.nm_cliente, c.vl_limite
FROM cliente c
LEFT JOIN nota_fiscal nf
    ON c.cd_cliente = nf.cd_cliente
    AND YEAR(nf.dt_emissao) = 2024
WHERE nf.nr_nota_fiscal IS NULL;

SELECT p.ds_produto, c.nm_categoria, p.vl_produto
FROM produto p
JOIN categoria c ON p.cd_categoria = c.cd_categoria
WHERE p.vl_produto > 500;

SELECT c.nm_cliente, p.ds_produto, p.vl_produto
FROM cliente c
JOIN nota_fiscal nf ON c.cd_cliente = nf.cd_cliente
JOIN item_nota_fiscal i ON nf.nr_nota_fiscal = i.nr_nota_fiscal
JOIN produto p ON i.cd_produto = p.cd_produto
WHERE nf.vl_total > 300 AND YEAR(nf.dt_emissao) = 2024;

SELECT p.ds_produto, v.nm_vendedor, i.qt_vendida
FROM vendedor v
JOIN nota_fiscal nf ON v.cd_vendedor = nf.cd_vendedor
JOIN item_nota_fiscal i ON nf.nr_nota_fiscal = i.nr_nota_fiscal
JOIN produto p ON i.cd_produto = p.cd_produto
JOIN categoria c ON p.cd_categoria = c.cd_categoria
WHERE c.nm_categoria = "Móveis" AND v.pc_comissao > 5;

SELECT v.nm_vendedor, s.nm_supervisor
FROM vendedor v
left JOIN supervisor s ON v.cd_supervisor = s.cd_supervisor;

SELECT p.ds_produto, c.nm_categoria
FROM produto p
JOIN categoria c ON p.cd_categoria = c.cd_categoria
ORDER BY p.ds_produto ASC 