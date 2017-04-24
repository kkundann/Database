-- Assignment 2B Question 2 & 3
-- Prepared by Randy PatanasakPinyo (raterko@iastate.edu)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `SID` int(11) NOT NULL,
  `SNAME` varchar(45) DEFAULT NULL,
  `SGENDER` varchar(45) DEFAULT NULL,
  `SAGE` varchar(45) DEFAULT NULL,
  `SMAJOR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'John','M','20','COMS'),(2,'Mike','M','18','ECPE'),(3,'Amy','F','22','CHEM'),(4,'Becky','F','19','MIS'),(5,'Seth','M','18','COMS');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `GID` int(11) NOT NULL,
  `GNAME` varchar(45) DEFAULT NULL,
  `GGENRE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'LOL','MOBA'),(2,'DOTA2','MOBA'),(3,'GTA','Action'),(4,'WOW','RPG');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport` (
  `SPID` int(11) NOT NULL,
  `SPNAME` varchar(45) DEFAULT NULL,
  `SPTYPE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` VALUES (1,'Football','Team'),(2,'Basketball','Team'),(3,'Wrestling','Individual');
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_game`
--

DROP TABLE IF EXISTS `play_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play_game` (
  `SID` int(11) NOT NULL,
  `GID` int(11) NOT NULL,
  `PLATFORM` varchar(45) DEFAULT NULL,
  `TOTALHOUR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SID`,`GID`),
  KEY `FK04_idx` (`GID`),
  CONSTRAINT `FK03` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK04` FOREIGN KEY (`GID`) REFERENCES `game` (`GID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_game`
--

LOCK TABLES `play_game` WRITE;
/*!40000 ALTER TABLE `play_game` DISABLE KEYS */;
INSERT INTO `play_game` VALUES (1,1,'PC','200'),(1,3,'PC','100'),(1,4,'PC','150'),(2,2,'PC','75'),(2,3,'XBOX1','80'),(2,4,'PC','50'),(5,1,'PC','500'),(5,2,'PC','450'),(5,3,'PS4','600'),(5,4,'PC','450');
/*!40000 ALTER TABLE `play_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_sport`
--

DROP TABLE IF EXISTS `play_sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play_sport` (
  `SID` int(11) NOT NULL,
  `SPID` int(11) NOT NULL,
  `TOTALHOUR` varchar(45) DEFAULT NULL,
  `LEVEL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SID`,`SPID`),
  KEY `FK02_idx` (`SPID`),
  CONSTRAINT `FK01` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK02` FOREIGN KEY (`SPID`) REFERENCES `sport` (`SPID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_sport`
--

LOCK TABLES `play_sport` WRITE;
/*!40000 ALTER TABLE `play_sport` DISABLE KEYS */;
INSERT INTO `play_sport` VALUES (1,1,'100','Beginner'),(1,3,'550','Pro'),(2,1,'25','Beginner'),(2,2,'50','Beginner'),(2,3,'400','Pro'),(3,2,'300','Pro'),(4,1,'30','Beginner'),(4,2,'40','Beginner');
/*!40000 ALTER TABLE `play_sport` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
