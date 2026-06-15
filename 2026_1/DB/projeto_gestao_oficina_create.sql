-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-04-12 16:25:49.32

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
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    id_endereco int  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
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

-- Table: especialidade
CREATE TABLE especialidade (
    id_especialidade int  NOT NULL,
    nm_especialidade varchar(50)  NOT NULL,
    CONSTRAINT especialidade_pk PRIMARY KEY (id_especialidade)
);

-- Table: marca
CREATE TABLE marca (
    id_marca int  NOT NULL,
    nm_marca varchar(50)  NOT NULL,
    CONSTRAINT marca_pk PRIMARY KEY (id_marca)
);

-- Table: modelo
CREATE TABLE modelo (
    id_modelo int  NOT NULL,
    dt_ano_modelo date  NOT NULL,
    id_marca int  NOT NULL,
    nm_modelo varchar(50)  NOT NULL,
    CONSTRAINT modelo_pk PRIMARY KEY (id_modelo)
);

-- Table: municipio
CREATE TABLE municipio (
    id_municipio int  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (id_municipio)
);

-- Table: nf
CREATE TABLE nf (
    id_nf int  NOT NULL,
    dt_emissao date  NOT NULL,
    vl_total decimal(10,2)  NOT NULL,
    id_os int  NOT NULL,
    CONSTRAINT nf_pk PRIMARY KEY (id_nf)
);

-- Table: nf_peca
CREATE TABLE nf_peca (
    id_nf int  NOT NULL,
    id_os int  NOT NULL,
    id_peca int  NOT NULL,
    vl_item decimal(10,2)  NOT NULL,
    CONSTRAINT nf_peca_pk PRIMARY KEY (id_nf,id_os,id_peca)
);

-- Table: nf_servico
CREATE TABLE nf_servico (
    id_nf int  NOT NULL,
    id_servico int  NOT NULL,
    id_os int  NOT NULL,
    vl_item decimal(10,2)  NOT NULL,
    CONSTRAINT nf_servico_pk PRIMARY KEY (id_nf,id_servico,id_os)
);

-- Table: os
CREATE TABLE os (
    id_os int  NOT NULL,
    id_cliente int  NOT NULL,
    id_veiculo int  NOT NULL,
    dt_emissao date  NOT NULL,
    CONSTRAINT os_pk PRIMARY KEY (id_os)
);

-- Table: peca
CREATE TABLE peca (
    id_peca int  NOT NULL,
    nm_peca varchar(50)  NOT NULL,
    ds_peca varchar(50)  NOT NULL,
    qt_estoque int  NOT NULL,
    vl_compra decimal(10,2)  NOT NULL,
    vl_venda decimal(10,2)  NOT NULL,
    id_categoria int  NOT NULL,
    CONSTRAINT peca_pk PRIMARY KEY (id_peca)
);

-- Table: peca_os
CREATE TABLE peca_os (
    id_os int  NOT NULL,
    id_peca int  NOT NULL,
    qt_peca int  NOT NULL,
    vl_unidade decimal(10,2)  NOT NULL,
    CONSTRAINT peca_os_pk PRIMARY KEY (id_os,id_peca)
);

-- Table: profissional
CREATE TABLE profissional (
    id_profissional int  NOT NULL,
    nm_profissional varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    id_endereco int  NOT NULL,
    id_especialidade int  NOT NULL,
    CONSTRAINT profissional_pk PRIMARY KEY (id_profissional)
);

-- Table: servico
CREATE TABLE servico (
    id_servico int  NOT NULL,
    nm_servico varchar(50)  NOT NULL,
    ds_servico varchar(50)  NOT NULL,
    vl_servico decimal(10,2)  NOT NULL,
    nr_tempo_estimado int  NOT NULL,
    CONSTRAINT servico_pk PRIMARY KEY (id_servico)
);

-- Table: servico_os
CREATE TABLE servico_os (
    id_servico int  NOT NULL,
    id_os int  NOT NULL,
    id_profissional int  NOT NULL,
    vl_total decimal(10,2)  NOT NULL,
    CONSTRAINT servico_os_pk PRIMARY KEY (id_servico,id_os)
);

