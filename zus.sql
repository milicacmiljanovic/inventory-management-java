-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2024 at 05:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zus`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `korisnik_id` int(11) NOT NULL,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `datum_rodjenja` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`korisnik_id`, `ime`, `prezime`, `username`, `password`, `datum_rodjenja`) VALUES
(1, 'Masa', 'Uzelac', 'muzelac25', 'ovdejemasa555', '2114-05-25'),
(2, 'Dragana', 'Marinkovic', 'dmarinkovicc', 'planetaje1111', '2114-01-22'),
(3, 'Igor', 'Damjanovic', 'igordam', 'raketicica', '2121-06-02'),
(4, 'Aleksa', 'Rakic', 'alekrakic', 'alienHomeBuyer1', '2112-11-01'),
(5, 'Nikola', 'Milic', 'nmiliccc', 'spaceexplorerone', '2114-03-14'),
(6, 'Jelena', 'Popovic', 'jelenapopovicc', 'lunarresidentSeven', '2132-02-10'),
(7, 'Iva', 'Bradic', 'ivabradica', 'alienHomebuyer5', '2125-07-21');

-- --------------------------------------------------------

--
-- Table structure for table `kupovine`
--

CREATE TABLE `kupovine` (
  `kupovina_id` int(11) NOT NULL,
  `broj_karata` int(11) NOT NULL,
  `cena` int(11) NOT NULL,
  `stambenii_objekat_id` int(11) NOT NULL,
  `korisnikk_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kupovine`
--

INSERT INTO `kupovine` (`kupovina_id`, `broj_karata`, `cena`, `stambenii_objekat_id`, `korisnikk_id`) VALUES
(1, 2, 1000000, 1, NULL),
(2, 3, 300000, 2, NULL),
(3, 5, 2000000, 5, NULL),
(4, 2, 500000, 3, NULL),
(5, 4, 2000000, 7, NULL),
(6, 4, 550000, 4, NULL),
(7, 3, 250000, 6, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `misije`
--

CREATE TABLE `misije` (
  `misija_id` int(11) NOT NULL,
  `naziv_misije` varchar(30) NOT NULL,
  `datum_polaska` date NOT NULL,
  `datum_povratka` date NOT NULL,
  `objekaat_id` int(11) NOT NULL,
  `voziloo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `misije`
--

INSERT INTO `misije` (`misija_id`, `naziv_misije`, `datum_polaska`, `datum_povratka`, `objekaat_id`, `voziloo_id`) VALUES
(1, 'Apex Project', '2133-06-16', '2138-01-02', 7, 2),
(2, 'Horizon Program', '2130-04-09', '2137-09-17', 6, 7),
(3, 'Ascendant Frontier Project', '2116-06-09', '2137-04-11', 2, 1),
(4, 'Biosphere Viability Survey', '2128-06-23', '2145-03-14', 9, 3),
(5, 'Environmental Suitability Surv', '2159-02-05', '2171-06-23', 8, 2),
(6, 'Pioneer Endeavor', '2120-06-03', '2151-04-09', 1, 1),
(7, 'Odyssey Exploration Program', '2133-08-05', '2140-05-09', 9, 6);

-- --------------------------------------------------------

--
-- Table structure for table `objekti`
--

