-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 19-02-2019 a las 16:37:01
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `example_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `alumno_id` int(11) NOT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(150) DEFAULT NULL,
  `promedio` decimal(5,2) DEFAULT NULL,
  `status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`alumno_id`, `nombres`, `apellidos`, `promedio`, `status`) VALUES
(1, 'José Manuel', 'Valezuela Soto', '18.00', '1'),
(2, 'Jhon', 'Jhon Jhon', '16.00', '1'),
(3, 'INSERT', 'CLOSE DELETE', '11.00', '1'),
(4, 'DROP', 'DATA BASE', '10.00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amount`
--

CREATE TABLE `amount` (
  `id` int(11) NOT NULL,
  `trans_name` varchar(100) NOT NULL,
  `trans_date` date NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `amount`
--

INSERT INTO `amount` (`id`, `trans_name`, `trans_date`, `amount`) VALUES
(2, 'jose', '2019-02-02', 23.23),
(3, 'marlon', '2019-02-06', 20.67),
(4, 'luisaos', '2019-02-18', -1),
(11, 'Khan', '2019-02-25', 23.2),
(12, 'Enkidu', '2019-02-19', 26.23),
(13, 'Enu', '2019-03-24', 29.23),
(14, 'Enoghtu', '2019-03-24', 29.23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `aula_id` int(11) NOT NULL,
  `cod_aula` char(5) DEFAULT NULL,
  `status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula_alumno`
--

CREATE TABLE `aula_alumno` (
  `aula_alumno_id` int(11) NOT NULL,
  `alumno_id` int(11) NOT NULL,
  `aula_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`alumno_id`);

--
-- Indices de la tabla `amount`
--
ALTER TABLE `amount`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`aula_id`);

--
-- Indices de la tabla `aula_alumno`
--
ALTER TABLE `aula_alumno`
  ADD PRIMARY KEY (`aula_alumno_id`),
  ADD KEY `fk_aula_alumno_alumno_idx` (`alumno_id`),
  ADD KEY `fk_aula_alumno_aula1_idx` (`aula_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `alumno_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `amount`
--
ALTER TABLE `amount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `aula_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `aula_alumno`
--
ALTER TABLE `aula_alumno`
  MODIFY `aula_alumno_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aula_alumno`
--
ALTER TABLE `aula_alumno`
  ADD CONSTRAINT `fk_aula_alumno_alumno` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`alumno_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aula_alumno_aula1` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`aula_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
