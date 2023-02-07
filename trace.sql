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

 Date: 28/08/2022 16:25:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for trace
-- ----------------------------
DROP TABLE IF EXISTS `trace`;
CREATE TABLE `trace`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `traceability_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '溯源id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `date_of_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产日期',
  `manufactor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家电话',
  `listing_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上架日期',
  `courier_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `term_of_validity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效期',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  `delivery_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of trace
-- ----------------------------
INSERT INTO `trace` VALUES (1, '555', '可乐', '2022/8/6', '米奇妙妙屋', '12345678910', '2022/8/5', '123', '8个月', '芜湖起飞', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (2, '555', '荔枝', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '11', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (3, '555', '烤鱼', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '31', '8个月', '芜湖', '12345678910', '2022/8/6');
INSERT INTO `trace` VALUES (4, '555', '格拉条', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '1', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (5, '555', '牛肉汤', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (7, '555', '炸蘑菇', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (8, '555', '油饼', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (9, '555', '树脂', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '12', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (10, '555', '兰州拉面', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '13', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (11, '555', '鸭腿饭', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '231231', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (12, '555', '黄焖鸡', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (13, '555', '123', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '1231', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (14, '555', '23', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '23', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (15, '555', '23', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '12', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (19, '555', '23', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (20, '555', '3', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (21, '555', '23', '2022/8/5', '米奇妙妙屋', '12345678910', '2022/8/5', '3123', '8个月', '芜湖', '12345678910', '2022/8/5');
INSERT INTO `trace` VALUES (25, '888', '888', '777', '888', '888', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (26, '999', '999', '999', '999', '999', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (27, '8848', '泰罗奥特曼', 'hhhha', 'hhhha', 'hhhha', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (28, '998', 'qwe', '艾克斯奥特曼', '捷德奥特曼', 'ttt', '123', '123', '123', '112', '123', '123');
INSERT INTO `trace` VALUES (32, '666', '螺蛳粉', '2022/8/9', '地球', '1231241241', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (33, '123', '荔枝', '2022/8/9', '全民制作', '18723452352', '2022/8/24', '13213187412', '3个月', '蓝球', '15167823494', '2022/8/24');
INSERT INTO `trace` VALUES (35, '777', '777', '777', '777', '777', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (36, '888', '888', '888', '888', '888', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `trace` VALUES (37, '999', '999', '999', '999', '999', '123', '123', '123', '123', '132', '123');
INSERT INTO `trace` VALUES (39, '678', '678', '678', '678', '678', '2022/8/15', 'ybdjszfes1231', '8年', 'gutrrrr', '123162481', '2022/8/16');
INSERT INTO `trace` VALUES (42, '79375', '3543', '5345', '345', '345', '213', '123', '3213', '14', '1231', '412');
INSERT INTO `trace` VALUES (43, '343453', '123', '123', '1231', '23123', '1231', '2312', '421', '21', '23124', '124');
INSERT INTO `trace` VALUES (44, '123', '123', '123', '1231', '23132', 'tert', 'erte', 'rte', 'ert', 'ert', 'ert');
INSERT INTO `trace` VALUES (45, '9889', '123123', '1241', '231', '23142', 'jjjj', 'jjj', 'jjj', 'jjj', 'jjj', 'jjj');
INSERT INTO `trace` VALUES (46, '444', '44', 'hh', '4', '44', '44', '44', '44', '44', '44', '44');
INSERT INTO `trace` VALUES (47, '7777', '77', '7', '7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `trace` VALUES (48, '7856', '1231', '21', '4124', '1241', '123', '123', '123', '123', '123', '1231');
INSERT INTO `trace` VALUES (49, '3754', 'qwe', 'qweq', 'weq', 'weq', 'ryqt', 'hhh', 'kkk', '54te', 'ggg', 'qweq');
INSERT INTO `trace` VALUES (50, '234', '234', '234', '234', '234', '23', '2342', '342', '342', '235', '4234');
INSERT INTO `trace` VALUES (53, '6666', '66', '66', '6', '7', '123', '123', '123', '123', '123', '123');
INSERT INTO `trace` VALUES (55, '78', '123', '123', '123', '123', '123', '123', '123', '123', '123', '132');

SET FOREIGN_KEY_CHECKS = 1;
