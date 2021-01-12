-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.18 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- kiosk 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `kiosk` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kiosk`;

-- 테이블 kiosk.drinkkiosk 구조 내보내기
CREATE TABLE IF NOT EXISTS `drinkkiosk` (
  `cider` int(11) NOT NULL DEFAULT '0',
  `coke` int(11) NOT NULL DEFAULT '0',
  `fanta` int(11) NOT NULL DEFAULT '0',
  `pocarisweat` int(11) NOT NULL DEFAULT '0',
  `ciderPrice` int(11) NOT NULL DEFAULT '0',
  `cokePrice` int(11) NOT NULL DEFAULT '0',
  `fantaPrice` int(11) NOT NULL DEFAULT '0',
  `pocariPrice` int(11) NOT NULL DEFAULT '0',
  `remainingAmount` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 kiosk.drinkkiosk:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `drinkkiosk` DISABLE KEYS */;
INSERT IGNORE INTO `drinkkiosk` (`cider`, `coke`, `fanta`, `pocarisweat`, `ciderPrice`, `cokePrice`, `fantaPrice`, `pocariPrice`, `remainingAmount`) VALUES
	(3, 7, 6, 10, 1500, 2000, 2000, 2500, 84500);
/*!40000 ALTER TABLE `drinkkiosk` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
