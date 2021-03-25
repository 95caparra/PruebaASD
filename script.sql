-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.14-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para prueba_tecnica
CREATE DATABASE IF NOT EXISTS `prueba_tecnica` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `prueba_tecnica`;

-- Volcando estructura para tabla prueba_tecnica.activos
CREATE TABLE IF NOT EXISTS `activos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_interno` varchar(200) NOT NULL,
  `ancho` bigint(20) NOT NULL,
  `color` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fecha_baja` date NOT NULL,
  `fecha_compra` date NOT NULL,
  `largo` bigint(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `peso` double NOT NULL,
  `serial` varchar(200) NOT NULL,
  `tipo` varchar(200) NOT NULL,
  `valor_compra` double NOT NULL,
  `id_area` bigint(20) DEFAULT NULL,
  `id_estado` bigint(20) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kgh02enbjpdax8ajuigu5mciy` (`numero_interno`),
  UNIQUE KEY `UK_iag34fs991rc9qlfue8h3syv9` (`ancho`),
  UNIQUE KEY `UK_7k2ka9j3cil7urevxw6mbooar` (`color`),
  UNIQUE KEY `UK_3v0cqnsuob0vf0i7tljryusp7` (`descripcion`),
  UNIQUE KEY `UK_olgs7yt29d1a09e5xc1d5w978` (`fecha_baja`),
  UNIQUE KEY `UK_p95uxn42kai3hdc2972vds9bx` (`fecha_compra`),
  UNIQUE KEY `UK_5cbhirpf1s4uygcyajsnwbl2v` (`largo`),
  UNIQUE KEY `UK_35fcq6iosohj56ju0vgmhrpx8` (`nombre`),
  UNIQUE KEY `UK_8fuv1ke7oqe55g158xo5hft90` (`peso`),
  UNIQUE KEY `UK_p7vnahcg9ces999an8xqop8oh` (`serial`),
  UNIQUE KEY `UK_aag44xt7n4vdn98we63quqc3w` (`tipo`),
  UNIQUE KEY `UK_qfc5ipdo2jyfnddfuh4i2e1ff` (`valor_compra`),
  KEY `FKc7uuvvyvc7kx0x20ovv0txvcy` (`id_area`),
  KEY `FK9dw5dv0s57t9jqyw79fog8qy6` (`id_estado`),
  KEY `FKky62oqtoxhx6ad02k2k8ogffv` (`id_persona`),
  CONSTRAINT `FK9dw5dv0s57t9jqyw79fog8qy6` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id`),
  CONSTRAINT `FKc7uuvvyvc7kx0x20ovv0txvcy` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id`),
  CONSTRAINT `FKky62oqtoxhx6ad02k2k8ogffv` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla prueba_tecnica.areas
CREATE TABLE IF NOT EXISTS `areas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `id_ciudad` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oxiafm7kisksgy3pncc6e458d` (`nombre`),
  KEY `FKol8b0nf5ewk05n8r64dfq1g59` (`id_ciudad`),
  CONSTRAINT `FKol8b0nf5ewk05n8r64dfq1g59` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla prueba_tecnica.ciudades
CREATE TABLE IF NOT EXISTS `ciudades` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4s6dlla8rc87qomrxq2q2js74` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla prueba_tecnica.estados
CREATE TABLE IF NOT EXISTS `estados` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_93g5ha066boi1ef1x390la9rc` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla prueba_tecnica.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k9mbg005jinfl83646w7dts6p` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
