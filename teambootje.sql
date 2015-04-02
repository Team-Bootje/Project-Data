-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 02 apr 2015 om 11:44
-- Serverversie: 5.6.21
-- PHP-versie: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `teambootje`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `doelgroep`
--

CREATE TABLE IF NOT EXISTS `doelgroep` (
`DID` int(11) NOT NULL,
  `Doelgroep` varchar(45),
  `Redebezoek` varchar(45) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `locatie`
--

CREATE TABLE IF NOT EXISTS `locatie` (
`LID` int(11) NOT NULL,
  `Land` varchar(255) NOT NULL,
  `Stad` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `locatie`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `persoon`
--

CREATE TABLE IF NOT EXISTS `persoon` (
`AID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Leeftijd` int(3) DEFAULT NULL,
  `Geslacht` varchar(5) DEFAULT NULL,
  `LID` int(11)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Tabelstructuur voor tabel `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
`PID` int(11) NOT NULL,
  `DID` int(11),
  `AID` int(11) NOT NULL,
  `Post` varchar(255) NOT NULL,
  `Datum` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `doelgroep`
--
ALTER TABLE `doelgroep`
 ADD PRIMARY KEY (`DID`);

--
-- Indexen voor tabel `locatie`
--
ALTER TABLE `locatie`
 ADD PRIMARY KEY (`LID`), ADD UNIQUE KEY `Stad` (`Stad`);

--
-- Indexen voor tabel `persoon`
--
ALTER TABLE `persoon`
 ADD PRIMARY KEY (`AID`), ADD UNIQUE KEY `Name` (`Name`), ADD KEY `LID` (`LID`);

--
-- Indexen voor tabel `posts`
--
ALTER TABLE `posts`
 ADD PRIMARY KEY (`PID`), ADD UNIQUE KEY `PID` (`PID`), ADD KEY `DID` (`DID`), ADD KEY `AID` (`AID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `doelgroep`
--
ALTER TABLE `doelgroep`
MODIFY `DID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `locatie`
--
ALTER TABLE `locatie`
MODIFY `LID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `persoon`
--
ALTER TABLE `persoon`
MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `posts`
--
ALTER TABLE `posts`
MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
