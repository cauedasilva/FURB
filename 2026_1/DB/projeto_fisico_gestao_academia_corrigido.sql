-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-03-30 23:02:43.612

-- tables
-- Table: aluno
CREATE TABLE aluno (
    cd_aluno int  NOT NULL,
    nm_aluno varchar(50)  NOT NULL,
    tp_genero char(1)  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    vl_peso decimal(4,1)  NOT NULL,
    vl_altura decimal(3,2)  NOT NULL,
    tp_plano char(1)  NOT NULL,
    nr_cartao int  NOT NULL,
    cd_grau_instrucao int  NOT NULL,
    cd_profissao int  NOT NULL,
    cd_endereco int  NOT NULL,
    cd_plano int  NOT NULL,
    CONSTRAINT aluno_pk PRIMARY KEY (cd_aluno)
);

-- Table: endereco
CREATE TABLE endereco (
    cd_endereco int  NOT NULL,
    ds_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(30)  NOT NULL,
    nm_bairro varchar(30)  NOT NULL,
    nr_cep char(8)  NOT NULL,
    cd_municipio int  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (cd_endereco)
);

-- Table: grau_instrucao
CREATE TABLE grau_instrucao (
    cd_grau_instrucao int  NOT NULL,
    ds_grau_instrucao varchar(50)  NOT NULL,
    CONSTRAINT grau_instrucao_pk PRIMARY KEY (cd_grau_instrucao)
);

-- Table: instrutor
CREATE TABLE instrutor (
    cd_instrutor int  NOT NULL,
    nm_instrutor varchar(50)  NOT NULL,
    fl_genero char(1)  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    cd_endereco int  NOT NULL,
    CONSTRAINT instrutor_pk PRIMARY KEY (cd_instrutor)
);

-- Table: instrutor_modalidade
CREATE TABLE instrutor_modalidade (
    cd_instrutor int  NOT NULL,
    cd_modalidade int  NOT NULL,
    CONSTRAINT instrutor_modalidade_pk PRIMARY KEY (cd_instrutor,cd_modalidade)
);

-- Table: matricula
CREATE TABLE matricula (
    cd_aluno int  NOT NULL,
    cd_turma int  NOT NULL,
    dt_matricula date  NOT NULL,
    CONSTRAINT matricula_pk PRIMARY KEY (cd_aluno,cd_turma)
);

-- Table: modalidade
CREATE TABLE modalidade (
    cd_modalidade int  NOT NULL,
    nm_modalidade varchar(50)  NOT NULL,
    ds_detalhamento varchar(100)  NOT NULL,
    CONSTRAINT modalidade_pk PRIMARY KEY (cd_modalidade)
);

-- Table: municipio
CREATE TABLE municipio (
    cd_municipio int  NOT NULL,
    nm_municipio varchar(50)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (cd_municipio)
);

-- Table: plano
CREATE TABLE plano (
    cd_plano int  NOT NULL,
    nm_plano varchar(50)  NOT NULL,
    ds_plano varchar(100)  NOT NULL,
    vl_mensal decimal(6,2)  NOT NULL,
    vl_trimestral decimal(6,2)  NOT NULL,
    vl_semestral decimal(6,2)  NOT NULL,
    vl_anual decimal(6,2)  NOT NULL,
    qt_turmas int  NOT NULL,
    CONSTRAINT plano_pk PRIMARY KEY (cd_plano)
);

-- Table: profissao
CREATE TABLE profissao (
    cd_profissao int  NOT NULL,
    nm_profissao varchar(50)  NOT NULL,
    CONSTRAINT profissao_pk PRIMARY KEY (cd_profissao)
);

-- Table: registro_presenca
CREATE TABLE registro_presenca (
    id_registro int  NOT NULL,
    dt_registro date  NOT NULL,
    hr_registro time  NOT NULL,
    cd_aluno int  NOT NULL,
    cd_turma int  NOT NULL,
    CONSTRAINT registro_presenca_pk PRIMARY KEY (id_registro)
);

-- Table: turma
CREATE TABLE turma (
    cd_turma int  NOT NULL,
    hr_inicio time  NOT NULL,
    nr_duracao int  NOT NULL,
    nr_vagas int  NOT NULL,
    ds_informacao_add varchar(100)  NOT NULL,
    cd_instrutor int  NOT NULL,
    cd_modalidade int  NOT NULL,
    CONSTRAINT turma_pk PRIMARY KEY (cd_turma)
);

-- foreign keys
-- Reference: aluno_endereco (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_endereco
    FOREIGN KEY (cd_endereco)
    REFERENCES endereco (cd_endereco)  
     
    
;

-- Reference: aluno_grau_instrucao (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_grau_instrucao
    FOREIGN KEY (cd_grau_instrucao)
    REFERENCES grau_instrucao (cd_grau_instrucao)  
     
    
;

-- Reference: aluno_plano (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_plano
    FOREIGN KEY (cd_plano)
    REFERENCES plano (cd_plano)  
     
    
;

-- Reference: aluno_profissao (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_profissao
    FOREIGN KEY (cd_profissao)
    REFERENCES profissao (cd_profissao)  
     
    
;

-- Reference: endereco_municipio (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_municipio
    FOREIGN KEY (cd_municipio)
    REFERENCES municipio (cd_municipio)  
     
    
;

-- Reference: instrutor_endereco (table: instrutor)
ALTER TABLE instrutor ADD CONSTRAINT instrutor_endereco
    FOREIGN KEY (cd_endereco)
    REFERENCES endereco (cd_endereco)  
     
    
;

-- Reference: instrutor_modalidade_instrutor (table: instrutor_modalidade)
ALTER TABLE instrutor_modalidade ADD CONSTRAINT instrutor_modalidade_instrutor
    FOREIGN KEY (cd_instrutor)
    REFERENCES instrutor (cd_instrutor)  
     
    
;

-- Reference: instrutor_modalidade_modalidade (table: instrutor_modalidade)
ALTER TABLE instrutor_modalidade ADD CONSTRAINT instrutor_modalidade_modalidade
    FOREIGN KEY (cd_modalidade)
    REFERENCES modalidade (cd_modalidade)  
     
    
;

-- Reference: matricula_aluno (table: matricula)
ALTER TABLE matricula ADD CONSTRAINT matricula_aluno
    FOREIGN KEY (cd_aluno)
    REFERENCES aluno (cd_aluno)  
     
    
;

-- Reference: matricula_turma (table: matricula)
ALTER TABLE matricula ADD CONSTRAINT matricula_turma
    FOREIGN KEY (cd_turma)
    REFERENCES turma (cd_turma)  
     
    
;

-- Reference: registro_presenca_matricula (table: registro_presenca)
ALTER TABLE registro_presenca ADD CONSTRAINT registro_presenca_matricula
    FOREIGN KEY (cd_aluno, cd_turma)
    REFERENCES matricula (cd_aluno, cd_turma)  
     
    
;

-- Reference: turma_instrutor_modalidade (table: turma)
ALTER TABLE turma ADD CONSTRAINT turma_instrutor_modalidade
    FOREIGN KEY (cd_instrutor, cd_modalidade)
    REFERENCES instrutor_modalidade (cd_instrutor, cd_modalidade)  
     
    
;

-- End of file.

