-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.6.32-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- fyl 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `fyl` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fyl`;


-- 테이블 fyl.account 구조 내보내기
CREATE TABLE IF NOT EXISTS `account` (
  `USER_ID` varchar(50) NOT NULL,
  `PASSWD` varchar(100) DEFAULT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `USER_EMAIL` varchar(50) DEFAULT NULL,
  `EMAIL_YN` char(1) DEFAULT NULL,
  `PHONE` varchar(11) DEFAULT NULL,
  `SMS_YN` char(1) DEFAULT NULL,
  `REG_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `PERMIT` char(50) DEFAULT 'N',
  `UPT_USER_ID` varchar(50) DEFAULT NULL,
  `UPT_DATE` datetime DEFAULT NULL,
  `AUTH_TOKEN` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 fyl.account:~18 rows (대략적) 내보내기
DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`USER_ID`, `PASSWD`, `USER_NAME`, `USER_EMAIL`, `EMAIL_YN`, `PHONE`, `SMS_YN`, `REG_DATE`, `PERMIT`, `UPT_USER_ID`, `UPT_DATE`, `AUTH_TOKEN`) VALUES
	('aefaf', '$2a$10$aTVnUjs3Qrf7.xurULm5OuGaW0r29KiMMD.0X8tQPf4W7qtopMBSu', 'awefawf', 'dlxotn12345@naver.com', 'Y', '124122142', 'Y', '2016-12-29 16:25:15', 'N', NULL, NULL, '$2a$10$Z30PEt3XQHZ1FEnyceldQePD1WeoRlEE8RRwtj5b1nDvryGlU/CMW'),
	('aefafa', '$2a$10$0wl9xA3EOBDXqeTaAJxkcOplRdtXSfRRqFF6heXTKCVCt2zrwSRfe', 'awfeweaf', 'dlxotn12345@naver.com', 'Y', 'afeafw', 'Y', '2016-12-29 16:28:28', 'N', NULL, NULL, '$2a$10$vU8mTC06r8sQAEb3LL1HuOkQNpQhT58VM9txU8w3TKRazpNA/He0C'),
	('afewafeawf', '$2a$10$i0t.h8tO7/Srk6xnjCKiQeWWaHKggEVBsZ3tMSD/gxWA1ZAivy.q.', 'tawetawtw', 'dlxotn12345@naver.com', 'Y', '0102221141', 'Y', '2016-12-29 16:16:38', 'N', NULL, NULL, '$2a$10$gsoYHR73PjCyIi6zyEGrM.dRlzA.5cg52ATSH1frgE9cKaa4GygLy'),
	('authtoekntet', '$2a$10$.Pz5b/l48561Z8GSpXjulOHaarCVZcCKWXK259Z4XznUbKjblTE5C', '마이네임', 'dlxotn12345@naver.com', 'Y', 'aefawf', 'Y', '2016-12-29 16:09:05', 'N', NULL, NULL, '$2a$10$w/yH6DZaziU5F8kEuoaqkecIkdthMUPWYmnk1IxaQIlNPQ3aSAvPa'),
	('awefawf', '$2a$10$SMD1GQVnKSbB/qGCRYYJTePGHciBXNh9hq0hQQCC0OyMjShKLbY1q', 'awefwafw', 'dlxotn12345@naver.com', 'Y', '0123123', 'N', '2016-12-29 17:30:35', 'N', NULL, NULL, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0ODMwODY2MzM4NTksImlkIjoiZGx4b3RuMTIzNDVAbmF2ZXIuY29tIn0.4bwRrvhzkiODrmv9gqGWFAM-QonNy3ePcugntE-2554'),
	('awefawfawef', '$2a$10$ebw5Ri4BNqtI9B1YjEj3q.35SHF7UQH/yHIly2p4BO2sAw1N8IRZm', 'aefaewf', 'dlxotn12345@naver.com', 'Y', '02103130', 'Y', '2016-12-29 17:28:27', 'N', NULL, NULL, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0ODMwODY1MDYxMjgsImlkIjoiZGx4b3RuMTIzNDVAbmF2ZXIuY29tIn0.d6ospHaPHBAPf60CGJO5UW_w7xwNhMuApU8eXjNVVTk'),
	('callbacktest2', '$2a$10$RkKV50ePKnME0pt2CSBVW.Uac05eCtFcvglUpR3dDMuNF9ARJt2NG', 'ㅁㄷㄻㅈㄹ', 'dlxotn12345@naver.com', 'Y', '0242140', 'Y', '2016-12-29 16:01:29', 'N', NULL, NULL, NULL),
	('feawfwaf', '$2a$10$1WHAhuwEGC1oiJIVaFuRsuME/42RnHa9mBT/BjGrmDv6kPXYVr.Jm', 'awefawf', 'dlxotn12345@naver.com', 'Y', '0123021', 'Y', '2016-12-29 16:23:42', 'N', NULL, NULL, '$2a$10$jyx5tPVSF4/AqodTB90tU.SF29Xb2wNzGamc26s8qEXWgIdIWiVv.'),
	('master', '$2a$10$I5chPX.tbnoX4ublkzIcvOecgDwkhHFqmH.o2zkwyyV/WJbbeUkWK', '마스터', 'dlxotn12345@naver.com', 'Y', '01099952723', 'Y', '2016-12-26 20:11:11', 'Y', NULL, NULL, NULL),
	('test', '$2a$10$AY6ykyUp6V84ibUR6JxO1uTvhkseIdddSjBylC7316LeSZTwgSnNu', '테스트', 'test@test.com', 'Y', '123123213', 'Y', '2016-12-26 22:17:40', 'N', NULL, NULL, NULL),
	('testaccount', '$2a$10$iY4ZkDimqeWhIGHEewDQu.gth4uS5s.0sdRRlT/y.zNrYZuuM022q', 'ㅁㄷㄻ', 'dlxotn12345@naver.com', 'Y', '014241124', 'Y', '2016-12-29 17:20:20', 'N', NULL, NULL, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0ODMwODYwMTM4ODcsImlkIjoiZGx4b3RuMTIzNDVAbmF2ZXIuY29tIn0.bLNrnPdUgkQA-VKz_ojNJamvQQAVSAoplfd3J5u_U4c'),
	('testforemail', '$2a$10$TRKyS.h0pWCL2.uAGbs4L.lDITJzFNoDMmCveMwUS/pJGD.jJ5d3e', '이메일테스트용', 'dlxotn12345@naver.com', 'Y', '01099951154', 'N', '2016-12-29 11:36:16', 'N', NULL, NULL, NULL),
	('testforMime', '$2a$10$I89xJzT0gYB0a/TOXO1PM.NQplABvOxj47gieiw.2KhyX0NQqm0M6', '테스트를위한마임', 'dlxotn12345@naver.com', 'Y', '01012131241', 'N', '2016-12-29 13:42:44', 'N', NULL, NULL, NULL),
	('testforNaver', '$2a$10$Nx4B6GZYjLMvb8cQ6ZiDHOG02MMBeXTUsnBsqaaVrGBR4y9EJXw0a', '네이버테스트용', 'dlxotn12345@naver.com', 'N', '01022145561', 'Y', '2016-12-29 12:37:16', 'N', NULL, NULL, NULL),
	('testId', '$2a$10$e.6NwUCRUru4HCV60sanQ.4eaKQF6oraNABF0Dk0jMInCGvb5OgXi', 'testName', 'test@email.com', 'N', '01099952723', 'Y', '2016-12-22 21:00:28', 'N', NULL, NULL, NULL),
	('testlocalname', '$2a$10$G4CsSzm1YCEfiW6O3rTEo.mykxXK9qDq8TWFdz4pAEZjqMnVQrWtO', 'aefawf', 'dlxotn12345@naver.com', 'Y', 'aefawf', 'Y', '2016-12-29 15:47:33', 'N', NULL, NULL, NULL),
	('testMailAll', '$2a$10$D8jYhpu7D66nn30YPPY4JeiFXjqIsuWAMe1/HdCo3.sBUPAZtZTCS', '통합메일테스트', 'dlxotn12345@naver.com', 'Y', '01022213145', 'Y', '2016-12-29 12:41:27', 'N', NULL, NULL, NULL),
	('tokentest', '$2a$10$7LpqnTkgYtguRtube88Jbuzc6l/2pshWBIrI64fb0xmeqfG.rWdx2', '토큰테스트', 'dlxotn12345@naver.com', 'Y', '214214214', 'Y', '2016-12-29 15:43:50', 'N', NULL, NULL, NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- 테이블 fyl.account_authority_mapping 구조 내보내기
CREATE TABLE IF NOT EXISTS `account_authority_mapping` (
  `USER_ID` varchar(50) DEFAULT NULL,
  `AUTH_NAME` varchar(50) DEFAULT NULL,
  KEY `FK_account_authority_mapping_account` (`USER_ID`),
  KEY `FK_account_authority_mapping_authority` (`AUTH_NAME`),
  CONSTRAINT `FK_account_authority_mapping_account` FOREIGN KEY (`USER_ID`) REFERENCES `account` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_account_authority_mapping_authority` FOREIGN KEY (`AUTH_NAME`) REFERENCES `authority` (`AUTH_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 fyl.account_authority_mapping:~18 rows (대략적) 내보내기
DELETE FROM `account_authority_mapping`;
/*!40000 ALTER TABLE `account_authority_mapping` DISABLE KEYS */;
INSERT INTO `account_authority_mapping` (`USER_ID`, `AUTH_NAME`) VALUES
	('testId', 'ROLE_USER'),
	('master', 'ROLE_MASTER'),
	('test', 'ROLE_USER'),
	('testforemail', 'ROLE_USER'),
	('testforNaver', 'ROLE_USER'),
	('testMailAll', 'ROLE_USER'),
	('testforMime', 'ROLE_USER'),
	('tokentest', 'ROLE_USER'),
	('testlocalname', 'ROLE_USER'),
	('callbacktest2', 'ROLE_USER'),
	('authtoekntet', 'ROLE_USER'),
	('afewafeawf', 'ROLE_USER'),
	('feawfwaf', 'ROLE_USER'),
	('aefaf', 'ROLE_USER'),
	('aefafa', 'ROLE_USER'),
	('testaccount', 'ROLE_USER'),
	('awefawfawef', 'ROLE_USER'),
	('awefawf', 'ROLE_USER');
/*!40000 ALTER TABLE `account_authority_mapping` ENABLE KEYS */;


-- 테이블 fyl.authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `authority` (
  `AUTH_NAME` varchar(50) NOT NULL DEFAULT '0',
  `DESCRIPTION` varchar(50) DEFAULT '0',
  PRIMARY KEY (`AUTH_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 fyl.authority:~3 rows (대략적) 내보내기
DELETE FROM `authority`;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`AUTH_NAME`, `DESCRIPTION`) VALUES
	('ROLE_ADMIN', 'ADMIN'),
	('ROLE_MASTER', 'MASTER'),
	('ROLE_USER', 'USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
