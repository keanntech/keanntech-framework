-- ----------------------------
-- 后台用户表
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `portrait` varchar(500) DEFAULT '' COMMENT '头像',
  `email` varchar(100) DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(200) NOT NULL COMMENT '昵称',
  `description` varchar(500) DEFAULT '' COMMENT '备注信息',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `update_id` bigint(20) NOT NULL COMMENT '修改人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `login_time` datetime NOT NULL COMMENT '最后登录时间',
  `enabled` tinyint(1) DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `deleted` tinyint(1) DEFAULT 0 COMMENT '帐号是否被删除：0->未删除；1->删除',
  `locked` tinyint(1) DEFAULT 0 COMMENT '帐号是否被锁定：0->未锁定；1->锁定',
  PRIMARY KEY (`id`),
  UNIQUE INDEX uniq_inx(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES (1, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test@qq.com', '测试账号', '', 1,1,'2018-09-29 13:55:30', '2018-09-29 13:55:39','2018-09-29 13:55:39', 1,0,0);

-- ----------------------------
-- 角色表
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `description` varchar(500) DEFAULT '' COMMENT '描述',
  `sort` int(11) DEFAULT 0,
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `update_id` bigint(20) NOT NULL COMMENT '修改人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `enable` tinyint(1) DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
  `deleted` tinyint(1) DEFAULT 0 COMMENT '帐号是否被删除：0->未删除；1->删除',
  PRIMARY KEY (`id`),
  UNIQUE INDEX uniq_inx(`role_name`,`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', '商品管理员', 'padmin', '只能查看及操作商品', 1,1,1,'2020-02-03 16:50:37','2020-02-03 16:50:37', '1', '0');
INSERT INTO `ums_role` VALUES ('2', '订单管理员', 'oadmin', '只能查看及操作订单', 1,1,1,'2018-09-30 15:53:45', '2020-02-03 16:50:37','1', '0');
INSERT INTO `ums_role` VALUES ('5', '超级管理员', 'sadmin', '拥有所有查看和操作功能', 1,1,1,'2020-02-02 15:11:05','2020-02-03 16:50:37', '1', '0');



-- ----------------------------
-- 用户权限
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL COMMENT '父级权限id',
  `permission_name` varchar(100) NOT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT '' COMMENT '权限值',
  `icon` varchar(500) DEFAULT '' COMMENT '图标',
  `type` tinyint(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT '' COMMENT '前端资源路径',
  `description` varchar(500) DEFAULT '' COMMENT '描述',
  `sort` int(11) DEFAULT 0 COMMENT '排序',
  `enable` tinyint(1) DEFAULT 1 COMMENT '启用状态；0->禁用；1->启用',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `update_id` bigint(20) NOT NULL COMMENT '修改人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT 0 COMMENT '帐号是否被删除：0->未删除；1->删除',
  PRIMARY KEY (`id`),
  UNIQUE INDEX uniq_inx(`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户权限表';

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
INSERT INTO `ums_permission` VALUES ('1', '0', '商品', null, null, '0', null, '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` VALUES ('2', '1', '商品列表', 'pms:product:read', null, '1', '/pms/product/index', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('3', '1', '添加商品', 'pms:product:create', null, '1', '/pms/product/add', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('4', '1', '商品分类', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('5', '1', '商品类型', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('6', '1', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('7', '2', '编辑商品', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('8', '2', '删除商品', 'pms:product:delete', null, '2', '/pms/product/delete', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` VALUES ('9', '4', '添加商品分类', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('10', '4', '修改商品分类', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('11', '4', '删除商品分类', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` VALUES ('12', '5', '添加商品类型', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` VALUES ('13', '5', '修改商品类型', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` VALUES ('14', '5', '删除商品类型', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('15', '6', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('16', '6', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('17', '6', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);
INSERT INTO `ums_permission` VALUES ('18', '0', '首页', null, null, '0', null, '1', 1,1,1,1,'2018-09-29 16:15:14','2018-09-29 16:15:14',0);



-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新人',
  `resource_name` varchar(200) DEFAULT '' COMMENT '资源名称',
  `url` varchar(200) DEFAULT '' COMMENT '资源URL',
  `description` varchar(500) DEFAULT '' COMMENT '描述',
  `category_id` bigint(20) DEFAULT NULL COMMENT '资源分类ID',
  `deleted` tinyint(1) DEFAULT 0 COMMENT '帐号是否被删除：0->未删除；1->删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台资源表';

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource` VALUES ('1', '2020-02-04 17:04:55', '2020-02-04 17:04:55', 1, 1, '商品品牌管理', '/brand/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('2', '2020-02-04 17:05:35', '2020-02-04 17:04:55', 1, 1,'商品属性分类管理', '/productAttribute/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('3', '2020-02-04 17:06:13', '2020-02-04 17:04:55', 1, 1,'商品属性管理', '/productAttribute/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('4', '2020-02-04 17:07:15', '2020-02-04 17:04:55', 1, 1,'商品分类管理', '/productCategory/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('5', '2020-02-04 17:09:16', '2020-02-04 17:04:55', 1, 1,'商品管理', '/product/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('6', '2020-02-04 17:09:53', '2020-02-04 17:04:55', 1, 1,'商品库存管理', '/sku/**', null, '1',0);
INSERT INTO `ums_resource` VALUES ('8', '2020-02-05 14:43:37', '2020-02-04 17:04:55', 1, 1,'订单管理', '/order/**', '', '2',0);
INSERT INTO `ums_resource` VALUES ('9', '2020-02-05 14:44:22', '2020-02-04 17:04:55', 1, 1,' 订单退货申请管理', '/returnApply/**', '', '2',0);
INSERT INTO `ums_resource` VALUES ('10', '2020-02-05 14:45:08', '2020-02-04 17:04:55', 1, 1,'退货原因管理', '/returnReason/**', '', '2',0);
INSERT INTO `ums_resource` VALUES ('11', '2020-02-05 14:45:43', '2020-02-04 17:04:55', 1, 1,'订单设置管理', '/orderSetting/**', '', '2',0);
INSERT INTO `ums_resource` VALUES ('12', '2020-02-05 14:46:23', '2020-02-04 17:04:55', 1, 1,'收货地址管理', '/companyAddress/**', '', '2',0);
INSERT INTO `ums_resource` VALUES ('13', '2020-02-07 16:37:22', '2020-02-04 17:04:55', 1, 1,'优惠券管理', '/coupon/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('14', '2020-02-07 16:37:59', '2020-02-04 17:04:55', 1, 1,'优惠券领取记录管理', '/couponHistory/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('15', '2020-02-07 16:38:28', '2020-02-04 17:04:55', 1, 1,'限时购活动管理', '/flash/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('16', '2020-02-07 16:38:59', '2020-02-04 17:04:55', 1, 1,'限时购商品关系管理', '/flashProductRelation/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('17', '2020-02-07 16:39:22', '2020-02-04 17:04:55', 1, 1,'限时购场次管理', '/flashSession/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('18', '2020-02-07 16:40:07', '2020-02-04 17:04:55', 1, 1,'首页轮播广告管理', '/home/advertise/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('19', '2020-02-07 16:40:34', '2020-02-04 17:04:55', 1, 1,'首页品牌管理', '/home/brand/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('20', '2020-02-07 16:41:06', '2020-02-04 17:04:55', 1, 1,'首页新品管理', '/home/newProduct/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('21', '2020-02-07 16:42:16', '2020-02-04 17:04:55', 1, 1,'首页人气推荐管理', '/home/recommendProduct/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('22', '2020-02-07 16:42:48', '2020-02-04 17:04:55', 1, 1,'首页专题推荐管理', '/home/recommendSubject/**', '', '3',0);
INSERT INTO `ums_resource` VALUES ('23', '2020-02-07 16:44:56', '2020-02-04 17:04:55', 1, 1,'商品优选管理', '/prefrenceArea/**', '', '5',0);
INSERT INTO `ums_resource` VALUES ('24', '2020-02-07 16:45:39', '2020-02-04 17:04:55', 1, 1,'商品专题管理', '/subject/**', '', '5',0);
INSERT INTO `ums_resource` VALUES ('25', '2020-02-07 16:47:34', '2020-02-04 17:04:55', 1, 1,'后台用户管理', '/admin/**', '', '4',0);
INSERT INTO `ums_resource` VALUES ('26', '2020-02-07 16:48:24', '2020-02-04 17:04:55', 1, 1,'后台用户角色管理', '/role/**', '', '4',0);
INSERT INTO `ums_resource` VALUES ('27', '2020-02-07 16:48:48', '2020-02-04 17:04:55', 1, 1,'后台菜单管理', '/menu/**', '', '4',0);
INSERT INTO `ums_resource` VALUES ('28', '2020-02-07 16:49:18', '2020-02-04 17:04:55', 1, 1,'后台资源分类管理', '/resourceCategory/**', '', '4',0);
INSERT INTO `ums_resource` VALUES ('29', '2020-02-07 16:49:45', '2020-02-04 17:04:55', 1, 1,'后台资源管理', '/resource/**', '', '4',0);


-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `category_name` varchar(200) DEFAULT '' COMMENT '分类名称',
  `sort` int(4) DEFAULT 1 COMMENT '排序',
  `deleted` tinyint(1) DEFAULT 0 COMMENT '帐号是否被删除：0->未删除；1->删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源分类表';

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
INSERT INTO `ums_resource_category` VALUES ('1', '2020-02-05 10:21:44', '2020-02-05 10:21:44', 1, 1, '商品模块', '0', 0);
INSERT INTO `ums_resource_category` VALUES ('2', '2020-02-05 10:22:34', '2020-02-05 10:21:44', 1, 1, '订单模块', '0', 0);
INSERT INTO `ums_resource_category` VALUES ('3', '2020-02-05 10:22:48', '2020-02-05 10:21:44', 1, 1, '营销模块', '0', 0);
INSERT INTO `ums_resource_category` VALUES ('4', '2020-02-05 10:23:04', '2020-02-05 10:21:44', 1, 1, '权限模块', '0', 0);
INSERT INTO `ums_resource_category` VALUES ('5', '2020-02-07 16:34:27', '2020-02-05 10:21:44', 1, 1, '内容模块', '0', 0);
INSERT INTO `ums_resource_category` VALUES ('6', '2020-02-07 16:35:49', '2020-02-05 10:21:44', 1, 1, '其他模块', '0', 0);

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES ('26', '3', '5');
INSERT INTO `ums_admin_role_relation` VALUES ('27', '6', '1');
INSERT INTO `ums_admin_role_relation` VALUES ('28', '7', '2');
INSERT INTO `ums_admin_role_relation` VALUES ('29', '1', '5');
INSERT INTO `ums_admin_role_relation` VALUES ('30', '4', '5');

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台角色资源关系表';

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
INSERT INTO `ums_role_resource_relation` VALUES ('103', '2', '8');
INSERT INTO `ums_role_resource_relation` VALUES ('104', '2', '9');
INSERT INTO `ums_role_resource_relation` VALUES ('105', '2', '10');
INSERT INTO `ums_role_resource_relation` VALUES ('106', '2', '11');
INSERT INTO `ums_role_resource_relation` VALUES ('107', '2', '12');
INSERT INTO `ums_role_resource_relation` VALUES ('142', '5', '1');
INSERT INTO `ums_role_resource_relation` VALUES ('143', '5', '2');
INSERT INTO `ums_role_resource_relation` VALUES ('144', '5', '3');
INSERT INTO `ums_role_resource_relation` VALUES ('145', '5', '4');
INSERT INTO `ums_role_resource_relation` VALUES ('146', '5', '5');
INSERT INTO `ums_role_resource_relation` VALUES ('147', '5', '6');
INSERT INTO `ums_role_resource_relation` VALUES ('148', '5', '8');
INSERT INTO `ums_role_resource_relation` VALUES ('149', '5', '9');
INSERT INTO `ums_role_resource_relation` VALUES ('150', '5', '10');
INSERT INTO `ums_role_resource_relation` VALUES ('151', '5', '11');
INSERT INTO `ums_role_resource_relation` VALUES ('152', '5', '12');
INSERT INTO `ums_role_resource_relation` VALUES ('153', '5', '13');
INSERT INTO `ums_role_resource_relation` VALUES ('154', '5', '14');
INSERT INTO `ums_role_resource_relation` VALUES ('155', '5', '15');
INSERT INTO `ums_role_resource_relation` VALUES ('156', '5', '16');
INSERT INTO `ums_role_resource_relation` VALUES ('157', '5', '17');
INSERT INTO `ums_role_resource_relation` VALUES ('158', '5', '18');
INSERT INTO `ums_role_resource_relation` VALUES ('159', '5', '19');
INSERT INTO `ums_role_resource_relation` VALUES ('160', '5', '20');
INSERT INTO `ums_role_resource_relation` VALUES ('161', '5', '21');
INSERT INTO `ums_role_resource_relation` VALUES ('162', '5', '22');
INSERT INTO `ums_role_resource_relation` VALUES ('163', '5', '23');
INSERT INTO `ums_role_resource_relation` VALUES ('164', '5', '24');
INSERT INTO `ums_role_resource_relation` VALUES ('165', '5', '25');
INSERT INTO `ums_role_resource_relation` VALUES ('166', '5', '26');
INSERT INTO `ums_role_resource_relation` VALUES ('167', '5', '27');
INSERT INTO `ums_role_resource_relation` VALUES ('168', '5', '28');
INSERT INTO `ums_role_resource_relation` VALUES ('169', '5', '29');
INSERT INTO `ums_role_resource_relation` VALUES ('170', '1', '1');
INSERT INTO `ums_role_resource_relation` VALUES ('171', '1', '2');
INSERT INTO `ums_role_resource_relation` VALUES ('172', '1', '3');
INSERT INTO `ums_role_resource_relation` VALUES ('173', '1', '4');
INSERT INTO `ums_role_resource_relation` VALUES ('174', '1', '5');
INSERT INTO `ums_role_resource_relation` VALUES ('175', '1', '6');
INSERT INTO `ums_role_resource_relation` VALUES ('176', '1', '23');
INSERT INTO `ums_role_resource_relation` VALUES ('177', '1', '24');