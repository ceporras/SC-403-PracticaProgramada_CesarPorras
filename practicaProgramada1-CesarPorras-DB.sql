-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: practicaprogramada1
-- ------------------------------------------------------
-- Server version	8.0.44

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

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `creditos` int DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  `ruta_imagen` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Base de datos',8,'En matricula',1,'https://storage.googleapis.com/techshop-6d0c4.firebasestorage.app/practicaprogramada1/curso/img00000000000001.jpg?GoogleAccessId=firebase-adminsdk-fbsvc@techshop-6d0c4.iam.gserviceaccount.com&Expires=1929400306&Signature=m0%2BTaIVqQVHNAPKMihdlbNSNkxMG4gUpu3Uzho%2BLhQR3FPrhW32ec2Z9O3mA4hsPFW5l0AiUOGVbkSnbfqJDw1WsvF6vmsxvYWBtKzMBjc4z0%2FRWVcPvSSOTFTvJZXiPX6mnAeHRZs6%2BRFcnBqJCRAZxyvfAV0RwEo3Io5wnlciO330UT%2BKi4EVfmxE4himp0X2TXpT%2B%2BfmZPeNF3O08ADs6ziCTa7t9VdI5Z0LvzwLCkC6QGWdS9yZnEstQ8zAgBVpyo79YEYttUEo%2BdwQ2p%2FakgMq5%2FfshsnVeCmnoMYab9lpKFv6eAYlfiZOkaxV4%2BlK6cKCQ1DT6jcmCREydFA%3D%3D'),(2,'Desarrollo web',4,'activo',1,'https://storage.googleapis.com/techshop-6d0c4.firebasestorage.app/practicaprogramada1/curso/img00000000000002.jpg?GoogleAccessId=firebase-adminsdk-fbsvc@techshop-6d0c4.iam.gserviceaccount.com&Expires=1929581113&Signature=XKIKCGtN4c%2F54GPCmmthggAxjXm%2Ba3DaAINLiDhAZEfWSFKDmsTa0l5HxyNE%2B%2FXaVnqd2yhW0QKOdW4iC01OHMd9lPRB%2BYUEbFSQUxmO8v6%2BUwdLiKdCO2F0Tym%2BzxP2y%2FaYDXuU7RA4kF7brtwgPl4Hp%2FA1mi2QN49V7UAGa3kIDEfT3EgqHosrCl8V3U7ti%2F%2BczVE4PUJYeoJn7fSu5CanhbLceyUVgq1uwJEqY89Z7ORjGwlztr9SfAgAPkzPiJI0SAHPd03cKOwLkJAED%2B4Fz1T%2F3155cjNBm6e6AqvW2Jm2nQjmBleubaYjY3qonhjLlV1pG50h4bf1kxpELA%3D%3D'),(3,'calculo 1',3,'No disponible',1,'https://storage.googleapis.com/techshop-6d0c4.firebasestorage.app/practicaprogramada1/curso/img00000000000003.jpg?GoogleAccessId=firebase-adminsdk-fbsvc@techshop-6d0c4.iam.gserviceaccount.com&Expires=1929581121&Signature=EwIsDfgAINwpi%2FGzuJ6ZkIq6kNoJGsLnD1PBFYabFWPjLNf7Ujbis1savJRT5NVkbvkmG%2FXIJNGjic%2BtWHpPIFFH8IolEv0k4oQBGYqO20ZUzwtE%2B6Tl%2Bbv9bw7d3%2B57wtxTY8mO6afJrywI9uPEclu15XRY44zYKtSxXMvZ0YODzPpQobH0VYnun89sc6RRcHBXh9306qmmWJkpSlCJ14mziZc4hxXovioMJ85cfcoZEtG1WnLYpeWu4edNd5TRZmmPDTfdgvFCmZ9ZfL525eR%2B%2FlTa057j52%2FdRQ4qkDsh10E42vNci4iYGTCcDbV1qBhcwx64Uk7Xe%2F%2BtLWlTuQ%3D%3D'),(15,'Programacion',5,'No disponible',1,'https://storage.googleapis.com/techshop-6d0c4.firebasestorage.app/practicaprogramada1/curso/img00000000000015.jpg?GoogleAccessId=firebase-adminsdk-fbsvc@techshop-6d0c4.iam.gserviceaccount.com&Expires=1929584084&Signature=RZp2JBZ%2FPjil096bu6lAZsTt%2F7zsJMuFmJJ9hssMVoZRHTJpWoHnP9Kzcf%2FYJ%2FIy%2BO1mf4p7gtHIHxWtcnBVeKrVSKJPuyOTDmHLDavnfGlPWeTbLRFzNDyhioBTHRWzxgSUVfkmtoqdy4voyL8i6edVz97UPNoXUUVZMI5KDC8n17V24Enx5NIUAkTQ3p9HRIlSBSuKAeA7%2F%2FXSjoTjTwdTovKPUFZtGKeJiMUMRWmfS%2F1hzLNmq%2BJrn%2BLIO6o%2BdMVOGfhUkpIUquMnWagW8k4xbmAmWjQsABypSpkXJAlDb2nV3Mg5LfB8xwSN6ipp%2BnAMgk7WKbF72guRO3ByHg%3D%3D');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id_estudiante` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `edad` int NOT NULL,
  `id_curso` int NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_estudiante`),
  KEY `id_curso_idx` (`id_curso`) /*!80000 INVISIBLE */,
  CONSTRAINT `id_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Elizabeth Brown','correo1@gmail.com',25,2,1),(9,'Cesar Porras','correo1@gmail.com',5234,2,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-23 22:05:23
