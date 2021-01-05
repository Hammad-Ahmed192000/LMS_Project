CREATE DATABASE  IF NOT EXISTS `library_managment_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library_managment_system`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: library_managment_system
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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `student_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `reserved_books` int DEFAULT '0',
  `student_id` int NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `student_id_idx` (`student_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (2,'Hammad','03109182087',4,12345),(3,'Akram','[C@3b31a32b',1,67890),(4,'Akram Bugti','03215704276',2,54321),(5,'Hammad Ahmed','03037661942',0,9876),(6,'Hamza','03335704276',0,16273),(7,'Kamran','03109182088',0,91827),(8,'Usama','03219182088',0,28376),(9,'Muhammad Akram','03109182066',0,21190),(10,'Noyaan','01234567',1,10101),(11,'Hamza ali','password',1,9123),(12,'Bilal','password123',1,1122);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` int NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `author_name` varchar(45) DEFAULT NULL,
  `book_ISBN` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'JAVA2','Schilit','0938210876','Microsoft Press'),(2,'JAVA Complete Reference','Silber Schatz','0938210234','Microsoft Press'),(3,'JavaScript: The Good Parts','Douglas Crockford','0938210382','Addison Wesley'),(4,'The Pragmatic Programmer','Andrew Hunt,  David Thomas','0938210233','MIT Press'),(5,'Structure and  Interpretation of Computer Programs',' Harold Abelson','0938210122','MIT Press'),(6,' The C++ Programming Language','Bjarne Stroustrup','0938210233','MIT Press'),(7,'The Little Schemer','Daniel P. Friedman','0938210345','Addison Wesley'),(8,'The Mythical Man-Month','Frederick P. Brooks','0938210787','Microsoft Press'),(9,' Computer Organization and Design','David A. Patterson','0938210345','Microsoft Press'),(10,'Programming Pearls','Jon Bentley','0938210238','MIT Press');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_details`
--

DROP TABLE IF EXISTS `books_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_details` (
  `books_details_id` int unsigned NOT NULL AUTO_INCREMENT,
  `issue_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `return_date` timestamp NULL DEFAULT NULL,
  `book_id` int NOT NULL,
  `librarian_id` int NOT NULL,
  `student_id` int NOT NULL,
  PRIMARY KEY (`books_details_id`),
  KEY `book_id_idx` (`book_id`),
  KEY `librarian_id_idx` (`librarian_id`),
  KEY `student_id_idx` (`student_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `librarian_id` FOREIGN KEY (`librarian_id`) REFERENCES `librarian` (`librarian_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_details`
--

LOCK TABLES `books_details` WRITE;
/*!40000 ALTER TABLE `books_details` DISABLE KEYS */;
INSERT INTO `books_details` VALUES (1,'2021-01-04 22:00:44','2021-01-11 22:00:44',1,3,12345),(2,'2021-01-04 22:22:36','2021-01-11 22:22:36',1,3,67890),(3,'2021-01-04 22:24:50','2021-01-11 22:24:50',1,3,12345),(6,'2021-01-05 01:23:55','2021-01-12 01:23:55',6,2,12345),(7,'2021-01-05 03:14:48','2021-01-12 03:14:48',10,3,54321),(8,'2021-01-05 06:23:17','2021-01-12 06:23:17',5,3,12345),(9,'2021-01-05 22:45:39','2021-01-12 22:45:39',5,2,10101),(10,'2021-01-05 23:04:53','2021-01-12 23:04:53',9,2,9123),(11,'2021-01-05 23:18:14','2021-01-12 23:18:14',5,2,1122),(12,'2021-01-05 23:30:55','2021-01-12 23:30:55',10,3,54321);
/*!40000 ALTER TABLE `books_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarian` (
  `librarian_id` int NOT NULL,
  `librarian_name` varchar(45) NOT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `timings` time NOT NULL,
  PRIMARY KEY (`librarian_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'Subhan Mangi','50000','09:00:00'),(2,'Kalbhoshan Yadav','40000','14:00:00'),(3,'Avinash Kumar','60000','17:00:00');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL,
  `student_name` varchar(45) NOT NULL,
  `program` varchar(45) DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `batch` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1122,'Bilal','BSCS','V','2019'),(9123,'Hamza ali','BBA','V','2019'),(9876,'Hammad Ahmed','BSCS','IV','2018'),(10101,'Noyaan','MBA','II','2020'),(12345,'Hammad','BSCS','IV','2018'),(16273,'Hamza','BCCS','V','2018'),(21190,'Muhammad Akram ','BSSE','IV','2018'),(28376,'Usama','BSCS','V','2017'),(54321,'Akram Bugti','BSSE','IV','2018'),(67890,'Akram','BSSE','IV','2018'),(91827,'Kamran','BBA','II','2019');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'library_managment_system'
--

--
-- Dumping routines for database 'library_managment_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05 15:49:54
