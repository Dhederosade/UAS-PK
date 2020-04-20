-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Apr 2020 pada 15.14
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_arsip`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL,
  `admin_fullname` varchar(50) NOT NULL,
  `admin_username` varchar(25) NOT NULL,
  `admin_password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`admin_id`, `admin_fullname`, `admin_username`, `admin_password`) VALUES
(3, 'Administators', 'revan', '66cca4f80d1138dcd0c942f18504f4b8');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_dokumen`
--

CREATE TABLE `tb_dokumen` (
  `kode_dokumen` int(10) NOT NULL,
  `nama_dokumen` varchar(50) NOT NULL,
  `kategori_dokumen` varchar(50) NOT NULL,
  `lokasi_dokumen` varchar(50) NOT NULL,
  `deskripsi_dokumen` varchar(100) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_dokumen`
--

INSERT INTO `tb_dokumen` (`kode_dokumen`, `nama_dokumen`, `kategori_dokumen`, `lokasi_dokumen`, `deskripsi_dokumen`, `tanggal`) VALUES
(1, 'asdasd', 'Surat  Keluar', 'sa', 'sddsfcxcvxbb', '2020-04-07'),
(2, 'jadull3', 'Surat Ijin', 'wqe211', 'qwe', '2020-05-31');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `admin_username` (`admin_username`);

--
-- Indeks untuk tabel `tb_dokumen`
--
ALTER TABLE `tb_dokumen`
  ADD PRIMARY KEY (`kode_dokumen`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_dokumen`
--
ALTER TABLE `tb_dokumen`
  MODIFY `kode_dokumen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
