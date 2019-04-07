create database alaorden;

use alaorden;

create table Cliente(
	id_cliente int primary key auto_increment,
	usuario varchar(50) not null,
	contrasena varchar(50) not null,
	correo varchar(50) not null);

create table Tarjeta(
	id_tarjeta int primary key auto_increment,
	id_cliente int not null,
	titular varchar(50) not null,
	fecha_exp date not null,
    foreign key (id_cliente) references Cliente(id_cliente) );

create table Franquicia(
	id_franquicia int primary key auto_increment,
	nombre varchar(50) not null);

create table Sede(
	id_sede int primary key auto_increment,
	id_franquicia int not null,
	direccion varchar(200) not null,
    foreign key (id_franquicia) references Franquicia(id_franquicia) );

create table Producto(
	id_producto int primary key auto_increment,
	nombre varchar(100) not null,
	marca varchar(50) not null,
	descripcion varchar(300),
	peso float,
	categoria varchar(50) not null);

create table Producto_Franquicia(
	id_producto int not null,
	id_franquicia int not null,
	primary key (id_producto, id_franquicia),
    foreign key (id_producto) references Producto(id_producto),
    foreign key (id_franquicia) references Franquicia(id_franquicia) );

create table Pedido(
	id_pedido int primary key auto_increment,
	id_cliente int not null,
	id_sede int not null,
	estado varchar(50) not null,
	fechar date not null,
	direccion varchar(200) not null,
	nro_transaccion int not null,
	subtotal decimal(7,2) not null,
	precio_envio decimal(7,2) not null,
	descuento decimal(7,2) not null,
    foreign key (id_cliente) references Cliente(id_cliente),
    foreign key (id_sede) references Sede(id_sede) );

create table DetallePedido(
	id_pedido int not null,
	id_producto int not null,
	id_franquicia int not null,
	precio decimal(5,2) not null,
	cantidad int not null,
	primary key (id_pedido, id_producto),
    foreign key (id_pedido) references Pedido(id_pedido),
	foreign key (id_producto,id_franquicia) references Producto_Franquicia(id_producto,id_franquicia) );