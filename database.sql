/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.1.21-MariaDB : Database - dbsibem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbsibem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dbsibem`;

/*Table structure for table `jabatan` */

DROP TABLE IF EXISTS `jabatan`;

CREATE TABLE `jabatan` (
  `id_jabatan` bigint(20) NOT NULL AUTO_INCREMENT,
  `masa_jabatan` varchar(255) DEFAULT NULL,
  `nama_jabatan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_jabatan`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `jabatan` */

insert  into `jabatan`(`id_jabatan`,`masa_jabatan`,`nama_jabatan`) values 
(1,'2016/2017','Ketua BEM'),
(2,'2016/2017','Kadep Komunikasi dan Informasi'),
(3,'2016/2017','Bendahara BEM'),
(4,'2016/2017','Sekretaris BEM'),
(5,'2016/2017','Kadep Olahraga'),
(6,'2016/2017','Bendahara Kelas');

/*Table structure for table `laporan_keuangan` */

DROP TABLE IF EXISTS `laporan_keuangan`;

CREATE TABLE `laporan_keuangan` (
  `idlaporankeuangan` int(11) NOT NULL AUTO_INCREMENT,
  `deskripsi` varchar(255) DEFAULT NULL,
  `tanggal` varchar(255) DEFAULT NULL,
  `tipe_laporan` varchar(255) DEFAULT NULL,
  `total` bigint(20) NOT NULL,
  `id_pengurus` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlaporankeuangan`),
  KEY `FK1i6bwtwbkwbw52ymr5hmys50t` (`id_pengurus`),
  CONSTRAINT `FK1i6bwtwbkwbw52ymr5hmys50t` FOREIGN KEY (`id_pengurus`) REFERENCES `pengurus` (`id_pengurus`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `laporan_keuangan` */

insert  into `laporan_keuangan`(`idlaporankeuangan`,`deskripsi`,`tanggal`,`tipe_laporan`,`total`,`id_pengurus`) values 
(21,'Iuran Untuk Bulan Juli','Juli','Iuran',0,3),
(22,'Pengeluaran dari Proposal Lomba Makan Rumput','Juni','Pengeluaran Proposal',50000,2),
(23,'Iuran Untuk Bulan Juni','Juni','Iuran',0,3),
(24,'Pengeluaran dari Proposal Lomba Makan Batu','Juni','Pengeluaran Proposal',5000,2),
(25,'Pengeluaran dari Proposal Lomba Makan Rumput','Juni','Pengeluaran Proposal',50000,2),
(26,'Pengeluaran dari Proposal Lomba Makan Batu','Juni','Pengeluaran Proposal',50000,2),
(27,'Pengeluaran dari Proposal Proposal Lomba Makan Batu','Juni','Pengeluaran Proposal',500000,2),
(28,'Pengeluaran dari Proposal Proposal kompetisi','Juni','Pengeluaran Proposal',50000,2),
(29,'Laporan Iuran JUNI','Juni','Iuran',0,3);

/*Table structure for table `mahasiswa` */

DROP TABLE IF EXISTS `mahasiswa`;

CREATE TABLE `mahasiswa` (
  `nim` varchar(255) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `angkatan` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `jeniskelamin` varchar(255) DEFAULT NULL,
  `notlp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `tanggallahir` date DEFAULT NULL,
  PRIMARY KEY (`nim`),
  UNIQUE KEY `UK_ot06raqgyi8em91jwy5bfxjrj` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mahasiswa` */

insert  into `mahasiswa`(`nim`,`alamat`,`angkatan`,`email`,`foto`,`fullname`,`jeniskelamin`,`notlp`,`password`,`role`,`tanggallahir`) values 
('admin','admin',0,'admin@sibem.del.ac.id',NULL,'ADMINISTRATOR','','0','$2a$10$Ehfphj7ogeZKT4PoRTQ31.v9D6bA.nQ224ACQ3N2cHl5nWz/Gc636','ROLE_ADMIN','2017-06-05'),
('iss14010','Balige',2014,'iss14010@students.del.ac.id',NULL,'Sarah Tambunan','Perempuan','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_MAHASISWA','2017-06-01'),
('iss14022','Siborong-borong',2014,'iss14022@students.del.ac.id',NULL,'Vera Simanjuntak','Perempuan','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_BENDAHARA','2017-06-01'),
('iss14024','Sidikalang',2014,'iss14024@students.del.ac.id',NULL,'Cindy Simarmata','Laki-laki','081375050505','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_BEKEL','1996-05-05'),
('iss14029','Medan',2014,'iss14029@students.del.ac.id',NULL,'Josua Simanungkalit','Laki-laki','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_BEKEL','2017-06-01'),
('iss14036','Sibolga',2014,'iss14036@students.del.ac.id',NULL,'Daniel Samosir','Laki-laki','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_BEKEL','2017-06-04'),
('iss14044','Medan',2014,'iss14044@students.del.ac.id',NULL,'Fyona Panjaitan','Perempuan','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_KADEP','2017-06-05'),
('iss14055','Samosir',2014,'iss14055@students.del.ac.id',NULL,'Hottua Gultom','Laki-laki','0','$2a$10$07XuqP7FoVlppaSudbJL/u8/Qc.jxNzTbPBWrvXWHJhOgoVMJN2Pq','ROLE_KETUA','2017-06-06');

/*Table structure for table `pengumuman` */

DROP TABLE IF EXISTS `pengumuman`;

CREATE TABLE `pengumuman` (
  `id_pengumuman` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_expired` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `date_upload` datetime DEFAULT NULL,
  `deskripsi` longtext,
  `file` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `id_pengurus` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `viewer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengumuman`),
  KEY `FK9nv371202a236m8s2f4jfi2xs` (`id_pengurus`),
  CONSTRAINT `FK9nv371202a236m8s2f4jfi2xs` FOREIGN KEY (`id_pengurus`) REFERENCES `pengurus` (`id_pengurus`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `pengumuman` */

insert  into `pengumuman`(`id_pengumuman`,`date_expired`,`date_update`,`date_upload`,`deskripsi`,`file`,`judul`,`link`,`id_pengurus`,`status`,`viewer`) values 
(11,NULL,NULL,'2017-06-06 11:32:48','<p>Dear Students,.</p>\r\n<p>Diharapkan kehadirannya untuk mendengarkan sharing session, sumbangan pemikiran mengenai permasalahan di sekitar Toba Samosir dilihat dari sudut pandang berpikir sistem yang akan di adakan pada :</p>\r\n<p>Hari/Tanggal : Selasa, 6 Juni 2017</p>\r\n<p>Pukul : 14.00 - 17.00 WIB</p>\r\n<p>Tempat : Auditorium Institut Teknologi Del</p>\r\n<p>Kegiatan :<em> Sharing session</em> mengenai perilaku berkendaraan di Toba Samosir, Tingginya penderita HIV Aids, Fenomena Malaria, Transportasi di Toba Samosir dll.</p>\r\n<p>Sharing session ini akan disampaikan dalam bentuk acara yang <em>Fun</em> dan <em>Relax</em>, ditunggu kehadirannya. </p>\r\n<p>&nbsp;</p>\r\n<p>Salam,.</p>\r\n<p>&nbsp;</p>','','Sharing Session Berpikir Sistem ',NULL,3,NULL,0),
(12,NULL,NULL,'2017-06-06 12:37:35','<p>Keuangan Bulanan</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<ul>\r\n<li><strong></strong>harap diapply secepatnya</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>Jumlah Sekian</p>','','Keuangan BEM',NULL,2,NULL,0),
(13,NULL,NULL,'2017-06-06 13:35:26','<p>ikuti bersama</p>\r\n<p>sama</p>\r\n<p>sama</p>\r\n<p>sama</p>\r\n<p>sama</p>\r\n<p>sama</p>\r\n<p>&nbsp;</p>','Proposal Lomba Makan Batu.docx','Ikuti Bersama sama',NULL,3,NULL,0),
(14,NULL,NULL,'2017-06-06 14:41:06','<p>pengumuman</p>','ID-ISP-17-SI13.doc','Pengumuman',NULL,1,NULL,0);

/*Table structure for table `pengurus` */

DROP TABLE IF EXISTS `pengurus`;

CREATE TABLE `pengurus` (
  `id_pengurus` int(11) NOT NULL AUTO_INCREMENT,
  `id_jabatan` bigint(20) DEFAULT NULL,
  `nim` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pengurus`),
  KEY `FK9s2g8si3kq1e82jg85vtup3nh` (`id_jabatan`),
  KEY `FKsajnk2dqqhn9gaar7t3n0dg9u` (`nim`),
  CONSTRAINT `FK9s2g8si3kq1e82jg85vtup3nh` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`),
  CONSTRAINT `FKsajnk2dqqhn9gaar7t3n0dg9u` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `pengurus` */

insert  into `pengurus`(`id_pengurus`,`id_jabatan`,`nim`) values 
(1,1,'iss14055'),
(2,2,'iss14044'),
(3,3,'iss14022'),
(4,4,'iss14024');

/*Table structure for table `prodi` */

DROP TABLE IF EXISTS `prodi`;

CREATE TABLE `prodi` (
  `id_prodi` varchar(255) NOT NULL,
  `jumlah_anggota` int(11) DEFAULT NULL,
  `nama_prodi` varchar(255) DEFAULT NULL,
  `nim` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_prodi`),
  KEY `FKgvu13541cb34rcp77ov5u050b` (`nim`),
  CONSTRAINT `FKgvu13541cb34rcp77ov5u050b` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `prodi` */

insert  into `prodi`(`id_prodi`,`jumlah_anggota`,`nama_prodi`,`nim`) values 
('ifs14',20,'Teknik Informatika 2014','iss14036'),
('ifs15',50,'Teknik Infromatika 2015','iss14024'),
('iss14',30,'Sistem Informasi 2014','iss14029'),
('iss15',56,'Sistem Informasi 2015','iss14044');

/*Table structure for table `programkerja` */

DROP TABLE IF EXISTS `programkerja`;

CREATE TABLE `programkerja` (
  `idprogramkerja` int(11) NOT NULL AUTO_INCREMENT,
  `date_upload` varchar(255) DEFAULT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `id_organisasi` varchar(255) DEFAULT NULL,
  `jenis_program_kerja` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `id_pengurus` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprogramkerja`),
  KEY `FKldraea5da6bce1hsdwdi0fcow` (`id_pengurus`),
  CONSTRAINT `FKldraea5da6bce1hsdwdi0fcow` FOREIGN KEY (`id_pengurus`) REFERENCES `pengurus` (`id_pengurus`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `programkerja` */

insert  into `programkerja`(`idprogramkerja`,`date_upload`,`deskripsi`,`id_organisasi`,`jenis_program_kerja`,`judul`,`id_pengurus`) values 
(2,'2017-06-05','ini ini ini ini ini ini',NULL,'Rutin','Lomba Makan Batu',2),
(3,'2017-06-06','Lomban ini mengandung makanan dari pasir yang dikompetisikan untuk dimakan',NULL,'Rutin','Lomba Makan Pasir Toba Fest',2),
(4,'2017-06-06','Lomban ini mengandung makanan dari rumput yang dikompetisikan untuk dimakan',NULL,'Non Rutin','Lomba Makan Rumput',2),
(5,'2017-06-06','Lomban ini mengandung makanan dari rumput yang dikompetisikan untuk dimakan',NULL,'Rutin','Lomba Makan Batu',2),
(6,'2017-06-06','kompetisi',NULL,'Rutin','Kompetisi',2);

/*Table structure for table `proposal` */

DROP TABLE IF EXISTS `proposal`;

CREATE TABLE `proposal` (
  `idproposal` int(11) NOT NULL AUTO_INCREMENT,
  `date_upload` varchar(255) DEFAULT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_dana` int(11) DEFAULT NULL,
  `id_program_kerja` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproposal`),
  KEY `FK3xtia7k79khhjpjq39t924p1p` (`id_program_kerja`),
  CONSTRAINT `FK3xtia7k79khhjpjq39t924p1p` FOREIGN KEY (`id_program_kerja`) REFERENCES `programkerja` (`idprogramkerja`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `proposal` */

insert  into `proposal`(`idproposal`,`date_upload`,`deskripsi`,`file`,`judul`,`status`,`total_dana`,`id_program_kerja`) values 
(1,'2017-06-05','Lomban ini mengandung makanan dari batu yang di','SistemInformasi_12S14029_Josua Simanungkalit.docx','Lomba Makan Batu','Request',5000,2),
(2,'2017-06-05','Lomban ini mengandung makanan dari rumput yang dikompetisikan untuk dimakan','SistemInformasi_12S14029_Josua Simanungkalit.docx','Lomba Makan Rumput','Accepted',50000,2),
(3,'2017-06-06','Lomban ini mengandung makanan dari pasir yang dikompetisikan untuk dimakan','SistemInformasi_12S14029_Josua Simanungkalit.docx','Lomba Makan Pasir Toba Fest','Request',60000,3),
(4,'2017-06-06','Lomban ini mengandung makanan dari batu yang di','SistemInformasi_12S14029_Josua Simanungkalit.docx','Lomba Makan Batu','Accepted',50000,2),
(5,'2017-06-06','Lomban ini mengandung makanan dari rumput yang dikompetisikan untuk dimakan','SistemInformasi_12S14029_Josua Simanungkalit.docx','Lomba Makan Rumput','Request',60000,4),
(6,'2017-06-06','Lomban ini mengandung makanan dari rumputyang dikompetisikan untuk dimakan','Proposal.docx','Lomba Makan Kayu','Request',60000,2),
(7,'2017-06-06','Lomban ini mengandung makanan dari batu yang dikompetisikan untuk dimakan','Proposal Lomba Makan Batu.docx','Proposal Lomba Makan Batu','Accepted',500000,2),
(8,'2017-06-06','kompetisi','Proposal Lomba.docx','Proposal kompetisi','Accepted',50000,6);

/*Table structure for table `saldo` */

DROP TABLE IF EXISTS `saldo`;

CREATE TABLE `saldo` (
  `id_saldo` int(11) NOT NULL AUTO_INCREMENT,
  `pemasukan` float DEFAULT NULL,
  `pengeluaran` float DEFAULT NULL,
  `tanggal_masuk` varchar(255) DEFAULT NULL,
  `total_saldo` float DEFAULT NULL,
  `idlaporanpengeluaran` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_saldo`),
  KEY `FKmflhw36t86jer1mct2v7v6q33` (`idlaporanpengeluaran`),
  CONSTRAINT `FKmflhw36t86jer1mct2v7v6q33` FOREIGN KEY (`idlaporanpengeluaran`) REFERENCES `laporan_keuangan` (`idlaporankeuangan`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `saldo` */

insert  into `saldo`(`id_saldo`,`pemasukan`,`pengeluaran`,`tanggal_masuk`,`total_saldo`,`idlaporanpengeluaran`) values 
(1,150000,0,'2017-06-05',150000,21),
(2,150000,0,'2017-06-05',300000,21),
(3,0,50000,'2017-06-05',250000,22),
(4,180000,0,'2017-06-05',430000,23),
(5,150000,0,'2017-06-05',580000,21),
(6,0,5000,'2017-06-05',575000,24),
(7,0,50000,'2017-06-06',525000,25),
(8,0,50000,'2017-06-06',475000,26),
(9,150000,0,'2017-06-06',625000,21),
(10,0,500000,'2017-06-06',125000,27),
(11,280000,0,'2017-06-06',405000,21),
(12,0,50000,'2017-06-06',355000,28),
(13,300000,0,'2017-06-06',655000,29);

/*Table structure for table `strukturorganisasibem` */

DROP TABLE IF EXISTS `strukturorganisasibem`;

CREATE TABLE `strukturorganisasibem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deskripsi` varchar(255) DEFAULT NULL,
  `id_struktur_organisasibem` varchar(255) NOT NULL,
  `nama_struktur` varchar(255) DEFAULT NULL,
  `tanggal_dibentuk` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kv5pqkinbcxvxu00l8cifmj1p` (`id_struktur_organisasibem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `strukturorganisasibem` */

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `bulan` varchar(255) DEFAULT NULL,
  `dibayarkan` int(11) NOT NULL,
  `iuran` int(11) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_iuran` int(11) NOT NULL,
  `id_laporan_keuangan` int(11) DEFAULT NULL,
  `id_prodi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `FKk0tbwce2qw0q5saoxctu2jm89` (`id_laporan_keuangan`),
  KEY `FKbx35inn1c7a6so1b5kahm8828` (`id_prodi`),
  CONSTRAINT `FKbx35inn1c7a6so1b5kahm8828` FOREIGN KEY (`id_prodi`) REFERENCES `prodi` (`id_prodi`),
  CONSTRAINT `FKk0tbwce2qw0q5saoxctu2jm89` FOREIGN KEY (`id_laporan_keuangan`) REFERENCES `laporan_keuangan` (`idlaporankeuangan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `transaksi` */

insert  into `transaksi`(`id_transaksi`,`bulan`,`dibayarkan`,`iuran`,`komentar`,`status`,`total_iuran`,`id_laporan_keuangan`,`id_prodi`) values 
(1,'Juli',150000,5000,'Cepat','Waiting',150000,21,'iss14'),
(2,'Juli',120000,6000,'Cepat','Waiting',120000,21,'ifs14'),
(3,'Juni',0,5000,'Cepat','Request',100000,23,'ifs14'),
(4,'Juni',180000,6000,'Cepat','Accepted',180000,23,'iss14'),
(5,'Juli',150000,5000,'Cepat','Accepted',150000,21,'iss14'),
(6,'Juli',0,5000,'Cepat','Accepted',280000,21,'iss15'),
(7,'Juni',0,5000,'Cepat','Request',280000,29,'iss15'),
(8,'Juni',300000,6000,'Cepat','Accepted',300000,29,'ifs15'),
(9,'Juli',0,0,'','Request',0,21,'ifs14'),
(10,'Juli',0,0,'','Request',0,21,'ifs15');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
