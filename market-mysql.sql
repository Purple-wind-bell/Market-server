-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.2-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5261
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 market-web 的数据库结构
CREATE DATABASE IF NOT EXISTS `market-web` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `market-web`;

-- 导出  表 market-web.business 结构
CREATE TABLE IF NOT EXISTS `business` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家表';

-- 正在导出表  market-web.business 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `business` DISABLE KEYS */;
/*!40000 ALTER TABLE `business` ENABLE KEYS */;

-- 导出  表 market-web.cart 结构
CREATE TABLE IF NOT EXISTS `cart` (
  `userId` varchar(50) NOT NULL,
  `productId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- 正在导出表  market-web.cart 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;

-- 导出  表 market-web.category 结构
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  market-web.category 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`, `description`) VALUES
	(3, '让各个', '让个耳光'),
	(4, '我的钱', '气得我'),
	(5, '33日让前r', '3人情味'),
	(6, '11', '14214142 '),
	(7, '124让35', 'Y35UY');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 导出  表 market-web.order 结构
CREATE TABLE IF NOT EXISTS `order` (
  `id` varchar(255) NOT NULL COMMENT '订单号',
  `status` int(11) NOT NULL COMMENT '0-未支付，1-已支付，2-已发货，3-完成',
  `userId` varchar(50) NOT NULL COMMENT '客户id',
  `pay` float unsigned NOT NULL COMMENT '支付金额',
  `gentime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '订单生成时间',
  `paytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '支付时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  market-web.order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- 导出  表 market-web.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `ownerId` varchar(50) NOT NULL DEFAULT '0',
  `price` float NOT NULL DEFAULT 0,
  `path` varchar(255) NOT NULL DEFAULT '0',
  `filename` varchar(255) NOT NULL DEFAULT '0',
  `description` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';

-- 正在导出表  market-web.product 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 导出  表 market-web.token 结构
CREATE TABLE IF NOT EXISTS `token` (
  `userId` varchar(50) NOT NULL,
  `uuid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  market-web.token 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;

-- 导出  表 market-web.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL COMMENT '用户ID，UUID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `phone` varchar(50) NOT NULL COMMENT '用户手机号',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- 正在导出表  market-web.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
