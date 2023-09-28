-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-09-2023 a las 02:26:25
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadulp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(1, 12345678, 'González', 'Juan', '2000-05-15', 1),
(2, 23456789, 'López', 'María', '1999-08-22', 0),
(3, 34567890, 'Martínez', 'Carlos', '2001-03-10', 1),
(4, 45678901, 'Sánchez', 'Laura', '1998-12-05', 0),
(5, 56789012, 'Rodríguez', 'Pedro', '2002-07-30', 1),
(6, 67890123, 'Fernández', 'Ana', '1997-11-20', 0),
(7, 78901234, 'Pérez', 'David', '2003-01-18', 1),
(8, 89012345, 'Gómez', 'Sofía', '1996-04-25', 0),
(9, 90123456, 'Díaz', 'Pablo', '2004-09-12', 1),
(10, 1234567, 'Ramírez', 'Elena', '1995-06-08', 0),
(11, 11223344, 'Torres', 'Luis', '2005-02-28', 1),
(12, 22334455, 'García', 'Marta', '1994-10-14', 0),
(13, 33445566, 'López', 'Diego', '2006-07-03', 1),
(14, 44556677, 'Fernández', 'Isabel', '1993-09-19', 0),
(15, 55667788, 'Martínez', 'Raúl', '2007-04-08', 1),
(16, 66778899, 'Sánchez', 'Carmen', '1992-08-27', 0),
(17, 77889900, 'Gómez', 'José', '2008-11-13', 1),
(18, 88990011, 'Rodríguez', 'Alicia', '1991-01-02', 0),
(19, 99001122, 'Díaz', 'Javier', '2009-06-20', 1),
(20, 112233, 'Pérez', 'Lorena', '1990-03-17', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripcion` int(11) NOT NULL,
  `nota` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripcion`, `nota`, `idAlumno`, `idMateria`) VALUES
(1, 8, 1, 1),
(2, 7, 2, 2),
(3, 8, 3, 3),
(4, 6, 4, 4),
(5, 9, 5, 5),
(6, 6, 6, 6),
(7, 9, 7, 7),
(8, 5, 8, 8),
(9, 7, 9, 9),
(10, 6, 10, 10),
(11, 9, 11, 11),
(12, 6, 12, 12),
(13, 8, 13, 13),
(14, 7, 14, 14),
(15, 10, 15, 15),
(16, 5, 16, 16),
(17, 7, 17, 17),
(18, 7, 18, 18),
(19, 8, 19, 19),
(20, 6, 20, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `año` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `año`, `estado`) VALUES
(1, 'Matemáticas', 2023, 1),
(2, 'Historia', 2023, 0),
(3, 'Física', 2023, 1),
(4, 'Química', 2023, 0),
(5, 'Biología', 2023, 1),
(6, 'Literatura', 2023, 0),
(7, 'Economía', 2023, 1),
(8, 'Inglés', 2023, 0),
(9, 'Programación', 2023, 1),
(10, 'Arte', 2023, 0),
(11, 'Psicología', 2023, 1),
(12, 'Filosofía', 2023, 0),
(13, 'Derecho', 2023, 1),
(14, 'Música', 2023, 0),
(15, 'Geografía', 2023, 1),
(16, 'Deportes', 2023, 0),
(17, 'Marketing', 2023, 1),
(18, 'Informática', 2023, 0),
(19, 'Ciencias Políticas', 2023, 1),
(20, 'Sociología', 2023, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
