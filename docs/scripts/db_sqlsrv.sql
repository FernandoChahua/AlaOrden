create database alaorden
go

use alaorden
go

create table Cliente(
	id_cliente int primary key identity,
	usuario varchar(50) not null,
	contrasena varchar(50) not null,
	correo varchar(50) not null)
go

create table Tarjeta(
	id_tarjeta int primary key identity,
	id_cliente int foreign key references Cliente(id_cliente) not null,
	titular varchar(50) not null,
	fecha_exp date not null)
go

create table Franquicia(
	id_franquicia int primary key identity,
	nombre varchar(50) not null)
go

create table Sede(
	id_sede int primary key identity,
	id_franquicia int foreign key references Franquicia(id_franquicia) not null,
	direccion varchar(200) not null)
go

create table Producto(
	id_producto int primary key identity,
	nombre varchar(100) not null,
	marca varchar(50) not null,
	descripcion varchar(300),
	peso float,
	categoria varchar(50) not null)
go

create table Producto_Franquicia(
	id_producto int foreign key references Producto(id_producto) not null,
	id_franquicia int foreign key references Franquicia(id_franquicia) not null,
	primary key (id_producto, id_franquicia) )
go

create table Pedido(
	id_pedido int primary key identity,
	id_cliente int foreign key references Cliente(id_cliente) not null,
	id_sede int foreign key references Sede(id_sede) not null,
	estado varchar(50) not null,
	fechar date not null,
	direccion varchar(200) not null,
	nro_transaccion int not null,
	subtotal decimal(7,2) not null,
	precio_envio decimal(7,2) not null,
	descuento decimal(7,2) not null)
go

create table DetallePedido(
	id_pedido int foreign key references Pedido(id_pedido) not null,
	id_producto int not null,
	id_franquicia int not null,
	precio decimal(5,2) not null,
	cantidad int not null,
	primary key (id_pedido, id_producto),
	foreign key (id_producto,id_franquicia) references Producto_Franquicia(id_producto,id_franquicia) )
go