CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `contraseña` varchar(25) NOT NULL,
  `nombrecompleto` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`,`usuario`, `correo`, `contraseña`, `nombrecompleto`, `telefono`, `ciudad`) VALUES
(1,'juan', 'juancito@hotmail.com', '1234', 'Juan Pérez', '123456', 'Quito');

