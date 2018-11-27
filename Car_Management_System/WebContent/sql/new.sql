-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:56573
-- Generation Time: Nov 26, 2018 at 09:17 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--
CREATE DATABASE IF NOT EXISTS `cms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cms`;

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `car_reg_no` varchar(30) NOT NULL,
  `car_divi` varchar(30) NOT NULL,
  `car_model` varchar(30) NOT NULL,
  `ct_date` date DEFAULT NULL,
  `ep_date` date DEFAULT NULL,
  `co_name` varchar(30) DEFAULT NULL,
  `co_tel` varchar(11) DEFAULT NULL,
  `co_fax` varchar(30) DEFAULT NULL,
  `bo_name` varchar(30) DEFAULT NULL,
  `bo_divi` varchar(30) DEFAULT NULL,
  `bo_age` int(11) DEFAULT NULL,
  `bo_s_date` date DEFAULT NULL,
  `bo_e_date` date DEFAULT NULL,
  `total_dist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cent`
--

CREATE TABLE `cent` (
  `cent_no` int(11) NOT NULL,
  `cent_name` varchar(30) NOT NULL,
  `cent_p_no` int(11) DEFAULT NULL,
  `cent_addr` varchar(255) DEFAULT NULL,
  `cent_addr_dtl` varchar(50) DEFAULT NULL,
  `cent_tell` varchar(15) NOT NULL,
  `cent_fax` varchar(45) DEFAULT NULL,
  `ceo_name` varchar(30) DEFAULT NULL,
  `cent_hp` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cour`
--

CREATE TABLE `cour` (
  `cour_no` int(11) NOT NULL,
  `s_place` int(11) NOT NULL,
  `e_place` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `cour_purpo` varchar(50) NOT NULL,
  `cour_divi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dept`
--

CREATE TABLE `dept` (
  `dept_no` int(11) NOT NULL,
  `dept_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `driv`
--

CREATE TABLE `driv` (
  `driv_no` int(11) NOT NULL,
  `mem_id` varchar(50) NOT NULL,
  `car_reg_no` varchar(30) NOT NULL,
  `cour_no` int(11) DEFAULT NULL,
  `driv_s_date` datetime NOT NULL,
  `driv_e_date` datetime NOT NULL,
  `driv_purpo` varchar(50) DEFAULT NULL,
  `card_divi` varchar(50) DEFAULT NULL,
  `oil_fee` int(11) DEFAULT NULL,
  `trans_fee` int(11) DEFAULT NULL,
  `etc_text` varchar(100) DEFAULT NULL,
  `etc_fee` int(11) DEFAULT NULL,
  `driv_dist` int(11) DEFAULT NULL,
  `bee_go` varchar(255) DEFAULT NULL,
  `driv_divi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mem`
--

CREATE TABLE `mem` (
  `mem_id` varchar(50) NOT NULL,
  `mem_pw` varchar(64) NOT NULL,
  `mem_name` varchar(30) NOT NULL,
  `mem_p_no` varchar(10) DEFAULT NULL,
  `mem_addr` varchar(255) DEFAULT NULL,
  `mem_addr_dtl` varchar(50) DEFAULT NULL,
  `mem_hp` varchar(11) NOT NULL,
  `mem_posi` varchar(30) DEFAULT NULL,
  `mem_auth` char(1) NOT NULL DEFAULT '0',
  `dept_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `place_no` int(11) NOT NULL,
  `place_name` varchar(50) NOT NULL,
  `place_p_no` int(11) DEFAULT NULL,
  `place_addr` varchar(255) DEFAULT NULL,
  `place_addr_dtl` varchar(50) NOT NULL,
  `place_divi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `repa`
--

CREATE TABLE `repa` (
  `repa_no` int(11) NOT NULL,
  `cent_no` int(11) NOT NULL,
  `car_reg_no` varchar(30) NOT NULL,
  `mechanic_name` varchar(30) DEFAULT NULL,
  `repa_s_date` date NOT NULL,
  `repa_e_date` date NOT NULL,
  `repa_cont` varchar(500) DEFAULT NULL,
  `repa_fee` int(11) DEFAULT NULL,
  `repa_divi` char(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_reg_no`);

--
-- Indexes for table `cent`
--
ALTER TABLE `cent`
  ADD PRIMARY KEY (`cent_no`);

--
-- Indexes for table `cour`
--
ALTER TABLE `cour`
  ADD PRIMARY KEY (`cour_no`),
  ADD KEY `FK_cms_s_place` (`s_place`),
  ADD KEY `FK_cms_e_place` (`e_place`);

--
-- Indexes for table `dept`
--
ALTER TABLE `dept`
  ADD PRIMARY KEY (`dept_no`);

--
-- Indexes for table `driv`
--
ALTER TABLE `driv`
  ADD PRIMARY KEY (`driv_no`),
  ADD KEY `FK_cms_mem_id` (`mem_id`),
  ADD KEY `FK_cms_car_reg_no` (`car_reg_no`),
  ADD KEY `FK_cms_cour_no` (`cour_no`);

--
-- Indexes for table `mem`
--
ALTER TABLE `mem`
  ADD PRIMARY KEY (`mem_id`),
  ADD KEY `FK_cms_dept` (`dept_no`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`place_no`);

--
-- Indexes for table `repa`
--
ALTER TABLE `repa`
  ADD PRIMARY KEY (`repa_no`),
  ADD KEY `FK_cms_cent` (`cent_no`),
  ADD KEY `FK_cms_car` (`car_reg_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cent`
--
ALTER TABLE `cent`
  MODIFY `cent_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `cour`
--
ALTER TABLE `cour`
  MODIFY `cour_no` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dept`
--
ALTER TABLE `dept`
  MODIFY `dept_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `driv`
--
ALTER TABLE `driv`
  MODIFY `driv_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `place_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `repa`
--
ALTER TABLE `repa`
  MODIFY `repa_no` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `cour`
--
ALTER TABLE `cour`
  ADD CONSTRAINT `FK_cms_e_place` FOREIGN KEY (`e_place`) REFERENCES `place` (`place_no`),
  ADD CONSTRAINT `FK_cms_s_place` FOREIGN KEY (`s_place`) REFERENCES `place` (`place_no`);

--
-- Constraints for table `driv`
--
ALTER TABLE `driv`
  ADD CONSTRAINT `FK_cms_car_reg_no` FOREIGN KEY (`car_reg_no`) REFERENCES `car` (`car_reg_no`),
  ADD CONSTRAINT `FK_cms_cour_no` FOREIGN KEY (`cour_no`) REFERENCES `cour` (`cour_no`),
  ADD CONSTRAINT `FK_cms_mem_id` FOREIGN KEY (`mem_id`) REFERENCES `mem` (`mem_id`);

--
-- Constraints for table `mem`
--
ALTER TABLE `mem`
  ADD CONSTRAINT `FK_cms_dept` FOREIGN KEY (`dept_no`) REFERENCES `dept` (`dept_no`);

--
-- Constraints for table `repa`
--
ALTER TABLE `repa`
  ADD CONSTRAINT `FK_cms_car` FOREIGN KEY (`car_reg_no`) REFERENCES `car` (`car_reg_no`),
  ADD CONSTRAINT `FK_cms_cent` FOREIGN KEY (`cent_no`) REFERENCES `cent` (`cent_no`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
