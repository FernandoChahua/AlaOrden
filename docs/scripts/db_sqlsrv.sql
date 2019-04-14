create database ALaOrden
go

use ALaOrden
go

create table Cliente(
	idCliente int primary key identity,
	usuario varchar(50) not null,
	contrasena varchar(50) not null,
	correo varchar(50) not null)
go

create table Tarjeta(
	idTarjeta int primary key identity,
	idCliente int foreign key references Cliente(idCliente) not null,
	titular varchar(50) not null,
	fechaExp date not null)
go

create table Franquicia(
	idFranquicia int primary key identity,
	nombre varchar(50) not null)
go

create table Sede(
	idSede int primary key identity,
	idFranquicia int foreign key references Franquicia(idFranquicia) not null,
	direccion varchar(200) not null)
go

create table Producto(
	idProducto int primary key identity,
	nombre varchar(100) not null,
	marca varchar(50) not null,
	descripcion varchar(300),
	peso float,
	categoria varchar(50) not null)
go

create table Producto_Franquicia(
	idProducto int foreign key references Producto(idProducto) not null,
	idFranquicia int foreign key references Franquicia(idFranquicia) not null,
	primary key (idProducto, idFranquicia) )
go

create table Pedido(
	idPedido int primary key identity,
	idCliente int foreign key references Cliente(idCliente) not null,
	idSede int foreign key references Sede(idSede) not null,
	estado varchar(50) not null,
	fechar date not null,
	direccion varchar(200) not null,
	nroTransaccion int not null,
	subtotal decimal(7,2) not null,
	precioEnvio decimal(7,2) not null,
	descuento decimal(7,2) not null)
go

create table DetallePedido(
	idPedido int foreign key references Pedido(idPedido) not null,
	idProducto int not null,
	idFranquicia int not null,
	precio decimal(5,2) not null,
	cantidad int not null,
	primary key (idPedido, idProducto),
	foreign key (idProducto,idFranquicia) references Producto_Franquicia(idProducto,idFranquicia) )
go