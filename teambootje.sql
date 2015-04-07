-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 07 apr 2015 om 13:28
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
  `Doelgroep` varchar(45) DEFAULT NULL,
  `Redebezoek` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `locatie`
--

CREATE TABLE IF NOT EXISTS `locatie` (
`LID` int(11) NOT NULL,
  `Land` varchar(255) NOT NULL,
  `Stad` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=916 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `locatie`
--

INSERT INTO `locatie` (`LID`, `Land`, `Stad`) VALUES
(881, 'N/A', 'N/A'),
(888, 'Nederland', 'Bergen op Zoom'),
(902, 'Nederland', 'Rotterdam'),
(915, 'Nederland', 'Veenendaal');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `persoon`
--

CREATE TABLE IF NOT EXISTS `persoon` (
`AID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Leeftijd` int(3) DEFAULT NULL,
  `Geslacht` varchar(5) DEFAULT NULL,
  `LID` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `persoon`
--

INSERT INTO `persoon` (`AID`, `Name`, `Leeftijd`, `Geslacht`, `LID`) VALUES
(5, 'Katendrechtnr1', NULL, NULL, 881),
(6, 'RuudvandenBos', NULL, NULL, 888),
(7, 'EdwindeKoning1', NULL, NULL, 902),
(8, 'Gerarddegraaff', NULL, NULL, 915),
(9, 'FR12Patrick', NULL, NULL, NULL),
(10, 'DMiddelman', NULL, NULL, NULL),
(11, '010byday', NULL, NULL, NULL),
(12, 'Plan_78', NULL, NULL, NULL),
(13, 'jpsoree', NULL, NULL, NULL),
(14, 'RebekkaKadijk', NULL, NULL, NULL),
(15, 'GwNpop', NULL, NULL, NULL),
(16, 'RuudvEck', NULL, NULL, NULL),
(17, 'FIVBVolleyball', NULL, NULL, NULL),
(18, 'FIVBWorldChamps', NULL, NULL, NULL),
(19, 'popupsquare', NULL, NULL, NULL),
(20, 'EelcoBeijl', NULL, NULL, NULL),
(21, 'SalvatoreOrtisi', NULL, NULL, NULL),
(22, 'CvanAdrighem', NULL, NULL, NULL),
(23, 'Voetbalr', NULL, NULL, NULL),
(24, 'JaccoScheer', NULL, NULL, NULL),
(25, 'Petrahoogenboom', NULL, NULL, NULL),
(26, 'Nellyvdvlies', NULL, NULL, NULL),
(27, 'TonWesselink', NULL, NULL, NULL),
(28, 'carolinedejager', NULL, NULL, NULL),
(29, 'ensanne', NULL, NULL, NULL),
(30, 'WestCordHotels', NULL, NULL, NULL),
(31, 'jes4life', NULL, NULL, NULL),
(32, 'marygoossens1', NULL, NULL, NULL),
(33, 'FeestdjNik', NULL, NULL, NULL),
(34, 'Zytec_Couplings', NULL, NULL, NULL),
(35, 'CaatVanEnst', NULL, NULL, NULL),
(36, 'FlorentinaNow', NULL, NULL, NULL),
(37, 'elsekramer', NULL, NULL, NULL),
(38, 'PoushNL', NULL, NULL, NULL),
(39, 'MarjoleinNagel', NULL, NULL, NULL),
(40, 'RichardPh0t0', NULL, NULL, NULL),
(41, 'SevereWeather_N', NULL, NULL, NULL),
(42, 'OdileHemmen', NULL, NULL, NULL),
(43, 'VeraBauman', NULL, NULL, NULL),
(44, 'PatriciaBenard', NULL, NULL, NULL),
(45, 'timzh95', NULL, NULL, NULL),
(46, 'AnneWallisDeVri', NULL, NULL, NULL),
(47, 'shirleys86', NULL, NULL, NULL),
(48, 'NLMaritiem', NULL, NULL, NULL),
(49, 'JolandaBolscher', NULL, NULL, NULL),
(50, 'MeerkatsNow', NULL, NULL, NULL),
(51, 'ray_rademaker', NULL, NULL, NULL),
(52, 'BotlekBusiness', NULL, NULL, NULL),
(53, 'KidsErOpUit', NULL, NULL, NULL),
(54, 'de_rotterdam', NULL, NULL, NULL),
(55, 'meerkatting', NULL, NULL, NULL),
(56, 'OVKatendrecht', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
`PID` int(11) NOT NULL,
  `DID` int(11) DEFAULT NULL,
  `AID` int(11) NOT NULL,
  `Post` varchar(255) NOT NULL,
  `Datum` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `posts`
--

INSERT INTO `posts` (`PID`, `DID`, `AID`, `Post`, `Datum`) VALUES
(2, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(3, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(4, NULL, 5, 'RT @RuudvandenBos: @de_rotterdam vandaag eerste training op SSRotterdam voor de SSRotterdamRun later dit jaar.#katendrecht', '2015-04-01'),
(5, NULL, 5, 'Vanaf 1 april voordelig met de Watertaxi - ss Rotterdam: http://t.co/HtjfXL1xAB #Katendrecht @de_rotterdam', '2015-03-31'),
(6, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(7, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(8, NULL, 5, 'RT @RuudvandenBos: @de_rotterdam vandaag eerste training op SSRotterdam voor de SSRotterdamRun later dit jaar.#katendrecht', '2015-04-01'),
(9, NULL, 5, 'Vanaf 1 april voordelig met de Watertaxi - ss Rotterdam: http://t.co/HtjfXL1xAB #Katendrecht @de_rotterdam', '2015-03-31'),
(10, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(11, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(12, NULL, 5, 'RT @RuudvandenBos: @de_rotterdam vandaag eerste training op SSRotterdam voor de SSRotterdamRun later dit jaar.#katendrecht', '2015-04-01'),
(13, NULL, 5, 'Vanaf 1 april voordelig met de Watertaxi - ss Rotterdam: http://t.co/HtjfXL1xAB #Katendrecht @de_rotterdam', '2015-03-31'),
(14, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(15, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(16, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(17, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(18, NULL, 9, '#Goodnight #ssRotterdam #Rotterdam https://t.co/KqLxbpVw8b', '2015-04-01'),
(19, NULL, 10, 'Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(20, NULL, 5, 'RT @RuudvandenBos: @de_rotterdam vandaag eerste training op SSRotterdam voor de SSRotterdamRun later dit jaar.#katendrecht', '2015-04-01'),
(21, NULL, 11, '"@Plan_78: @rotterdam, @ssrotterdam en @HotelNewYork in @Kodak Tri-X 400 35mm. #fotograaf #fotografie #photography http://t.co/ewsOxXBgHs"', '2015-04-01'),
(22, NULL, 12, '@rotterdam, @ssrotterdam en @HotelNewYork in @Kodak Tri-X 400 35mm. #fotograaf #fotografie #photography http://t.co/dbluAHqwny', '2015-04-01'),
(23, NULL, 6, '@de_rotterdam vandaag eerste training op SSRotterdam voor de SSRotterdamRun later dit jaar.#katendrecht', '2015-04-01'),
(24, NULL, 13, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(25, NULL, 14, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(26, NULL, 15, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(27, NULL, 16, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(28, NULL, 17, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(29, NULL, 18, 'Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(30, NULL, 19, 'RT @PoushNL: Geheel in Rotterdamse stijl sluiten wij deze waanzinnig gave dag af #StartPopUpNow #PopUpSummit @ssrotterdam http://t.co/jNGns…', '2015-03-31'),
(31, NULL, 20, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(32, NULL, 21, '#vscocam #igersnederland #igersrotterdam #rotterdam #ssrotterdam https://t.co/LcgvqvFAch', '2015-03-31'),
(33, NULL, 21, '#vscocam #igersnederlad #igersrotterdam #rotterdam #ssrotterdam https://t.co/Kc8iyLBVCt', '2015-03-31'),
(34, NULL, 22, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(35, NULL, 5, 'Vanaf 1 april voordelig met de Watertaxi - ss Rotterdam: http://t.co/HtjfXL1xAB #Katendrecht @de_rotterdam', '2015-03-31'),
(36, NULL, 23, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(37, NULL, 7, 'Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 http://t.co/0spuEGGxdx', '2015-03-31'),
(38, NULL, 24, 'Oefening vullen ademlucht en tegelijkertijd duikers Amsterdam-Amstelland ondersteunen bij oefening #SSRotterdam. http://t.co/fK5IGq86Sx', '2015-03-30'),
(39, NULL, 11, '"@Petrahoogenboom: Wereldschip de @de_rotterdam in een wereldstad #ssrotterdam #rotterdam http://t.co/8CbNbM7xVf"', '2015-03-30'),
(40, NULL, 25, 'Wereldschip in een wereldstad #ssrotterdam #rotterdam http://t.co/YDlNxqJ3bt', '2015-03-30'),
(41, NULL, 26, 'RT @WestCordHotels: Nieuws! Vanaf 1 april voordelig van en naar het ss Rotterdam met de #watertaxi http://t.co/I3Vg9tFr0W http://t.co/GClNc…', '2015-03-30'),
(42, NULL, 27, 'RT @WestCordHotels: Nieuws! Vanaf 1 april voordelig van en naar het ss Rotterdam met de #watertaxi http://t.co/I3Vg9tFr0W http://t.co/GClNc…', '2015-03-30'),
(43, NULL, 28, 'RT @PoushNL: Geheel in Rotterdamse stijl sluiten wij deze waanzinnig gave dag af #StartPopUpNow #PopUpSummit @ssrotterdam http://t.co/jNGns…', '2015-03-30'),
(44, NULL, 29, 'RT @WestCordHotels: Nieuws! Vanaf 1 april voordelig van en naar het ss Rotterdam met de #watertaxi http://t.co/I3Vg9tFr0W http://t.co/GClNc…', '2015-03-30'),
(45, NULL, 30, 'Nieuws! Vanaf 1 april voordelig van en naar het ss Rotterdam met de #watertaxi http://t.co/I3Vg9tFr0W http://t.co/GClNcxSjUJ', '2015-03-30'),
(46, NULL, 31, '#ssRotterdam #deck #fun ....?? https://t.co/fD31gQaysb', '2015-03-29'),
(47, NULL, 32, 'RT @FeestdjNik: Het was weer een geslaagd feest! #ssrotterdam', '2015-03-29'),
(48, NULL, 33, 'Het was weer een geslaagd feest! #ssrotterdam', '2015-03-29'),
(49, NULL, 34, 'RT @Gerarddegraaff: Mooie bijeenkomst @Kennissenclub op de @ssrotterdam http://t.co/jyPutjWHZf', '2015-03-27'),
(50, NULL, 8, 'Mooie bijeenkomst @Kennissenclub op de @ssrotterdam http://t.co/jyPutjWHZf', '2015-03-27'),
(51, NULL, 35, 'RT @PoushNL: Geheel in Rotterdamse stijl sluiten wij deze waanzinnig gave dag af #StartPopUpNow #PopUpSummit @ssrotterdam http://t.co/jNGns…', '2015-03-26'),
(52, NULL, 36, 'Op momenten dat je dicht bij jezelf bent kun jij een glimp opvangen van intens #geluk @ssrotterdam http://t.co/0oBLWmecNN', '2015-03-26'),
(53, NULL, 37, '@PoushNL @ssrotterdam ??', '2015-03-26'),
(54, NULL, 38, 'Geheel in Rotterdamse stijl sluiten wij deze waanzinnig gave dag af #StartPopUpNow #PopUpSummit @ssrotterdam http://t.co/jNGns1Lp8Q', '2015-03-26'),
(55, NULL, 39, 'Op #SSRotterdam met #d''Associatie, 50 communicatiebaasjes.  Pracht van een schip.  En trotse Rotterdammers.', '2015-03-26'),
(56, NULL, 40, 'RT @RichardMaasdijk: The @ssrotterdam @Katendrechtnr1 http://t.co/3xyuUHK3CJ', '2015-04-07'),
(57, NULL, 41, 'RT @RichardMaasdijk: The @ssrotterdam @Katendrechtnr1 http://t.co/3xyuUHK3CJ', '2015-04-07'),
(58, NULL, 42, '@PatriciaBenard @VeraBauman @RDStad @markthalrdam @ssrotterdam @RotterdamZoo en #hetmuseumpark niet vergeten met de #swanmarket #2epaas', '2015-04-07'),
(59, NULL, 43, 'RT @PatriciaBenard: Zie artikel @RDStad topdrukte tijdens de Pasen @markthalrdam @ssrotterdam @RotterdamZoo ea http://t.co/ZvlG7wG5hT', '2015-04-07'),
(60, NULL, 44, 'Zie artikel @RDStad topdrukte tijdens de Pasen @markthalrdam @ssrotterdam @RotterdamZoo ea http://t.co/ZvlG7wG5hT', '2015-04-07'),
(61, NULL, 45, 'RT @RichardMaasdijk: The @ssrotterdam @Katendrechtnr1 http://t.co/3xyuUHK3CJ', '2015-04-07'),
(62, NULL, 5, 'Prachtige foto! @RichardMaasdijk: The @ssrotterdam @Katendrechtnr1 http://t.co/JtfHTrRkWO #Katendrecht', '2015-04-07'),
(63, NULL, 46, 'Think we''ll still go by plain next week... @NewYork @ssrotterdam @KLM http://t.co/X6te8JhRwa', '2015-04-07'),
(64, NULL, 47, '#ssRotterdam #RestaurantRauwRotterdam #Fenixfood', '2015-04-07'),
(65, NULL, 48, 'Kom naar het #TKIMaritiem innovatie event 16 april, #SSRotterdam. Aanmelden via: http://t.co/0uHBdiHIgU http://t.co/UUMsxd7crN', '2015-04-06'),
(66, NULL, 49, '2e paasdag = familiedag... In alle vroegte richting Rotterdam @markthalrdam en @ssrotterdam', '2015-04-06'),
(67, NULL, 50, 'ray_rademaker: |LIVE NOW| eerste terrasdag ssrotterdam #meerkat http://t.co/Gxrw3rmDS0 April 05, 2015 at 09:07AM', '2015-04-05'),
(68, NULL, 51, '|LIVE NOW| eerste terrasdag @ssrotterdam #meerkat http://t.co/RofQi785dW', '2015-04-05'),
(69, NULL, 52, 'RT @de_rotterdam: Vandaag, 1e & 2e Paasdag zijn er leuke kinderactiviteiten aan boord van het schip! Bekijk alle paasactiviteiten hier: htt…', '2015-04-04'),
(70, NULL, 53, 'RT @de_rotterdam: Vandaag, 1e & 2e Paasdag zijn er leuke kinderactiviteiten aan boord van het schip! Bekijk alle paasactiviteiten hier: htt…', '2015-04-04'),
(71, NULL, 54, 'Vandaag, 1e & 2e Paasdag zijn er leuke kinderactiviteiten aan boord van het schip! Bekijk alle paasactiviteiten hier: http://t.co/dg0ZZl6SQo', '2015-04-04'),
(72, NULL, 51, '|LIVE NOW| easterbreakfast @ssrotterdam #meerkat http://t.co/WVh90sL3mZ', '2015-04-04'),
(73, NULL, 55, 'RT @ray_rademaker: |LIVE NOW| easterbreakfast @ssrotterdam #meerkat http://t.co/QbNG0kZspr', '2015-04-04'),
(74, NULL, 51, '|LIVE NOW| easterbreakfast @ssrotterdam #meerkat http://t.co/QbNG0kZspr', '2015-04-04'),
(75, NULL, 56, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-03'),
(76, NULL, 5, 'Live muziek in de Ocean Bar - ss Rotterdam: http://t.co/jWR0IIJKrc @de_rotterdam', '2015-04-01'),
(77, NULL, 5, 'RT @DMiddelman: Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(78, NULL, 9, '#Goodnight #ssRotterdam #Rotterdam https://t.co/KqLxbpVw8b', '2015-04-01'),
(79, NULL, 10, 'Er is genoeg te beleven met de Pasen op de @de_rotterdam http://t.co/oKEHL04LNL #katendrecht', '2015-04-01'),
(80, NULL, 11, '"@Plan_78: @rotterdam, @ssrotterdam en @HotelNewYork in @Kodak Tri-X 400 35mm. #fotograaf #fotografie #photography http://t.co/ewsOxXBgHs"', '2015-04-01'),
(81, NULL, 12, '@rotterdam, @ssrotterdam en @HotelNewYork in @Kodak Tri-X 400 35mm. #fotograaf #fotografie #photography http://t.co/dbluAHqwny', '2015-04-01'),
(82, NULL, 13, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(83, NULL, 14, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(84, NULL, 15, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(85, NULL, 16, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(86, NULL, 17, 'RT @FIVBWorldChamps: Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(87, NULL, 18, 'Rotterdam ambassador @RebekkaKadijk invites you to board the @ssrotterdam #FIVBWorldChamps http://t.co/7NKKSof9rQ', '2015-03-31'),
(88, NULL, 19, 'RT @PoushNL: Geheel in Rotterdamse stijl sluiten wij deze waanzinnig gave dag af #StartPopUpNow #PopUpSummit @ssrotterdam http://t.co/jNGns…', '2015-03-31'),
(89, NULL, 20, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(90, NULL, 21, '#vscocam #igersnederland #igersrotterdam #rotterdam #ssrotterdam https://t.co/LcgvqvFAch', '2015-03-31'),
(91, NULL, 21, '#vscocam #igersnederlad #igersrotterdam #rotterdam #ssrotterdam https://t.co/Kc8iyLBVCt', '2015-03-31'),
(92, NULL, 22, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(93, NULL, 5, 'Vanaf 1 april voordelig met de Watertaxi - ss Rotterdam: http://t.co/HtjfXL1xAB #Katendrecht @de_rotterdam', '2015-03-31'),
(94, NULL, 23, 'RT @EdwindeKoning1: Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 ht…', '2015-03-31'),
(95, NULL, 7, 'Wereldkampioenen spelen tegen Europeeskampioenen tijdens het @WKBeach2015 bij de @ssrotterdam. @Sportstad vanaf 27/6 http://t.co/0spuEGGxdx', '2015-03-31');

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
 ADD PRIMARY KEY (`LID`), ADD UNIQUE KEY `Stad` (`Stad`), ADD UNIQUE KEY `Land` (`Land`,`Stad`);

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
MODIFY `LID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=916;
--
-- AUTO_INCREMENT voor een tabel `persoon`
--
ALTER TABLE `persoon`
MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT voor een tabel `posts`
--
ALTER TABLE `posts`
MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=96;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
