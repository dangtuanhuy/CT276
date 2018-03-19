-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 21, 2017 at 11:26 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuanlySV`
--

-- --------------------------------------------------------

--
-- Table structure for table `Diem`
--

CREATE TABLE `Diem` (
  `MaSV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaMH` varchar(10) NOT NULL,
  `Diem` float DEFAULT NULL,
  `Diemchu` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Diem`
--

INSERT INTO `Diem` (`MaSV`, `MaMH`, `Diem`, `Diemchu`) VALUES
('B1400100', 'CT101', 5, 'D'),
('B1400100', 'CT122', 7, 'B'),
('B1500222', 'CT101', -1, 'null'),
('C1200221', 'CT122', -1, 'null'),
('C123456', 'CT101', 4, 'D'),
('C15002219', 'CT101', -1, 'null'),
('C1500222', 'CT101', 1, 'F'),
('C1500222', 'CT122', 5, 'D'),
('C1600222', 'CT101', 7, 'B'),
('C1600222', 'CT122', 6, 'C'),
('C1600222', 'CT267', 8, 'B+'),
('C1700222', 'CT267', 8, 'B+'),
('C1700222', 'CT276', 5, 'D'),
('C1700222', 'CT288', 9, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `GiangVien`
--

CREATE TABLE `GiangVien` (
  `MaGV` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `HoTenGV` varchar(70) NOT NULL,
  `MaMH` varchar(10) NOT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `GioiTinh` tinyint(1) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(70) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GiangVien`
--

INSERT INTO `GiangVien` (`MaGV`, `Password`, `HoTenGV`, `MaMH`, `NgaySinh`, `GioiTinh`, `Email`, `DiaChi`, `SDT`) VALUES
('Admin', 'Admin', 'Nguyen Admin', 'CT123', '2017-04-04 00:00:00', 1, 'admin@gmail.com', 'Can Tho', '0980980987'),
('C111', '111', '111', 'CT111', '2017-04-03 00:00:00', 1, 'f@gf.com', 'hfggf', '0909090909'),
('C112', '111', 'sadf', 'CT111', '2017-04-03 00:00:00', 1, 'sd@df.com', 'hjf', '09876543212');

-- --------------------------------------------------------

--
-- Table structure for table `HocPhan`
--

CREATE TABLE `HocPhan` (
  `MaHP` varchar(10) NOT NULL,
  `TenHP` varchar(50) NOT NULL,
  `SoTinChi` int(11) NOT NULL,
  `HocKy` int(11) NOT NULL,
  `NamHoc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `HocPhan`
--

INSERT INTO `HocPhan` (`MaHP`, `TenHP`, `SoTinChi`, `HocKy`, `NamHoc`) VALUES
('CT101', 'Lap trinh C', 3, 1, '2012 -2014'),
('CT122', 'Mang may tinh', 3, 2, '2015-2016'),
('CT267', 'Java', 3, 1, '2015 -2017'),
('CT276', 'Java', 3, 1, '2012 -2014'),
('CT288', 'C#', 3, 1, '2012 -2014');

-- --------------------------------------------------------

--
-- Table structure for table `Lop`
--

CREATE TABLE `Lop` (
  `MaLop` varchar(10) NOT NULL,
  `TenLop` varchar(50) NOT NULL,
  `MaKhoa` varchar(10) NOT NULL,
  `KhoaHoc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Lop`
--

INSERT INTO `Lop` (`MaLop`, `TenLop`, `MaKhoa`, `KhoaHoc`) VALUES
('CT1022', 'Lop Tin Ung Dung', 'KH2', '01235456789'),
('CT4022', 'Lop Ky Thuat Phan Mem', 'KH2', '01235456789'),
('DI2222', 'Lop cong nghe', 'KH1', '01232456789'),
('DI2252', 'Lop The Chat', 'KH1', '01232456689');

-- --------------------------------------------------------

--
-- Table structure for table `SinhVien`
--

CREATE TABLE `SinhVien` (
  `MaSV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(70) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaLop` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HeDaoTao` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` bit(2) DEFAULT NULL,
  `SDT` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NamHoc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SinhVien`
--

INSERT INTO `SinhVien` (`MaSV`, `HoTen`, `MaLop`, `HeDaoTao`, `NgaySinh`, `DiaChi`, `GioiTinh`, `SDT`, `NamHoc`) VALUES
('B1400100', 'Nguyen Truong Giang', 'Ct1022', ' Liên thông chính quy', '2000-12-12', 'Hau Giang - Can Tho', b'00', '0901233333', '2009-2013'),
('B1500222', 'Nguyen Thi Minh Tuyet', 'DI2222', 'Chính quy', '1995-11-18', 'Thoi Lai - Can Tho', b'01', '0909009999', '2014- 2016'),
('C1200221', 'Nguyen Duong Chau', 'Ct1022', 'Vừa học vừa làm', '2001-10-30', 'Can Tho', b'00', '0909090233', '2011-2015'),
('C123456', 'Nguyen Truong', 'CT4022', 'Chính quy', '2000-12-13', 'Thoi Lai', b'00', '09090904435', '2015-2016'),
('C15002219', 'Lam Quy', 'Ct1022', 'Chính quy', '1994-02-19', 'Thot Not - Can Tho', b'00', '098989334', '2004- 2008'),
('C1500222', 'Nguyen Tuyet', 'Ct1022', 'Chính quy', '1992-12-12', 'Thoi Lai - Can Tho', b'00', '0123456789', '2014-2018'),
('C1500223', 'Nguyen Hoang', 'DI2222', 'Chính quy', '2011-12-12', 'Can Tho', b'01', '090909022', '2012- 2013'),
('C1600222', 'Nguyen Minh Tuyet', 'DI2222', 'Chính quy', '1996-11-18', 'Can Tho', b'01', '0945454322', '2014-2015'),
('C1700222', 'Nguyen Tuyet', 'DI2222', 'Chính quy', '1994-11-11', 'O Mon - Can Tho', b'01', '0966666667', '2013-2016');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Diem`
--
ALTER TABLE `Diem`
  ADD PRIMARY KEY (`MaSV`,`MaMH`),
  ADD KEY `fk_maHP` (`MaMH`);

--
-- Indexes for table `GiangVien`
--
ALTER TABLE `GiangVien`
  ADD PRIMARY KEY (`MaGV`);

--
-- Indexes for table `HocPhan`
--
ALTER TABLE `HocPhan`
  ADD PRIMARY KEY (`MaHP`);

--
-- Indexes for table `Lop`
--
ALTER TABLE `Lop`
  ADD PRIMARY KEY (`MaLop`);

--
-- Indexes for table `SinhVien`
--
ALTER TABLE `SinhVien`
  ADD PRIMARY KEY (`MaSV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Diem`
--
ALTER TABLE `Diem`
  ADD CONSTRAINT `fk_maHP` FOREIGN KEY (`MaMH`) REFERENCES `HocPhan` (`MaHP`),
  ADD CONSTRAINT `fk_masv` FOREIGN KEY (`MaSV`) REFERENCES `SinhVien` (`MaSV`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
