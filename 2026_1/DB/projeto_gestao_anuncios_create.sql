-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-04-18 16:34:44.481

-- tables
-- Table: anuncio
CREATE TABLE anuncio (
    id_anuncio int  NOT NULL,
    nm_titulo varchar(50)  NOT NULL,
    ds_descricao varchar(200)  NOT NULL,
    vl_venda decimal(10,2)  NOT NULL,
    dt_publicacao date  NOT NULL,
    nr_validade int  NOT NULL,
    id_categoria int  NOT NULL,
    id_situacao_produto int  NOT NULL,
    id_status int  NOT NULL,
    id_classificacao_anuncio int  NOT NULL,
    id_cep int  NOT NULL,
    id_subcategoria int  NOT NULL,
    CONSTRAINT anuncio_pk PRIMARY KEY (id_anuncio)
);

-- Table: categoria
CREATE TABLE categoria (
    id_categoria int  NOT NULL,
    nm_categoria varchar(50)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id_categoria)
);

-- Table: cep
CREATE TABLE cep (
    id_cep int  NOT NULL,
    nr_cep char(8)  NOT NULL,
    id_regiao int  NOT NULL,
    CONSTRAINT cep_pk PRIMARY KEY (id_cep)
);

-- Table: classificacao_anuncio
CREATE TABLE classificacao_anuncio (
    id_classificacao_anuncio int  NOT NULL,
    nm_classificacao varchar(50)  NOT NULL,
    nr_prioridade int  NOT NULL,
    vl_pago decimal(10,2)  NOT NULL,
    id_fotos_permitidas int  NOT NULL,
    CONSTRAINT classificacao_anuncio_pk PRIMARY KEY (id_classificacao_anuncio)
);

-- Table: endereco
CREATE TABLE endereco (
    id_endereco int  NOT NULL,
    ds_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(30)  NOT NULL,
    nm_bairro varchar(30)  NOT NULL,
    id_usuario int  NOT NULL,
    id_municipio int  NOT NULL,
    id_cep int  NOT NULL,
    nr_numero varchar(50)  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- Table: excluir_anuncio
CREATE TABLE excluir_anuncio (
    id_excluir_anuncio int  NOT NULL,
    dt_data_exclusao date  NOT NULL,
    id_motivo_exclusao int  NOT NULL,
    id_usuario int  NOT NULL,
    id_anuncio int  NOT NULL,
    CONSTRAINT excluir_anuncio_pk PRIMARY KEY (id_excluir_anuncio)
);

-- Table: fotos_permitidas
CREATE TABLE fotos_permitidas (
    id_fotos_permitidas int  NOT NULL,
    nr_fotos_permitidas int  NOT NULL,
    CONSTRAINT fotos_permitidas_pk PRIMARY KEY (id_fotos_permitidas)
);

-- Table: genero
CREATE TABLE genero (
    id_genero int  NOT NULL,
    nm_genero varchar(50)  NOT NULL,
    CONSTRAINT genero_pk PRIMARY KEY (id_genero)
);

-- Table: mensagem
CREATE TABLE mensagem (
    id_mensagem int  NOT NULL,
    ds_texto varchar(200)  NOT NULL,
    id_status_mensagem int  NOT NULL,
    id_remetente int  NOT NULL,
    id_destinatario int  NOT NULL,
    CONSTRAINT mensagem_pk PRIMARY KEY (id_mensagem)
);

-- Table: motivo_exclusao
CREATE TABLE motivo_exclusao (
    id_motivo_exclusao int  NOT NULL,
    ds_motivo_exclusao varchar(50)  NOT NULL,
    CONSTRAINT motivo_exclusao_pk PRIMARY KEY (id_motivo_exclusao)
);

-- Table: municipio
CREATE TABLE municipio (
    id_municipio int  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (id_municipio)
);

-- Table: regiao
CREATE TABLE regiao (
    id_regiao int  NOT NULL,
    nm_regiao varchar(50)  NOT NULL,
    CONSTRAINT regiao_pk PRIMARY KEY (id_regiao)
);

-- Table: situacao_produto
CREATE TABLE situacao_produto (
    id_situacao_produto int  NOT NULL,
    nm_situacao_produto varchar(50)  NOT NULL,
    CONSTRAINT situacao_produto_pk PRIMARY KEY (id_situacao_produto)
);

-- Table: status
CREATE TABLE status (
    id_status int  NOT NULL,
    nm_status varchar(50)  NOT NULL,
    CONSTRAINT status_pk PRIMARY KEY (id_status)
);

-- Table: status_mensagem
CREATE TABLE status_mensagem (
    id_status_mensagem int  NOT NULL,
    tp_status_mensagem char(1)  NOT NULL,
    CONSTRAINT status_mensagem_pk PRIMARY KEY (id_status_mensagem)
);

-- Table: subcategoria
CREATE TABLE subcategoria (
    id_subcategoria int  NOT NULL,
    nm_subcategoria varchar(50)  NOT NULL,
    id_categoria int  NOT NULL,
    CONSTRAINT subcategoria_pk PRIMARY KEY (id_subcategoria)
);

-- Table: tipo_usuario
CREATE TABLE tipo_usuario (
    id_tipo int  NOT NULL,
    nm_tipo varchar(50)  NOT NULL,
    CONSTRAINT tipo_usuario_pk PRIMARY KEY (id_tipo)
);

-- Table: usuario
CREATE TABLE usuario (
    id_usuario int  NOT NULL,
    nm_cliente varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    dt_nascimento date  NOT NULL,
    id_genero int  NOT NULL,
    id_tipo int  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_usuario)
);

