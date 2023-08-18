/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : curd

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 18/08/2023 12:13:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '索引主键',
  `user` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `image` longblob NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1692383640294486018', 'root', 'root', '男', '1565541068', NULL);
INSERT INTO `t_user` VALUES ('1692384282639560705', 'root1', 'root', '男', '1565541068', NULL);
INSERT INTO `t_user` VALUES ('1692384300121419777', 'root2', 'root', '男', '1565541068', NULL);
INSERT INTO `t_user` VALUES ('1692384315493543938', 'root3', 'root', '男', '1565541068', NULL);
INSERT INTO `t_user` VALUES ('1692384329787731970', 'root4', 'root', '男', '1565541068', NULL);
INSERT INTO `t_user` VALUES ('1692384342567776258', 'root5', 'root', '男', '1565541068', NULL);

SET FOREIGN_KEY_CHECKS = 1;
