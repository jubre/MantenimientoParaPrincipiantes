drop table PRINCIPIANTE if exists;

create table PRINCIPIANTE (PRINCIPIANTE_ID integer identity primary key, NOMBRE varchar(50) not null, FECHA_CREACION date);