-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-03-18 18:22:57.357

-- tables
-- Table: categoria
CREATE TABLE categoria (
    id_categoria int  NOT NULL,
    nm_categoria varchar(50)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id_categoria)
);

-- Table: cliente
CREATE TABLE cliente (
    id_cliente int  NOT NULL,
    nm_cliente varchar(50)  NOT NULL,
    ed_rua varchar(50)  NOT NULL,
    ed_nro varchar(50)  NOT NULL,
    ed_bairro varchar(50)  NOT NULL,
    ed_cidade varchar(50)  NOT NULL,
    ed_cep int  NOT NULL,
    ed_uf char(2)  NOT NULL,
    tl_comercial varchar(20)  NOT NULL,
    em_comercial varchar(50)  NOT NULL,
    cr_limite decimal(10,2)  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);

-- Table: pedido
CREATE TABLE pedido (
    id_pedido int  NOT NULL,
    dt_pedido date  NOT NULL,
    id_cliente int  NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (id_pedido)
);

-- Table: produto
CREATE TABLE produto (
    id_produto int  NOT NULL,
    nm_produto varchar(50)  NOT NULL,
    ct_produto varchar(50)  NOT NULL,
    qt_estoque int  NOT NULL,
    vl_unidade decimal(10,2)  NOT NULL,
    id_categoria int  NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (id_produto)
);

-- Table: produto_pedido
CREATE TABLE produto_pedido (
    id_pedido int  NOT NULL,
    id_produto int  NOT NULL,
    qt_item int  NOT NULL,
    vl_total decimal(10,2)  NOT NULL,
    CONSTRAINT produto_pedido_pk PRIMARY KEY (id_produto,id_pedido)
);

-- foreign keys
-- Reference: pedido_cliente (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_cliente FOREIGN KEY pedido_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: produto_categoria (table: produto)
ALTER TABLE produto ADD CONSTRAINT produto_categoria FOREIGN KEY produto_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- Reference: produto_pedido_pedido (table: produto_pedido)
ALTER TABLE produto_pedido ADD CONSTRAINT produto_pedido_pedido FOREIGN KEY produto_pedido_pedido (id_pedido)
    REFERENCES pedido (id_pedido);

-- Reference: produto_pedido_produto (table: produto_pedido)
ALTER TABLE produto_pedido ADD CONSTRAINT produto_pedido_produto FOREIGN KEY produto_pedido_produto (id_produto)
    REFERENCES produto (id_produto);

-- End of file.

