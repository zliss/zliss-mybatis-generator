package com.example.zgenerator;

import net.zliss.tool.mybatis.generator.zgenerator.application.ZGenerator;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant.ZGMethods;
import net.zliss.tool.mybatis.generator.zgenerator.exception.ZGException;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaTypes;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGSetting;
import net.zliss.tool.mybatis.generator.zgenerator.util.ZGMiscUtil;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZGeneratorExample {
    public static void main(String[] args) {

        /**
         *
         * CREATE TABLE `z_item` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'type',
         * `url` varchar(32) NOT NULL DEFAULT '' COMMENT 'url',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_item';
         *
         * CREATE TABLE `z_item_t` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'type',
         * `url` varchar(32) NOT NULL DEFAULT '' COMMENT 'url',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_item_t';
         *
         * CREATE TABLE `z_user` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `phone` varchar(32) NOT NULL DEFAULT '' COMMENT 'phone',
         * `name` varchar(32) NOT NULL DEFAULT '' COMMENT 'name',
         * `img` varchar(32) NOT NULL DEFAULT '' COMMENT 'img',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`),
         * KEY `idx_phone` (`phone`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_user';
         *
         */

        // simple case
        ZGenerator generator1 = new ZGenerator(
                "jdbc:mysql://mysqlhost.com:3306/ztest",
                "root",
                "123456",
                "z_item_t,z_user",
                Paths.get("").toAbsolutePath()
                        + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main".replace("/", File.separator),
                "com.example.zgenerator.test.project");

        boolean r1 = generator1.build();

        if (!r1) {
            for (ZGException exception : generator1.getExceptionList()) {
                exception.getSourceException().printStackTrace();
            }
        }

        ZGSetting setting1 = ZGMiscUtil.buildZGSetting(
                "jdbc:mysql://mysqlhost.com:3306/ztest",
                "root",
                "123456",
                "z_item");

        // custom path
        setting1.setEntityDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/java/" +
                "com/example/zgenerator/test/project/entity/sub").replace("/", File.separator));
        setting1.setEntityPkgFull("com.example.zgenerator.test.project.entity.sub");
        setting1.setRepositoryDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/java/" +
                "com/example/zgenerator/test/project/repository/sub").replace("/", File.separator));
        setting1.setRepositoryPkgFull("com.example.zgenerator.test.project.repository.sub");
        setting1.setMapperDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mapper/sub").replace("/", File.separator));

        // custom remark
        setting1.setRemarkFormat("// DatabaseType:{{type}}, DatabaseDefault:{{default}}, DatabaseRemark:{{remark}}");

        // custom methods
        List<String> methodList = new ArrayList<>();
        methodList.add(ZGMethods.INSERT.getName());
        methodList.add(ZGMethods.SELECT_PAGE.getName());
        setting1.setMethodStrList(methodList);

        // custom jdbcTypeMap
        Map<Integer, JdbcJavaType> jdbcJavaTypeMap = new HashMap<>();
        /**
         * {@link java.sql.Types}
         * {@link net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaTypes}
         * {@link net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType}
         */
        jdbcJavaTypeMap.put(Types.TINYINT, JdbcJavaTypes.INTEGER);
        // jdbcJavaTypeMap.put(Types.TINYINT, new JdbcJavaType("MyInteger", "my.pkg"));
        setting1.setJdbcJavaTypeMap(jdbcJavaTypeMap);

        // custom vm template
        setting1.setEntityTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/entity.vm".replace("/", File.separator));
        setting1.setRepositoryTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/repository.vm".replace("/", File.separator));
        setting1.setMapperTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/mapper.vm".replace("/", File.separator));
        ZGenerator generator2 = new ZGenerator(setting1);

        boolean r2 = generator2.build();

        if (!r2) {
            for (ZGException exception : generator2.getExceptionList()) {
                exception.getSourceException().printStackTrace();
            }
        }
    }
}
