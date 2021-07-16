-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2020 at 10:02 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `programkerja`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `NPP` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `NAMA_DOSEN` varchar(45) DEFAULT NULL,
  `TTL_DOSEN` varchar(45) DEFAULT NULL,
  `JK_DOSEN` varchar(45) DEFAULT NULL,
  `AGAMA_DOSEN` varchar(45) DEFAULT NULL,
  `ALAMAT_DOSEN` varchar(45) DEFAULT NULL,
  `EMAIL_DOSEN` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`NPP`, `ID_USER`, `NAMA_DOSEN`, `TTL_DOSEN`, `JK_DOSEN`, `AGAMA_DOSEN`, `ALAMAT_DOSEN`, `EMAIL_DOSEN`) VALUES
(21833018, 2, 'Muhammad Hafizh Azzasafah', 'Surabaya,2001-08-04', 'laki-laki', 'Islam', 'jombang oke', 'azza@gmail.com'),
(21833019, 1, 'Hana Ai Ardiana', 'Bandung,2000-05-12', 'perempuan', 'Islam', 'Plandi oke', 'hanaai@gmail.com'),
(21833020, 3, 'Maria Mardhatillah Maslehah', 'Jombang,2001-02-06', 'perempuan', 'Islam', 'jombang', 'mariaa@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `NIDN` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `NAMA_JABATAN` varchar(45) DEFAULT NULL,
  `MASA_JABATAN` varchar(45) DEFAULT NULL,
  `Periode` varchar(45) DEFAULT NULL,
  `STATUS_JABATAN` varchar(45) DEFAULT NULL,
  `AWAL_JABATAN` int(45) DEFAULT NULL,
  `AKHIR_JABATAN` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`NIDN`, `ID_USER`, `NAMA_JABATAN`, `MASA_JABATAN`, `Periode`, `STATUS_JABATAN`, `AWAL_JABATAN`, `AKHIR_JABATAN`) VALUES
(22833018, 2, 'wakil Dekan', '4 tahun', '2019/2020', 'aktif', 2020, 2023),
(22833019, 1, 'kaprodi', '4 tahun', '2019/2020', 'aktif', 2020, 2024),
(22833020, 3, 'Dekan', '4 tahun', '2019/2020', 'aktif', 2020, 2024);

--
-- Triggers `jabatan`
--
DELIMITER $$
CREATE TRIGGER `riwayat_jabatan` BEFORE UPDATE ON `jabatan` FOR EACH ROW BEGIN
    INSERT INTO riwayat_jabatan
	set NIDN = OLD.NIDN,
    NAMA_JABATAN_after = new.nama_jabatan,
    NAMA_JABATAN_before = old.nama_jabatan,
	STATUS_JABATAN_after = new.STATUS_JABATAN,
    STATUS_JABATAN_before = old.Status_jabatan,
    Periode_after = new.periode,
    Periode_before = old.periode;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `proker`
--