-- Table: usuario_anuncio
CREATE TABLE usuario_anuncio (
    id_usuario int  NOT NULL,
    id_anuncio int  NOT NULL,
    CONSTRAINT usuario_anuncio_pk PRIMARY KEY (id_usuario,id_anuncio)
);

-- Table: usuario_mensagem
CREATE TABLE usuario_mensagem (
    id_usuario int  NOT NULL,
    id_mensagem int  NOT NULL,
    dt_envio date  NOT NULL,
    CONSTRAINT usuario_mensagem_pk PRIMARY KEY (id_usuario,id_mensagem)
);

-- foreign keys
-- Reference: anuncio_categoria (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_categoria FOREIGN KEY anuncio_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- Reference: anuncio_cep (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_cep FOREIGN KEY anuncio_cep (id_cep)
    REFERENCES cep (id_cep);

-- Reference: anuncio_classificacao_anuncio (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_classificacao_anuncio FOREIGN KEY anuncio_classificacao_anuncio (id_classificacao_anuncio)
    REFERENCES classificacao_anuncio (id_classificacao_anuncio);

-- Reference: anuncio_situacao_produto (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_situacao_produto FOREIGN KEY anuncio_situacao_produto (id_situacao_produto)
    REFERENCES situacao_produto (id_situacao_produto);

-- Reference: anuncio_status (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_status FOREIGN KEY anuncio_status (id_status)
    REFERENCES status (id_status);

-- Reference: anuncio_subcategoria (table: anuncio)
ALTER TABLE anuncio ADD CONSTRAINT anuncio_subcategoria FOREIGN KEY anuncio_subcategoria (id_subcategoria)
    REFERENCES subcategoria (id_subcategoria);

-- Reference: cep_regiao (table: cep)
ALTER TABLE cep ADD CONSTRAINT cep_regiao FOREIGN KEY cep_regiao (id_regiao)
    REFERENCES regiao (id_regiao);

-- Reference: classificacao_anuncio_fotos_permitidas (table: classificacao_anuncio)
ALTER TABLE classificacao_anuncio ADD CONSTRAINT classificacao_anuncio_fotos_permitidas FOREIGN KEY classificacao_anuncio_fotos_permitidas (id_fotos_permitidas)
    REFERENCES fotos_permitidas (id_fotos_permitidas);

-- Reference: cliente_genero (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT cliente_genero FOREIGN KEY cliente_genero (id_genero)
    REFERENCES genero (id_genero);

-- Reference: endereco_cep (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_cep FOREIGN KEY endereco_cep (id_cep)
    REFERENCES cep (id_cep);

-- Reference: endereco_cliente (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_cliente FOREIGN KEY endereco_cliente (id_usuario)
    REFERENCES usuario (id_usuario);

-- Reference: endereco_municipio (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_municipio FOREIGN KEY endereco_municipio (id_municipio)
    REFERENCES municipio (id_municipio);

-- Reference: excluir_anuncio_motivo_exclusao (table: excluir_anuncio)
ALTER TABLE excluir_anuncio ADD CONSTRAINT excluir_anuncio_motivo_exclusao FOREIGN KEY excluir_anuncio_motivo_exclusao (id_motivo_exclusao)
    REFERENCES motivo_exclusao (id_motivo_exclusao);

-- Reference: excluir_anuncio_usuario_anuncio (table: excluir_anuncio)
ALTER TABLE excluir_anuncio ADD CONSTRAINT excluir_anuncio_usuario_anuncio FOREIGN KEY excluir_anuncio_usuario_anuncio (id_usuario,id_anuncio)
    REFERENCES usuario_anuncio (id_usuario,id_anuncio);

-- Reference: mensagem_destinatario (table: mensagem)
ALTER TABLE mensagem ADD CONSTRAINT mensagem_destinatario FOREIGN KEY mensagem_destinatario (id_remetente)
    REFERENCES usuario (id_usuario);

-- Reference: mensagem_remetente (table: mensagem)
ALTER TABLE mensagem ADD CONSTRAINT mensagem_remetente FOREIGN KEY mensagem_remetente (id_destinatario)
    REFERENCES usuario (id_usuario);

-- Reference: mensagem_status_mensagem (table: mensagem)
ALTER TABLE mensagem ADD CONSTRAINT mensagem_status_mensagem FOREIGN KEY mensagem_status_mensagem (id_status_mensagem)
    REFERENCES status_mensagem (id_status_mensagem);

-- Reference: subcategoria_categoria (table: subcategoria)
ALTER TABLE subcategoria ADD CONSTRAINT subcategoria_categoria FOREIGN KEY subcategoria_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- Reference: usuario_anuncio_anuncio (table: usuario_anuncio)
ALTER TABLE usuario_anuncio ADD CONSTRAINT usuario_anuncio_anuncio FOREIGN KEY usuario_anuncio_anuncio (id_anuncio)
    REFERENCES anuncio (id_anuncio);

-- Reference: usuario_anuncio_usuario (table: usuario_anuncio)
ALTER TABLE usuario_anuncio ADD CONSTRAINT usuario_anuncio_usuario FOREIGN KEY usuario_anuncio_usuario (id_usuario)
    REFERENCES usuario (id_usuario);

-- Reference: usuario_mensagem_mensagem (table: usuario_mensagem)
ALTER TABLE usuario_mensagem ADD CONSTRAINT usuario_mensagem_mensagem FOREIGN KEY usuario_mensagem_mensagem (id_mensagem)
    REFERENCES mensagem (id_mensagem);

-- Reference: usuario_mensagem_usuario (table: usuario_mensagem)
ALTER TABLE usuario_mensagem ADD CONSTRAINT usuario_mensagem_usuario FOREIGN KEY usuario_mensagem_usuario (id_usuario)
    REFERENCES usuario (id_usuario);

-- Reference: usuario_tipo_usuario (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_tipo_usuario FOREIGN KEY usuario_tipo_usuario (id_tipo)
    REFERENCES tipo_usuario (id_tipo);

-- End of file.

