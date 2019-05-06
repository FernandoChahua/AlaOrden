insert into marca
(nombre)
values
('Gloria'),/*1*/
('Nestle'),/*2*/
('Negrita'),/*3*/
('Universal'),/*4*/
('Field'),/*5*/
('BLancaFlor'),/*6*/
('Donofrio'),/*7*/
('Bimbo'),/*8*/
('Tottus'),/*9*/
('Metro'),
('Wong'),
('Vivanda'),
('Ideal');


insert into categoria
(nombre) 
values
('Lacteos'),/*1*/
('Bebidas'),/*2*/
('Carnes'),/*3*/
('Golosinas'),/*4*/
('ComidaInstantanea'),/*5*/
('Frutas'),/*6*/
('Verduras'),/*7*/
('Conservas'),/*8*/
('Detergente'),/*9*/
('Legumbres'),/*10*/
('Snacks'),/*11*/
('Higiene'),/*12*/
('Belleza'),/*13*/
('CuidadoPersonal'),/*14*/
('Licores'),/*15*/
('Panetones');


insert into producto
(descripcion,nombre,peso,idCategoria,idMarca) 
values
('Leche evaporada sin lactosa','Leche evaporada deslactosada3',300,1,1),
('Leche evaproada sin lactosa1','Leche evaporada deslactosada',300,1,13),
('Paneton','Paneton Blanca Flor',300,16,6),
('Paneton','Paneton Donofrio',300,16,7),
('Galleta soda bañada en chocolate','ChokoSoda',300,4,5),
('Galleta de vainilla con cubierta de chocolate','Morocha',300,4,2),
('Leche condensada','Leche condensada Nestlé',300,1,2),
('Leche condensada1','Leche condensada Gloria',300,1,1),
('Paneton','Paneton Bimbo',300,16,8);