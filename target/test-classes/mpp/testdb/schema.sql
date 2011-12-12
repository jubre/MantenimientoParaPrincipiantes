drop table PRINCIPIANTE if exists;
drop table ESTADO if exists;

create table ESTADO(ESTADO_ID integer identity primary key,
	DESCRIPCION varchar(50) not null);

create table PRINCIPIANTE (PRINCIPIANTE_ID integer identity primary key, 
	NOMBRE varchar(50) not null,
	APELLIDO_PATERNO varchar(50) not null,
	APELLIDO_MATERNO varchar(50) not null,
	ESTADO_ID integer not null,
	FECHA_CREACION date);
	
