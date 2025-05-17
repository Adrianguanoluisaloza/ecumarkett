-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2025 a las 16:31:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario2`
--

DELIMITER $$
--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `mes` (`_d` DATE, `_locale` VARCHAR(5)) RETURNS VARCHAR(22) CHARSET utf8 COLLATE utf8_general_ci DETERMINISTIC BEGIN
                    SET @@lc_time_names = _locale;
                    RETURN DATE_FORMAT(_d, '%M');
                    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL,
  `categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idCategoria`, `categoria`) VALUES
(1, 'Bebidas1'),
(2, 'Enlatado'),
(5, 'Perecibles'),
(7, 'abarrote'),
(8, 'Tecnologia'),
(11, 'legunbres'),
(12, 'Muebles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombre`, `apellido`, `documento`, `direccion`, `telefono`, `correo`) VALUES
(1, 'susana', 'torrez damian', '96325874', 'av los angeles 12', '963258741', 'susana@gmail.com'),
(3, 'julio', 'dominguex damian', '85217785', 'av los programadores 12', '952369874', 'julio@gmail.com'),
(4, 'sofia', 'gonzales gutierrez', '8521478', 'av las flores 25', '963258745', 'sofi.g@gmail.com'),
(5, 'Adrian elias', 'Guanoluisa', '0850295882', 'aire libre[j', '00987561851', 'adrina@gmail.com'),
(6, 'Jennifer', 'guila', '085615615', 'calderon y seis de diciembre', '6846849841', 'jennifer@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallesalida`
--

CREATE TABLE `detallesalida` (
  `id` int(11) NOT NULL,
  `idSalida` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallesalida`
--

INSERT INTO `detallesalida` (`id`, `idSalida`, `idproducto`, `cantidad`, `importe`) VALUES
(1, 2, 1, 2, 20.00),
(2, 2, 2, 1, 25.00),
(3, 3, 4, 5, 27.50),
(4, 3, 3, 5, 32.50),
(5, 4, 1, 10, 500.00),
(6, 4, 2, 10, 250.00),
(7, 5, 1, 20, 1000.00),
(8, 6, 3, 5, 32.50),
(9, 7, 3, 1, 6.50),
(10, 8, 2, 10, 250.00),
(11, 9, 3, 1, 6.50),
(12, 10, 3, 20, 130.00),
(13, 11, 3, 4, 26.00),
(14, 11, 2, 10, 250.00),
(15, 12, 1, 10, 500.00),
(16, 13, 1, 10, 500.00),
(17, 14, 1, 10, 500.00),
(18, 14, 1, 10, 500.00),
(19, 14, 3, 10, 65.00),
(20, 16, 8, 100, 50.00),
(21, 17, 8, 100, 50000.00),
(22, 18, 8, 20, 40000.00),
(23, 19, 9, 50, 25000.00),
(24, 20, 9, 495, 247500.00),
(25, 21, 9, 1, 500.00),
(26, 22, 8, 400, 800000.00),
(27, 23, 7, 2, 40.00),
(28, 24, 9, 100, 50000.00),
(29, 25, 9, 22, 11000.00),
(30, 26, 9, 20, 10000.00),
(31, 26, 5, 2, 280.00),
(32, 27, 9, 20, 10000.00),
(33, 28, 8, 2, 4000.00),
(34, 29, 9, 1, 500.00),
(35, 30, 8, 10, 20000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `identrada` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idproveedor` int(11) NOT NULL,
  `precioE` decimal(10,2) NOT NULL,
  `precioV` decimal(10,2) NOT NULL,
  `total` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`identrada`, `idproducto`, `stock`, `fecha`, `idproveedor`, `precioE`, `precioV`, `total`) VALUES
(2, 2, 15, '2024-05-17', 1, 22.00, 25.00, 330.00),
(3, 1, 50, '2024-05-17', 3, 8.00, 10.00, 400.00),
(6, 3, 16, '2024-05-22', 4, 5.00, 6.50, 80.00),
(8, 7, 500, '2025-04-19', 6, 40.00, 500.00, 20000.00),
(9, 3, 8, '2024-05-30', 4, 5.00, 6.50, 40.00),
(10, 2, 10, '2024-06-05', 4, 19.00, 25.00, 190.00),
(11, 7, 6000, '2024-06-05', 6, 22.00, 500.00, 132000.00),
(12, 2, 8, '2024-06-05', 2, 23.00, 25.00, 184.00),
(13, 2, 10, '2024-06-06', 4, 22.00, 25.00, 220.00),
(14, 2, 10, '2024-06-06', 1, 8.50, 25.00, 85.00),
(15, 2, 6, '2024-06-07', 4, 5.00, 25.00, 30.00),
(16, 4, 10, '2024-06-21', 2, 10.00, 11.50, 100.00),
(17, 4, 10, '2024-06-24', 4, 9.00, 10.50, 90.00),
(18, 4, 20, '2024-06-24', 3, 10.00, 10.50, 200.00),
(19, 4, 5, '2024-06-24', 2, 10.50, 11.00, 52.50),
(20, 1, 5, '2024-06-24', 4, 10.00, 11.00, 50.00),
(21, 5, 15, '2024-06-24', 4, 13.00, 14.00, 195.00),
(22, 1, 20, '2025-04-05', 1, 20.00, 50.00, 400.00),
(23, 1, 10, '2025-04-23', 6, 50.00, 50.00, 500.00),
(24, 5, 50, '2024-05-10', 6, 40.00, 140.00, 2000.00),
(25, 8, 50, '2025-05-04', 7, 200.00, 500.00, 10000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `stock` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `precioV` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idproducto`, `nombre`, `stock`, `idCategoria`, `precioV`) VALUES
(1, 'inka cola 3L', 75, 1, 50.00),
(2, 'arroz 5k costeña', 520, 1, 25.00),
(3, 'Coca cola 1L', 40, 1, 6.50),
(4, 'Atun', 500, 2, 5.50),
(5, 'arroz 5kg', 50, 7, 140.00),
(7, 'Laptod', 10, 8, 20.00),
(8, 'cebolla', 688, 11, 2000.00),
(9, 'miel de abejka', 951, 12, 500.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `Activadad_comercial` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idproveedor`, `nombre`, `apellido`, `documento`, `Activadad_comercial`, `direccion`, `telefono`, `correo`) VALUES
(1, 'julio', 'ramirez00000', '85214785698', 'golosinas sac000', 'av los girasoles 25', '963258741', 'julio@gmail.com'),
(2, 'rosa00', 'muñoz dominguez', '96325874125', 'enlatados sac', 'av los girasoles 25', '963258741', 'rosa.m@gmail.com'),
(3, 'daniel1', 'torres miranda', '852147856987', 'golosinas 1', 'av los rosales', '963258741', 'daniel.T@gmail.com'),
(4, 'Enrique', 'Dominguez Torres', '963258741257', 'Alicorp[', 'av girasoles 20', '963258740', 'alicorP@gmail.com'),
(6, 'Adrian', 'Guanoluisa', '08502958811', 'Tecnologia', 'dfd65441651', '65685', 'adrian@gmail.com'),
(7, 'cristofere', 'aaaa', '123456789', 'Legumbrero', 'atacames', '54654654', 'legumbre@.gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `idSalida` int(11) NOT NULL,
  `numSalida` varchar(10) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `igv` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` varchar(8) NOT NULL DEFAULT 'Pagada'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salidas`
--

INSERT INTO `salidas` (`idSalida`, `numSalida`, `idCliente`, `fecha`, `subtotal`, `igv`, `total`, `estado`) VALUES
(1, '001', 4, '2024-05-28', 25.83, 5.67, 31.50, 'Pagada'),
(2, '002', 4, '2024-05-28', 36.90, 8.10, 45.00, 'Pagada'),
(3, '003', 4, '2024-06-24', 49.20, 10.80, 60.00, 'Pagada'),
(4, '004', 1, '2025-04-29', 615.00, 135.00, 750.00, 'Anulada'),
(5, '005', 1, '2025-04-30', 820.00, 180.00, 1000.00, 'Pagada'),
(6, '006', 1, '2025-04-30', 26.65, 5.85, 32.50, 'Pagada'),
(7, '007', 1, '2025-04-03', 5.33, 1.17, 6.50, 'Pagada'),
(8, '008', 1, '2025-04-30', 205.00, 45.00, 250.00, 'Anulada'),
(9, '009', 1, '2025-04-09', 5.33, 1.17, 6.50, 'Anulada'),
(10, '0010', 1, '2025-04-30', 106.60, 23.40, 130.00, 'Anulada'),
(11, '0011', 1, '2025-04-08', 226.32, 49.68, 276.00, 'Aprobada'),
(12, '0012', 1, '2025-04-16', 410.00, 90.00, 500.00, 'Pagada'),
(13, '0013', 5, '2025-05-14', 410.00, 90.00, 500.00, 'Anulada'),
(14, '0014', 5, '2025-05-05', 410.00, 90.00, 500.00, 'Aprobada'),
(15, '0014', 5, '2025-05-05', 463.30, 101.70, 565.00, 'Anulada'),
(16, '0016', 5, '2025-05-04', 41.00, 9.00, 50.00, 'Anulada'),
(17, '0017', 5, '2025-05-04', 41000.00, 9000.00, 50000.00, 'Anulada'),
(18, '0018', 5, '2025-05-06', 32800.00, 7200.00, 40000.00, 'Anulada'),
(19, '0019', 5, '2025-05-06', 20500.00, 4500.00, 25000.00, 'Anulada'),
(20, '0020', 5, '2025-05-07', 202950.00, 44550.00, 247500.00, 'Anulada'),
(21, '0021', 5, '2025-05-06', 410.00, 90.00, 500.00, 'Anulada'),
(22, '0022', 5, '2025-05-07', 656000.00, 144000.00, 800000.00, 'Anulada'),
(23, '0023', 5, '2025-05-07', 32.80, 7.20, 40.00, 'Pagada'),
(24, '0024', 5, '2025-05-07', 41000.00, 9000.00, 50000.00, 'Anulada'),
(25, '0025', 5, '2025-05-07', 9020.00, 1980.00, 11000.00, 'Pagada'),
(26, '0026', 5, '2025-05-07', 8429.60, 1850.40, 10280.00, 'Anulada'),
(27, '0027', 5, '2025-05-08', 8200.00, 1800.00, 10000.00, 'Pagada'),
(28, '0028', 5, '2025-05-08', 3280.00, 720.00, 4000.00, 'Pagada'),
(29, '0029', 5, '2025-05-08', 410.00, 90.00, 500.00, 'Pagada'),
(30, '0030', 5, '2025-05-09', 16400.00, 3600.00, 20000.00, 'Pagada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `tipoUsuario` varchar(20) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `pass` varbinary(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellido`, `documento`, `direccion`, `telefono`, `correo`, `tipoUsuario`, `usuario`, `pass`) VALUES
(1, 'Tadeo', 'Ballesteros', '74850994', 'Universidad', '963258741', 'Angel@gmail.com', 'Administrador', 'Angel', 0x7b3f57093f3f0e00673f1f153f3f6c3f),
(2, 'sofia', 'dominguez perez', '85214785', 'av rosales 35', '985698587', 'sofia@gmail.com', 'Vendedor', 'sofia', 0xcf9ee6f98d1436218774b1a9b685d3ec),
(4, 'pedro', 'puentes torres', '85214785', 'Calderon ', '963258789', 'pedro.p@gmail.com', 'Almacenero', 'pedro', 0x7bc5570986930e0067e31f15eccc6c86),
(6, 'aDRIAN', 'puentes torres', '85214785', 'acasias', '963258789', 'adr@gmail.com', 'Administrador', 'aDRI', 0xcf9ee6f98d1436218774b1a9b685d3ec);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_salida` (`idSalida`),
  ADD KEY `fk_productos` (`idproducto`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`identrada`),
  ADD KEY `fk_proveedor` (`idproveedor`),
  ADD KEY `fk_producto` (`idproducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idproveedor`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`idSalida`),
  ADD KEY `fk_cliente` (`idCliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `identrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `idSalida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  ADD CONSTRAINT `fk_productos` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  ADD CONSTRAINT `fk_salida` FOREIGN KEY (`idSalida`) REFERENCES `salidas` (`idSalida`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `fk_producto` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  ADD CONSTRAINT `fk_proveedor` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`);

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
