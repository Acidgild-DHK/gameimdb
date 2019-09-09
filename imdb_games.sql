-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: imdb_games
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `average_rating` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ESRB` varchar(255) DEFAULT NULL,
  `game_name` varchar(255) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `user_count` int(11) NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,3,'blah','M','Some game','FPS','Some publisher','2019-10-14 00:00:00',1),(2,1,NULL,NULL,'other game',NULL,NULL,NULL,1),(3,1,NULL,NULL,'Assassin\'s Creed Infinity',NULL,NULL,NULL,1),(4,0,'So not real that it seems real.','M','Not Real','RPG','Not Real Games','2019-10-12 00:00:00',0),(5,0,'Game sequel before the first game.','E','Some Game2','FPS','Games Games','2010-01-20 00:00:00',0),(6,1,'blah blah blah','E','blah','RPG','Not Real Games','2019-10-13 00:00:00',1);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games_platforms`
--

DROP TABLE IF EXISTS `games_platforms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games_platforms` (
  `game_id` int(11) NOT NULL,
  `platform_id` int(11) NOT NULL,
  PRIMARY KEY (`game_id`,`platform_id`),
  KEY `FK4x2bpl7ph6rumr0n25gjslps8` (`platform_id`) /*!80000 INVISIBLE */
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_platforms`
--

LOCK TABLES `games_platforms` WRITE;
/*!40000 ALTER TABLE `games_platforms` DISABLE KEYS */;
INSERT INTO `games_platforms` VALUES (1,1),(2,2),(3,2),(6,1);
/*!40000 ALTER TABLE `games_platforms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `log_id` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `game_id` int(11) NOT NULL,
  `platform_id` int(11) NOT NULL,
  `time_played` int(11) NOT NULL,
  `rating` decimal(10,0) NOT NULL,
  `review_text` text,
  PRIMARY KEY (`log_id`),
  KEY `LOG_USERNAME_idx` (`username`),
  KEY `FK_LOG_GAME_idx` (`game_id`),
  KEY `FK_LOG_PLATFORM_idx` (`platform_id`),
  CONSTRAINT `FK_LOG_PLATFORM` FOREIGN KEY (`platform_id`) REFERENCES `platforms` (`platform_id`),
  CONSTRAINT `FK_LOG_USER` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES ('kurwhibble:1','kurwhibble',1,1,24,3,'some game...'),('kurwhibble:2','kurwhibble',2,1,54,1,'Hello'),('kurwhibble:3','kurwhibble',3,1,153,1,'Best Game Ever'),('kurwhibble:6','kurwhibble',6,1,24,1,'blah blah');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platforms`
--

DROP TABLE IF EXISTS `platforms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platforms` (
  `platform_id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(45) NOT NULL,
  PRIMARY KEY (`platform_id`),
  UNIQUE KEY `platform_id_UNIQUE` (`platform_id`),
  UNIQUE KEY `name_UNIQUE` (`platform_name`),
  UNIQUE KEY `UK_22h7knjjouhcr8xa2n3i60mhp` (`platform_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platforms`
--

LOCK TABLES `platforms` WRITE;
/*!40000 ALTER TABLE `platforms` DISABLE KEYS */;
INSERT INTO `platforms` VALUES (3,'console'),(1,'mobile'),(2,'pc');
/*!40000 ALTER TABLE `platforms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varbinary(255) NOT NULL,
  `question` varchar(45) NOT NULL,
  `answer` varbinary(255) NOT NULL,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gamertag` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `my_key` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('karissa',_binary '•w/\ÁÑg\∆\–Û*Û9Ñ“Æy','',_binary '\¬\ƒE\‚v\√W\’˙`ı¨Üı\ÿ','','kar','kar2',21,'SecretKey'),('karissa2',_binary '•w/\ÁÑg\∆\–Û*Û9Ñ“Æy','',_binary '\¬\ƒE\‚v\√W\’˙`ı¨Üı\ÿ','','sa','kar',12,'SecretKey'),('kurwhibble',_binary ';U\Îr,ç˘≥\›ˆ)','what',_binary ';U\Îr,ç˘≥\›ˆ)','someemail@email.com','kari','kurwhibble',26,'SecretKey');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 15:55:33