-- Table: veiculo
CREATE TABLE veiculo (
    id_veiculo int  NOT NULL,
    ds_placa char(7)  NOT NULL,
    dt_fabricacao date  NOT NULL,
    id_modelo int  NOT NULL,
    CONSTRAINT veiculo_pk PRIMARY KEY (id_veiculo)
);

-- foreign keys
-- Reference: cliente_endereco (table: cliente)
ALTER TABLE cliente ADD CONSTRAINT cliente_endereco FOREIGN KEY cliente_endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: endereco_municipio (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_municipio FOREIGN KEY endereco_municipio (id_municipio)
    REFERENCES municipio (id_municipio);

-- Reference: modelo_marca (table: modelo)
ALTER TABLE modelo ADD CONSTRAINT modelo_marca FOREIGN KEY modelo_marca (id_marca)
    REFERENCES marca (id_marca);

-- Reference: nf_os (table: nf)
ALTER TABLE nf ADD CONSTRAINT nf_os FOREIGN KEY nf_os (id_os)
    REFERENCES os (id_os);

-- Reference: nf_peca_nf (table: nf_peca)
ALTER TABLE nf_peca ADD CONSTRAINT nf_peca_nf FOREIGN KEY nf_peca_nf (id_nf)
    REFERENCES nf (id_nf);

-- Reference: nf_peca_peca_os (table: nf_peca)
ALTER TABLE nf_peca ADD CONSTRAINT nf_peca_peca_os FOREIGN KEY nf_peca_peca_os (id_os,id_peca)
    REFERENCES peca_os (id_os,id_peca);

-- Reference: nf_servico_nf (table: nf_servico)
ALTER TABLE nf_servico ADD CONSTRAINT nf_servico_nf FOREIGN KEY nf_servico_nf (id_nf)
    REFERENCES nf (id_nf);

-- Reference: nf_servico_servico_os (table: nf_servico)
ALTER TABLE nf_servico ADD CONSTRAINT nf_servico_servico_os FOREIGN KEY nf_servico_servico_os (id_servico,id_os)
    REFERENCES servico_os (id_servico,id_os);

-- Reference: os_cliente (table: os)
ALTER TABLE os ADD CONSTRAINT os_cliente FOREIGN KEY os_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: os_veiculo (table: os)
ALTER TABLE os ADD CONSTRAINT os_veiculo FOREIGN KEY os_veiculo (id_veiculo)
    REFERENCES veiculo (id_veiculo);

-- Reference: peca_categoria (table: peca)
ALTER TABLE peca ADD CONSTRAINT peca_categoria FOREIGN KEY peca_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- Reference: peca_os_os (table: peca_os)
ALTER TABLE peca_os ADD CONSTRAINT peca_os_os FOREIGN KEY peca_os_os (id_os)
    REFERENCES os (id_os);

-- Reference: peca_os_peca (table: peca_os)
ALTER TABLE peca_os ADD CONSTRAINT peca_os_peca FOREIGN KEY peca_os_peca (id_peca)
    REFERENCES peca (id_peca);

-- Reference: profissional_endereco (table: profissional)
ALTER TABLE profissional ADD CONSTRAINT profissional_endereco FOREIGN KEY profissional_endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: profissional_especialidade (table: profissional)
ALTER TABLE profissional ADD CONSTRAINT profissional_especialidade FOREIGN KEY profissional_especialidade (id_especialidade)
    REFERENCES especialidade (id_especialidade);

-- Reference: servico_os_os (table: servico_os)
ALTER TABLE servico_os ADD CONSTRAINT servico_os_os FOREIGN KEY servico_os_os (id_os)
    REFERENCES os (id_os);

-- Reference: servico_os_profissional (table: servico_os)
ALTER TABLE servico_os ADD CONSTRAINT servico_os_profissional FOREIGN KEY servico_os_profissional (id_profissional)
    REFERENCES profissional (id_profissional);

-- Reference: servico_os_servico (table: servico_os)
ALTER TABLE servico_os ADD CONSTRAINT servico_os_servico FOREIGN KEY servico_os_servico (id_servico)
    REFERENCES servico (id_servico);

-- Reference: veiculo_modelo (table: veiculo)
ALTER TABLE veiculo ADD CONSTRAINT veiculo_modelo FOREIGN KEY veiculo_modelo (id_modelo)
    REFERENCES modelo (id_modelo);

-- End of file.