CREATE TABLE `objekti` (
  `objekat_id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `vrsta` varchar(20) NOT NULL,
  `udaljenost_od_zvezde` int(30) NOT NULL,
  `najniza_temperatura` int(30) NOT NULL,
  `najvisa_temperatura` int(30) NOT NULL,
  `kiseonik` decimal(30,2) NOT NULL,
  `drugi_gas` varchar(30) NOT NULL,
  `kolicina_drugog_gasa` decimal(30,2) NOT NULL,
  `visina` int(30) NOT NULL,
  `brzina_orbitiranja` int(11) NOT NULL,
  `broj_umrlih` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `objekti`
--

INSERT INTO `objekti` (`objekat_id`, `naziv`, `vrsta`, `udaljenost_od_zvezde`, `najniza_temperatura`, `najvisa_temperatura`, `kiseonik`, `drugi_gas`, `kolicina_drugog_gasa`, `visina`, `brzina_orbitiranja`, `broj_umrlih`) VALUES
(1, 'Merkur', 'planeta', 57910000, 100, 700, 0.01, 'natrijum', 30.00, 4880, 47, 0),
(2, 'Venera', 'planeta', 108200000, 733, 735, 0.10, 'ugljen dioksid', 96.50, 275, 35, 0),
(3, 'Mesec', 'satelit', 149600000, 100, 390, 0.00, 'helijum', 0.20, 3744, 47, 0),
(4, 'Mars', 'planeta', 225000000, -125, 20, 0.13, 'ugljen dioksid', 95.30, 6779, 86, 0),
(5, 'Stelaria', 'planeta', 150000000, 170, 288, 20.00, 'azot', 73.00, 1300, 28, 5),
(6, 'Celestia', 'planeta', 180000000, 225, 323, 22.50, 'argon', 68.00, 1250, 29, 9),
(7, 'Scootaloo', 'satelit', 100000000, 245, 340, 19.20, 'neon', 72.80, 1050, 27, 3),
(8, 'Starlight Glimmer', 'satelit', 130000000, 157, 268, 16.50, 'helijum', 75.60, 1500, 32, 0),
(9, 'Spike', 'planeta', 108250000, 201, 310, 24.03, 'ksenon', 67.50, 1650, 30, 4);

-- --------------------------------------------------------

--
-- Table structure for table `putovanja`
--

CREATE TABLE `putovanja` (
  `putovanje_id` int(11) NOT NULL,
  `datum_kretanja` date NOT NULL,
  `objekatt_id` int(11) NOT NULL,
  `voziilo_id` int(11) NOT NULL,
  `korisnik_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `putovanja`
--

INSERT INTO `putovanja` (`putovanje_id`, `datum_kretanja`, `objekatt_id`, `voziilo_id`, `korisnik_id`) VALUES
(1, '2172-08-19', 6, 2, NULL),
(2, '2174-03-05', 7, 3, NULL),
(3, '2177-05-23', 8, 7, NULL),
(4, '2180-07-10', 5, 3, NULL),
(5, '2182-08-08', 9, 5, NULL),
(6, '2184-09-11', 8, 4, NULL),
(7, '2190-11-22', 9, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stambeni_objekti`
--

CREATE TABLE `stambeni_objekti` (
  `stambeni_objekat_id` int(11) NOT NULL,
  `vrsta_stambenog_objekta` varchar(20) NOT NULL,
  `kvadratura` int(11) NOT NULL,
  `broj_stanara` int(11) NOT NULL,
  `dostupnost` tinyint(1) DEFAULT 1,
  `objekkat_id` int(11) NOT NULL,
  `vlasnik_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stambeni_objekti`
--

INSERT INTO `stambeni_objekti` (`stambeni_objekat_id`, `vrsta_stambenog_objekta`, `kvadratura`, `broj_stanara`, `dostupnost`, `objekkat_id`, `vlasnik_id`) VALUES
(1, 'kuca', 200, 5, 1, 6, NULL),
(2, 'stan', 45, 2, 1, 7, NULL),
(3, 'stan', 80, 3, 1, 8, NULL),
(4, 'stan', 100, 4, 1, 9, NULL),
(5, 'apartman', 180, 5, 1, 5, NULL),
(6, 'kuca', 150, 5, 1, 6, NULL),
(7, 'stan', 120, 4, 1, 5, NULL),
(8, 'kuca', 195, 5, 1, 9, NULL),
(9, 'stan', 135, 4, 1, 7, NULL),
(10, 'apartman', 220, 6, 1, 6, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vozilo`
--

CREATE TABLE `vozilo` (
  `vozilo_id` int(11) NOT NULL,
  `sifra_vozila` varchar(30) NOT NULL,
  `vrsta_vozila` varchar(20) NOT NULL,
  `broj_dozvoljenih_putnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vozilo`
--

INSERT INTO `vozilo` (`vozilo_id`, `sifra_vozila`, `vrsta_vozila`, `broj_dozvoljenih_putnika`) VALUES
(1, '190566', 'raketa', 6),
(2, '551077', 'svemirski_brod', 15),
(3, '2004005', 'svemirski_avion', 30),
(4, '190677', 'raketa', 8),
(5, '551288', 'svemirski_brod', 12),
(6, '2005006', 'svemirski_avion', 25),
(7, '190899', 'raketa', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`korisnik_id`);

--
-- Indexes for table `kupovine`
--
ALTER TABLE `kupovine`
  ADD PRIMARY KEY (`kupovina_id`),
  ADD KEY `stambenii_objekat_id` (`stambenii_objekat_id`),
  ADD KEY `korisnikk_id` (`korisnikk_id`);

--
-- Indexes for table `misije`
--
ALTER TABLE `misije`
  ADD PRIMARY KEY (`misija_id`),
  ADD KEY `objekaat_id` (`objekaat_id`),
  ADD KEY `voziloo_id` (`voziloo_id`);

--
-- Indexes for table `objekti`
--
ALTER TABLE `objekti`
  ADD PRIMARY KEY (`objekat_id`);

--
-- Indexes for table `putovanja`
--
ALTER TABLE `putovanja`
  ADD PRIMARY KEY (`putovanje_id`),
  ADD KEY `objekatt_id` (`objekatt_id`),
  ADD KEY `voziilo_id` (`voziilo_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `stambeni_objekti`
--
ALTER TABLE `stambeni_objekti`
  ADD PRIMARY KEY (`stambeni_objekat_id`),
  ADD KEY `objekkat_id` (`objekkat_id`),
  ADD KEY `vlasnik_id` (`vlasnik_id`);

--
-- Indexes for table `vozilo`
--
ALTER TABLE `vozilo`
  ADD PRIMARY KEY (`vozilo_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `kupovine`
--
ALTER TABLE `kupovine`
  MODIFY `kupovina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `misije`
--
ALTER TABLE `misije`
  MODIFY `misija_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `objekti`
--
ALTER TABLE `objekti`
  MODIFY `objekat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `putovanja`
--
ALTER TABLE `putovanja`
  MODIFY `putovanje_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `stambeni_objekti`
--
ALTER TABLE `stambeni_objekti`
  MODIFY `stambeni_objekat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vozilo`
--
ALTER TABLE `vozilo`
  MODIFY `vozilo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kupovine`
--
ALTER TABLE `kupovine`
  ADD CONSTRAINT `korisnikk_id` FOREIGN KEY (`korisnikk_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `stambenii_objekat_id` FOREIGN KEY (`stambenii_objekat_id`) REFERENCES `stambeni_objekti` (`stambeni_objekat_id`);

--
-- Constraints for table `misije`
--
ALTER TABLE `misije`
  ADD CONSTRAINT `objekaat_id` FOREIGN KEY (`objekaat_id`) REFERENCES `objekti` (`objekat_id`),
  ADD CONSTRAINT `voziloo_id` FOREIGN KEY (`voziloo_id`) REFERENCES `vozilo` (`vozilo_id`);

--
-- Constraints for table `putovanja`
--
ALTER TABLE `putovanja`
  ADD CONSTRAINT `korisnik_id` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `objekatt_id` FOREIGN KEY (`objekatt_id`) REFERENCES `objekti` (`objekat_id`),
  ADD CONSTRAINT `voziilo_id` FOREIGN KEY (`voziilo_id`) REFERENCES `vozilo` (`vozilo_id`);

--
-- Constraints for table `stambeni_objekti`
--
ALTER TABLE `stambeni_objekti`
  ADD CONSTRAINT `objekkat_id` FOREIGN KEY (`objekkat_id`) REFERENCES `objekti` (`objekat_id`),
  ADD CONSTRAINT `vlasnik_id` FOREIGN KEY (`vlasnik_id`) REFERENCES `korisnici` (`korisnik_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
