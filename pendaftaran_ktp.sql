-- Adminer 4.7.3 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `agama`;
CREATE TABLE `agama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `agama` (`id`, `agama`) VALUES
(1,	'Islam'),
(2,	'Kristen'),
(3,	'Katholik'),
(4,	'Hindu'),
(5,	'Budha');

DROP TABLE IF EXISTS `kecamatan`;
CREATE TABLE `kecamatan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kecamatan` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `kecamatan` (`id`, `kecamatan`) VALUES
(1,	'KEDUNGKANDANG'),
(2,	'SUKUN'),
(3,	'KLOJEN'),
(4,	'BLIMBING'),
(5,	'LOWOKWARU');

DROP TABLE IF EXISTS `kelurahan`;
CREATE TABLE `kelurahan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kecamatan_id` int(11) NOT NULL,
  `kelurahan` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `kelurahan` (`id`, `kecamatan_id`, `kelurahan`) VALUES
(1,	1,	'ARJOWINANGUN'),
(2,	1,	'TLOGOWARU'),
(3,	1,	'WONOKOYO'),
(4,	1,	'BUMIAYU'),
(5,	1,	'BURING'),
(6,	1,	'MERGOSONO'),
(7,	1,	'KOTALAMA'),
(8,	1,	'KEDUNGKANDANG'),
(9,	1,	'SAWOJAJAR'),
(10,	1,	'MADYOPURO'),
(11,	1,	'LESANPURO'),
(12,	1,	'CEMOROKANDANG'),
(16,	2,	'KEBONSARI'),
(17,	2,	'GADANG'),
(18,	2,	'CIPTOMULYO'),
(19,	2,	'BANDUNGREJOSARI'),
(20,	2,	'BAKALAN KRAJAN'),
(21,	2,	'MULYOREJO'),
(22,	2,	'BANDULAN'),
(23,	2,	'TANJUNGREJO'),
(24,	2,	'PISANG CANDI'),
(25,	2,	'KARANG BESUKI'),
(31,	3,	'KASIN'),
(32,	3,	'SUKOHARJO'),
(33,	3,	'KIDUL DALEM'),
(34,	3,	'KAUMAN'),
(35,	3,	'BARENG'),
(36,	3,	'GADINGKASRI'),
(37,	3,	'ORO ORO DOWO'),
(38,	3,	'KLOJEN'),
(39,	3,	'RAMPAL CELAKET'),
(40,	3,	'SAMAAN'),
(41,	3,	'PENANGGUNGAN'),
(46,	4,	'JODIPAN'),
(47,	4,	'POLEHAN'),
(48,	4,	'KESATRIAN'),
(49,	4,	'BUNULREJO'),
(50,	4,	'PURWANTORO'),
(51,	4,	'PANDANWANGI'),
(52,	4,	'BLIMBING'),
(53,	4,	'PURWODADI'),
(54,	4,	'POLOWIJEN'),
(55,	4,	'ARJOSARI'),
(56,	4,	'BALEARJOSARI'),
(61,	5,	'MERJOSARI'),
(62,	5,	'DINOYO'),
(63,	5,	'SUMBERSARI'),
(64,	5,	'KETAWANGGEDE'),
(65,	5,	'JATIMULYO'),
(66,	5,	'LOWOKWARU'),
(67,	5,	'TULUSREJO'),
(68,	5,	'MOJOLANGU'),
(69,	5,	'TUNJUNGSEKAR'),
(70,	5,	'TASIKMADU'),
(71,	5,	'TLOGOMAS');

DROP TABLE IF EXISTS `pendaftaran`;
CREATE TABLE `pendaftaran` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_kelurahan` int(11) NOT NULL,
  `id_agama` int(11) NOT NULL,
  `kode_pendaftaran` int(11) NOT NULL,
  `nkk` varchar(100) DEFAULT NULL,
  `nama` varchar(200) NOT NULL,
  `tempat_lahir` varchar(200) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `status_perkawinan` enum('kawin','belum kawin','cerai') NOT NULL,
  `pekerjaan` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `kewarganegaraan` enum('WNI','WNA') NOT NULL,
  `image` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_kelurahan` (`id_kelurahan`),
  KEY `id_agama` (`id_agama`),
  CONSTRAINT `pendaftaran_ibfk_1` FOREIGN KEY (`id_kelurahan`) REFERENCES `kelurahan` (`id`),
  CONSTRAINT `pendaftaran_ibfk_2` FOREIGN KEY (`id_agama`) REFERENCES `kelurahan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `pendaftaran` (`id`, `id_kelurahan`, `id_agama`, `kode_pendaftaran`, `nkk`, `nama`, `tempat_lahir`, `tanggal_lahir`, `status_perkawinan`, `pekerjaan`, `alamat`, `kewarganegaraan`, `image`) VALUES
(7,	1,	1,	17611,	'23424234',	'asdasd',	'asdasd',	'2000-01-01',	'kawin',	'asdasd',	'asdasdsad',	'WNI',	'./src/pendaftaran/ktp/img/capture/capture-1595344930975.jpg');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`id`, `name`, `username`, `password`, `last_login`) VALUES
(1,	'Admin Utama',	'admin',	'21232f297a57a5a743894a0e4a801fc3',	'2020-07-20 19:44:42');

-- 2020-07-21 15:34:04
