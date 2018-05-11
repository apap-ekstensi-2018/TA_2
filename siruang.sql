-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: siruang
-- ------------------------------------------------------
-- Server version 5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `peminjaman_ruangan`
--

DROP TABLE IF EXISTS `peminjaman_ruangan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peminjaman_ruangan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_ruang` int(11) unsigned NOT NULL,
  `id_mahasiswa` int(11) NOT NULL,
  `waktu_mulai` time NOT NULL,
  `waktu_selesai` time NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `tujuan` varchar(255) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `jumlah_peserta` int(11) NOT NULL,
  `fasilitas` varchar(255) NOT NULL,
  `is_disetujui` tinyint(1) DEFAULT NULL,
  `disetujui_oleh` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ruang_idx` (`id_ruang`),
  KEY `id_mahasiswa_idx` (`id_mahasiswa`),
  KEY `tanggal_mulai_idx` (`waktu_mulai`,`tanggal_mulai`),
  KEY `tanggal_selesai_idx` (`waktu_selesai`,`tanggal_selesai`),
  KEY `is_disetujui_idx` (`is_disetujui`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peminjaman_ruangan`
--

LOCK TABLES `peminjaman_ruangan` WRITE;
/*!40000 ALTER TABLE `peminjaman_ruangan` DISABLE KEYS */;
INSERT INTO `peminjaman_ruangan` VALUES (1,3,1,'15:00:00','15:00:00','2018-05-10','2018-05-12','main dota','main dota',100,'laptop',1,NULL),(2,4,1,'21:46:32','21:46:36','2018-05-14','2018-05-16','main dota','main dota',100,'laptop',1,NULL),(4,3,1,'02:44:46','02:45:46','2018-05-17','2018-05-18','main dota','main dota',100,'laptop',NULL,NULL);
/*!40000 ALTER TABLE `peminjaman_ruangan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruang`
--

DROP TABLE IF EXISTS `ruang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruang` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `kapasitas` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruang`
--

LOCK TABLES `ruang` WRITE;
/*!40000 ALTER TABLE `ruang` DISABLE KEYS */;
INSERT INTO `ruang` VALUES (3,'110540',65),(4,'1103',40),(5,'R1105',123),(6,'R11209',1234),(11,'R2214',100);
/*!40000 ALTER TABLE `ruang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `enabled_idx` (`enabled`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('1290578781','password','ROLE_STAF',1),('1290578783','password','ROLE_DOSEN',1),('1290578785','password','ROLE_DOSEN',1),('1290578787','password','ROLE_DOSEN',1),('1290578789','password','ROLE_DOSEN',1),('1290578791','password','ROLE_DOSEN',1),('1290578793','password','ROLE_DOSEN',1),('1290578795','password','ROLE_DOSEN',1),('1290578797','password','ROLE_DOSEN',1),('1290578799','password','ROLE_DOSEN',1),('1290578801','password','ROLE_DOSEN',1),('1290578803','password','ROLE_DOSEN',1),('1290578805','password','ROLE_DOSEN',1),('1290578807','password','ROLE_DOSEN',1),('1290578809','password','ROLE_DOSEN',1),('1290578811','password','ROLE_DOSEN',1),('1290578813','password','ROLE_DOSEN',1),('1290578815','password','ROLE_DOSEN',1),('1290578817','password','ROLE_DOSEN',1),('1290578819','password','ROLE_DOSEN',1),('1290578821','password','ROLE_DOSEN',1),('1290578823','password','ROLE_DOSEN',1),('1290578825','password','ROLE_DOSEN',1),('1290578827','password','ROLE_DOSEN',1),('1290578829','password','ROLE_DOSEN',1),('1290578831','password','ROLE_DOSEN',1),('1290578833','password','ROLE_DOSEN',1),('1290578835','password','ROLE_DOSEN',1),('1290578837','password','ROLE_DOSEN',1),('1290578839','password','ROLE_DOSEN',1),('1290578841','password','ROLE_DOSEN',1),('1290578843','password','ROLE_DOSEN',1),('1290578845','password','ROLE_DOSEN',1),('1290578897','password','ROLE_DOSEN',1),('1406575815','password','ROLE_STAF',1),('1506689692','password','ROLE_STAF',1),('1506721756','password','ROLE_MAHASISWA',1),('1506721762','password','ROLE_MAHASISWA',1),('1506721775','password','ROLE_MAHASISWA',1),('1506721781','password','ROLE_MAHASISWA',1),('1506721794','password','ROLE_MAHASISWA',1),('1506721806','password','ROLE_MAHASISWA',1),('1506721812','password','ROLE_MAHASISWA',1),('1506721825','password','ROLE_MAHASISWA',1),('1506721831','password','ROLE_MAHASISWA',1),('1506721844','password','ROLE_MAHASISWA',1),('1506721863','password','ROLE_MAHASISWA',1),('1506721876','password','ROLE_MAHASISWA',1),('1506721882','password','ROLE_MAHASISWA',1),('1506721895','password','ROLE_MAHASISWA',1),('1506721900','password','ROLE_MAHASISWA',1),('1506723231','password','ROLE_STAF',1),('1506737823','password','ROLE_STAF',1),('1506757642','password','ROLE_MAHASISWA',1),('1506757655','password','ROLE_MAHASISWA',1),('1506757661','password','ROLE_MAHASISWA',1),('1506757680','password','ROLE_MAHASISWA',1),('1506757693','password','ROLE_MAHASISWA',1),('admin','admin','ROLE_STAF',1),('user','user','ROLE_MAHASISWA',1);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11  2:51:28
