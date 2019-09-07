CREATE DATABASE trabajo_tpv

USE DATABASE trabajo_tpv;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `empleados`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id del empleado',
`nombre` varchar(40) NOT NULL COMMENT 'nombre del empleado',
`apellido1` varchar(40) NOT NULL COMMENT 'primer apellido',
`apellido2` varchar(40) NOT NULL COMMENT 'segundo apellido',
`password` varchar(40) NOT NULL COMMENT 'password',
PRIMARY KEY (`id`),
UNIQUE KEY `id`(`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Lista de empleados' AUTO_INCREMENT=1;

INSERT INTO `empleados` ( `nombre`, `password`) VALUES ( 'admin', '1234');


CREATE TABLE IF NOT EXISTS `familias`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id de la familia',
`familia` varchar(40) NOT NULL COMMENT 'nombre de la familia',
`icono` varchar (200) NOT NULL COMMENT 'icono de la familia',
PRIMARY KEY (`id`),
UNIQUE KEY `id`(`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Lista de familias' AUTO_INCREMENT=1;


CREATE TABLE IF NOT EXISTS `productos`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id del producto',
`familia` varchar(40) NOT NULL COMMENT 'familia a la que pertenece',
`nombre` varchar(40) NOT NULL COMMENT 'nombre del producto',
`precio` float(11) NOT NULL COMMENT 'precio del producto',
`icono` varchar (200) NOT NULL COMMENT 'icono del producto',
PRIMARY KEY (`id`),
UNIQUE KEY `id`(`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Lista de productos' AUTO_INCREMENT=1;


CREATE TABLE IF NOT EXISTS `clientes`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id del cliente',
`nombre` varchar(40) NOT NULL COMMENT 'nombre del cliente',
`apellidos` varchar(80) NOT NULL COMMENT 'apellidos del cliente',
`DNI` varchar(10) NOT NULL COMMENT 'DNI del cliente',
`telefono` int(10) NOT NULL COMMENT 'telefono del cliente',
`descuento` int(2) NOT NULL COMMENT 'descuento aplicable',
PRIMARY KEY (`id`),
UNIQUE KEY `id`(`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Lista de clientes' AUTO_INCREMENT=1;

INSERT INTO `clientes` (`nombre`, `descuento`) VALUES ('Cliente', 0);


CREATE TABLE IF NOT EXISTS `facturas`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id de la factura',
`vendedor` varchar(100) NOT NULL COMMENT 'nombre del vendedor',
`cliente` varchar(100) NOT NULL COMMENT 'nombre del cliente',
`fecha` varchar(9) NOT NULL COMMENT 'fecha de la factura',
`factura` varchar(1000) NOT NULL COMMENT 'contenido de la factura',
PRIMARY KEY (`id`),
UNIQUE KEY `id`(`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Listado de facturas' AUTO_INCREMENT=1;



