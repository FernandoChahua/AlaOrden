create database alaorden;

use alaorden;

create table Cliente(
	idCliente int primary key auto_increment,
	usuario varchar(50) not null,
	contrasena varchar(50) not null,
	email varchar(50) not null);

create table Tarjeta(
	idTarjeta int primary key auto_increment,
	idCliente int not null,
    nroCuenta varchar(50) not null,
	titular varchar(50) not null,
	fechaExp date not null,
    foreign key (idCliente) references Cliente(idCliente) );

create table Franquicia(
	idFranquicia int primary key auto_increment,
	nombre varchar(50) not null);

create table Sede(
	idSede int primary key auto_increment,
	idFranquicia int not null,
	direccion varchar(200) not null,
    foreign key (idFranquicia) references Franquicia(idFranquicia) );

create table Producto(
	idProducto int primary key auto_increment,
	nombre varchar(100) not null,
	marca varchar(50) not null,
	descripcion varchar(300),
	peso float,
	categoria varchar(50) not null);

create table Producto_Franquicia(
	idProducto int not null,
	idFranquicia int not null,
	primary key (idProducto, idFranquicia),
    foreign key (idProducto) references Producto(idProducto),
    foreign key (idFranquicia) references Franquicia(idFranquicia) );

create table Pedido(
	idPedido int primary key auto_increment,
	idCliente int not null,
	idSede int not null,
	estado varchar(50) not null,
	fechar datetime not null,
	direccion varchar(200) not null,
	nroTransaccion int not null,
	subtotal decimal(7,2) not null,
	precioEnvio decimal(7,2) not null,
	descuento decimal(7,2) not null,
    foreign key (idCliente) references Cliente(idCliente),
    foreign key (idSede) references Sede(idSede) );

create table DetallePedido(
	idPedido int not null,
	idProducto int not null,
	idFranquicia int not null,
	precio decimal(5,2) not null,
	cantidad int not null,
	primary key (idPedido, idProducto),
    foreign key (idPedido) references Pedido(idPedido),
	foreign key (idProducto,idFranquicia) references Producto_Franquicia(idProducto,idFranquicia) );