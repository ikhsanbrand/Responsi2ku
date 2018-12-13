-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13 Des 2018 pada 02.54
-- Versi Server: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `member`
--

CREATE TABLE `member` (
  `nosal` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `member`
--

INSERT INTO `member` (`nosal`, `nama`, `brand`, `alamat`) VALUES
('SPB002', 'REZA', 'VIVO', 'MALANG'),
('SPB004', 'DANU', 'OPPO', 'BERAU'),
('SPB005', 'ALFIAN', 'SAMSUNG', 'BERAU'),
('SPB006', 'ALAM', 'VIVO', 'BALIKPAPAN'),
('SPB007', 'THOMAS', 'SAMSUNG', 'BALIKPAPAN'),
('SPB008', 'YUDHA', 'ASUS', 'BERAU'),
('SPB009', 'KOKO', 'VIVO', 'SAMARINDA'),
('SPB011', 'Wawan', 'Xiaomi', 'Marauke'),
('spb123', 'yohanes', 'malang', 'acer'),
('SPG002', 'DIKA', 'ASUS', 'MALANG'),
('SPG003', 'AJRAH', 'OPPO', 'MALANG'),
('SPG005', 'TIWI', 'SAMSUNG', 'BERAU'),
('SPG006', 'WIWIN', 'VIVO', 'BALIKPAPAN'),
('SPG007', 'DHEA', 'SAMSUNG', 'BALIKPAPAN'),
('SPG008', 'MELI', 'ASUS', 'BERAU'),
('spg0088', 'sasa', 'asa', 'saas'),
('SPG009', 'IRMA', 'VIVO', 'SAMARINDA'),
('SPG010', 'TITIN', 'ASUS', 'SAMARINDA'),
('TES', 'TES', 'TES', 'TES');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`nosal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
