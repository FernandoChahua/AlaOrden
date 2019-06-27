insert into tfinal.brand(name) values('Coca Cola'),
('Nabisco'),
('Gloria'),
('Pringles'),
('Aje'),
('Molitalia'),
('Costeño'),
('Wawasana'),
('Kelloggs'),
('Costa'),
('Pepsico'),
('Donofrio');


	insert into tfinal.category(name, parent) values('Bebidas', null),
	('Abarrotes', null),
	('Lacteos', null),
	('Agua', '1'),
	('Refrescos gaseosos', '1'),
	('Cereales', '2'),
	('Pastas', '2'),
	('Arroz', '2'),
	('Infusiones', '2'),
	('Galletas', '2'),
	('Snacks', '2'),
	('Leches', '3'),
	('Helados', '3'),
	('Cuidado personal', null),
	('Frescos', null),
	('Limpieza', null),
	('Mascotas', null),
	('Niños', null),
	('Hogar', null),
	('Cuidado de la piel', '14'),
	('Afeitado y depilacion', '14'),
	('Congelados', '15'),
	('Frutas y verduras', '15'),
	('Accesorios de limpieza', '16'),
	('Ambientales', '16'),
	('Accesorios para mascotas', '17'),
	('Alimento para mascotas', '17'),
	('Accesorio para bebe', '18'),
	('Alimentos infantiles', '18'),
	('Baterias', '19'),
	('Iluminacion', '19');


	insert into tfinal.user(nickname, hashPassword, salt, email, emailValidated, state) values
	('Alexia', 'u201714092', 'salt', 'alexia@hotmail.com', '1'),
	('Diego', 'u201616874', 'salt', 'diego@hotmail.com', '1'),
	('Fernando', 'u201712916', 'salt', 'fernando@hotmail.com', '1'),
	('Jorge', 'u201620280', 'salt', 'jorge@hotmail.com', '1'),
	('Marco', 'u20171b533', 'salt', 'marco@hotmail.com', '1');

	insert into tfinal.franchise(name, webUrl, apiUrl, logo) values
	('Wong', 'www.wong.com', 'wong.api', 'wong.png'),
		('Metro', 'www.metro.com', 'metro.api', 'metro.png'),
		('Plaza Vea', 'www.plazavea.com', 'plazavea.api', 'plazavea.png'),
		('Tottus', 'www.tottus.com', 'tottus.api', 'tottus.png');

	insert into tfinal.address(user, longitude, latitude, description) values
	('direccion':'Av. Universitaria 3, Pueblo Libre 15084', '1', '-77.081605',  '-12.077053', 'Wongo Plaza San Miguel'),
		('direccion':'Av. Sta. Cruz 771, Miraflores 15074', '1', '-77.036466',  '-12.110091', 'Wong Ovalo Gutierrez'),
		('direccion':'Av. de la Marina 2500, San Miguel 15088', '2', '-77.089390',  '-12.076645', 'Metro La Marina'),
		('direccion':'Av Alfredo Mendiola 3900, Independencia 15311', '2', '-77.063322',  '-11.988214', 'Metro Independencia'),
		('direccion':'Av. Arequipa 2250, Lince 15046', '3', '-77.034525',  '-12.086598', 'Plaza Vea Centro Comercial Risso'),
		('direccion':'Av Alfredo Mendiola 3900, Independencia 15311', '3', '-77.063365',  '-11.989074', 'Plaza Vea Independecia'),
		('direccion':'San Miguel 15087', '4', '-77.088456',  '-12.079253', 'Tottus Open Plaza'),
		('direccion':'Zinc, Los Olivos 15311', '4', '-77.066993',  '-11.965446', 'Tottus Los Olivos'),



		insert into tfinal.location(address, idFranchise, longitude, latitude) values
		('Av. Universitaria 3, Pueblo Libre 15084', '1', '-77.081605', '-12.077053', 'Wongo Plaza San Miguel'),
		('Av. Sta. Cruz 771, Miraflores 15074', '1', '-77.036466', '-12.110091', 'Wong Ovalo Gutierrez'),
		('Av. de la Marina 2500, San Miguel 15088', '2', '-77.089390', '-12.076645', 'Metro La Marina'),
		('Av Alfredo Mendiola 3900, Independencia 15311', '2', '-77.063322', '-11.988214', 'Metro Independencia'),
		('Av. Arequipa 2250, Lince 15046', '3', '-77.034525', '-12.086598', 'Plaza Vea Centro Comercial Risso'),
		('Av Alfredo Mendiola 3900, Independencia 15311', '3', '-77.063365', '-11.989074', 'Plaza Vea Independecia'),
		('San Miguel 15087', '4', '-77.088456', '-12.079253', 'Tottus Open Plaza'),
		('Zinc, Los Olivos 15311', '4', '-77.066993', '-11.965446', 'Tottus Los Olivos');

	insert into tfinal.product(idCategory, idBrand, name, packaging, quantity, measure, unit, description, image) values

	('5', '1', 'Sprite', 'botella', '1', '625', 'ml', 'Gaseosa blanca sabor a limón', 'sprite.png'), ,
		('4', '1', 'San Luis', 'botella', '6', '625', 'ml', 'Six pack de agua con sabor a metal', 'sixsanluis.png' },
		('10', '2', 'Oreo', 'paquete', '1', '18', 'g', 'Galleta de chocolote con relleno', 'oreo.png' },
		('10', '2', 'Oreo Fresa', 'paquete', '6', '18', 'g', 'Six pack de galleta de chocolote con relleno', 'sixoreofresa.png' },
		('12', '3', 'Leche Evaporada', 'tarro', '1', '400', 'g', 'Tarro de leche evaporada', 'gloria.png' },
		('12', '3', 'Tetrapack', 'caja', '1', '1', 'l', 'Tetrapack de leche', 'gloriatp.png' },
		('11', '4', 'Pringles BBQ', 'lata', '1', '168', 'g', 'Lata de pringles con sabor a BBQ', 'pringlesbbq.png' },
		('11', '4', 'Pringles Honey Mustard', 'lata', '1', '168', 'g', 'Lata de pringles con sabor a honey mustard', 'pringleshm.png' },
		('4', '5', 'Cielo personal', 'botella', '1', '625', 'ml', 'Agua de manantial', 'cielo.png' },
		('4', '5', 'Cielo grande', 'botella', '1', '2.5', 'l', 'Botella grande de agua de manantial', 'cielogrande.png' },
		('7', '6', 'Tallarin', 'paquete', '1', '500', 'g', 'Fideos tallarin', 'molitalia.png' },
		('7', '6', 'Pasta corta', 'paquete', '1', '250', 'g', 'Fideos codo', 'molitaliacodo.png' },
		('8', '7', ' Arroz Extra', 'paquete', '1', '750', 'g', 'Paquete de arroz graneadito', 'costeño.png' },
		('8', '7', ' Arroz Integral', 'paquete', '1', '750', 'g', 'Paquete de arroz integral', 'costeñointegral.png' },
		('9', '8', 'Te Verde', 'caja', '50', '1', 'g', 'Caja de 50 filtrantes de te verde', 'wawateverde.png' },
		('9', '8', 'Digestivo', 'caja', '12', '1.5', 'g', 'Caja de 12 filtrantes de digestivo', 'wawadigestivo.png' },
		('6', '9', 'Zucaritas', 'caja', '1', '800', 'g', 'Cereal de hojuelas maíz', 'zucaritas.png' },
		('6', '9', 'Froot Loops', 'caja', '1', '550', 'g', 'Cereal de maíz con colorantes naturales', 'frootloops.png' },
		('10', '10', 'Gran Cereal Choco', 'paquete', '6', '32', 'g', 'Six pack de galletas gran cereal de chocolate', 'grancerealchoco.png' },
		('10', '10', 'Cereal Bar Choco', 'caja', '8', '21', 'g', 'Caja con 8 barras de cereal sabor chocolate', 'cerealbarchoco.png' },
		('11', '11', 'Lays', 'bolsa', '1', '80', 'g', 'Bolsa con aire y unas cuantas papas', 'lays.png' },
		('11', '11', 'Doritos', 'bolsa', '1', '62', 'g', 'Bolsa con aire y unos doritos', 'doritos.png' },
		('13', '12', 'PeziDuri', 'pote', '1', '1', 'l', 'Pote de helado de vainilla', 'peziduri.png' },
		('13', '12', 'Frio Rico', 'cono', '1', '75', 'g', 'Cono con helado de vainilla y chispas de chocolate', 'friorico.png' }

