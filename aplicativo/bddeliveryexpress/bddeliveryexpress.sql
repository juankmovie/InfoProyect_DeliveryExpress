-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33065
-- Tiempo de generación: 13-12-2021 a las 05:34:45
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
-- Base de datos: `bdddeliveryexpress`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idAdministrador` int(11) NOT NULL,
  `nombreUsuario` varchar(40) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cedula` int(11) NOT NULL,
  `nombres` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `edad` tinyint(4) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `barrio` varchar(20) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `celular` int(10) NOT NULL,
  `telefono` int(13) NOT NULL,
  `correoelectronico` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domiciliario`
--

CREATE TABLE `domiciliario` (
  `idDomiciliario` int(11) NOT NULL,
  `idFactura` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `nombreCliente` varchar(20) NOT NULL,
  `apellidoCliente` varchar(20) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `telefono` int(10) NOT NULL,
  `valorTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia`
--

CREATE TABLE `guia` (
  `idGuia` int(11) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `idMonitor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monitor`
--

CREATE TABLE `monitor` (
  `idMonitor` int(11) NOT NULL,
  `nombreMonitor` varchar(20) NOT NULL,
  `apellidoMonitor` text NOT NULL,
  `correoElectronico` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(40) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombreUsuario`, `usuario`, `contrasena`, `email`) VALUES
(1, 'Juan Holguin', 'JuanH', '1234', 'juankmovie@hotmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idAdministrador`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `domiciliario`
--
ALTER TABLE `domiciliario`
  ADD PRIMARY KEY (`idDomiciliario`),
  ADD KEY `cedula` (`idFactura`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `codServicio` (`cedula`),
  ADD KEY `idCliente` (`cedula`);

--
-- Indices de la tabla `guia`
--
ALTER TABLE `guia`
  ADD PRIMARY KEY (`idGuia`),
  ADD KEY `codServicio` (`idMonitor`),
  ADD KEY `idCliente` (`cedula`);

--
-- Indices de la tabla `monitor`
--
ALTER TABLE `monitor`
  ADD PRIMARY KEY (`idMonitor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `idAdministrador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `cedula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `domiciliario`
--
ALTER TABLE `domiciliario`
  MODIFY `idDomiciliario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idFactura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `guia`
--
ALTER TABLE `guia`
  MODIFY `idGuia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `monitor`
--
ALTER TABLE `monitor`
  MODIFY `idMonitor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `domiciliario`
--
ALTER TABLE `domiciliario`
  ADD CONSTRAINT `domiciliario_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `clientes` (`cedula`) ON DELETE CASCADE;

--
-- Filtros para la tabla `guia`
--
ALTER TABLE `guia`
  ADD CONSTRAINT `guia_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `clientes` (`cedula`) ON DELETE CASCADE,
  ADD CONSTRAINT `guia_ibfk_2` FOREIGN KEY (`idMonitor`) REFERENCES `monitor` (`idMonitor`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
