/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-01-21 17:38:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_manager`
-- ----------------------------
DROP TABLE IF EXISTS `book_manager`;
CREATE TABLE `book_manager` (
  `BookUniqueID` int(11) NOT NULL AUTO_INCREMENT,
  `BID` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BookUniqueID`),
  KEY `name` (`name`),
  KEY `BID` (`BID`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_manager
-- ----------------------------
INSERT INTO `book_manager` VALUES ('1', '000A18FDB38F470DBE9CD0972BADB23F', 'Java Web整合开发实战--基于Struts 2+Hibernate+Spring（99个应用实例，4个项目开发案例，15.5小时配套教学视频，超值DVD光盘含大量开发资源。一本书搞定SSH框架整合开发！）');
INSERT INTO `book_manager` VALUES ('2', '0BE0707984014E66BD9F34F534FCE0F7', 'OSGi实战【OSGi规范制定者亲自撰写 汇集Apache项目技术实战经验】');
INSERT INTO `book_manager` VALUES ('3', '0EE8A0AE69154287A378FB110FF2C780', 'Java核心技术：卷Ⅰ基础知识（原书第8版）');
INSERT INTO `book_manager` VALUES ('4', '113D0D1BB9174DD19A7DE7E2B37F677F', 'Java7入门经典（跟编程导师Ivor Horton学Java 预计到货日期9月初）');
INSERT INTO `book_manager` VALUES ('5', '1286B13F0EA54E4CB75434762121486A', 'Java核心技术 卷I：基础知识(第9版·英文版)(上、下册)');
INSERT INTO `book_manager` VALUES ('6', '13EBF9B1FDE346A683A1C45BD6773ECB', 'Java开发实战1200例（第Ⅱ卷）（史上最全的“编程实例”类图书，代码分析、实例速查、练习巩固的绝好帮手）');
INSERT INTO `book_manager` VALUES ('7', '1A15DC5E8A014A58862ED741D579B530', 'Java深入解析——透析Java本质的36个话题');
INSERT INTO `book_manager` VALUES ('8', '210A3DCA429049C78B623C3986BEB136', 'JavaScript经典教程套装：JavaScript高级程序设计(第3版)+JavaScript DOM编程艺术(第2版)(套装共2册)(超值附赠《码农》光盘1张)');
INSERT INTO `book_manager` VALUES ('9', '22234CECF15F4ECB813F0B433DDA5365', 'JavaScript从入门到精通（附光盘1张）（连续8月JavaScript类全国零售排行前2名，13小时视频，400个经典实例、369项面试真题、138项测试史上最全资源库）');
INSERT INTO `book_manager` VALUES ('10', '260F8A3594F741C1B0EB69616F65045B', 'Tomcat与Java Web开发技术详解（第2版）(含光盘1张)');
INSERT INTO `book_manager` VALUES ('11', '28A03D28BAD449659A77330BE35FCD65', 'JAVA核心技术卷II：高级特性（原书第8版）');
INSERT INTO `book_manager` VALUES ('12', '2EE1A20A6AF742E387E18619D7E3BB94', 'Java虚拟机并发编程(Java并发编程领域的里程碑之作，资深Java技术专家、并发编程专家、敏捷开发专家和Jolt大奖得主撰写，Amazon五星畅销书)');
INSERT INTO `book_manager` VALUES ('13', '33ACF97A9A374352AE9F5E89BB791262', '基于MVC的JavaScript Web富应用开发');
INSERT INTO `book_manager` VALUES ('14', '37F75BEAE1FE46F2B14674923F1E7987', '数据结构与算法分析Java语言描述 第2版');
INSERT INTO `book_manager` VALUES ('15', '39F1D0803E8F4592AE1245CACE683214', 'Java程序员修炼之道');
INSERT INTO `book_manager` VALUES ('16', '3AE5C8B976B6448A9D3A155C1BDE12BC', '深入理解Java虚拟机:JVM高级特性与最佳实践（超级畅销书，6个月5次印刷，从实践角度解析JVM工作原理，Java程序员必备）');
INSERT INTO `book_manager` VALUES ('17', '3DD187217BF44A99B86DD18A4DC628BA', 'Java核心技术 卷1 基础知识（原书第9版）');
INSERT INTO `book_manager` VALUES ('18', '3E1990E19989422E9DA735978CB1E4CE', 'Effective Java中文版(第2版)');
INSERT INTO `book_manager` VALUES ('19', '400D94DE5A0742B3A618FC76DF107183', 'JavaScript宝典（第7版）（配光盘）');
INSERT INTO `book_manager` VALUES ('20', '48BBFBFC07074ADE8CC906A45BE5D9A6', 'JavaScript权威指南（第6版）（淘宝前端团队倾情翻译！经典权威的JavaScript犀牛书！第6版特别涵盖了HTML5和ECMAScript5！）（经典巨著，当当独家首发）');
INSERT INTO `book_manager` VALUES ('21', '49D98E7916B94232862F7DCD1B0BAB66', 'HTML5+JavaScript动画基础');
INSERT INTO `book_manager` VALUES ('22', '4A9574F03A6B40C1B2A437237C17DEEC', 'Spring实战(第3版)（In Action系列中最畅销的Spring图书，近十万读者学习Spring的共同选择）');
INSERT INTO `book_manager` VALUES ('23', '4BF6D97DD18A4B77B8DED9B057577F8F', 'Java Web从入门到精通（附光盘1张）（连续8月Java类全国零售排行前2名，27小时视频，951个经典实例、369项面试真题、596项测试史上最全资源库）');
INSERT INTO `book_manager` VALUES ('24', '4C3331CAD5A5453787A94B8D7CCEAA29', 'Java Web整合开发王者归来（JSP+Servlet+Struts+Hibernate+Spring）（配光盘');
INSERT INTO `book_manager` VALUES ('25', '4D20D2450B084113A331D909FF4975EB', 'jQuery实战(第2版)(畅销书升级版，掌握Web开发利器必修宝典)');
INSERT INTO `book_manager` VALUES ('26', '4E44405DAFB7413E8A13BBFFBEE73AC7', 'JavaScript经典实例');
INSERT INTO `book_manager` VALUES ('27', '504FB999B0444B339907090927FDBE8A', '深入浅出Ext JS(第3版)');
INSERT INTO `book_manager` VALUES ('28', '52077C8423B645A9BADA96A5E0B14422', 'Spring源码深度解析');
INSERT INTO `book_manager` VALUES ('29', '52B0EDFF966E4A058BDA5B18EEC698C4', '亮剑Java Web项目开发案例导航(含DVD光盘1张)');
INSERT INTO `book_manager` VALUES ('30', '5315DA60D24042889400AD4C93A37501', 'Spring 3.x企业应用开发实战(含CD光盘1张)');
INSERT INTO `book_manager` VALUES ('31', '56B1B7D8CD8740B098677C7216A673C4', '疯狂 Java 程序员的基本修养（《疯狂Java讲义》最佳拍档，扫清知识死角，夯实基本功）');
INSERT INTO `book_manager` VALUES ('32', '57B6FF1B89C843C38BA39C717FA557D6', '了不起的Node.js: 将JavaScript进行到底（Web开发首选实时 跨多服务器 高并发）');
INSERT INTO `book_manager` VALUES ('33', '5C4A6F0F4A3B4672AD8C5F89BF5D37D2', 'Java从入门到精通（第3版）（附光盘1张）（连续8月Java类全国零售排行前2名，32小时视频，732个经典实例、369项面试真题、616项测试史上最全资源库）');
INSERT INTO `book_manager` VALUES ('34', '5C68141786B84A4CB8929A2415040739', 'JavaScript高级程序设计(第3版)(JavaScript技术名著，国内JavasScript第一书，销量超过8万册)');
INSERT INTO `book_manager` VALUES ('35', '5EDB981339C342ED8DB17D5A198D50DC', 'Java程序性能优化');
INSERT INTO `book_manager` VALUES ('36', '6398A7BA400D40258796BCBB2B256068', 'JavaScript设计模式');
INSERT INTO `book_manager` VALUES ('37', '676B56A612AF4E968CF0F6FFE289269D', 'JavaScript和jQuery实战手册（原书第2版）');
INSERT INTO `book_manager` VALUES ('38', '7917F5B19A0948FD9551932909328E4E', 'Java项目开发案例全程实录（第2版）（配光盘）（软件项目开发全程实录丛书）');
INSERT INTO `book_manager` VALUES ('39', '7C0C785FFBEC4DEC802FA36E8B0BC87E', '深入分析Java Web技术内幕');
INSERT INTO `book_manager` VALUES ('40', '7CD79C20258F477AB841518D9312E843', 'Java程序员面试宝典（第三版）');
INSERT INTO `book_manager` VALUES ('41', '7D7FE81293124793BDB2C6FF1F1C943D', '21天学通Java(第6版)（中文版累计销量超30000册）');
INSERT INTO `book_manager` VALUES ('42', '7FD7F50B15F74248AA769798909F8653', 'Java网络编程（第3版）——O’Reilly Java系列');
INSERT INTO `book_manager` VALUES ('43', '819FF56E4423462394E6F83882F78975', '学通Java Web的24堂课（配光盘）（软件开发羊皮卷）');
INSERT INTO `book_manager` VALUES ('44', '81FADA99309342F4978D5C680B0C6E8C', 'Java入门很简单（配光盘）（入门很简单丛书）（打开Java编程之门 Java技术网推荐）');
INSERT INTO `book_manager` VALUES ('45', '89A57D099EA14026A5C3D10CFC10C22C', 'Java 2实用教程（第4版）（21世纪高等学校计算机基础实用规划教材）');
INSERT INTO `book_manager` VALUES ('46', '8A5B4042D5B14D6B87A34DABF327387F', 'Java核心技术 卷II：高级特性(第9版·英文版)(上、下册)');
INSERT INTO `book_manager` VALUES ('47', '8DD0ADF2665B40899E09ED2983DC3F7B', 'jQuery权威指南（被公认的权威的、易学的jQuery实战教程，多次重印，热销中）');
INSERT INTO `book_manager` VALUES ('48', '8E16D59BA4C34374A68029AE877613C4', '轻量级Java EE企业应用实战（第3版）：Struts 2＋Spring 3＋Hibernate整合开发(含CD光盘1张)');
INSERT INTO `book_manager` VALUES ('49', '8F1520F2CED94C679433B9C109E791CB', 'Java从入门到精通（实例版）（附光盘1张）（连续8月Java类全国零售排行前2名，14小时视频，732个经典实例、369项面试真题、616项测试史上最全资源库）');
INSERT INTO `book_manager` VALUES ('50', '90E423DBE56042838806673DB3E86BD3', '《Spring技术内幕（第2版）》（畅销书全新升级，Spring类图书销量桂冠，从宏观和微观两个角度解析Spring架构设计和实现原理）');
INSERT INTO `book_manager` VALUES ('51', '926B8F31C5D04F61A72F66679A0CCFFD', 'JavaScript编程精解（华章程序员书库）（JavaScript之父高度评价并强力推荐，系统学习JS首选！）');
INSERT INTO `book_manager` VALUES ('52', '95AACC68D64D4D67B1E33E9EAC22B885', 'Head First Java（中文版）（JAVA经典畅销书 生动有趣 轻松学好JAVA）');
INSERT INTO `book_manager` VALUES ('53', '97437DAD03FA456AA7D6154614A43B55', 'HTML、CSS、JavaScript网页制作从入门到精通（两万读者的选择，经久不衰的超级畅销书最新升级版！网页制作学习者入门必读经典！）');
INSERT INTO `book_manager` VALUES ('54', '9923901FBF124623BC707920D8936BC8', 'JavaScript DOM编程艺术(第2版)');
INSERT INTO `book_manager` VALUES ('55', '99BF63AC12AD48FCB673F1820888964E', 'Java Web开发实战1200例（第Ⅱ卷）（史上最全的“编程实例”类图书，代码分析、实例速查、练习巩固的绝好帮手）');
INSERT INTO `book_manager` VALUES ('56', '9D257176A6934CB79427CEC37E69249F', '疯狂Ajax讲义（第3版）--jQuery/Ext JS/Prototype/DWR企业应用前端开发实战(含CD光盘1张)（畅销书升级版，企业应用前端开发实战指南）');
INSERT INTO `book_manager` VALUES ('57', '9FBD51A7C02D4F5B9862CD2EBBF5CA04', 'Flash ActionScript 3.0全站互动设计');
INSERT INTO `book_manager` VALUES ('58', '9FF423101836438F874035A48498CF45', 'Java编程思想（英文版·第4版）');
INSERT INTO `book_manager` VALUES ('59', 'A123R56', 'JAVA');
INSERT INTO `book_manager` VALUES ('60', 'A123R56', 'JSP');
INSERT INTO `book_manager` VALUES ('61', 'A3D464D1D1344ED5983920B472826730', 'Java Web开发详解：XML+DTD+XML Schema+XSLT+Servlet 3 0+JSP 2 2深入剖析与实例应用(含CD光盘1张)');
INSERT INTO `book_manager` VALUES ('62', 'A46A0F48A4F649AE9008B38EA48FAEBA', 'Java编程全能词典(含DVD光盘2张)');
INSERT INTO `book_manager` VALUES ('63', 'A5A6F27DCD174614850B26633A0B4605', 'JavaScript模式');
INSERT INTO `book_manager` VALUES ('64', 'A7220EF174704012830E066FDFAAD4AD', 'Spring 3.0就这么简单（国内原创的Java敏捷开发图书，展现作者Spring原创开源项目ROP开发的全过程，所有项目工程均以Maven组织）');
INSERT INTO `book_manager` VALUES ('65', 'A7EFD99367C9434682A790635D3C5FDF', 'Java Web技术整合应用与项目实战（JSP+Servlet+Struts2+Hibernate+Spring3）');
INSERT INTO `book_manager` VALUES ('66', 'A8EF76FD21A645109538614DEA85F3F7', 'Java语言程序设计：基础篇（原书第8版）');
INSERT INTO `book_manager` VALUES ('67', 'AD6EA79CCB8240AAAF5B292AD7E5DCAA', 'jQuery Mobile权威指南（根据jQuery Mobile最新版本撰写的权威参考书！全面讲解jQuery Mobile的所有功能、特性、使用方法和开发技巧）');
INSERT INTO `book_manager` VALUES ('68', 'AE0935F13A214436B8599DE285A86220', 'JavaScript基础教程(第8版)(经典JavaScript入门书 涵盖Ajax和jQuery)');
INSERT INTO `book_manager` VALUES ('69', 'AF28ED8F692C4288B32CF411CBDBFC23', '经典Java EE企业应用实战——基于WebLogic/JBoss的JSF+EJB 3+JPA整合开发(含CD光盘1张)');
INSERT INTO `book_manager` VALUES ('70', 'B329A14DDEF8455F82B3FDF25821D2BB', '名师讲坛——Java Web开发实战经典基础篇（JSP、Servlet、Struts、Ajax）（32小时全真课堂培训，视频超级给力！390项实例及分析，北京魔乐科技培训中心Java Web全部精华）');
INSERT INTO `book_manager` VALUES ('71', 'B7A7DA7A94E54054841EED1F70C3027C', '锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)');
INSERT INTO `book_manager` VALUES ('72', 'BD1CB005E4A04DCA881DA8689E21D4D0', 'jQuery UI开发指南');
INSERT INTO `book_manager` VALUES ('73', 'C23E6E8A6DB94E27B6E2ABD39DC21AF5', 'JavaScript:The Good Parts(影印版）');
INSERT INTO `book_manager` VALUES ('74', 'C3CF52B3ED2D4187A16754551488D733', 'Java从入门到精通（附光盘）');
INSERT INTO `book_manager` VALUES ('75', 'C86D3F6FACB449BEBD940D9307ED4A47', '编写高质量代码：改善Java程序的151个建议(从语法、程序设计和架构、工具和框架、编码风格、编程思想5个方面探讨编写高质量Java代码的技巧、禁忌和最佳实践)');
INSERT INTO `book_manager` VALUES ('76', 'CB0AB3654945411EA69F368D0EA91A00', 'JavaScript语言精粹（修订版）');
INSERT INTO `book_manager` VALUES ('77', 'CD913617EE964D0DBAF20C60076D32FB', '名师讲坛——Java开发实战经典（配光盘）（60小时全真课堂培训，视频超级给力！790项实例及分析，北京魔乐科技培训中心Java全部精华）');
INSERT INTO `book_manager` VALUES ('78', 'CE01F15D435A4C51B0AD8202A318DCA7', 'Java编程思想（第4版）');
INSERT INTO `book_manager` VALUES ('79', 'CF5546769F2842DABB2EF7A00D51F255', 'jQuery开发从入门到精通（配套视频327节，中小实例232个，实战案例7个商品详情手册11部，网页模版83类）（附1DVD）');
INSERT INTO `book_manager` VALUES ('80', 'D0DA36CEE42549FFB299B7C7129761D5', 'Java应用架构设计：模块化模式与OSGi(全球资深Java技术专家的力作，系统、全面地讲解如何将模块化设计思想引入开发中，涵盖18个有助于实现模块化软件架构的模式)');
INSERT INTO `book_manager` VALUES ('81', 'D0E69F85ACAB4C15BB40966E5AA545F1', 'Java并发编程实战（第16届Jolt大奖提名图书，Java并发编程必读佳作');
INSERT INTO `book_manager` VALUES ('82', 'D2ABA8B06C524632846F27C34568F3CE', 'Java 经典实例');
INSERT INTO `book_manager` VALUES ('83', 'D8723405BA054C13B52357B8F6AEEC24', '深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）');
INSERT INTO `book_manager` VALUES ('84', 'DC36FD53A1514312A0A9ADD53A583886', 'JavaScript异步编程：设计快速响应的网络应用【掌握JavaScript异步编程必杀技，让代码更具响应度！ 】');
INSERT INTO `book_manager` VALUES ('85', 'DCB64DF0084E486EBF173F729A3A630A', 'Java设计模式(第2版)');
INSERT INTO `book_manager` VALUES ('86', 'DEE7BDC7E0E343149E3C3601D2658171', '疯狂HTML 5/CSS 3/JavaScript讲义(含CD光盘1张)');
INSERT INTO `book_manager` VALUES ('87', 'DF4E74EEE89B43229BB8212F0B858C38', '精通Hibernate：Java对象持久化技术详解（第2版）(含光盘1张)');
INSERT INTO `book_manager` VALUES ('88', 'E4F184188C8B4C7BB32D4E76603426AC', '疯狂Java讲义（第2版，附光盘）');
INSERT INTO `book_manager` VALUES ('89', 'EA695342393C4BE48B831FA5E6B0E5C4', '编写可维护的JavaScript《JavaScript高级程序设计》作者Nicholas Zakas最新力作，构建编码风格手册，帮助开发团队从“游击队”走向“正规军”）');
INSERT INTO `book_manager` VALUES ('90', 'F0E34313BF304CCEBF198BD4E05307B8', 'jQuery Cookbook中文版（jQuery之父鼎力推荐，社区数十位专家倾情力作');
INSERT INTO `book_manager` VALUES ('91', 'F6162799E913423EA5CB57BEC65AB1E9', 'JUnit实战(第2版)');
INSERT INTO `book_manager` VALUES ('92', 'F693239BC3B3444C8538ABE7411BB38E', 'Java Web典型模块与项目实战大全（配光盘）');
INSERT INTO `book_manager` VALUES ('93', 'F78C94641DB4475BBA1E72A07DF9B3AE', 'JAVA面向对象编程');
INSERT INTO `book_manager` VALUES ('94', 'FC232CD9B6E6411BBBB1A5B781D2C3C9', 'Java与模式(含盘)（超多实例和习题，详解设计原则与设计模式）');
INSERT INTO `book_manager` VALUES ('95', 'FEC3740CF30E442A94021911A25EF0D7', 'Spring攻略(第2版)(Spring攻略(第2版))');
INSERT INTO `book_manager` VALUES ('96', 'FFABBED1E5254BC0B2726EC4ED8ACCDA', '深入理解OSGi：Equinox原理、应用与最佳实践（《深入理解Java虚拟机》作者新作！全面解读最新OSGi R5.0规范，深入讲解OSGi原理和服务，以及Equinox框架的用法和原理）');

-- ----------------------------
-- Table structure for `creditmanager`
-- ----------------------------
DROP TABLE IF EXISTS `creditmanager`;
CREATE TABLE `creditmanager` (
  `level` tinyint(11) NOT NULL,
  `discount` float(10,2) DEFAULT NULL,
  `payaftergoods` tinyint(1) DEFAULT NULL,
  `overdraft` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of creditmanager
-- ----------------------------
INSERT INTO `creditmanager` VALUES ('0', '0.00', '0', '0');
INSERT INTO `creditmanager` VALUES ('1', '0.10', '0', '0');
INSERT INTO `creditmanager` VALUES ('2', '0.15', '0', '0');
INSERT INTO `creditmanager` VALUES ('3', '0.15', '1', '1');
INSERT INTO `creditmanager` VALUES ('4', '0.20', '1', '1');
INSERT INTO `creditmanager` VALUES ('5', '0.25', '1', '2');

-- ----------------------------
-- Table structure for `order_has_pay`
-- ----------------------------
DROP TABLE IF EXISTS `order_has_pay`;
CREATE TABLE `order_has_pay` (
  `UID` varchar(255) NOT NULL,
  `OID` varchar(255) NOT NULL,
  `money_should_pay` float(10,2) DEFAULT NULL,
  `money_real_pay` float(10,2) DEFAULT NULL,
  `user_account_money` float(10,2) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `deliver_time` datetime DEFAULT NULL,
  PRIMARY KEY (`UID`,`OID`),
  KEY `OID` (`OID`),
  KEY `money_should_pay` (`money_should_pay`),
  KEY `user_account_money` (`user_account_money`),
  CONSTRAINT `OID` FOREIGN KEY (`OID`) REFERENCES `t_order` (`OID`),
  CONSTRAINT `UID` FOREIGN KEY (`UID`) REFERENCES `t_user` (`UID`),
  CONSTRAINT `money_should_pay` FOREIGN KEY (`money_should_pay`) REFERENCES `t_order` (`money`) ON UPDATE CASCADE,
  CONSTRAINT `user_account_money` FOREIGN KEY (`user_account_money`) REFERENCES `t_user` (`user_account_money`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_has_pay
-- ----------------------------
INSERT INTO `order_has_pay` VALUES ('xiaoluo', 'AAX0123C', '123.00', '50.00', '450.00', '2015-01-19 19:27:42', '2015-01-21 19:27:47');

-- ----------------------------
-- Table structure for `stockregister`
-- ----------------------------
DROP TABLE IF EXISTS `stockregister`;
CREATE TABLE `stockregister` (
  `BID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `publish` varchar(255) NOT NULL,
  `supplierID` varchar(255) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `registerdate` datetime DEFAULT NULL,
  PRIMARY KEY (`BID`),
  KEY `name` (`name`),
  KEY `publish` (`publish`),
  KEY `supplierID` (`supplierID`),
  CONSTRAINT `BID` FOREIGN KEY (`BID`) REFERENCES `t_book` (`TBID`),
  CONSTRAINT `name` FOREIGN KEY (`name`) REFERENCES `t_book` (`name`),
  CONSTRAINT `publish` FOREIGN KEY (`publish`) REFERENCES `t_book` (`publish`),
  CONSTRAINT `supplierID` FOREIGN KEY (`supplierID`) REFERENCES `t_book` (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockregister
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierID` varchar(255) NOT NULL DEFAULT '',
  `supplierName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('A1', null);
INSERT INTO `supplier` VALUES ('A10', null);
INSERT INTO `supplier` VALUES ('A11', null);
INSERT INTO `supplier` VALUES ('A2', null);
INSERT INTO `supplier` VALUES ('A3', null);
INSERT INTO `supplier` VALUES ('A4', null);
INSERT INTO `supplier` VALUES ('A5', null);
INSERT INTO `supplier` VALUES ('A6', null);
INSERT INTO `supplier` VALUES ('A7', null);
INSERT INTO `supplier` VALUES ('A8', null);
INSERT INTO `supplier` VALUES ('A9', null);
INSERT INTO `supplier` VALUES ('B1', null);
INSERT INTO `supplier` VALUES ('B2', null);
INSERT INTO `supplier` VALUES ('B3', null);
INSERT INTO `supplier` VALUES ('B4', null);
INSERT INTO `supplier` VALUES ('B5', null);
INSERT INTO `supplier` VALUES ('B6', null);

-- ----------------------------
-- Table structure for `supply_manager`
-- ----------------------------
DROP TABLE IF EXISTS `supply_manager`;
CREATE TABLE `supply_manager` (
  `supplyID` varchar(255) NOT NULL,
  `bookID` varchar(255) NOT NULL,
  `book_count` int(255) DEFAULT NULL,
  PRIMARY KEY (`supplyID`,`bookID`),
  KEY `m_supply_bid` (`bookID`),
  CONSTRAINT `m_supply_bid` FOREIGN KEY (`bookID`) REFERENCES `book_manager` (`BID`),
  CONSTRAINT `m_supply_id` FOREIGN KEY (`supplyID`) REFERENCES `supplier` (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply_manager
-- ----------------------------

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `TBID` int(11) NOT NULL AUTO_INCREMENT,
  `BID` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `authors` varchar(255) DEFAULT NULL,
  `publish` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `catalogue` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `stockNum` int(11) DEFAULT NULL,
  `supplierID` varchar(255) NOT NULL,
  PRIMARY KEY (`TBID`),
  KEY `suppilerIDF` (`supplierID`),
  KEY `BID` (`BID`),
  KEY `name` (`name`),
  KEY `publish` (`publish`),
  CONSTRAINT `suppilerIDF` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`supplierID`),
  CONSTRAINT `tb_BID` FOREIGN KEY (`BID`) REFERENCES `book_manager` (`BID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tbname` FOREIGN KEY (`name`) REFERENCES `book_manager` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '000A18FDB38F470DBE9CD0972BADB23F', 'Java Web整合开发实战--基于Struts 2+Hibernate+Spring（99个应用实例，4个项目开发案例，15.5小时配套教学视频，超值DVD光盘含大量开发资源。一本书搞定SSH框架整合开发！）', '贾蓓', '清华大学出版社', '79.8', null, null, null, '10', 'A1');
INSERT INTO `t_book` VALUES ('2', '0BE0707984014E66BD9F34F534FCE0F7', 'OSGi实战【OSGi规范制定者亲自撰写 汇集Apache项目技术实战经验】', 'Richard', '人民邮电出版社', '99', null, null, null, '10', 'A2');
INSERT INTO `t_book` VALUES ('3', '0EE8A0AE69154287A378FB110FF2C780', 'Java核心技术：卷Ⅰ基础知识（原书第8版）', '昊斯特曼', '机械工业出版社', '98', null, null, null, '10', 'A4');
INSERT INTO `t_book` VALUES ('4', '113D0D1BB9174DD19A7DE7E2B37F677F', 'Java7入门经典（跟编程导师Ivor Horton学Java 预计到货日期9月初）', '霍尔顿', '清华大学出版社', '118', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('5', '1286B13F0EA54E4CB75434762121486A', 'Java核心技术 卷I：基础知识(第9版·英文版)(上、下册)', '霍斯特曼', '人民邮电出版社', '109', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('6', '13EBF9B1FDE346A683A1C45BD6773ECB', 'Java开发实战1200例（第Ⅱ卷）（史上最全的“编程实例”类图书，代码分析、实例速查、练习巩固的绝好帮手）', '无', '清华大学出版社', '99', null, null, null, '10', 'A2');
INSERT INTO `t_book` VALUES ('7', '1A15DC5E8A014A58862ED741D579B530', 'Java深入解析——透析Java本质的36个话题', '梁勇', '电子工业出版社', '49', null, null, null, '10', 'A4');
INSERT INTO `t_book` VALUES ('8', '210A3DCA429049C78B623C3986BEB136', 'JavaScript经典教程套装：JavaScript高级程序设计(第3版)+JavaScript DOM编程艺术(第2版)(套装共2册)(超值附赠《码农》光盘1张)', 'Nicholas C. Zakas', '人民邮电出版社', '148', null, null, null, '10', 'A3');
INSERT INTO `t_book` VALUES ('9', '22234CECF15F4ECB813F0B433DDA5365', 'JavaScript从入门到精通（附光盘1张）（连续8月JavaScript类全国零售排行前2名，13小时视频，400个经典实例、369项面试真题、138项测试史上最全资源库）', '明日科技', '清华大学出版社', '69.8', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('10', '260F8A3594F741C1B0EB69616F65045B', 'Tomcat与Java Web开发技术详解（第2版）(含光盘1张)', '孙卫琴', '电子工业出版社', '79.5', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('11', '28A03D28BAD449659A77330BE35FCD65', 'JAVA核心技术卷II：高级特性（原书第8版）', '霍斯特曼', '机械工业出版社', '118', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('12', '2EE1A20A6AF742E387E18619D7E3BB94', 'Java虚拟机并发编程(Java并发编程领域的里程碑之作，资深Java技术专家、并发编程专家、敏捷开发专家和Jolt大奖得主撰写，Amazon五星畅销书)', 'Venkat Subramaniam', '机械工业出版社', '59', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('13', '33ACF97A9A374352AE9F5E89BB791262', '基于MVC的JavaScript Web富应用开发', '麦卡劳', '电子工业出版社', '59', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('14', '37F75BEAE1FE46F2B14674923F1E7987', '数据结构与算法分析Java语言描述 第2版', '韦斯', '机械工业出版社', '55', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('15', '39F1D0803E8F4592AE1245CACE683214', 'Java程序员修炼之道', '埃文斯', '人民邮电出版社', '89', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('16', '3AE5C8B976B6448A9D3A155C1BDE12BC', '深入理解Java虚拟机:JVM高级特性与最佳实践（超级畅销书，6个月5次印刷，从实践角度解析JVM工作原理，Java程序员必备）', '周志明', '机械工业出版社', '69', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('17', '3DD187217BF44A99B86DD18A4DC628BA', 'Java核心技术 卷1 基础知识（原书第9版）', '霍斯特曼，科内尔', '机械工业出版社', '119', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('18', '3E1990E19989422E9DA735978CB1E4CE', 'Effective Java中文版(第2版)', '布洛克', '机械工业出版社', '52', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('19', '400D94DE5A0742B3A618FC76DF107183', 'JavaScript宝典（第7版）（配光盘）', '古德曼', '清华大学出版社', '128', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('20', '48BBFBFC07074ADE8CC906A45BE5D9A6', 'JavaScript权威指南（第6版）（淘宝前端团队倾情翻译！经典权威的JavaScript犀牛书！第6版特别涵盖了HTML5和ECMAScript5！）（经典巨著，当当独家首发）', '弗兰纳根', '机械工业出版社', '139', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('21', '49D98E7916B94232862F7DCD1B0BAB66', 'HTML5+JavaScript动画基础', '兰贝塔', '人民邮电出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('22', '4A9574F03A6B40C1B2A437237C17DEEC', 'Spring实战(第3版)（In Action系列中最畅销的Spring图书，近十万读者学习Spring的共同选择）', 'Craig Walls', '人民邮电出版社', '59', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('23', '4BF6D97DD18A4B77B8DED9B057577F8F', 'Java Web从入门到精通（附光盘1张）（连续8月Java类全国零售排行前2名，27小时视频，951个经典实例、369项面试真题、596项测试史上最全资源库）', '明日科技', '清华大学出版社', '69.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('24', '4C3331CAD5A5453787A94B8D7CCEAA29', 'Java Web整合开发王者归来（JSP+Servlet+Struts+Hibernate+Spring）（配光盘', '刘京华', '清华大学出版社', '99.8', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('25', '4D20D2450B084113A331D909FF4975EB', 'jQuery实战(第2版)(畅销书升级版，掌握Web开发利器必修宝典)', 'Bear Bibeault　Yehuda Katz ', '人民邮电出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('26', '4E44405DAFB7413E8A13BBFFBEE73AC7', 'JavaScript经典实例', '鲍尔斯', '中国电力出版社', '78', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('27', '504FB999B0444B339907090927FDBE8A', '深入浅出Ext JS(第3版)', '徐会生', '人民邮电出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('28', '52077C8423B645A9BADA96A5E0B14422', 'Spring源码深度解析', '郝佳', '人民邮电出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('29', '52B0EDFF966E4A058BDA5B18EEC698C4', '亮剑Java Web项目开发案例导航(含DVD光盘1张)', '朱雪琴', '电子工业出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('30', '5315DA60D24042889400AD4C93A37501', 'Spring 3.x企业应用开发实战(含CD光盘1张)', '陈雄华', '电子工业出版社', '90', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('31', '56B1B7D8CD8740B098677C7216A673C4', '疯狂 Java 程序员的基本修养（《疯狂Java讲义》最佳拍档，扫清知识死角，夯实基本功）', '李刚', '电子工业出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('32', '57B6FF1B89C843C38BA39C717FA557D6', '了不起的Node.js: 将JavaScript进行到底（Web开发首选实时 跨多服务器 高并发）', 'Guillermo Rauch', '电子工业出版社', '79', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('33', '5C4A6F0F4A3B4672AD8C5F89BF5D37D2', 'Java从入门到精通（第3版）（附光盘1张）（连续8月Java类全国零售排行前2名，32小时视频，732个经典实例、369项面试真题、616项测试史上最全资源库）', '明日科技', '清华大学出版社', '59.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('34', '5C68141786B84A4CB8929A2415040739', 'JavaScript高级程序设计(第3版)(JavaScript技术名著，国内JavasScript第一书，销量超过8万册)', 'Nicholas C. Zakas', '人民邮电出版社', '99', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('35', '5EDB981339C342ED8DB17D5A198D50DC', 'Java程序性能优化', '葛一鸣', '清华大学出版社', '59', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('36', '6398A7BA400D40258796BCBB2B256068', 'JavaScript设计模式', 'Addy Osmani', '人民邮电出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('37', '676B56A612AF4E968CF0F6FFE289269D', 'JavaScript和jQuery实战手册（原书第2版）', '麦克法兰', '机械工业出版社', '99', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('38', '7917F5B19A0948FD9551932909328E4E', 'Java项目开发案例全程实录（第2版）（配光盘）（软件项目开发全程实录丛书）', '明日科技', '清华大学出版社', '69.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('39', '7C0C785FFBEC4DEC802FA36E8B0BC87E', '深入分析Java Web技术内幕', '许令波', '电子工业出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('40', '7CD79C20258F477AB841518D9312E843', 'Java程序员面试宝典（第三版）', '欧立奇', '电子工业出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('41', '7D7FE81293124793BDB2C6FF1F1C943D', '21天学通Java(第6版)（中文版累计销量超30000册）', 'Rogers Cadenhead', '人民邮电出版社', '55', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('42', '7FD7F50B15F74248AA769798909F8653', 'Java网络编程（第3版）——O’Reilly Java系列', '哈诺德', '中国电力出版社', '85', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('43', '819FF56E4423462394E6F83882F78975', '学通Java Web的24堂课（配光盘）（软件开发羊皮卷）', '陈丹丹', '清华大学出版社', '79.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('44', '81FADA99309342F4978D5C680B0C6E8C', 'Java入门很简单（配光盘）（入门很简单丛书）（打开Java编程之门 Java技术网推荐）', '李世民', '清华大学出版社', '59.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('45', '89A57D099EA14026A5C3D10CFC10C22C', 'Java 2实用教程（第4版）（21世纪高等学校计算机基础实用规划教材）', '耿祥义', '清华大学出版社', '39.5', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('46', '8A5B4042D5B14D6B87A34DABF327387F', 'Java核心技术 卷II：高级特性(第9版·英文版)(上、下册)', '霍斯特曼', '人民邮电出版社', '119', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('47', '8DD0ADF2665B40899E09ED2983DC3F7B', 'jQuery权威指南（被公认的权威的、易学的jQuery实战教程，多次重印，热销中）', '陶国荣', '机械工业出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('48', '8E16D59BA4C34374A68029AE877613C4', '轻量级Java EE企业应用实战（第3版）：Struts 2＋Spring 3＋Hibernate整合开发(含CD光盘1张)', '李刚', '电子工业出版社', '99', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('49', '8F1520F2CED94C679433B9C109E791CB', 'Java从入门到精通（实例版）（附光盘1张）（连续8月Java类全国零售排行前2名，14小时视频，732个经典实例、369项面试真题、616项测试史上最全资源库）', '明日科技', '清华大学出版社', '69.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('50', '90E423DBE56042838806673DB3E86BD3', '《Spring技术内幕（第2版）》（畅销书全新升级，Spring类图书销量桂冠，从宏观和微观两个角度解析Spring架构设计和实现原理）', '计文柯', '机械工业出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('51', '926B8F31C5D04F61A72F66679A0CCFFD', 'JavaScript编程精解（华章程序员书库）（JavaScript之父高度评价并强力推荐，系统学习JS首选！）', '哈弗贝克', '械工业出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('52', '95AACC68D64D4D67B1E33E9EAC22B885', 'Head First Java（中文版）（JAVA经典畅销书 生动有趣 轻松学好JAVA）', '塞若', '中国电力出版社', '79', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('53', '97437DAD03FA456AA7D6154614A43B55', 'HTML、CSS、JavaScript网页制作从入门到精通（两万读者的选择，经久不衰的超级畅销书最新升级版！网页制作学习者入门必读经典！）', '刘西杰', '人民邮电出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('54', '9923901FBF124623BC707920D8936BC8', 'JavaScript DOM编程艺术(第2版)', '基思', '人民邮电出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('55', '99BF63AC12AD48FCB673F1820888964E', 'Java Web开发实战1200例（第Ⅱ卷）（史上最全的“编程实例”类图书，代码分析、实例速查、练习巩固的绝好帮手）', '无', '清华大学出版社', '99', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('56', '9D257176A6934CB79427CEC37E69249F', '疯狂Ajax讲义（第3版）--jQuery/Ext JS/Prototype/DWR企业应用前端开发实战(含CD光盘1张)（畅销书升级版，企业应用前端开发实战指南）', '李刚', '电子工业出版社', '79', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('57', '9FBD51A7C02D4F5B9862CD2EBBF5CA04', 'Flash ActionScript 3.0全站互动设计', '刘欢 ', '人民邮电出版社', '69.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('58', '9FF423101836438F874035A48498CF45', 'Java编程思想（英文版·第4版）', '埃克尔 ', '机械工业出版社', '79', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('59', 'A123R56', 'JAVA', 'AZ', null, null, null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('60', 'A123R56', 'JSP', 'ZM', 'ZM', null, null, null, null, '10', 'A4');
INSERT INTO `t_book` VALUES ('61', 'A3D464D1D1344ED5983920B472826730', 'Java Web开发详解：XML+DTD+XML Schema+XSLT+Servlet 3 0+JSP 2 2深入剖析与实例应用(含CD光盘1张)', '孙鑫', '电子工业出版社', '119', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('62', 'A46A0F48A4F649AE9008B38EA48FAEBA', 'Java编程全能词典(含DVD光盘2张)', '明日科技', '电子工业出版社', '98', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('63', 'A5A6F27DCD174614850B26633A0B4605', 'JavaScript模式', '斯特凡洛夫', '中国电力出版社', '38', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('64', 'A7220EF174704012830E066FDFAAD4AD', 'Spring 3.0就这么简单（国内原创的Java敏捷开发图书，展现作者Spring原创开源项目ROP开发的全过程，所有项目工程均以Maven组织）', '陈雄华', '人民邮电出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('65', 'A7EFD99367C9434682A790635D3C5FDF', 'Java Web技术整合应用与项目实战（JSP+Servlet+Struts2+Hibernate+Spring3）', '张志锋', '清华大学出版社', '98', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('66', 'A8EF76FD21A645109538614DEA85F3F7', 'Java语言程序设计：基础篇（原书第8版）', '梁勇', '机械工业出版社', '75', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('67', 'AD6EA79CCB8240AAAF5B292AD7E5DCAA', 'jQuery Mobile权威指南（根据jQuery Mobile最新版本撰写的权威参考书！全面讲解jQuery Mobile的所有功能、特性、使用方法和开发技巧）', '陶国荣', '机械工业出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('68', 'AE0935F13A214436B8599DE285A86220', 'JavaScript基础教程(第8版)(经典JavaScript入门书 涵盖Ajax和jQuery)', 'Tom Negrino　Dori Smith', '人民邮电出版社', '69', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('69', 'AF28ED8F692C4288B32CF411CBDBFC23', '经典Java EE企业应用实战——基于WebLogic/JBoss的JSF+EJB 3+JPA整合开发(含CD光盘1张)', '无', '电子工业出版社', '79', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('70', 'B329A14DDEF8455F82B3FDF25821D2BB', '名师讲坛——Java Web开发实战经典基础篇（JSP、Servlet、Struts、Ajax）（32小时全真课堂培训，视频超级给力！390项实例及分析，北京魔乐科技培训中心Java Web全部精华）', '李兴华', '清华大学出版社', '69.8', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('71', 'B7A7DA7A94E54054841EED1F70C3027C', '锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)', '单东林', '人民邮电出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('72', 'BD1CB005E4A04DCA881DA8689E21D4D0', 'jQuery UI开发指南', 'Eric Sarrion', '人民邮电出版社', '39', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('73', 'C23E6E8A6DB94E27B6E2ABD39DC21AF5', 'JavaScript:The Good Parts(影印版）', '克罗克福特', '东南大学出版社', '28', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('74', 'C3CF52B3ED2D4187A16754551488D733', 'Java从入门到精通（附光盘）', '魔乐科技', '人民邮电出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('75', 'C86D3F6FACB449BEBD940D9307ED4A47', '编写高质量代码：改善Java程序的151个建议(从语法、程序设计和架构、工具和框架、编码风格、编程思想5个方面探讨编写高质量Java代码的技巧、禁忌和最佳实践)', '秦小波', '机械工业出版社', '59', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('76', 'CB0AB3654945411EA69F368D0EA91A00', 'JavaScript语言精粹（修订版）', '道格拉斯·克罗克福德', '电子工业出版社', '49', null, null, null, '10', 'A5');
INSERT INTO `t_book` VALUES ('77', 'CD913617EE964D0DBAF20C60076D32FB', '名师讲坛——Java开发实战经典（配光盘）（60小时全真课堂培训，视频超级给力！790项实例及分析，北京魔乐科技培训中心Java全部精华）', '李兴华', '清华大学出版社', '79.8', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('78', 'CE01F15D435A4C51B0AD8202A318DCA7', 'Java编程思想（第4版）', '布鲁斯.艾克尔', '机械工业出版社', '108', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('79', 'CF5546769F2842DABB2EF7A00D51F255', 'jQuery开发从入门到精通（配套视频327节，中小实例232个，实战案例7个商品详情手册11部，网页模版83类）（附1DVD）', '袁江', '清华大学出版社', '79.8', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('80', 'D0DA36CEE42549FFB299B7C7129761D5', 'Java应用架构设计：模块化模式与OSGi(全球资深Java技术专家的力作，系统、全面地讲解如何将模块化设计思想引入开发中，涵盖18个有助于实现模块化软件架构的模式)', '克内恩席尔德', '机械工业出版社', '69', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('81', 'D0E69F85ACAB4C15BB40966E5AA545F1', 'Java并发编程实战（第16届Jolt大奖提名图书，Java并发编程必读佳作', 'Brian Goetz', '机械工业出版社', '69', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('82', 'D2ABA8B06C524632846F27C34568F3CE', 'Java 经典实例', '达尔文', '中国电力出版社', '98', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('83', 'D8723405BA054C13B52357B8F6AEEC24', '深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）', '周志明', '机械工业出版社', '79', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('84', 'DC36FD53A1514312A0A9ADD53A583886', 'JavaScript异步编程：设计快速响应的网络应用【掌握JavaScript异步编程必杀技，让代码更具响应度！ 】', 'Trevor Burnham ', '人民邮电出版社', '32', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('85', 'DCB64DF0084E486EBF173F729A3A630A', 'Java设计模式(第2版)', 'Steven John Metsker', '电子工业出版社', '75', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('86', 'DEE7BDC7E0E343149E3C3601D2658171', '疯狂HTML 5/CSS 3/JavaScript讲义(含CD光盘1张)', '李刚', '电子工业出版社', '69', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('87', 'DF4E74EEE89B43229BB8212F0B858C38', '精通Hibernate：Java对象持久化技术详解（第2版）(含光盘1张)', '孙卫琴', '电子工业出版社', '75', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('88', 'E4F184188C8B4C7BB32D4E76603426AC', '疯狂Java讲义（第2版，附光盘）', '李刚', '电子工业出版社', '109', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('89', 'EA695342393C4BE48B831FA5E6B0E5C4', '编写可维护的JavaScript《JavaScript高级程序设计》作者Nicholas Zakas最新力作，构建编码风格手册，帮助开发团队从“游击队”走向“正规军”）', 'Nicholas C. Zakas', '人民邮电出版社', '55', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('90', 'F0E34313BF304CCEBF198BD4E05307B8', 'jQuery Cookbook中文版（jQuery之父鼎力推荐，社区数十位专家倾情力作', 'jQuery社区专家组', '人民邮电出版社', '69', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('91', 'F6162799E913423EA5CB57BEC65AB1E9', 'JUnit实战(第2版)', '塔凯文', '人民邮电出版社', '79', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('92', 'F693239BC3B3444C8538ABE7411BB38E', 'Java Web典型模块与项目实战大全（配光盘）', '常建功', '清华大学出版社', '99.5', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('93', 'F78C94641DB4475BBA1E72A07DF9B3AE', 'JAVA面向对象编程', '孙卫琴 ', '电子工业出版社', '65.8', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('94', 'FC232CD9B6E6411BBBB1A5B781D2C3C9', 'Java与模式(含盘)（超多实例和习题，详解设计原则与设计模式）', '阎宏', '电子工业出版社', '88', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('95', 'FEC3740CF30E442A94021911A25EF0D7', 'Spring攻略(第2版)(Spring攻略(第2版))', 'Gary Mak　Josh Long　Daniel Rubio', '人民邮电出版社', '128', null, null, null, '10', 'A6');
INSERT INTO `t_book` VALUES ('96', 'FFABBED1E5254BC0B2726EC4ED8ACCDA', '深入理解OSGi：Equinox原理、应用与最佳实践（《深入理解Java虚拟机》作者新作！全面解读最新OSGi R5.0规范，深入讲解OSGi原理和服务，以及Equinox框架的用法和原理）', '周志明', '机械工业出版社', '79', null, null, null, '10', 'A5');

-- ----------------------------
-- Table structure for `t_cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_cartitem`;
CREATE TABLE `t_cartitem` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `userID` varchar(255) NOT NULL,
  `bookID` varchar(255) NOT NULL,
  `bookName` varchar(255) NOT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKB719D99E8E3A8847` (`bookID`),
  KEY `FKB719D99EAEE3398B` (`userID`),
  KEY `t_cartitem_bname` (`bookName`),
  CONSTRAINT `FKB719D99E8E3A8847` FOREIGN KEY (`bookID`) REFERENCES `t_book` (`BID`),
  CONSTRAINT `FKB719D99EAEE3398B` FOREIGN KEY (`userID`) REFERENCES `t_user` (`UID`),
  CONSTRAINT `t_cartitem_bname` FOREIGN KEY (`bookName`) REFERENCES `t_book` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cartitem
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `OID` varchar(255) NOT NULL,
  `order_time` datetime DEFAULT NULL,
  `del_address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `money` float(10,2) DEFAULT NULL,
  `userID` varchar(255) DEFAULT NULL,
  `order_item_count` int(255) DEFAULT NULL,
  PRIMARY KEY (`OID`),
  KEY `FKA0C0C3C3AEE3398B` (`userID`),
  KEY `money` (`money`),
  CONSTRAINT `FKA0C0C3C3AEE3398B` FOREIGN KEY (`userID`) REFERENCES `t_user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('AAX0123C', '2015-01-18 16:25:46', 'xiaoluo', '-1', '123.00', 'xiaoluo', '5');

-- ----------------------------
-- Table structure for `t_orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `orderID` varchar(255) NOT NULL,
  `bookID` int(11) NOT NULL,
  PRIMARY KEY (`itemID`),
  KEY `orderitemid` (`orderID`),
  KEY `bidf` (`bookID`),
  CONSTRAINT `bidf` FOREIGN KEY (`bookID`) REFERENCES `t_book` (`TBID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderitemid` FOREIGN KEY (`orderID`) REFERENCES `t_order` (`OID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES ('4', '3', 'AAX0123C', '59');
INSERT INTO `t_orderitem` VALUES ('5', '3', 'AAX0123C', '60');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `UID` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `level` tinyint(11) DEFAULT NULL,
  `account_balance` float(10,2) DEFAULT NULL,
  `money_has_consume` float(10,2) DEFAULT NULL,
  `user_account_money` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`UID`),
  KEY `user_account_money` (`user_account_money`),
  KEY `creditlevel` (`level`),
  CONSTRAINT `creditlevel` FOREIGN KEY (`level`) REFERENCES `creditmanager` (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('18202720293', '22', '123', '101', '12435', '1243', null, null, null, null);
INSERT INTO `t_user` VALUES ('32DB3700D2564254982BC58B0E4D95BC', 'liSi', '123', null, 'itcast_cxf@126.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4028d0814abf1198014abf119a950000', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4DE7E4D829A54D4FAB150B7451407198', 'def', 'def', null, 'itcast_cxf@soh.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('531D8A16D524478D86F8A115FE95D93F', 'zhangSan', '123', null, 'itcast_cxf@163.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('55790D9C1A1845738E6D93866A148C7E', 'wangWu', '123', null, 'itcast_cxf@sina.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('9CC972DFA2D4481F89841A46FD1B3E7B', 'abc', 'abc', null, 'itcast_cxf@qq.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('B50ADE921BF14F6EB5331777B1874763', 'aabb', 'aaa', null, 'abc@abc.cn', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('x', '22', '123', '101', '12435', '1243', null, null, null, null);
INSERT INTO `t_user` VALUES ('xiao', '罗小', '1234', null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('xiaoluo', 'xiaoluo', 'xiaoluo', 'xiaoluo', 'xiaoluo', '13005285101', null, null, null, '450.00');
INSERT INTO `t_user` VALUES ('xx', '关羽', '123', null, 'guanYu@163.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('xxx', '张三', '123', null, 'zhangFei@163.com', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('xxxx', '赵云', '123', null, 'zhaoYun@163.com', null, null, null, null, null);

-- ----------------------------
-- View structure for `order_detail`
-- ----------------------------
DROP VIEW IF EXISTS `order_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `order_detail` AS select `t_order`.`OID` AS `OID`,`t_order`.`order_time` AS `order_time`,`t_order`.`del_address` AS `del_address`,`t_order`.`state` AS `state`,`t_user`.`name` AS `userName`,`t_user`.`phone` AS `phone`,`t_user`.`level` AS `level`,`t_order`.`userID` AS `userID`,`t_orderitem`.`quantity` AS `quantity`,`t_book`.`BID` AS `BID`,`t_book`.`name` AS `bookName`,`t_order`.`money` AS `money_should_pay` from (((`t_order` join `t_orderitem` on((`t_orderitem`.`orderID` = `t_order`.`OID`))) join `t_book` on((`t_orderitem`.`bookID` = `t_book`.`TBID`))) join `t_user` on((`t_order`.`userID` = `t_user`.`UID`))) ;

-- ----------------------------
-- View structure for `view_consumer_user`
-- ----------------------------
DROP VIEW IF EXISTS `view_consumer_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_consumer_user` AS select `t_user`.`UID` AS `UID`,`t_user`.`name` AS `name`,`t_user`.`password` AS `password`,`t_user`.`address` AS `address`,`t_user`.`email` AS `email`,`t_user`.`phone` AS `phone` from `t_user` ;

-- ----------------------------
-- View structure for `view_getcart_detail`
-- ----------------------------
DROP VIEW IF EXISTS `view_getcart_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_getcart_detail` AS select `t_cartitem`.`quantity` AS `quantity`,`t_cartitem`.`userID` AS `userID`,`t_cartitem`.`bookID` AS `bookID`,`t_cartitem`.`bookName` AS `bookName`,`t_book`.`price` AS `price`,`creditmanager`.`discount` AS `discount` from (((`t_cartitem` join `t_book` on(((`t_cartitem`.`bookID` = `t_book`.`BID`) and (`t_cartitem`.`bookName` = `t_book`.`name`)))) join `t_user` on((`t_cartitem`.`userID` = `t_user`.`UID`))) join `creditmanager` on((`t_user`.`level` = `creditmanager`.`level`))) ;

-- ----------------------------
-- View structure for `view_order_item`
-- ----------------------------
DROP VIEW IF EXISTS `view_order_item`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_order_item` AS select `t_book`.`BID` AS `BID`,`t_book`.`name` AS `name`,`t_orderitem`.`quantity` AS `quantity`,`t_orderitem`.`orderID` AS `orderID` from (`t_orderitem` join `t_book` on((`t_orderitem`.`bookID` = `t_book`.`TBID`))) ;
DROP TRIGGER IF EXISTS `order_pay_trigger`;
DELIMITER ;;
CREATE TRIGGER `order_pay_trigger` AFTER INSERT ON `order_has_pay` FOR EACH ROW begin
SET @shoulid_pay = new.money_should_pay;
SET @real_pay = new.money_real_pay;
UPDATE t_user SET 
t_user.money_has_consume = t_user.money_has_consume+@shoulid_pay
WHERE t_user.UID = new.UID;
UPDATE t_user SET 
t_user.user_account_money = t_user.user_account_money-@real_pay
WHERE t_user.UID = new.UID;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `stockTrigger`;
DELIMITER ;;
CREATE TRIGGER `stockTrigger` AFTER UPDATE ON `t_book` FOR EACH ROW begin
if new.stockNum=0 then
set @countm = (SELECT count(*) FROM stockregister,t_book WHERE stockregister.BID = new.TBID);
if   @countm!=0 THEN
UPDATE stockregister SET stockregister.amount = stockregister.amount+1 WHERE stockregister.BID = new.TBID;
ELSE
insert into stockregister values(new.TBID,new.name,new.publish,new.supplierID,1,NOW());
END IF;
END IF;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `orderItemTrigger`;
DELIMITER ;;
CREATE TRIGGER `orderItemTrigger` AFTER INSERT ON `t_orderitem` FOR EACH ROW BEGIN
SET @stock_num = (SELECT t_book.stockNum FROM t_book,t_orderitem WHERE t_book.TBID = new.bookID );
IF @stock_num >0
then UPDATE t_book
SET t_book.stockNum = t_book.stockNum-new.quantity
WHERE t_book.TBID = new.bookID;
end IF;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `levelTrigger`;
DELIMITER ;;
CREATE TRIGGER `levelTrigger` AFTER UPDATE ON `t_user` FOR EACH ROW BEGIN
SET @consume_money = new.money_has_consume;
SET @user_money = new.user_account_money;
SET @daytime = DAY(NOW());
IF @daytime = 1
THEN 
IF @user_money>100 and @user_money<=500
THEN UPDATE t_user
SET t_user.level = 1 WHERE t_user.UID = new.UID;
end IF;
IF @user_money>500 and @user_money<=1000
THEN UPDATE t_user
SET t_user.level = 2 WHERE t_user.UID = new.UID;
end IF;
IF @user_money>1000 and @user_money<=2000
THEN UPDATE t_user
SET t_user.level = 3 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = 2000 WHERE t_user.UID = new.UID;
end IF;
IF @user_money>2000 and @user_money<=4000
THEN UPDATE t_user
SET t_user.level = 4 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = 4000 WHERE t_user.UID = new.UID;
end IF;
IF @user_money>4000
THEN UPDATE t_user
SET t_user.level = 5 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = -1 WHERE t_user.UID = new.UID;
end IF;
END IF;
IF @consume_money>100 and @consume_money<=500
THEN UPDATE t_user
SET t_user.level = 1 WHERE t_user.UID = new.UID;
end IF;
IF @consume_money>500 and @consume_money<=1000
THEN UPDATE t_user
SET t_user.level = 2 WHERE t_user.UID = new.UID;
end IF;
IF @consume_money>1000 and @consume_money<=2000
THEN UPDATE t_user
SET t_user.level = 3 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = 2000 WHERE t_user.UID = new.UID;
end IF;
IF @consume_money>2000 and @consume_money<=4000
THEN UPDATE t_user
SET t_user.level = 4 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = 4000 WHERE t_user.UID = new.UID;
end IF;
IF @consume_money>4000
THEN UPDATE t_user
SET t_user.level = 5 WHERE t_user.UID = new.UID;
UPDATE t_user
SET t_user.account_balance = -1 WHERE t_user.UID = new.UID;
end IF;
END
;;
DELIMITER ;
