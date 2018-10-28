-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: dbAracAlisSatis
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `Tbl_Araba`
--

DROP TABLE IF EXISTS `Tbl_Araba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_Araba` (
  `ArabaID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Araba_Marka` varchar(50) NOT NULL,
  `Araba_Model` varchar(50) NOT NULL,
  `Araba_VitesTuruID` int(5) unsigned DEFAULT NULL,
  `Araba_YakitTuruID` int(5) unsigned DEFAULT NULL,
  `Araba_RenkID` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`ArabaID`),
  KEY `Araba_VitesTuruID` (`Araba_VitesTuruID`),
  KEY `Araba_YakitTuruID` (`Araba_YakitTuruID`),
  KEY `Araba_RenkID` (`Araba_RenkID`),
  CONSTRAINT `Tbl_Araba_ibfk_1` FOREIGN KEY (`Araba_VitesTuruID`) REFERENCES `Tbl_VitesTuru` (`VitesTuruID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Tbl_Araba_ibfk_2` FOREIGN KEY (`Araba_YakitTuruID`) REFERENCES `Tbl_YakitTuru` (`YakitTuruID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Tbl_Araba_ibfk_3` FOREIGN KEY (`Araba_RenkID`) REFERENCES `Tbl_Renk` (`RenkID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_Araba`
--

LOCK TABLES `Tbl_Araba` WRITE;
/*!40000 ALTER TABLE `Tbl_Araba` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_Araba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tbl_Ilan`
--

DROP TABLE IF EXISTS `Tbl_Ilan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_Ilan` (
  `IlanID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Ilan_Adi` varchar(50) NOT NULL,
  `Ilan_Fiyat` double(40,2) NOT NULL,
  `Ilan_Km` double(40,2) NOT NULL,
  `Ilan_Tarih` date NOT NULL,
  `Ilan_ArabaID` int(5) unsigned DEFAULT NULL,
  `Ilan_SehirID` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`IlanID`),
  KEY `Ilan_ArabaID` (`Ilan_ArabaID`),
  KEY `Ilan_SehirID` (`Ilan_SehirID`),
  CONSTRAINT `Tbl_Ilan_ibfk_1` FOREIGN KEY (`Ilan_ArabaID`) REFERENCES `Tbl_Araba` (`ArabaID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Tbl_Ilan_ibfk_2` FOREIGN KEY (`Ilan_SehirID`) REFERENCES `Tbl_Sehir` (`SehirID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_Ilan`
--

LOCK TABLES `Tbl_Ilan` WRITE;
/*!40000 ALTER TABLE `Tbl_Ilan` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_Ilan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tbl_Renk`
--

DROP TABLE IF EXISTS `Tbl_Renk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_Renk` (
  `RenkID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Renk` varchar(50) NOT NULL,
  PRIMARY KEY (`RenkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_Renk`
--

LOCK TABLES `Tbl_Renk` WRITE;
/*!40000 ALTER TABLE `Tbl_Renk` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_Renk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tbl_Sehir`
--

DROP TABLE IF EXISTS `Tbl_Sehir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_Sehir` (
  `SehirID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Sehir` varchar(50) NOT NULL,
  PRIMARY KEY (`SehirID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_Sehir`
--

LOCK TABLES `Tbl_Sehir` WRITE;
/*!40000 ALTER TABLE `Tbl_Sehir` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_Sehir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tbl_VitesTuru`
--

DROP TABLE IF EXISTS `Tbl_VitesTuru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_VitesTuru` (
  `VitesTuruID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Vites_Turu` varchar(50) NOT NULL,
  PRIMARY KEY (`VitesTuruID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_VitesTuru`
--

LOCK TABLES `Tbl_VitesTuru` WRITE;
/*!40000 ALTER TABLE `Tbl_VitesTuru` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_VitesTuru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tbl_YakitTuru`
--

DROP TABLE IF EXISTS `Tbl_YakitTuru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tbl_YakitTuru` (
  `YakitTuruID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Yakit_Turu` varchar(50) NOT NULL,
  PRIMARY KEY (`YakitTuruID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tbl_YakitTuru`
--

LOCK TABLES `Tbl_YakitTuru` WRITE;
/*!40000 ALTER TABLE `Tbl_YakitTuru` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tbl_YakitTuru` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-06  0:42:56