CREATE TABLE `proker` (
  `ID_PROKER` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT 1,
  `DOSEN_PENANGGUNG` varchar(45) DEFAULT NULL,
  `PERIODE_PROKER` varchar(45) DEFAULT NULL,
  `REVISI_PROKER` varchar(45) DEFAULT NULL,
  `URAIAN_PROKER` varchar(45) DEFAULT NULL,
  `STATUS_WADEK` varchar(45) DEFAULT NULL,
  `STATUS_DEKAN` varchar(45) DEFAULT NULL,
  `ANGGARAN_DANA` varchar(45) DEFAULT NULL,
  `TGLPERENCANAAN` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proker`
--

INSERT INTO `proker` (`ID_PROKER`, `ID_USER`, `DOSEN_PENANGGUNG`, `PERIODE_PROKER`, `REVISI_PROKER`, `URAIAN_PROKER`, `STATUS_WADEK`, `STATUS_DEKAN`, `ANGGARAN_DANA`, `TGLPERENCANAAN`) VALUES
(1, 1, 'Hana Ai Ardiana', '2015/2016', 'Belum', 'Masukkan Data Proker', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-02'),
(2, 2, 'Karina Anggia', '2015/2016', 'sudah', 'Masukkan Data Proker', 'Tidak Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-02'),
(3, 2, 'Indah Dwi Setyawati', '2017/2018', NULL, 'Masukkan Data Proker	', NULL, NULL, 'Rp 87.000.000', '2020-01-03'),
(4, 3, 'Camelia Mars', '2015/2016', NULL, 'Masukkan Data Proker', NULL, NULL, 'Rp 59.000.000', '2020-01-04'),
(6, 1, 'aku', '2015/2016', NULL, 'Masukkan Data Proker', NULL, NULL, 'Rp 90.000.000', '2020-01-10'),
(7, 1, 'aku', '2016/2017', NULL, 'Masukkan Data Proker', NULL, NULL, 'Rp 90.000.000', '2020-01-03'),
(10, NULL, 'karina Angggia', '2020/2021', 'sudah', 'hmm', 'belum setuju', 'setuju', 'setuju', '2020-08-09');

--
-- Triggers `proker`
--
DELIMITER $$
CREATE TRIGGER `riwayat_proker` BEFORE UPDATE ON `proker` FOR EACH ROW BEGIN
    INSERT INTO riwayat_proker
	set ID_PROKER = OLD.ID_PROKER, 
	Dosen_penanggung=old.DOSEN_PENANGGUNG, 
	Uraian_proker=old.URAIAN_PROKER,
	Periode_proker=old.periode_proker,
	Revisi_after=new.Revisi_proker,
	Revisi_before=old.Revisi_proker,
	Status_wadek_after=new.STATUS_WADEK,
	Status_wadek_before=old.STATUS_WADEK,
    Status_dekan_after=new.STATUS_DEKAN,
	Status_dekan_before=old.STATUS_DEKAN,
	Anggaran_dana=old.ANGGARAN_DANA,
	Tgl_perencanaan=old.TGLPERENCANAAN;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_jabatan`
--

CREATE TABLE `riwayat_jabatan` (
  `ID_Riwayatjabatan` int(45) NOT NULL,
  `NIDN` int(45) DEFAULT NULL,
  `nama_jabatan_after` varchar(45) DEFAULT NULL,
  `nama_jabatan_before` varchar(45) DEFAULT NULL,
  `status_jabatan_after` varchar(45) DEFAULT NULL,
  `status_jabatan_before` varchar(45) DEFAULT NULL,
  `Periode_after` varchar(45) DEFAULT NULL,
  `Periode_before` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `riwayat_jabatan`
--

INSERT INTO `riwayat_jabatan` (`ID_Riwayatjabatan`, `NIDN`, `nama_jabatan_after`, `nama_jabatan_before`, `status_jabatan_after`, `status_jabatan_before`, `Periode_after`, `Periode_before`) VALUES
(1, 22833018, 'Dekan', 'Wakil Dekan', 'tidak aktif', 'aktif', '2019/2020', '2019/2020'),
(2, 22833018, 'wakil Dekan', 'Dekan', 'aktif', 'tidak aktif', '2019/2020', '2019/2020'),
(3, 22833019, 'wakil Dekan', 'Kaprodi', 'tidak aktif', 'aktif', '2019/2020', '2019/2020'),
(4, 22833018, 'kaprodi', 'wakil Dekan', 'aktif', 'tidak aktif', '2019/2020', '2019/2020'),
(5, 22833019, 'wakil Dekan', 'wakil Dekan', 'aktif', 'tidak aktif', '2019/2020', '2019/2020'),
(6, 22833019, 'wakil Dekan', 'wakil Dekan', 'aktif', 'tidak aktif', '2019/2020', '2019/2020'),
(7, 22833018, 'wakil Dekan', 'kaprodi', 'tidak aktif', 'aktif', '2019/2020', '2019/2020'),
(8, 22833019, 'kaprodi', 'wakil Dekan', 'aktif', 'tidak aktif', '2019/2020', '2019/2020'),
(9, 22833020, 'wakil Dekan', 'Dekan', 'aktif', 'aktif', '2019/2020', '2019/2020'),
(10, 22833020, 'Dekan', 'wakil Dekan', 'aktif', 'aktif', '2019/2020', '2019/2020'),
(11, 22833018, 'kaprodi', 'wakil Dekan', 'aktif', 'aktif', '2019/2020', '2019/2020'),
(12, 22833018, 'wakil Dekan', 'kaprodi', 'aktif', 'aktif', '2019/2020', '2019/2020');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_proker`
--

CREATE TABLE `riwayat_proker` (
  `ID_History` int(45) NOT NULL,
  `ID_Proker` int(45) DEFAULT NULL,
  `Dosen_penanggung` varchar(45) DEFAULT NULL,
  `Uraian_proker` varchar(45) DEFAULT NULL,
  `Periode_proker` varchar(45) DEFAULT NULL,
  `Revisi_after` varchar(45) DEFAULT NULL,
  `Revisi_before` varchar(45) DEFAULT NULL,
  `Status_wadek_after` varchar(45) DEFAULT NULL,
  `Status_wadek_before` varchar(45) DEFAULT NULL,
  `Status_dekan_after` varchar(45) DEFAULT NULL,
  `Status_dekan_before` varchar(45) DEFAULT NULL,
  `Anggaran_dana` varchar(45) DEFAULT NULL,
  `Tgl_perencanaan` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `riwayat_proker`
--

INSERT INTO `riwayat_proker` (`ID_History`, `ID_Proker`, `Dosen_penanggung`, `Uraian_proker`, `Periode_proker`, `Revisi_after`, `Revisi_before`, `Status_wadek_after`, `Status_wadek_before`, `Status_dekan_after`, `Status_dekan_before`, `Anggaran_dana`, `Tgl_perencanaan`) VALUES
(60, 2, 'Karina Anggia', NULL, '2019/2020', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 68.000.000', '2019-08-04'),
(61, 1, 'Hana Ai Ardiana', NULL, '2020/2021', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 90.000.000 ', '2020-08-01'),
(62, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', NULL, NULL, NULL, NULL, 'Disetujui', NULL, 'Rp 97.000.000', '2020-08-01'),
(63, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'sudah', NULL, 'Tidak Disetujui', NULL, 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-08-01'),
(64, 2, 'Karina Anggia', 'Masukkan Data Proker', '2015/2016', 'sudah', NULL, 'Tidak Disetujui', NULL, 'Disetujui', NULL, 'Rp 97.000.000', '2018-08-04'),
(66, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'sudah', 'sudah', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-08-01'),
(67, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'Sudah ', 'sudah', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-16'),
(68, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'Sudah ', 'Sudah ', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-16'),
(69, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'Belum', 'Sudah ', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-16'),
(70, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'Belum', 'Belum', 'Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-16'),
(73, 3, 'Indah Dwi Setyawati', 'Masukkan Data Proker	', '2017/2018', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 87.000.000', '2020-01-03'),
(74, 4, 'Camelia Mars', 'Masukkan Data Proker', '2015/2016', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 59.000.000', '2020-01-04'),
(78, 3, 'Indah Dwi Setyawati', 'Masukkan Data Proker	', '2017/2018', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 87.000.000', '2020-01-03'),
(80, 2, 'Karina Anggia', 'Masukkan Data Proker', '2015/2016', 'sudah', 'sudah', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2018-08-04'),
(82, 1, 'Hana Ai Ardiana', 'Masukkan Data Proker', '2015/2016', 'Belum', 'Belum', 'Disetujui', 'Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-16'),
(83, 2, 'Karina Anggia', 'Masukkan Data Proker', '2015/2016', 'sudah', 'sudah', 'Tidak Disetujui', 'Tidak Disetujui', 'Disetujui', 'Disetujui', 'Rp 97.000.000', '2020-01-02'),
(84, 3, 'Indah Dwi Setyawati', 'Masukkan Data Proker	', '2017/2018', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 87.000.000', '2020-01-03'),
(85, 4, 'Camelia Mars', 'Masukkan Data Proker', '2015/2016', NULL, NULL, NULL, NULL, NULL, NULL, 'Rp 59.000.000', '2020-01-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID_USER` int(11) NOT NULL,
  `NPP` int(11) DEFAULT NULL,
  `NIDN` int(11) DEFAULT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `LASTLOGIN` varchar(45) DEFAULT NULL,
  `AKSES` enum('1','0') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID_USER`, `NPP`, `NIDN`, `USERNAME`, `PASSWORD`, `LASTLOGIN`, `AKSES`) VALUES
(1, 21833019, 22833019, 'kaprodi', 'kaprodi', '2020-01-29 17:07:06', '1'),
(2, 21833018, 22833018, 'wadek', 'wadek', '2020-01-29 16:50:14', '1'),
(3, 21833020, 22833020, 'dekan', 'dekan', '2020-01-29 03:49:34', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`NPP`),
  ADD KEY `FK_LOGIN` (`ID_USER`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`NIDN`),
  ADD KEY `FK_MEMILIKI2` (`ID_USER`);

--
-- Indexes for table `proker`
--
ALTER TABLE `proker`
  ADD PRIMARY KEY (`ID_PROKER`),
  ADD KEY `FK_MENGAKSES` (`ID_USER`);

--
-- Indexes for table `riwayat_jabatan`
--
ALTER TABLE `riwayat_jabatan`
  ADD PRIMARY KEY (`ID_Riwayatjabatan`),
  ADD KEY `NIDN` (`NIDN`);

--
-- Indexes for table `riwayat_proker`
--
ALTER TABLE `riwayat_proker`
  ADD PRIMARY KEY (`ID_History`),
  ADD KEY `ID_Proker` (`ID_Proker`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_USER`),
  ADD KEY `FK_LOGIN2` (`NPP`),
  ADD KEY `FK_MEMILIKI` (`NIDN`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `riwayat_jabatan`
--
ALTER TABLE `riwayat_jabatan`
  MODIFY `ID_Riwayatjabatan` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `riwayat_proker`
--
ALTER TABLE `riwayat_proker`
  MODIFY `ID_History` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dosen`
--
ALTER TABLE `dosen`
  ADD CONSTRAINT `FK_LOGIN` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Constraints for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD CONSTRAINT `FK_MEMILIKI2` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Constraints for table `proker`
--
ALTER TABLE `proker`
  ADD CONSTRAINT `FK_MENGAKSES` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Constraints for table `riwayat_jabatan`
--
ALTER TABLE `riwayat_jabatan`
  ADD CONSTRAINT `riwayat_jabatan_ibfk_1` FOREIGN KEY (`NIDN`) REFERENCES `jabatan` (`NIDN`);

--
-- Constraints for table `riwayat_proker`
--
ALTER TABLE `riwayat_proker`
  ADD CONSTRAINT `riwayat_proker_id_frgn` FOREIGN KEY (`ID_Proker`) REFERENCES `proker` (`ID_PROKER`) ON DELETE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_LOGIN2` FOREIGN KEY (`NPP`) REFERENCES `dosen` (`NPP`),
  ADD CONSTRAINT `FK_MEMILIKI` FOREIGN KEY (`NIDN`) REFERENCES `jabatan` (`NIDN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
