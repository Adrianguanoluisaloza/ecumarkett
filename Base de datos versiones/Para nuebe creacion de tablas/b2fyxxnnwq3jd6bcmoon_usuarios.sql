-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: b2fyxxnnwq3jd6bcmoon-mysql.services.clever-cloud.com    Database: b2fyxxnnwq3jd6bcmoon
-- ------------------------------------------------------
-- Server version	8.0.22-13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'a05a675a-1414-11e9-9c82-cecd01b08c7e:1-491550428,
a38a16d0-767a-11eb-abe2-cecd029e558e:1-551617856';

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `documento` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `tipoUsuario` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `pass` varbinary(100) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Tadeo','Ballesteros','74850994','Universidad','963258741','Angel@gmail.com','Administrador','Angel',_binary 'Ο\ζω6!‡t±©¶…\Σ\μ'),(2,'David ','No me acuerdo','8541684186','Casa bonita','5468465','David@gmail.com','Vendedor','David',_binary 'Ο\ζω6!‡t±©¶…\Σ\μ'),(4,'Franco','Herrera','85214785','Calderon ','963258789','Franco@gmail.com','Almacenero','Franco',_binary 'Ο\ζω6!‡t±©¶…\Σ\μ'),(6,'Adrian','Patron','564161561','Orlando','54641654165','adr@gmail.com','Administrador','Adrin',_binary '{\ΕW	†“\0g\γ\μ\Μl†'),(8,'TadeoEmpleado','Ballesteros','74850994','Universidad','963258741','Angel1@gmail.com','Vendedor','AngelEmpleado',_binary 'Ο\ζω6!‡t±©¶…\Σ\μ'),(9,'FrancoAlmacenero','Herrera','85214785','Calderon ','963258789','Franco1@gmail.com','Almacenero','FrancoAlmacen',_binary 'Ο\ζω6!‡t±©¶…\Σ\μ'),(10,'DavidJEfe','No me acuerdo','8541684186','Casa bonita','5468465','David1@gmail.com','Administrador','David',_binary '{\ΕW	†“\0g\γ\μ\Μl†');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-26 12:29:29
