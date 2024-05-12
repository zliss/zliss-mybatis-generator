package net.zliss.tool.mybatis.generator.zgenerator.util;

import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant.ZGJdbcColKeys;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaTypes;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGMethod;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGMethodItem;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGSetting;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGSysSetting;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableColInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGUserSetting;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ZGMiscUtil {

    /**
     * JDBC Type                    | Java Class
     * ----------------------------|-------------------
     * CHAR, VARCHAR, LONGVARCHAR   | java.lang.String
     * NUMERIC, DECIMAL             | java.math.BigDecimal
     * BIT                          | boolean
     * TINYINT                      | byte
     * SMALLINT                     | short
     * INTEGER                      | int
     * BIGINT                       | long
     * REAL                         | float
     * FLOAT, DOUBLE                | double
     * DATE                         | java.sql.Date
     * TIME                         | java.sql.Time
     * TIMESTAMP                    | java.sql.Timestamp
     * BINARY, VARBINARY, LONGVARBINARY | byte[]
     * BLOB                         | java.sql.Blob
     * CLOB                         | java.sql.Clob
     * NCLOB                        | java.sql.NClob
     */
    public static Map<Integer, JdbcJavaType> getJdbcFieldTypeMapping() {
        Map<Integer, JdbcJavaType> map = new LinkedHashMap<>();
        map.put(Types.CHAR, JdbcJavaTypes.STRING);
        map.put(Types.VARCHAR, JdbcJavaTypes.STRING);
        map.put(Types.LONGVARCHAR, JdbcJavaTypes.STRING);
        map.put(Types.NUMERIC, JdbcJavaTypes.BIG_DECIMAL);
        map.put(Types.DECIMAL, JdbcJavaTypes.BIG_DECIMAL);
        map.put(Types.BIT, JdbcJavaTypes.BOOLEAN);
        map.put(Types.TINYINT, JdbcJavaTypes.BYTE);
        map.put(Types.SMALLINT, JdbcJavaTypes.SHORT);
        map.put(Types.INTEGER, JdbcJavaTypes.INTEGER);
        map.put(Types.BIGINT, JdbcJavaTypes.LONG);
        map.put(Types.REAL, JdbcJavaTypes.FLOAT);
        map.put(Types.FLOAT, JdbcJavaTypes.DOUBLE);
        map.put(Types.DOUBLE, JdbcJavaTypes.DOUBLE);
        map.put(Types.DATE, JdbcJavaTypes.DATE);
        map.put(Types.TIME, JdbcJavaTypes.TIME);
        map.put(Types.TIMESTAMP, JdbcJavaTypes.TIMESTAMP);
        map.put(Types.BINARY, JdbcJavaTypes.BYTEARRAY);
        map.put(Types.VARBINARY, JdbcJavaTypes.BYTEARRAY);
        map.put(Types.LONGVARBINARY, JdbcJavaTypes.BYTEARRAY);
        map.put(Types.BLOB, JdbcJavaTypes.BLOB);
        map.put(Types.CLOB, JdbcJavaTypes.CLOB);
        map.put(Types.NCLOB, JdbcJavaTypes.NCLOB);
//        map.put(Types.CHAR, new JdbcTypeItem(new JdbcType("CHAR", Types.CHAR), DbJavaTypes.STRING));
//        map.put(Types.VARCHAR, new JdbcTypeItem(new JdbcType("VARCHAR", Types.VARCHAR), DbJavaTypes.STRING));
//        map.put(Types.LONGVARCHAR, new JdbcTypeItem(new JdbcType("LONGVARCHAR", Types.LONGVARCHAR), DbJavaTypes.STRING));
//        map.put(Types.NUMERIC, new JdbcTypeItem(new JdbcType("NUMERIC", Types.NUMERIC), DbJavaTypes.BIG_DECIMAL));
//        map.put(Types.DECIMAL, new JdbcTypeItem(new JdbcType("DECIMAL", Types.DECIMAL), DbJavaTypes.BIG_DECIMAL));
//        map.put(Types.BIT, new JdbcTypeItem(new JdbcType("BIT", Types.BIT), DbJavaTypes.BOOLEAN));
//        map.put(Types.TINYINT, new JdbcTypeItem(new JdbcType("TINYINT", Types.TINYINT), DbJavaTypes.BYTE));
//        map.put(Types.SMALLINT, new JdbcTypeItem(new JdbcType("SMALLINT", Types.SMALLINT), DbJavaTypes.SHORT));
//        map.put(Types.INTEGER, new JdbcTypeItem(new JdbcType("INTEGER", Types.INTEGER), DbJavaTypes.INTEGER));
//        map.put(Types.BIGINT, new JdbcTypeItem(new JdbcType("BIGINT", Types.BIGINT), DbJavaTypes.LONG));
//        map.put(Types.REAL, new JdbcTypeItem(new JdbcType("REAL", Types.REAL), DbJavaTypes.FLOAT));
//        map.put(Types.FLOAT, new JdbcTypeItem(new JdbcType("FLOAT", Types.FLOAT), DbJavaTypes.DOUBLE));
//        map.put(Types.DOUBLE, new JdbcTypeItem(new JdbcType("DOUBLE", Types.DOUBLE), DbJavaTypes.DOUBLE));
//        map.put(Types.DATE, new JdbcTypeItem(new JdbcType("DATE", Types.DATE), DbJavaTypes.DATE));
//        map.put(Types.TIME, new JdbcTypeItem(new JdbcType("TIME", Types.TIME), DbJavaTypes.TIME));
//        map.put(Types.TIMESTAMP, new JdbcTypeItem(new JdbcType("TIMESTAMP", Types.TIMESTAMP), DbJavaTypes.TIMESTAMP));
//        map.put(Types.BINARY, new JdbcTypeItem(new JdbcType("BINARY", Types.BINARY), DbJavaTypes.BYTEARRAY));
//        map.put(Types.VARBINARY, new JdbcTypeItem(new JdbcType("VARBINARY", Types.VARBINARY), DbJavaTypes.BYTEARRAY));
//        map.put(Types.LONGVARBINARY, new JdbcTypeItem(new JdbcType("LONGVARBINARY", Types.LONGVARBINARY), DbJavaTypes.BYTEARRAY));
//        map.put(Types.BLOB, new JdbcTypeItem(new JdbcType("BLOB", Types.BLOB), DbJavaTypes.BLOB));
//        map.put(Types.CLOB, new JdbcTypeItem(new JdbcType("CLOB", Types.CLOB), DbJavaTypes.CLOB));
//        map.put(Types.NCLOB, new JdbcTypeItem(new JdbcType("NCLOB", Types.NCLOB), DbJavaTypes.NCLOB));

        return map;
    }

    public static Map<Integer, String> getJdbcTypeMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        Field[] fields = Types.class.getFields();
        for (Field field : fields) {
            try {
                String n = field.getName();
                int v = field.getInt(null);
                map.put(v, n);
            } catch (IllegalAccessException e) {
                // todo
            }
        }
        return map;
    }

    public static int getColJdbcTypeInt(ZGTableColInfo colInfo) {
        return NumberUtils.toInt(Objects.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.DATA_TYPE)));
    }

    public static JdbcJavaType getColJdbcJavaType(ZGTableColInfo colInfo, ZGInfo info) {
        JdbcJavaType jdbcJavaType = MapUtils.getObject(info.getSysSetting().getJdbcJavaTypeMap(), getColJdbcTypeInt(colInfo));
        return jdbcJavaType;
    }

    public static String getColJdbcType(ZGTableColInfo colInfo, ZGInfo info) {
        String jdbcType = MapUtils.getObject(info.getSysSetting().getJdbcTypeMap(), getColJdbcTypeInt(colInfo));
        return jdbcType;
    }

    public static String stripPkg(String pkg) {
        return StringUtils.strip(pkg, ".");
    }

    public static String stripPath(String pkg) {
        return StringUtils.strip(pkg, File.separator);
    }

    public static String convertPkgPath(String pkg) {
        return StringUtils.replace(StringUtils.strip(pkg, "."), ".", File.separator);
    }

    public static List<ZGMethod> getSettingMethodList() {
        List<ZGMethod> list = new ArrayList<>();
        list.add(getZGMethod(ZGConstant.ZGMethods.SELECT_BY_PRIMARY_KEY));
        list.add(getZGMethod(ZGConstant.ZGMethods.INSERT));
//        list.add(getZGMethod(ZGConstant.ZGMethods.INSERT_SELECTIVE));
        list.add(getZGMethod(ZGConstant.ZGMethods.UPDATE_BY_PRIMARY_KEY));
//        list.add(getZGMethod(ZGConstant.ZGMethods.UPDATE_BY_PRIMARY_KEY_SELECTIVE));
        list.add(getZGMethod(ZGConstant.ZGMethods.DELETE_BY_PRIMARY_KEY));
        list.add(getZGMethod(ZGConstant.ZGMethods.SELECT_COUNT));
        list.add(getZGMethod(ZGConstant.ZGMethods.SELECT_PAGE));
        return list;
    }

    public static List<String> getSettingMethodStrList(List<ZGMethod> methodList) {
        List<String> list = new ArrayList<>();
        for (ZGMethod method : methodList) {
            list.add(method.getMethodName());
        }
        return list;
    }

    private static ZGMethod getZGMethod(ZGMethodItem item) {
        ZGMethod method = new ZGMethod();
        method.setMethodName(item.getName());
        method.setMethodItem(item);
        return method;
    }

    public static ZGUserSetting buildZGUserSetting(ZGSetting setting) {
        ZGUserSetting userSetting = new ZGUserSetting();
        userSetting.setProjectPath(String.format(".%ssrc%smain", File.separator, File.separator));
        userSetting.setJavaPath("java");
        userSetting.setDaoPkg("entity");
        userSetting.setRepositoryPkg("repository");
        userSetting.setMapperDir(String.format("resources%smapper", File.separator));
        userSetting.setRemarkFormat("// Type:{{type}}, Default:{{default}}, Remark:{{remark}}");

        if (setting != null) {
            if (setting.getUrl() != null) {
                userSetting.setUrl(setting.getUrl());
            }
            if (setting.getUser() != null) {
                userSetting.setUser(setting.getUser());
            }
            if (setting.getPassword() != null) {
                userSetting.setPassword(setting.getPassword());
            }
            if (setting.getTableList() != null) {
                userSetting.setTableList(setting.getTableList());
            }
            if (setting.getProjectPath() != null) {
                userSetting.setProjectPath(setting.getProjectPath());
            }
            if (setting.getJavaPath() != null) {
                userSetting.setJavaPath(setting.getJavaPath());
            }
            if (setting.getParentPkg() != null) {
                userSetting.setParentPkg(setting.getParentPkg());
            }
            if (setting.getMapperDir() != null) {
                userSetting.setMapperDir(setting.getMapperDir());
            }
            if (setting.getEntityPkg() != null) {
                userSetting.setDaoPkg(setting.getEntityPkg());
            }
            if (setting.getRepositoryPkg() != null) {
                userSetting.setRepositoryPkg(setting.getRepositoryPkg());
            }
            if (setting.getEntityPkgFull() != null) {
                userSetting.setDaoPkgFull(setting.getEntityPkgFull());
            }
            if (setting.getRepositoryPkgFull() != null) {
                userSetting.setRepositoryPkgFull(setting.getRepositoryPkgFull());
            }
            if (setting.getEntityDirPathFull() != null) {
                userSetting.setDaoDirPathFull(setting.getEntityDirPathFull());
            }
            if (setting.getRepositoryDirPathFull() != null) {
                userSetting.setRepositoryDirPathFull(setting.getRepositoryDirPathFull());
            }
            if (setting.getMapperDirPathFull() != null) {
                userSetting.setMapperDirPathFull(setting.getMapperDirPathFull());
            }
            if (setting.getRemarkFormat() != null) {
                userSetting.setRemarkFormat(setting.getRemarkFormat());
            }
        }
        return userSetting;
    }

    public static List<String> buildStrList(String... strArr) {
        List<String> strList = new ArrayList<>();
        for (String str : strArr) {
            if (!StringUtils.isBlank(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            FileUtils.forceMkdir(parentDir);
        }
        FileUtils.writeStringToFile(file, content, StandardCharsets.UTF_8);
    }

    public static ZGSysSetting buildZGSysSetting(ZGSetting setting) {
        ZGSysSetting sysSetting = new ZGSysSetting();
        sysSetting.setDaoSuffix("");
        sysSetting.setRepositorySuffix("Repository");
        sysSetting.setMapperSuffix("Mapper");
        sysSetting.setJdbcJavaTypeMap(ZGMiscUtil.getJdbcFieldTypeMapping());
        sysSetting.setJdbcTypeMap(ZGMiscUtil.getJdbcTypeMap());
        sysSetting.setMethodList(ZGMiscUtil.getSettingMethodList());
        sysSetting.setMethodStrList(ZGMiscUtil.getSettingMethodStrList(sysSetting.getMethodList()));
        sysSetting.setDaoTemplatePath("mybatis/entity.vm");
        sysSetting.setRepositoryTemplatePath("mybatis/repository.vm");
        sysSetting.setMapperTemplatePath("mybatis/mapper.vm");

        if (setting != null) {
            if (setting.getMapperTemplatePath() != null) {
                sysSetting.setMapperTemplatePath(setting.getMapperTemplatePath());
            }
            if (setting.getEntityTemplatePath() != null) {
                sysSetting.setDaoTemplatePath(setting.getEntityTemplatePath());
            }
            if (setting.getRepositoryTemplatePath() != null) {
                sysSetting.setRepositoryTemplatePath(setting.getRepositoryTemplatePath());
            }
            if (setting.getMethodList() != null) {
                sysSetting.setMethodList(setting.getMethodList());
            }
            if (setting.getMethodStrList() != null) {
                sysSetting.setMethodStrList(setting.getMethodStrList());
            }
            if (setting.getEntitySuffix() != null) {
                sysSetting.setDaoSuffix(setting.getEntitySuffix());
            }
            if (setting.getRepositorySuffix() != null) {
                sysSetting.setRepositorySuffix(setting.getRepositorySuffix());
            }
            if (setting.getMapperSuffix() != null) {
                sysSetting.setMapperSuffix(setting.getMapperSuffix());
            }
            if (setting.getJdbcJavaTypeMap() != null) {
                sysSetting.getJdbcJavaTypeMap().putAll(setting.getJdbcJavaTypeMap());
            }
            if (setting.getJdbcTypeMap() != null) {
                sysSetting.getJdbcTypeMap().putAll(setting.getJdbcTypeMap());
            }
        }
        return sysSetting;
    }

    public static ZGSetting buildZGSetting(String url, String user, String password, String tables) {
        ZGSetting settingIpt = new ZGSetting();
        settingIpt.setUrl(url);
        settingIpt.setUser(user);
        settingIpt.setPassword(password);
        settingIpt.setTableList(new ArrayList<>(Arrays.asList(StringUtils.split(tables, ","))));
        return settingIpt;
    }

    public static ZGSetting buildZGSetting(String url, String user, String password, List<String> tables,
                                           String projectPath, String parentPkg, String mapperDir,
                                           String daoPkg, String repositoryPkg) {
        ZGSetting settingIpt = new ZGSetting();
        settingIpt.setUrl(url);
        settingIpt.setUser(user);
        settingIpt.setPassword(password);
        settingIpt.setTableList(tables);
        settingIpt.setProjectPath(projectPath);
        settingIpt.setParentPkg(parentPkg);
        settingIpt.setMapperDir(mapperDir);
        settingIpt.setEntityPkg(daoPkg);
        settingIpt.setRepositoryPkg(repositoryPkg);
        return settingIpt;
    }
}
