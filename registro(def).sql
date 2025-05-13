-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.25-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.2.0.6576
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para registro
CREATE DATABASE IF NOT EXISTS `registro` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `registro`;

-- Volcando estructura para tabla registro.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla registro.clientes: ~3 rows (aproximadamente)
REPLACE INTO `clientes` (`id`, `nombre`, `apellido`, `telefono`, `username`, `email`, `clave`) VALUES
	(1, 'jesus', 'beltran', '3164509677', 'jesu', 'jesus@gmail.com', '12345'),
	(2, 'juan', 'peres', 'peres@gmai.com', 'llio', '311554125', '0123'),
	(4, 'test', 'test', 'test@gmail.com', 'test', '32222222', '0147');

-- Volcando estructura para tabla registro.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `apellido` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `clave` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla registro.usuario: ~4 rows (aproximadamente)
REPLACE INTO `usuario` (`id`, `nombre`, `apellido`, `username`, `email`, `clave`) VALUES
	(1, 'jesus daniel\r\n', 'beltran polo', 'jedabep', 'jesusdbp365@gmail.com', '1234'),
	(3, 'alvaro', 'gonzales', 'llio', 'alvaro@gmail.com', '12345'),
	(6, 'test', 'test', 'test', 'test@gmail.com', '0123'),
	(7, 'test', '2', 'test', 'test2@gmail.com', '0147');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
