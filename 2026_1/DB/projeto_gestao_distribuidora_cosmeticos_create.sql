-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-04-06 22:42:20.651

-- tables
-- Table: categoria
CREATE TABLE categoria (
    id_categora int  NOT NULL,
    ds_categoria varchar(50)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id_categora)
);

-- Table: cliente
CREATE TABLE cliente (
    id_cliente int  NOT NULL,
    nm_cliente varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    vl_limite decimal(10,2)  NOT NULL,
    endereco_id_endereco int  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);

-- Table: condicao_pagamento
CREATE TABLE condicao_pagamento (
    id_condicao int  NOT NULL,
    ds_condicao_pagamento varchar(50)  NOT NULL,
    vl_expressao varchar(30)  NOT NULL,
    CONSTRAINT condicao_pagamento_pk PRIMARY KEY (id_condicao)
);

-- Table: endereco
CREATE TABLE endereco (
    id_endereco int  NOT NULL,
    nm_logradouro varchar(50)  NOT NULL,
    nm_bairro varchar(50)  NOT NULL,
    ds_complemento varchar(50)  NOT NULL,
    nr_cep char(8)  NOT NULL,
    id_municipio int  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- Table: fornecedor
CREATE TABLE fornecedor (
    id_fornecedor int  NOT NULL,
    nm_fornecedor varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    id_ramo_atuacao int  NOT NULL,
    CONSTRAINT fornecedor_pk PRIMARY KEY (id_fornecedor)
);

-- Table: item_nota_fiscal_saida
CREATE TABLE item_nota_fiscal_saida (
    id_nf int  NOT NULL,
    id_produto int  NOT NULL,
    qt_vendida int  NOT NULL,
    vl_produto decimal(10,2)  NOT NULL,
    CONSTRAINT item_nota_fiscal_saida_pk PRIMARY KEY (id_nf,id_produto)
);

-- Table: item_pedido
CREATE TABLE item_pedido (
    id_pedido int  NOT NULL,
    id_produto int  NOT NULL,
    qt_vendida int  NOT NULL,
    vl_produto decimal(10,2)  NOT NULL,
    CONSTRAINT item_pedido_pk PRIMARY KEY (id_pedido,id_produto)
);

-- Table: municipio
CREATE TABLE municipio (
    id_municipio int  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    id_regiao int  NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (id_municipio)
);

-- Table: nota_fiscal_entrada
CREATE TABLE nota_fiscal_entrada (
    id_fornecedor int  NOT NULL,
    id_nf int  NOT NULL,
    dt_emissao date  NOT NULL,
    vl_total decimal(8,2)  NOT NULL,
    CONSTRAINT nota_fiscal_entrada_pk PRIMARY KEY (id_fornecedor,id_nf)
);

-- Table: nota_fiscal_saida
CREATE TABLE nota_fiscal_saida (
    id_nf int  NOT NULL,
    dt_emissao date  NOT NULL,
    vl_total decimal(8,2)  NOT NULL,
    id_cliente int  NOT NULL,
    pedido_id_pedido int  NOT NULL,
    CONSTRAINT nota_fiscal_saida_pk PRIMARY KEY (id_nf)
);

-- Table: pedido
CREATE TABLE pedido (
    id_pedido int  NOT NULL,
    dt_emissao date  NOT NULL,
    vl_total decimal(10,2)  NOT NULL,
    id_cliente int  NOT NULL,
    id_vendedor int  NOT NULL,
    id_condicao int  NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (id_pedido)
);

-- Table: produto
CREATE TABLE produto (
    id_produto int  NOT NULL,
    nm_produto varchar(50)  NOT NULL,
    vl_custo decimal(10,2)  NOT NULL,
    vl_venda decimal(8,2)  NOT NULL,
    pc_margem decimal(4,1)  NOT NULL,
    id_categora int  NOT NULL,
    id_fornecedor int  NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (id_produto)
);

-- Table: ramo_atuacao
CREATE TABLE ramo_atuacao (
    id_ramo_atuacao int  NOT NULL,
    nm_ramo_atuacao varchar(50)  NOT NULL,
    CONSTRAINT ramo_atuacao_pk PRIMARY KEY (id_ramo_atuacao)
);

-- Table: regiao
CREATE TABLE regiao (
    id_regiao int  NOT NULL,
    nm_regiao varchar(50)  NOT NULL,
    id_vendedor int  NOT NULL,
    CONSTRAINT regiao_pk PRIMARY KEY (id_regiao)
);

-- Table: titulo_pagar
CREATE TABLE titulo_pagar (
    id_titulo int  NOT NULL,
    dt_emissao date  NOT NULL,
    dt_vencimento date  NOT NULL,
    dt_pagamento date  NOT NULL,
    vl_titulo decimal(10,2)  NOT NULL,
    vl_multa decimal(10,2)  NOT NULL,
    vl_juros decimal(10,2)  NOT NULL,
    id_fornecedor int  NOT NULL,
    id_nf int  NOT NULL,
    CONSTRAINT titulo_pagar_pk PRIMARY KEY (id_titulo)
);

-- Table: titulo_receber
CREATE TABLE titulo_receber (
    id_titulo int  NOT NULL,
    dt_emissao date  NOT NULL,
    dt_vencimento date  NOT NULL,
    dt_pagamento date  NOT NULL,
    vl_titulo decimal(10,2)  NOT NULL,
    vl_multa decimal(10,2)  NOT NULL,
    vl_juros decimal(10,2)  NOT NULL,
    id_cliente int  NOT NULL,
    id_nf int  NOT NULL,
    CONSTRAINT titulo_receber_pk PRIMARY KEY (id_titulo)
);

-- Table: vendedor
CREATE TABLE vendedor (
    id_vendedor int  NOT NULL,
    nm_vendedor varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    vl_salario_base decimal(10,2)  NOT NULL,
    pc_vendas decimal(3,1)  NOT NULL,
    id_endereco int  NOT NULL,
    CONSTRAINT vendedor_pk PRIMARY KEY (id_vendedor)
);

-- foreign keys
-- Reference: cliente_endereco (table: cliente)
ALTER TABLE cliente ADD CONSTRAINT cliente_endereco FOREIGN KEY cliente_endereco (endereco_id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: endereco_municipio (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_municipio FOREIGN KEY endereco_municipio (id_municipio)
    REFERENCES municipio (id_municipio);

-- Reference: fornecedor_ramo_atuacao (table: fornecedor)
ALTER TABLE fornecedor ADD CONSTRAINT fornecedor_ramo_atuacao FOREIGN KEY fornecedor_ramo_atuacao (id_ramo_atuacao)
    REFERENCES ramo_atuacao (id_ramo_atuacao);

-- Reference: item_nota_fiscal_saida_nota_fiscal_saida (table: item_nota_fiscal_saida)
ALTER TABLE item_nota_fiscal_saida ADD CONSTRAINT item_nota_fiscal_saida_nota_fiscal_saida FOREIGN KEY item_nota_fiscal_saida_nota_fiscal_saida (id_nf)
    REFERENCES nota_fiscal_saida (id_nf);

-- Reference: item_nota_fiscal_saida_produto (table: item_nota_fiscal_saida)
ALTER TABLE item_nota_fiscal_saida ADD CONSTRAINT item_nota_fiscal_saida_produto FOREIGN KEY item_nota_fiscal_saida_produto (id_produto)
    REFERENCES produto (id_produto);

-- Reference: item_pedido_pedido (table: item_pedido)
ALTER TABLE item_pedido ADD CONSTRAINT item_pedido_pedido FOREIGN KEY item_pedido_pedido (id_pedido)
    REFERENCES pedido (id_pedido);

-- Reference: item_pedido_produto (table: item_pedido)
ALTER TABLE item_pedido ADD CONSTRAINT item_pedido_produto FOREIGN KEY item_pedido_produto (id_produto)
    REFERENCES produto (id_produto);

-- Reference: municipio_regiao (table: municipio)
ALTER TABLE municipio ADD CONSTRAINT municipio_regiao FOREIGN KEY municipio_regiao (id_regiao)
    REFERENCES regiao (id_regiao);

-- Reference: nota_fiscal_entrada_fornecedor (table: nota_fiscal_entrada)
ALTER TABLE nota_fiscal_entrada ADD CONSTRAINT nota_fiscal_entrada_fornecedor FOREIGN KEY nota_fiscal_entrada_fornecedor (id_fornecedor)
    REFERENCES fornecedor (id_fornecedor);

-- Reference: nota_fiscal_saida_cliente (table: nota_fiscal_saida)
ALTER TABLE nota_fiscal_saida ADD CONSTRAINT nota_fiscal_saida_cliente FOREIGN KEY nota_fiscal_saida_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: nota_fiscal_saida_pedido (table: nota_fiscal_saida)
ALTER TABLE nota_fiscal_saida ADD CONSTRAINT nota_fiscal_saida_pedido FOREIGN KEY nota_fiscal_saida_pedido (pedido_id_pedido)
    REFERENCES pedido (id_pedido);

-- Reference: pedido_cliente (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_cliente FOREIGN KEY pedido_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: pedido_condicao_pagamento (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_condicao_pagamento FOREIGN KEY pedido_condicao_pagamento (id_condicao)
    REFERENCES condicao_pagamento (id_condicao);

-- Reference: pedido_vendedor (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_vendedor FOREIGN KEY pedido_vendedor (id_vendedor)
    REFERENCES vendedor (id_vendedor);

-- Reference: produto_categoria (table: produto)
ALTER TABLE produto ADD CONSTRAINT produto_categoria FOREIGN KEY produto_categoria (id_categora)
    REFERENCES categoria (id_categora);

-- Reference: produto_fornecedor (table: produto)
ALTER TABLE produto ADD CONSTRAINT produto_fornecedor FOREIGN KEY produto_fornecedor (id_fornecedor)
    REFERENCES fornecedor (id_fornecedor);

-- Reference: regiao_vendedor (table: regiao)
ALTER TABLE regiao ADD CONSTRAINT regiao_vendedor FOREIGN KEY regiao_vendedor (id_vendedor)
    REFERENCES vendedor (id_vendedor);

-- Reference: titulo_pagar_nota_fiscal_entrada (table: titulo_pagar)
ALTER TABLE titulo_pagar ADD CONSTRAINT titulo_pagar_nota_fiscal_entrada FOREIGN KEY titulo_pagar_nota_fiscal_entrada (id_fornecedor,id_nf)
    REFERENCES nota_fiscal_entrada (id_fornecedor,id_nf);

-- Reference: titulo_receber_cliente (table: titulo_receber)
ALTER TABLE titulo_receber ADD CONSTRAINT titulo_receber_cliente FOREIGN KEY titulo_receber_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: titulo_receber_nota_fiscal_saida (table: titulo_receber)
ALTER TABLE titulo_receber ADD CONSTRAINT titulo_receber_nota_fiscal_saida FOREIGN KEY titulo_receber_nota_fiscal_saida (id_nf)
    REFERENCES nota_fiscal_saida (id_nf);

-- Reference: vendedor_endereco (table: vendedor)
ALTER TABLE vendedor ADD CONSTRAINT vendedor_endereco FOREIGN KEY vendedor_endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- End of file.

