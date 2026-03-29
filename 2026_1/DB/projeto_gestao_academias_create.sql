-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-03-29 01:56:09.812

-- tables
-- Table: aluno
CREATE TABLE aluno (
    id_aluno int  NOT NULL,
    nm_aluno varchar(50)  NOT NULL,
    dt_nascimento date  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    ds_genero varchar(20)  NOT NULL,
    nr_peso decimal(10,2)  NOT NULL,
    nr_altura decimal(10,2)  NOT NULL,
    ds_escolaridade varchar(50)  NOT NULL,
    ds_profissao varchar(50)  NOT NULL,
    id_plano int  NOT NULL,
    CONSTRAINT aluno_pk PRIMARY KEY (id_aluno)
);

-- Table: aluno_turma
CREATE TABLE aluno_turma (
    id_aluno int  NOT NULL,
    id_turma int  NOT NULL,
    CONSTRAINT aluno_turma_pk PRIMARY KEY (id_aluno,id_turma)
);

-- Table: cartao
CREATE TABLE cartao (
    id_cartao int  NOT NULL,
    id_aluno int  NOT NULL,
    CONSTRAINT cartao_pk PRIMARY KEY (id_cartao)
);

-- Table: endereco
CREATE TABLE endereco (
    id_endereco int  NOT NULL,
    ds_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(50)  NOT NULL,
    nm_bairro varchar(50)  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    nr_cep char(8)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    id_aluno int  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- Table: endereco_instrutor
CREATE TABLE endereco_instrutor (
    id_endereco int  NOT NULL,
    ds_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(50)  NOT NULL,
    nm_bairro varchar(50)  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    nr_cep char(8)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    id_instrutor int  NOT NULL,
    CONSTRAINT endereco_instrutor_pk PRIMARY KEY (id_endereco)
);

-- Table: instrutor
CREATE TABLE instrutor (
    id_instrutor int  NOT NULL,
    nm_instrutor varchar(50)  NOT NULL,
    nr_cpf char(11)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    nr_telefone varchar(20)  NOT NULL,
    CONSTRAINT instrutor_pk PRIMARY KEY (id_instrutor)
);

-- Table: instrutor_modalidade
CREATE TABLE instrutor_modalidade (
    id_instrutor int  NOT NULL,
    id_modalidade int  NOT NULL,
    CONSTRAINT instrutor_modalidade_pk PRIMARY KEY (id_instrutor,id_modalidade)
);

-- Table: modalidade
CREATE TABLE modalidade (
    id_modalidade int  NOT NULL,
    ds_modalidade varchar(50)  NOT NULL,
    CONSTRAINT modalidade_pk PRIMARY KEY (id_modalidade)
);

-- Table: plano
CREATE TABLE plano (
    id_plano int  NOT NULL,
    ds_plano varchar(50)  NOT NULL,
    vl_mensal decimal(10,2)  NOT NULL,
    vl_trimestral decimal(10,2)  NOT NULL,
    vl_semestral decimal(10,2)  NOT NULL,
    vl_anual decimal(10,2)  NOT NULL,
    nr_turmas int  NOT NULL,
    CONSTRAINT plano_pk PRIMARY KEY (id_plano)
);

-- Table: presenca
CREATE TABLE presenca (
    id_presenca int  NOT NULL,
    dt_data date  NOT NULL,
    hr_hora time  NOT NULL,
    id_cartao int  NOT NULL,
    id_turma int  NOT NULL,
    CONSTRAINT presenca_pk PRIMARY KEY (id_presenca)
);

-- Table: turma
CREATE TABLE turma (
    id_turma int  NOT NULL,
    hr_horario time  NOT NULL,
    nr_dia int  NOT NULL,
    nr_duracao decimal(10,2)  NOT NULL,
    nr_limite int  NOT NULL,
    ds_descricao varchar(50)  NOT NULL,
    id_modalidade int  NOT NULL,
    id_instrutor int  NOT NULL,
    CONSTRAINT turma_pk PRIMARY KEY (id_turma)
);

-- foreign keys
-- Reference: aluno_plano (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_plano FOREIGN KEY aluno_plano (id_plano)
    REFERENCES plano (id_plano);

-- Reference: aluno_turma_aluno (table: aluno_turma)
ALTER TABLE aluno_turma ADD CONSTRAINT aluno_turma_aluno FOREIGN KEY aluno_turma_aluno (id_aluno)
    REFERENCES aluno (id_aluno);

-- Reference: aluno_turma_turma (table: aluno_turma)
ALTER TABLE aluno_turma ADD CONSTRAINT aluno_turma_turma FOREIGN KEY aluno_turma_turma (id_turma)
    REFERENCES turma (id_turma);

-- Reference: cartao_aluno (table: cartao)
ALTER TABLE cartao ADD CONSTRAINT cartao_aluno FOREIGN KEY cartao_aluno (id_aluno)
    REFERENCES aluno (id_aluno);

-- Reference: endereco_aluno (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_aluno FOREIGN KEY endereco_aluno (id_aluno)
    REFERENCES aluno (id_aluno);

-- Reference: endereco_instrutor_instrutor (table: endereco_instrutor)
ALTER TABLE endereco_instrutor ADD CONSTRAINT endereco_instrutor_instrutor FOREIGN KEY endereco_instrutor_instrutor (id_instrutor)
    REFERENCES instrutor (id_instrutor);

-- Reference: instruto_modalidade_instrutor (table: instrutor_modalidade)
ALTER TABLE instrutor_modalidade ADD CONSTRAINT instruto_modalidade_instrutor FOREIGN KEY instruto_modalidade_instrutor (id_instrutor)
    REFERENCES instrutor (id_instrutor);

-- Reference: instruto_modalidade_modalidade (table: instrutor_modalidade)
ALTER TABLE instrutor_modalidade ADD CONSTRAINT instruto_modalidade_modalidade FOREIGN KEY instruto_modalidade_modalidade (id_modalidade)
    REFERENCES modalidade (id_modalidade);

-- Reference: presenca_cartao (table: presenca)
ALTER TABLE presenca ADD CONSTRAINT presenca_cartao FOREIGN KEY presenca_cartao (id_cartao)
    REFERENCES cartao (id_cartao);

-- Reference: presenca_turma (table: presenca)
ALTER TABLE presenca ADD CONSTRAINT presenca_turma FOREIGN KEY presenca_turma (id_turma)
    REFERENCES turma (id_turma);

-- Reference: turma_instrutor (table: turma)
ALTER TABLE turma ADD CONSTRAINT turma_instrutor FOREIGN KEY turma_instrutor (id_instrutor)
    REFERENCES instrutor (id_instrutor);

-- Reference: turma_modalidade (table: turma)
ALTER TABLE turma ADD CONSTRAINT turma_modalidade FOREIGN KEY turma_modalidade (id_modalidade)
    REFERENCES modalidade (id_modalidade);

-- End of file.

