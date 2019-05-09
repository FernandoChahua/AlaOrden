insert into usuario (idUsuario,apodo,contrasena,email,estado) values (1,'admin','admin','admin@gmail.com',1);
insert into rol (idRol,nombre) values (1,'administrador');
insert into rol (idRol,nombre) values (2,'cliente');
insert into rol_usuario (idUsuario,idRol)values (1,1);

insert into marca (nombre) values ('Gloria');
insert into marca (nombre) values ('Nestle');
insert into marca (nombre) values ('Negrita');/*3*/
insert into marca (nombre) values ('Universal');/*4*/
insert into marca (nombre) values ('Field');/*5*/
insert into marca (nombre) values ('BLancaFlor');/*6*/
insert into marca (nombre) values ('Donofrio');/*7*/
insert into marca (nombre) values ('Bimbo');/*8*/
insert into marca (nombre) values ('Tottus');/*9*/
insert into marca (nombre) values ('Metro');
insert into marca (nombre) values ('Wong');
insert into marca (nombre) values ('Vivanda');
insert into marca (nombre) values ('Ideal');


insert into categoria (nombre) values ('Lacteos');/*1*/
insert into categoria (nombre) values ('Bebidas');/*2*/
insert into categoria (nombre) values ('Carnes');/*3*/
insert into categoria (nombre) values ('Golosinas');/*4*/
insert into categoria (nombre) values ('ComidaInstantanea');/*5*/
insert into categoria (nombre) values ('Frutas');/*6*/
insert into categoria (nombre) values ('Verduras');/*7*/
insert into categoria (nombre) values ('Conservas');/*8*/
insert into categoria (nombre) values ('Detergente');/*9*/
insert into categoria (nombre) values ('Legumbres');/*10*/
insert into categoria (nombre) values ('Snacks');/*11*/
insert into categoria (nombre) values ('Higiene');/*12*/
insert into categoria (nombre) values ('Belleza');/*13*/
insert into categoria (nombre) values ('CuidadoPersonal');/*14*/
insert into categoria (nombre) values ('Licores');/*15*/
insert into categoria (nombre) values ('Panetones');


insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Leche evaporada sin lactosa','Leche evaporada deslactosada3',300,1,1);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Leche evaproada sin lactosa','Leche evaporada deslactosada',300,1,13);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Paneton','Paneton Blanca Flor',300,16,6);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Paneton','Paneton Donofrio',300,16,7);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Galleta soda bañada en chocolate','ChokoSoda',300,4,5);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Galleta de vainilla con cubierta de chocolate','Morocha',300,4,2);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Leche condensada','Leche condensada Nestlé',300,1,2);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Leche condensada1','Leche condensada Gloria',300,1,1);
insert into producto (descripcion,nombre,peso,idCategoria,idMarca) values ('Paneton','Paneton Bimbo',300,16,8);