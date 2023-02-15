/*
 Navicat Premium Data Transfer

 Source Server         : BreonGao
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : ivf-back

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 15/02/2023 11:07:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '住宅电话',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '$10$b.yYEQ.vGPxMdDiOaAbU8eKiRQxfOfZGzci8wHtrwRmEBS4xlwXSS' COMMENT '密码',
  `userface` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `remark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10039 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `rId` int(0) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rId`) USING BTREE,
  INDEX `adminId`(`adminId`) USING BTREE,
  CONSTRAINT `t_admin_role_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `t_admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_admin_role_ibfk_2` FOREIGN KEY (`rId`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_alarm_notify_list
-- ----------------------------
DROP TABLE IF EXISTS `t_alarm_notify_list`;
CREATE TABLE `t_alarm_notify_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(0) NULL DEFAULT NULL COMMENT '员工编号',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `commType` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通知方式',
  `commNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通知号码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_alarm_notify_list_ibfk_3`(`adminId`) USING BTREE,
  CONSTRAINT `t_alarm_notify_list_ibfk_3` FOREIGN KEY (`adminId`) REFERENCES `t_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_cycle
-- ----------------------------
DROP TABLE IF EXISTS `t_cycle`;
CREATE TABLE `t_cycle`  (
  `ccId` int(0) NOT NULL AUTO_INCREMENT COMMENT '周期编号',
  `tcId` int(0) NULL DEFAULT NULL COMMENT '所属诊案编号',
  `ccNum` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '周期次序',
  `step1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第一阶段是否完成',
  `step2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第二阶段是否完成',
  `step3` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第三阶段是否完成',
  `step4` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第四阶段是否完成',
  `step5` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第五阶段是否完成',
  `step6` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第六阶段是否完成',
  PRIMARY KEY (`ccId`) USING BTREE,
  INDEX `t_cycle_ibfk_1`(`tcId`) USING BTREE,
  CONSTRAINT `t_cycle_ibfk_1` FOREIGN KEY (`tcId`) REFERENCES `t_treatment_case` (`tcId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_experiment_opt
-- ----------------------------
DROP TABLE IF EXISTS `t_experiment_opt`;
CREATE TABLE `t_experiment_opt`  (
  `expId` int(0) NOT NULL AUTO_INCREMENT COMMENT '实验操作编号',
  `operandId` int(0) NULL DEFAULT NULL COMMENT '操作对象编号',
  `expType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实验种类',
  `expName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实验内容',
  `expDate` datetime(0) NULL DEFAULT NULL COMMENT '实验时间',
  `operatorId` int(0) NULL DEFAULT NULL COMMENT '操作人员编号',
  `cycleNum` int(0) NULL DEFAULT NULL COMMENT '周期',
  PRIMARY KEY (`expId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'url',
  `path` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'path',
  `component` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组件',
  `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `iconCls` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keepAlive` tinyint(1) NULL DEFAULT NULL COMMENT '是否保持激活',
  `requireAuth` tinyint(1) NULL DEFAULT NULL COMMENT '是否要求权限',
  `parentId` int(0) NULL DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentId`(`parentId`) USING BTREE,
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_role`;
CREATE TABLE `t_menu_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mId` int(0) NULL DEFAULT NULL COMMENT '菜单id',
  `rId` int(0) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mId`) USING BTREE,
  INDEX `rid`(`rId`) USING BTREE,
  CONSTRAINT `t_menu_role_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_menu_role_ibfk_2` FOREIGN KEY (`rId`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 854 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_patient
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient`  (
  `ptId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `citizenId` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `gender` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `nativePlace` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `address` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `spouseId` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配偶身份证号',
  `spouse` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配偶姓名',
  `medicalHistory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '病史',
  PRIMARY KEY (`ptId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10038 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sample_egg
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_egg`;
CREATE TABLE `t_sample_egg`  (
  `seId` int(0) NOT NULL AUTO_INCREMENT COMMENT '受精卵编号',
  `tcId` int(0) NULL DEFAULT NULL COMMENT '诊案编号',
  `saveCount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存放器皿编号',
  `saveLocation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '培养箱编号',
  `refStoreTankId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '液氮冷冻罐编号',
  `stage` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所处于的培养阶段',
  `isOosed` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '受精状态',
  `collectDate` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  `expId` int(0) NULL DEFAULT NULL COMMENT '实验编号',
  `number` int(0) NULL DEFAULT NULL COMMENT '数量',
  `conditions` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`seId`) USING BTREE,
  INDEX `expId`(`expId`) USING BTREE,
  INDEX `t_sample_egg_ibfk_1`(`tcId`) USING BTREE,
  CONSTRAINT `t_sample_egg_ibfk_1` FOREIGN KEY (`tcId`) REFERENCES `t_treatment_case` (`tcId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_sample_egg_ibfk_2` FOREIGN KEY (`expId`) REFERENCES `t_experiment_opt` (`expId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sample_sperm
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_sperm`;
CREATE TABLE `t_sample_sperm`  (
  `ssId` int(0) NOT NULL AUTO_INCREMENT COMMENT '样本编号',
  `tcId` int(0) NULL DEFAULT NULL COMMENT '诊案编号',
  `position` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存放位置',
  `containerId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存放容器编号',
  `collectDate` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  `expId` int(0) NULL DEFAULT NULL COMMENT '实验编号',
  `conditions` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ssId`) USING BTREE,
  INDEX `tcId`(`tcId`) USING BTREE,
  CONSTRAINT `t_sample_sperm_ibfk_1` FOREIGN KEY (`tcId`) REFERENCES `t_treatment_case` (`tcId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_treatment_case
-- ----------------------------
DROP TABLE IF EXISTS `t_treatment_case`;
CREATE TABLE `t_treatment_case`  (
  `tcId` int(0) NOT NULL AUTO_INCREMENT COMMENT '诊案编号',
  `fpatientId` int(0) NULL DEFAULT NULL COMMENT '患者女编号',
  `mpatientId` int(0) NULL DEFAULT NULL COMMENT '患者男编号',
  `beginDate` date NULL DEFAULT NULL COMMENT '开始日期',
  `endDate` date NULL DEFAULT NULL COMMENT '结束日期',
  `rfid` char(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'RFID卡编号',
  `step` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前阶段',
  `state` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `cycleNum` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '周期数',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简要描述',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`tcId`) USING BTREE,
  INDEX `t_treatment_case_ibfk_1`(`fpatientId`) USING BTREE,
  INDEX `t_treatment_case_ibfk_2`(`mpatientId`) USING BTREE,
  CONSTRAINT `t_treatment_case_ibfk_1` FOREIGN KEY (`fpatientId`) REFERENCES `t_patient` (`ptId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_treatment_case_ibfk_2` FOREIGN KEY (`mpatientId`) REFERENCES `t_patient` (`ptId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_treatment_rec
-- ----------------------------
DROP TABLE IF EXISTS `t_treatment_rec`;
CREATE TABLE `t_treatment_rec`  (
  `trId` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '就诊编号',
  `patientId` int(0) NULL DEFAULT NULL COMMENT '患者编号',
  `docId` int(0) NULL DEFAULT NULL COMMENT '医生编号',
  `treatmentProgram` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '就诊项目',
  `prescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方项目',
  `trDate` datetime(0) NULL DEFAULT NULL COMMENT '就诊时间',
  `fee` double(255, 2) UNSIGNED NULL DEFAULT NULL COMMENT '费用',
  PRIMARY KEY (`trId`) USING BTREE,
  INDEX `t_treatment_rec_ibfk_1`(`docId`) USING BTREE,
  INDEX `patientId`(`patientId`) USING BTREE,
  CONSTRAINT `t_treatment_rec_ibfk_1` FOREIGN KEY (`docId`) REFERENCES `t_admin` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `t_treatment_rec_ibfk_2` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`ptId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_wit_log
-- ----------------------------
DROP TABLE IF EXISTS `t_wit_log`;
CREATE TABLE `t_wit_log`  (
  `logId` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `checkType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '核对类型',
  `dateTime` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `rfid1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '芯片1编号',
  `rfid1Rectime` datetime(0) NULL DEFAULT NULL COMMENT '芯片1记录时间',
  `rfid2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '芯片2编号',
  `rfid2Rectime` datetime(0) NULL DEFAULT NULL COMMENT '芯片2记录时间',
  `results` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结果',
  `resComment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结果描述',
  PRIMARY KEY (`logId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into t_department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from t_department where id=parentId;
  update t_department set depPath=concat(pDepPath,'.',did) where id=did;
  update t_department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
  select count(*) into a from t_department where id=did and isParent=false;
  if a=0 then set result=-2;
  else
  select count(*) into ecount from t_employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from t_department where id=did;
  delete from t_department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from t_department where parentId=pid;
  if pcount=0 then update t_department set isParent=false where id=pid;
  end if;
  end if;
  end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
