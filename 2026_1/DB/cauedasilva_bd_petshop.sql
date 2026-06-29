CREATE TABLE cliente
(cd_cliente INT,
nm_cliente VARCHAR(50),
nr_telefone VARCHAR(15),
ds_email VARCHAR(50),
dt_nascimento DATE
);

CREATE TABLE especie
(cd_especie INT,
nm_especie VARCHAR(30)
);

CREATE TABLE raca
(cd_raca INT,
nm_raca VARCHAR(50),
cd_especie INT
);

CREATE TABLE nota_fiscal
(nr_nota_fiscal INT,
dt_emissao DATE,
vl_total DECIMAL(8,2),
cd_cliente INT
);

CREATE TABLE categoria
(cd_categoria INT,
ds_categoria VARCHAR(50)
);

CREATE TABLE item_nota_fiscal
(nr_nota_fiscal INT,
cd_produto INT,
qt_produto INT,
vl_produto DECIMAL(8,2)
);

CREATE TABLE produto
(cd_produto INT,
nm_produto VARCHAR(50),
ds_produto VARCHAR(50),
vl_custo DECIMAL(8,2),
vl_venda DECIMAL(8,2),
qt_estoque INT,
cd_categoria INT
);

CREATE TABLE agendamento
(nr_agendamento INT,
dt_agendamento DATE,
hr_agendamento TIME,
cd_prestador INT,
cd_cliente INT,
cd_animal INT
);

ALTER TABLE agendamento
	ADD cd_prestador INT,
	ADD cd_cliente INT,
	ADD cd_animal INT 

CREATE TABLE agendamento_servico
(nr_agendamento INT,
cd_servico INT,
qt_servico INT,
vl_servico DECIMAL(6,2)
);

CREATE TABLE servico
(cd_servico INT,
ds_servico VARCHAR(50),
vl_servico DECIMAL(6,2)
);

CREATE TABLE servico_prestador
(cd_prestador INT,
cd_servico INT
);

CREATE TABLE prestador_servico
(cd_prestador INT,
nm_prestador VARCHAR(50),
nr_telefone VARCHAR(15),
ds_email VARCHAR(50),
cd_endereco INT
);

CREATE TABLE endereco
(cd_endereco INT,
ds_logradouro VARCHAR(50),
ds_complemento VARCHAR(50),
nm_bairro VARCHAR(30),
nr_cep CHAR(8),
cd_municipio INT
);

CREATE TABLE municipio
(cd_municipio INT,
nm_municipio VARCHAR(50),
sg_uf CHAR(2)
);

CREATE TABLE animal 
(cd_animal INT,
nm_animal VARCHAR(50),
ds_animal VARCHAR(50),
dt_nascimento DATE,
tp_porte CHAR(1),
cd_raca INT,
cd_cliente INT
);

ALTER TABLE especie ADD CONSTRAINT PRIMARY KEY (cd_especie)

ALTER TABLE raca ADD CONSTRAINT PRIMARY KEY (cd_raca)
ALTER TABLE raca ADD CONSTRAINT FOREIGN KEY (cd_especie) REFERENCES especie

ALTER TABLE animal ADD CONSTRAINT PRIMARY KEY (cd_animal)
ALTER TABLE	animal ADD CONSTRAINT FOREIGN KEY (cd_raca) REFERENCES raca
ALTER TABLE	animal ADD CONSTRAINT FOREIGN KEY (cd_cliente) REFERENCES cliente

ALTER TABLE cliente ADD CONSTRAINT PRIMARY KEY (cd_cliente)
ALTER TABLE cliente ADD COLUMN cd_endereco INT 
ALTER TABLE cliente ADD CONSTRAINT FOREIGN KEY (cd_endereco) REFERENCES endereco

ALTER TABLE endereco ADD CONSTRAINT PRIMARY KEY (cd_endereco)
ALTER TABLE endereco ADD CONSTRAINT FOREIGN KEY (cd_municipio) REFERENCES municipio

ALTER TABLE municipio ADD CONSTRAINT PRIMARY KEY (cd_municipio)

ALTER TABLE categoria ADD CONSTRAINT PRIMARY KEY (cd_categoria)

ALTER TABLE produto ADD CONSTRAINT PRIMARY KEY (cd_produto)
ALTER TABLE produto ADD CONSTRAINT FOREIGN KEY (cd_categoria) REFERENCES categoria

ALTER TABLE nota_fiscal ADD CONSTRAINT PRIMARY KEY (nr_nota_fiscal)
ALTER TABLE nota_fiscal ADD CONSTRAINT FOREIGN KEY (cd_cliente) REFERENCES cliente

ALTER TABLE item_nota_fiscal ADD CONSTRAINT PRIMARY KEY (nr_nota_fiscal, cd_produto)
ALTER TABLE item_nota_fiscal ADD CONSTRAINT FOREIGN KEY (nr_nota_fiscal) REFERENCES nota_fiscal
ALTER TABLE item_nota_fiscal ADD CONSTRAINT FOREIGN KEY (cd_produto) REFERENCES produto

ALTER TABLE prestador_servico ADD CONSTRAINT PRIMARY KEY (cd_prestador)
ALTER TABLE prestador_servico ADD CONSTRAINT FOREIGN KEY (cd_endereco) REFERENCES endereco

ALTER TABLE servico ADD CONSTRAINT PRIMARY KEY (cd_servico)

ALTER TABLE servico_prestador ADD CONSTRAINT PRIMARY KEY (cd_prestador, cd_servico)
ALTER TABLE servico_prestador ADD CONSTRAINT FOREIGN KEY (cd_prestador) REFERENCES prestador_servico
ALTER TABLE servico_prestador ADD CONSTRAINT FOREIGN KEY (cd_servico) REFERENCES servico

ALTER TABLE agendamento ADD CONSTRAINT PRIMARY KEY (nr_agendamento)
add
