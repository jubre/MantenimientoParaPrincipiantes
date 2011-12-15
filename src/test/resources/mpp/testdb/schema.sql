drop table PRINCIPIANTE if exists;
drop table ESTADO if exists;
drop table ESTADO_REGISTRO if exists;
drop table SEXO if exists;

create table ESTADO(ESTADO_ID integer identity primary key,
	DESCRIPCION varchar(50) not null);
	
create table ESTADO_REGISTRO(ESTADO_REGISTRO_ID integer identity primary key,
	DESCRIPCION varchar(50) not null);
	
create table SEXO(SEXO_ID integer identity primary key,
	DESCRIPCION varchar(50) not null);

create table PRINCIPIANTE (PRINCIPIANTE_ID integer identity primary key, 
	NOMBRE varchar(50) not null,
	APELLIDO_PATERNO varchar(50) not null,
	APELLIDO_MATERNO varchar(50) not null,
	ESTADO_ID integer not null,
	ESTADO_REGISTRO_ID integer not null,
	SEXO_ID integer not null,
	FECHA_CREACION date);
	
