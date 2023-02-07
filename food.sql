/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : fabric

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 28/08/2022 16:24:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `registration_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (1, 'ttt', 'ttt', '生产商');
INSERT INTO `food` VALUES (13, 'yyy', 'yyy', '消费者');
INSERT INTO `food` VALUES (14, 'ooo', 'ooo', '生产商');
INSERT INTO `food` VALUES (17, 'rrr', 'rrr', '经销商');
INSERT INTO `food` VALUES (18, 'fff', 'fff', '消费者');
INSERT INTO `food` VALUES (19, 'ggg', 'ggg', '生产商');
INSERT INTO `food` VALUES (23, 'fff', 'fff', '经销商');
INSERT INTO `food` VALUES (24, 'vvv', 'vvv', '经销商');
INSERT INTO `food` VALUES (44, 'kkk', 'kkk', '经销商');
INSERT INTO `food` VALUES (45, 'jjj', 'jjj', '经销商');
INSERT INTO `food` VALUES (46, '345', '345', '经销商');
INSERT INTO `food` VALUES (47, '1234', '1234f', '生产商');
INSERT INTO `food` VALUES (49, 'admin', 'admin', '生产商');
INSERT INTO `food` VALUES (50, 'nhnh', 'nhnh', '生产商');
INSERT INTO `food` VALUES (51, 'wakuwaku', 'wakuwaku', '生产商');
INSERT INTO `food` VALUES (52, 'vvv', 'vvv', '生产商');

SET FOREIGN_KEY_CHECKS = 1;
