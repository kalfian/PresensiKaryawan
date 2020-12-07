-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `m_hari_libur`;
CREATE TABLE `m_hari_libur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tanggal_libur` date NOT NULL,
  `keterangan` text NOT NULL,
  `create_by` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `m_hari_libur` (`id`, `tanggal_libur`, `keterangan`, `create_by`) VALUES
(4,	'2020-11-03',	'jancok',	1),
(8,	'2020-11-03',	'xcvxcvcxv',	1);

DROP TABLE IF EXISTS `m_jabatan`;
CREATE TABLE `m_jabatan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_jabatan` varchar(100) NOT NULL,
  `create_by` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `m_jabatan_fk0` (`create_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `m_jabatan` (`id`, `nama_jabatan`, `create_by`) VALUES
(5,	'Tech Support',	1),
(6,	'Kuli Online',	0),
(7,	'Managerial',	0);

DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `m_role` (`id`, `nama`) VALUES
(1,	'SuperAdmin'),
(2,	'Karyawan');

DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jenis_kelamin` tinyint(1) NOT NULL DEFAULT '0',
  `status` int NOT NULL DEFAULT '1',
  `jabatan_id` int NOT NULL,
  `create_by` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `m_user_fk0` (`jabatan_id`),
  KEY `m_user_fk1` (`create_by`),
  CONSTRAINT `m_user_fk0` FOREIGN KEY (`jabatan_id`) REFERENCES `m_jabatan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `m_user` (`id`, `nama`, `alamat`, `jenis_kelamin`, `status`, `jabatan_id`, `create_by`) VALUES
(4,	'Admin Ganteng',	'jl in ajas',	1,	1,	5,	1),
(23,	'tests',	'test',	1,	1,	6,	1),
(24,	'tessss',	'tessss',	1,	1,	5,	1);

DROP TABLE IF EXISTS `r_absensi`;
CREATE TABLE `r_absensi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `foto_masuk` varchar(150) NOT NULL,
  `foto_pulang` varchar(150) NOT NULL,
  `tanggal` date NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL,
  `keterangan` varchar(50) NOT NULL DEFAULT '-',
  PRIMARY KEY (`id`),
  KEY `r_absensi_fk0` (`user_id`),
  CONSTRAINT `r_absensi_fk0` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `r_login`;
CREATE TABLE `r_login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `r_login_fk0` (`user_id`),
  KEY `r_login_fk1` (`role`),
  CONSTRAINT `r_login_fk0` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`),
  CONSTRAINT `r_login_fk1` FOREIGN KEY (`role`) REFERENCES `m_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `r_login` (`id`, `user_id`, `email`, `password`, `role`) VALUES
(1,	4,	'admin@ta.com',	'21232f297a57a5a743894a0e4a801fc3',	1),
(9,	23,	'test@test.com',	'123',	2),
(10,	24,	'tessss@gmail.com',	'tessss',	2);

-- 2020-12-07 11:57:53
