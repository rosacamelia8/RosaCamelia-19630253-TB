-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2022 at 07:12 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_javakrs`
--

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id` int(11) NOT NULL,
  `nama_kelas` varchar(200) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id`, `nama_kelas`) VALUES
(1, 'O Reguler Pagi Bjm'),
(2, 'A Reguler Pagi Bjb');

-- --------------------------------------------------------

--
-- Table structure for table `krs`
--

CREATE TABLE `krs` (
  `id` int(11) NOT NULL,
  `id_mahasiswa` int(11) NOT NULL,
  `id_matakuliah` int(11) NOT NULL,
  `semester` varchar(200) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` varchar(200) CHARACTER SET latin1 NOT NULL,
  `nama_mahasiswa` varchar(200) CHARACTER SET latin1 NOT NULL,
  `jenis_kelamin` varchar(200) CHARACTER SET latin1 NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `agama` varchar(200) CHARACTER SET latin1 NOT NULL,
  `kelas` varchar(200) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama_mahasiswa`, `jenis_kelamin`, `tanggal_lahir`, `agama`, `kelas`) VALUES
('202201001', 'Rosa Camelia', 'Perempuan', '2001-01-08', 'Islam', 'Reguler O'),
('202201002', 'Mila k', 'Perempuan', '2022-01-09', 'Islam', 'Reguler E'),
('202201003', 'Nina Amara', 'Perempuan', '2001-10-03', 'Islam', 'Reguler O'),
('202201004', 'Rani', 'Perempuan', '2022-01-09', 'Islam', 'Reguler B'),
('202201005', 'Dina', 'Perempuan', '2022-01-09', 'Islam', 'Reguler A');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `id` int(11) NOT NULL,
  `kodemk` varchar(10) CHARACTER SET latin1 NOT NULL,
  `matakuliah` varchar(200) CHARACTER SET latin1 NOT NULL,
  `sks` varchar(200) CHARACTER SET latin1 NOT NULL,
  `semester` varchar(200) CHARACTER SET latin1 NOT NULL,
  `dosen` varchar(200) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`id`, `kodemk`, `matakuliah`, `sks`, `semester`, `dosen`) VALUES
(1, 'INT315', 'Pbo 2', '3', '5', 'Edya Rosadi'),
(2, 'INF203', 'Statistika', '2', '5', 'Rusdina'),
(3, 'INT322', 'Praktek SBD 1', '1', '1', 'Kelvin'),
(4, 'FTI001', 'Matematika', '2', '5', 'KeviA'),
(5, 'FTI02', 'PBO1', '3', '3', 'Amira'),
(6, 'FTI005', 'Kecerdasan Buatan', '2', '5', 'Ibu'),
(7, 'IPS', 'FTI007', '1', '3', 'rara');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `krs`
--
ALTER TABLE `krs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `matakuliah`
--
ALTER TABLE `matakuliah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
