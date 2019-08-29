drop database IF EXISTS inretail;
create database IF NOT EXISTS inretail;
use inretail;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Código',
  `nombres` varchar(50) NOT NULL COMMENT 'Nombres',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos',
  `fechaNacimiento` varchar(10) NOT NULL COMMENT 'Fecha de Nacimiento',
  `edad` int(11) NOT NULL COMMENT 'Edad',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table customers';