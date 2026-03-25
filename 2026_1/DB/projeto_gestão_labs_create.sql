-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-03-16 22:38:40.775

-- tables
-- Table: equipamento
CREATE TABLE equipamento (
    id_equipamento varchar(8)  NOT NULL,
    ds_config varchar(100)  NOT NULL,
    id_sala int  NOT NULL,
    CONSTRAINT equipamento_pk PRIMARY KEY (id_equipamento)
);

-- Table: equipamento_software
CREATE TABLE equipamento_software (
    id_equipamento varchar(8)  NOT NULL,
    id_software int  NOT NULL,
    dt_instalacao date  NOT NULL,
    CONSTRAINT equipamento_software_pk PRIMARY KEY (id_equipamento,id_software)
);

-- Table: sala
CREATE TABLE sala (
    id_sala int  NOT NULL,
    nm_sala varchar(50)  NOT NULL,
    qt_capacidade int  NOT NULL,
    CONSTRAINT sala_pk PRIMARY KEY (id_sala)
);

-- Table: software
CREATE TABLE software (
    id_software int  NOT NULL,
    nm_software varchar(100)  NOT NULL,
    CONSTRAINT software_pk PRIMARY KEY (id_software)
);

-- foreign keys
-- Reference: Table_4_equipamento (table: equipamento_software)
ALTER TABLE equipamento_software ADD CONSTRAINT Table_4_equipamento FOREIGN KEY Table_4_equipamento (id_equipamento)
    REFERENCES equipamento (id_equipamento);

-- Reference: Table_4_software (table: equipamento_software)
ALTER TABLE equipamento_software ADD CONSTRAINT Table_4_software FOREIGN KEY Table_4_software (id_software)
    REFERENCES software (id_software);

-- Reference: equipamento_sala (table: equipamento)
ALTER TABLE equipamento ADD CONSTRAINT equipamento_sala FOREIGN KEY equipamento_sala (id_sala)
    REFERENCES sala (id_sala);

-- End of file.

