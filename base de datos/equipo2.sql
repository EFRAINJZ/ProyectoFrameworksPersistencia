-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-04-2021 a las 06:06:55
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equipo2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `idDireccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `email`, `sexo`, `idDireccion`) VALUES
(2, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(3, 'Samuel', 'Velasques', 'sam_velas@gmail.com', 'masculino', 3),
(4, 'Kenny', 'Ramos', 'ramoskenny@hotmail.com', 'masculino', 4),
(5, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(6, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(7, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(8, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(9, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(10, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(11, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(12, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1),
(13, 'Mariela', 'Lopez Lopez', 'MarielaLL@gmail.com', 'Femenino', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventas`
--

CREATE TABLE `detalleventas` (
  `ventaId` int(11) NOT NULL,
  `productoId` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleventas`
--

INSERT INTO `detalleventas` (`ventaId`, `productoId`, `cantidad`) VALUES
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(1, 2, 4),
(31, 4, 2),
(31, 5, 2),
(32, 4, 2),
(32, 5, 2),
(33, 4, 2),
(33, 5, 2),
(1, 2, 4),
(1, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `idDireccion` int(11) NOT NULL,
  `calle` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `colonia` varchar(100) NOT NULL,
  `ciudad` varchar(80) NOT NULL,
  `estado` varchar(80) NOT NULL,
  `pais` varchar(80) NOT NULL,
  `codigoPostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`idDireccion`, `calle`, `numero`, `colonia`, `ciudad`, `estado`, `pais`, `codigoPostal`) VALUES
(1, 'Mina', 9, 'Alamos', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(2, 'Zaragoza', 5, 'Zaragoza', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(3, 'Mina', 12, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(4, 'Morelos', 1, 'Centro', 'Mexico', 'Mexico', 'Mexico', 89000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancias`
--

CREATE TABLE `ganancias` (
  `idGanancia` int(11) NOT NULL,
  `ventaId` int(11) NOT NULL,
  `totalGanancia` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ganancias`
--

INSERT INTO `ganancias` (`idGanancia`, `ventaId`, `totalGanancia`, `fecha`) VALUES
(8, 1, 2123.9, '2021-04-14'),
(9, 1, 2123.9, '2021-04-14'),
(10, 1, 2123.9, '2021-04-14'),
(11, 1, 2123.9, '2021-04-14'),
(12, 1, 2123.9, '2021-04-14'),
(13, 1, 2123.9, '2021-04-14'),
(14, 1, 2123.9, '2021-04-14'),
(15, 1, 2123.9, '2021-04-14'),
(16, 1, 2123.9, '2021-04-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`idMarca`, `nombreMarca`) VALUES
(1, 'Adidas'),
(2, 'Adidas'),
(3, 'Nike'),
(5, 'Nike'),
(6, 'Nike'),
(7, 'Nike'),
(8, 'Nike');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `precioVta` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `marcaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `precio`, `precioVta`, `cantidad`, `marcaId`) VALUES
(2, 'Procesador', 4000, 5678, 123, 2),
(3, 'Prueba producto', 22, 33, 274, 2),
(4, 'Prueba producto', 22, 33, 268, 3),
(5, 'Prueba producto', 22, 33, 268, 2),
(7, 'Prueba producto', 22, 33, 274, 2),
(8, 'Prueba producto', 22, 33, 274, 2),
(9, 'Taza', 22, 33, 274, 2),
(10, 'Taza', 22, 33, 274, 2),
(11, 'Taza', 22, 33, 274, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `clienteId` int(11) NOT NULL,
  `totalVenta` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `clienteId`, `totalVenta`, `fecha`) VALUES
(1, 2, 1800, '2021-04-01'),
(2, 4, 80.5, '2011-04-02'),
(5, 4, 80.5, '2011-04-02'),
(6, 4, 80.5, '2011-04-02'),
(7, 4, 80.5, '2011-04-02'),
(8, 4, 80.5, '2011-04-02'),
(9, 4, 80.5, '2011-04-02'),
(10, 4, 80.5, '2011-04-02'),
(11, 4, 80.5, '2011-04-02'),
(15, 4, 80.5, '2011-04-02'),
(16, 4, 80.5, '2011-04-02'),
(17, 4, 80.5, '2011-04-02'),
(18, 4, 80.5, '2011-04-02'),
(19, 4, 80.5, '2011-04-02'),
(24, 4, 80.5, '2011-04-02'),
(26, 4, 80.5, '2011-04-02'),
(28, 4, 80.5, '2011-04-02'),
(29, 4, 8.5, '2011-04-02'),
(31, 3, 132, '2021-04-21'),
(32, 3, 132, '2021-04-21'),
(33, 3, 132, '2021-04-21');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `iddireccion` (`idDireccion`);

--
-- Indices de la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD KEY `detalle-producto` (`productoId`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`idDireccion`);

--
-- Indices de la tabla `ganancias`
--
ALTER TABLE `ganancias`
  ADD PRIMARY KEY (`idGanancia`),
  ADD KEY `venta-ganancia` (`ventaId`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `product-marca` (`marcaId`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `idDireccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13569;

--
-- AUTO_INCREMENT de la tabla `ganancias`
--
ALTER TABLE `ganancias`
  MODIFY `idGanancia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD CONSTRAINT `detalle-producto` FOREIGN KEY (`productoId`) REFERENCES `productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `ganancias`
--
ALTER TABLE `ganancias`
  ADD CONSTRAINT `venta-ganancia` FOREIGN KEY (`ventaId`) REFERENCES `ventas` (`idVenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `product-marca` FOREIGN KEY (`marcaId`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
