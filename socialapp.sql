-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Bulan Mei 2024 pada 15.48
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `socialapp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `donasi`
--

CREATE TABLE `donasi` (
  `donasiid` int(11) NOT NULL,
  `fee` int(11) NOT NULL,
  `eventid` int(11) NOT NULL,
  `namaUs` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `donasi`
--

INSERT INTO `donasi` (`donasiid`, `fee`, `eventid`, `namaUs`) VALUES
(1, 300000, 1, 'cenat');

-- --------------------------------------------------------

--
-- Struktur dari tabel `partisipasi`
--

CREATE TABLE `partisipasi` (
  `partisipasiid` int(11) NOT NULL,
  `eventid` int(11) NOT NULL,
  `namaU` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `partisipasi`
--

INSERT INTO `partisipasi` (`partisipasiid`, `eventid`, `namaU`) VALUES
(1, 1, 'cenat');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `donasi`
--
ALTER TABLE `donasi`
  ADD PRIMARY KEY (`donasiid`),
  ADD KEY `eventid` (`eventid`),
  ADD KEY `namaUs` (`namaUs`);

--
-- Indeks untuk tabel `partisipasi`
--
ALTER TABLE `partisipasi`
  ADD PRIMARY KEY (`partisipasiid`),
  ADD KEY `eventid` (`eventid`),
  ADD KEY `namaU` (`namaU`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `donasi`
--
ALTER TABLE `donasi`
  MODIFY `donasiid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `partisipasi`
--
ALTER TABLE `partisipasi`
  MODIFY `partisipasiid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `donasi`
--
ALTER TABLE `donasi`
  ADD CONSTRAINT `donasi_ibfk_1` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`),
  ADD CONSTRAINT `donasi_ibfk_2` FOREIGN KEY (`namaUs`) REFERENCES `user` (`nama`);

--
-- Ketidakleluasaan untuk tabel `partisipasi`
--
ALTER TABLE `partisipasi`
  ADD CONSTRAINT `partisipasi_ibfk_1` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`),
  ADD CONSTRAINT `partisipasi_ibfk_2` FOREIGN KEY (`namaU`) REFERENCES `user` (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
