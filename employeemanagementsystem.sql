CREATE DATABASE  IF NOT EXISTS `employeemanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `employeemanagementsystem`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employeemanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `departmentID` int NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(45) NOT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Infomation Technologies'),(2,'Human Resources'),(3,'Sales'),(4,'Customer Service'),(5,'Marketing'),(6,'Public Relations'),(7,'Security');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(75) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `departmentID` int DEFAULT NULL,
  `payRate` varchar(4) NOT NULL,
  `startDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `endDate` datetime DEFAULT NULL,
  `dateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastAccessed` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isManager` tinyint(1) NOT NULL DEFAULT '0',
  `employeeID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`employeeID`),
  KEY `departmentID_idx` (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('john','doe','123 abc st','johnDoe@blah.com','9871237654',2,'ITL1','2020-05-08 00:00:00',NULL,'2020-05-08 00:00:00','2020-05-08 00:00:00',1,1),('jane','doe','321 abc st','janeDoe@blah.com','3217894560',1,'HRL2','2020-05-08 00:00:00',NULL,'2020-05-08 00:00:00','2020-05-08 00:00:00',0,2),('billy','bob','555 some st','billy.bob@blah.com','1234567890',1,'HRL1','2020-05-08 00:00:00',NULL,'2020-05-08 00:00:00','2020-06-10 21:51:16',1,3),('Molly','hatchet','75643 boston cir','molly.harchet@blah.com','8605553241',2,'ITL3','2020-05-08 00:00:00',NULL,'2020-05-08 00:00:00','2020-06-03 19:46:21',1,4),('this','guy','765 OverHere ln','this.guy@blah.com','8604443333',2,'ITL1','2020-05-08 00:00:00',NULL,'2020-05-08 00:00:00','2020-06-04 09:13:10',1,5),('billy','pastora','123 harplin ln, houston, TX 09453','billys@email.com','5557849855',-1,'XXXX','2020-06-04 00:00:00','2020-06-04 00:00:00','2020-06-04 08:46:23','2020-06-04 09:07:47',0,6);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `managerID` int NOT NULL AUTO_INCREMENT,
  `departmentID` int NOT NULL,
  `employeeID` int NOT NULL,
  PRIMARY KEY (`managerID`),
  KEY `departmentID_idx` (`departmentID`),
  KEY `employeeID_idx` (`employeeID`),
  CONSTRAINT `departmentID` FOREIGN KEY (`departmentID`) REFERENCES `departments` (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,1,1),(2,2,5),(3,2,2),(4,2,3);
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `managersview`
--

DROP TABLE IF EXISTS `managersview`;
/*!50001 DROP VIEW IF EXISTS `managersview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `managersview` AS SELECT 
 1 AS `First Name`,
 1 AS `Last Name`,
 1 AS `Department`,
 1 AS `Manager ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `managersview`
--

/*!50001 DROP VIEW IF EXISTS `managersview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `managersview` AS select `employees`.`firstName` AS `First Name`,`employees`.`lastName` AS `Last Name`,`departments`.`departmentName` AS `Department`,`managers`.`managerID` AS `Manager ID` from ((`managers` join `departments` on((`departments`.`departmentID` = `managers`.`departmentID`))) join `employees` on((`employees`.`employeeID` = `managers`.`employeeID`))) where (`employees`.`isManager` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-10 21:56:13
