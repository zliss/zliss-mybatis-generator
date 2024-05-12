package net.zliss.tool.mybatis.generator.zgenerator.util;

import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant.ZGJdbcColKeys;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant.ZGJdbcTableKeys;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.JdbcFieldInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableColInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGMethod;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGUserSetting;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZGBuildUtil {

    public static String buildTableName(ZGTableInfo tableInfo, ZGInfo info) {
        String tableName = ZGStringUtil.toString(tableInfo.getJdbcTableData().get(ZGJdbcTableKeys.TABLE_NAME));
        return tableName;
    }

    public static String buildDaoPath(ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String daoName = buildDaoClassName(tableInfo, info);
        String daoPkg = buildDaoPkg(tableInfo, info);
        String projectPath = ZGMiscUtil.stripPath(userSetting.getProjectPath());
        String javaPath = ZGMiscUtil.stripPath(userSetting.getJavaPath());
        // String parentPath = ZGMiscUtil.convertPkgPath(userSetting.getParentPkg());
        String daoPath = ZGMiscUtil.convertPkgPath(daoPkg);
        String daoDirPath = ZGMiscUtil.stripPath(userSetting.getDaoDirPathFull());
        List<String> list = new ArrayList<>();
        if (!StringUtils.isBlank(daoDirPath)) {
            list.add(daoDirPath);
        } else {
            if (!StringUtils.isBlank(projectPath)) {
                list.add(projectPath);
            }
//        if (!StringUtils.isBlank(parentPath)) {
//            list.add(parentPath);
//        }
            if (!StringUtils.isBlank(javaPath)) {
                list.add(javaPath);
            }
            if (!StringUtils.isBlank(daoPath)) {
                list.add(daoPath);
            }
        }
        list.add(daoName);

        String pathStr = String.format("%s%s.java", File.separator, StringUtils.join(list, File.separator));
        String content = pathStr;
        if(info.getFunc().getDaoPathFunc() != null) {
            content = info.getFunc().getDaoPathFunc().get(tableInfo, info, pathStr);
        }
        return content;
    }

    public static String buildDaoPkg(ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String parentPkg = ZGMiscUtil.stripPkg(userSetting.getParentPkg());
        String daoPkg = ZGMiscUtil.stripPkg(userSetting.getDaoPkg());
        String daoPkgFull = ZGMiscUtil.stripPkg(userSetting.getDaoPkgFull());
        List<String> list = new ArrayList<>();
        if (!StringUtils.isBlank(daoPkgFull)) {
            list.add(daoPkgFull);
        } else {
            if (!StringUtils.isBlank(parentPkg)) {
                list.add(parentPkg);
            }
            if (!StringUtils.isBlank(daoPkg)) {
                list.add(daoPkg);
            }
        }
        String pkgStr = StringUtils.join(list, ".");
        String content = pkgStr;
        if(info.getFunc().getDaoPkgFunc() != null) {
            content = info.getFunc().getDaoPkgFunc().get(tableInfo, info, pkgStr);
        }
        return content;
    }

    public static String buildDaoImport(ZGTableInfo tableInfo, ZGInfo info) {
        List<String> pkgList = new ArrayList<>();
        for (ZGTableColInfo colInfo : tableInfo.getColInfoList()) {
            String filedPkg = buildDaoClassFieldPkg(colInfo, tableInfo, info);
            String importStr = String.format("import %s;", filedPkg);
            if (!StringUtils.isBlank(filedPkg) && !pkgList.contains(importStr)) {
                pkgList.add(importStr);
            }
        }
        String importStr = CollectionUtils.isEmpty(pkgList) ? null : ("\n"+StringUtils.join(pkgList, "\n")+"\n");
        String content = importStr;
        if(info.getFunc().getDaoImportFunc() != null) {
            content = info.getFunc().getDaoImportFunc().get(tableInfo, info, importStr);
        }
        return content;
    }

    public static String buildDaoClassName(ZGTableInfo tableInfo, ZGInfo info) {
        String tableName = buildTableName(tableInfo, info);
        String nameStr = ZGStringUtil.firstLetterUpper(ZGStringUtil.underscoreToUpperCamel(tableName))+info.getSysSetting().getDaoSuffix();
        String content = nameStr;
        if(info.getFunc().getDaoClassNameFunc() != null) {
            content = info.getFunc().getDaoClassNameFunc().get(tableInfo, info, nameStr);
        }
        return content;
    }

    public static String buildDaoObjectName(ZGTableInfo tableInfo, ZGInfo info) {
        return ZGStringUtil.firstLetterLower(buildDaoClassName(tableInfo, info));
    }

    public static String buildDaoReference(ZGTableInfo tableInfo, ZGInfo info) {
        return StringUtils.join(ZGMiscUtil.buildStrList(buildDaoPkg(tableInfo, info), buildDaoClassName(tableInfo, info)), ".");
    }

    public static String buildDaoClassFieldColName(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String colName = ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_NAME));
        return colName;
    }

    public static String buildDaoClassFieldType(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        JdbcJavaType jdbcJavaType = ZGMiscUtil.getColJdbcJavaType(colInfo, info);
        String typeStr = jdbcJavaType == null ? null : jdbcJavaType.getType();
        String content = typeStr;
        if(info.getFunc().getDaoClassFieldTypeFunc() != null) {
            content = info.getFunc().getDaoClassFieldTypeFunc().get(colInfo, tableInfo, info, typeStr);
        }
        return content;
    }

    public static String buildDaoClassFieldPkg(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        JdbcJavaType jdbcJavaType = ZGMiscUtil.getColJdbcJavaType(colInfo, info);
        String pkgStr = jdbcJavaType == null ? null : jdbcJavaType.getPkg();
        String content = pkgStr;
        if(info.getFunc().getDaoClassFieldTypeFunc() != null) {
            content = info.getFunc().getDaoClassFieldPkgFunc().get(colInfo, tableInfo, info, pkgStr);
        }
        return content;
    }

    public static String buildDaoClassFieldName(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String colName = buildDaoClassFieldColName(colInfo, tableInfo, info);
        String nameStr = ZGStringUtil.firstLetterLower(ZGStringUtil.underscoreToUpperCamel(colName));
        String content = nameStr;
        if(info.getFunc().getDaoClassFieldNameFunc() != null) {
            content = info.getFunc().getDaoClassFieldNameFunc().get(colInfo, tableInfo, info, nameStr);
        }
        return content;
    }

    public static String buildDaoClassFieldRemark(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String type = ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.TYPE_NAME));
        String remark = ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.REMARKS));
        String def = colInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_DEF) == null ? "null" : ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_DEF));
        if ("".equals(def)) {
            def = "\"\"";
        }
        String remarkFormat = ZGStringUtil.toString(userSetting.getRemarkFormat());
        String content = remarkFormat.replace("{{type}}", type).replace("{{default}}", def).replace("{{remark}}", remark);
        if (!StringUtils.isBlank(content)) {
            content = " " + content;
        }
        if(info.getFunc().getDaoClassFieldRemarkFunc() != null) {
            content = info.getFunc().getDaoClassFieldRemarkFunc().get(colInfo, tableInfo, info, content);
        }
        return content;
    }

    public static String buildDaoClassAttr(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String fieldType = buildDaoClassFieldType(colInfo, tableInfo, info);
        String fieldName = buildDaoClassFieldName(colInfo, tableInfo, info);
        String fieldRemark = buildDaoClassFieldRemark(colInfo, tableInfo, info);
        String attrStr = String.format("\tprivate %s %s; %s", fieldType, fieldName, fieldRemark);
        String content = attrStr;
        if(info.getFunc().getDaoClassAttrFunc() != null) {
            content = info.getFunc().getDaoClassAttrFunc().get(colInfo, tableInfo, info, attrStr);
        }
        return content;
    }

    public static String buildDaoClassFieldSetMethod(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String fieldType = buildDaoClassFieldType(colInfo, tableInfo, info);
        String fieldName = buildDaoClassFieldName(colInfo, tableInfo, info);
        String methodStr = String.format("\tpublic void set%s(%s %s){\n\t\tthis.%s = %s;\n\t}\n",
                ZGStringUtil.firstLetterUpper(fieldName), fieldType, fieldName, fieldName, fieldName);
        String content = methodStr;
        if(info.getFunc().getDaoClassFieldSetMethodFunc() != null) {
            content = info.getFunc().getDaoClassFieldSetMethodFunc().get(colInfo, tableInfo, info, methodStr);
        }
        return content;
    }

    public static String buildDaoClassFieldGetMethod(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String fieldType = buildDaoClassFieldType(colInfo, tableInfo, info);
        String fieldName = buildDaoClassFieldName(colInfo, tableInfo, info);
        String methodStr = String.format("\tpublic %s get%s(){\n\t\treturn this.%s;\n\t}\n",
                fieldType, ZGStringUtil.firstLetterUpper(fieldName), fieldName);
        String content = methodStr;
        if(info.getFunc().getDaoClassFieldGetMethodFunc() != null) {
            content = info.getFunc().getDaoClassFieldGetMethodFunc().get(colInfo, tableInfo, info, methodStr);
        }
        return content;
    }

    public static String buildDaoClassTxt(ZGTableInfo tableInfo, ZGInfo info, String txtStr) {
        String content = txtStr;
        if(info.getFunc().getDaoClassTxtFunc() != null) {
            content = info.getFunc().getDaoClassTxtFunc().get(tableInfo, info, txtStr);
        }
        return content;
    }


    public static String buildRepositoryPath(ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String repositoryName = buildRepositoryClassName(tableInfo, info);
        String repositoryPkg = buildRepositoryPkg(tableInfo, info);
        String projectPath = ZGMiscUtil.stripPath(userSetting.getProjectPath());
        String javaPath = ZGMiscUtil.stripPath(userSetting.getJavaPath());
        // String parentPath = ZGMiscUtil.convertPkgPath(userSetting.getParentPkg());
        String repositoryPath = ZGMiscUtil.convertPkgPath(repositoryPkg);
        String repositoryDirPath = ZGMiscUtil.stripPath(userSetting.getRepositoryDirPathFull());
        List<String> list = new ArrayList<>();
        if (!StringUtils.isBlank(repositoryDirPath)) {
            list.add(repositoryDirPath);
        } else {
            if (!StringUtils.isBlank(projectPath)) {
                list.add(projectPath);
            }
//        if (!StringUtils.isBlank(parentPath)) {
//            list.add(parentPath);
//        }
            if (!StringUtils.isBlank(javaPath)) {
                list.add(javaPath);
            }
            if (!StringUtils.isBlank(repositoryPath)) {
                list.add(repositoryPath);
            }
        }
        list.add(repositoryName);

        String pathStr = String.format("%s%s.java", File.separator, StringUtils.join(list, File.separator));
        String content = pathStr;
        if(info.getFunc().getRepositoryPathFunc() != null) {
            content = info.getFunc().getRepositoryPathFunc().get(tableInfo, info, pathStr);
        }
        return content;
    }

    public static String buildRepositoryPkg(ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String parentPkg = ZGMiscUtil.stripPkg(userSetting.getParentPkg());
        String repositoryPkg = ZGMiscUtil.stripPkg(userSetting.getRepositoryPkg());
        String repositoryPkgFull = ZGMiscUtil.stripPkg(userSetting.getRepositoryPkgFull());
        List<String> list = new ArrayList<>();
        if (!StringUtils.isBlank(repositoryPkgFull)) {
            list.add(repositoryPkgFull);
        } else {
            if (!StringUtils.isBlank(parentPkg)) {
                list.add(parentPkg);
            }
            if (!StringUtils.isBlank(repositoryPkg)) {
                list.add(repositoryPkg);
            }
        }
        String pkgStr = StringUtils.join(list, ".");
        String content = pkgStr;
        if(info.getFunc().getRepositoryPkgFunc() != null) {
            content = info.getFunc().getRepositoryPkgFunc().get(tableInfo, info, pkgStr);
        }
        return content;
    }

    public static String buildRepositoryImport(ZGTableInfo tableInfo, ZGInfo info) {
        String daoName = buildDaoClassName(tableInfo, info);
        String daoPkg = buildDaoPkg(tableInfo, info);
        List<String> pkgList = new ArrayList<>();
//        pkgList.add(String.format("import %s;", ZGPackages.JAVA_UTIL_LIST));
//        pkgList.add(String.format("import %s;", ZGPackages.ORG_APACHE_IBATIS_ANNOTATIONS_PARAM));
//        pkgList.add(String.format("import %s;", ZGPackages.ORG_SPRINGFRAMEWORK_STEREOTYPE_REPOSITORY));
//        pkgList.add(String.format("import %s;", ZGPackages.ORG_SPRINGFRAMEWORK_DATA_DOMAIN_PAGEABLE));
        pkgList.add(String.format("import %s;", daoPkg+"."+daoName));
        if (tableInfo.getPrimaryKeyCol() != null) {
            String pkFieldPkg = buildDaoClassFieldPkg(tableInfo.getPrimaryKeyCol(), tableInfo, info);
            if (!StringUtils.isBlank(pkFieldPkg)) {
                pkgList.add(String.format("import %s;", pkFieldPkg));
            }
        }
        String importStr = StringUtils.join(pkgList, "\n");
        String content = importStr;
        if(info.getFunc().getRepositoryImportFunc() != null) {
            content = info.getFunc().getRepositoryImportFunc().get(tableInfo, info, importStr);
        }
        return content;
    }

    public static String buildRepositoryClassName(ZGTableInfo tableInfo, ZGInfo info) {
        String tableName = buildTableName(tableInfo, info);
        String nameStr = ZGStringUtil.firstLetterUpper(ZGStringUtil.underscoreToUpperCamel(tableName))+info.getSysSetting().getRepositorySuffix();
        String content = nameStr;
        if(info.getFunc().getRepositoryClassNameFunc() != null) {
            content = info.getFunc().getRepositoryClassNameFunc().get(tableInfo, info, nameStr);
        }
        return content;
    }

    public static String buildRepositoryReference(ZGTableInfo tableInfo, ZGInfo info) {
        return StringUtils.join(ZGMiscUtil.buildStrList(buildRepositoryPkg(tableInfo, info), buildRepositoryClassName(tableInfo, info)), ".");
    }

//    public static String buildRepositoryMethod(ZGMethod method, ZGTableInfo tableInfo, ZGInfo info) {
//        String methodStr = null;
//        String content = methodStr;
//        if(info.getFunc().getRepositoryMethodFunc() != null) {
//            content = info.getFunc().getRepositoryMethodFunc().get(method, tableInfo, info, methodStr);
//        }
//        return content;
//    }

    public static String buildRepositoryClassTxt(ZGTableInfo tableInfo, ZGInfo info, String txtStr) {
        String content = txtStr;
        if(info.getFunc().getRepositoryClassTxtFunc() != null) {
            content = info.getFunc().getRepositoryClassTxtFunc().get(tableInfo, info, txtStr);
        }
        return content;
    }


    public static String buildMapperPath(ZGTableInfo tableInfo, ZGInfo info) {
        ZGUserSetting userSetting = info.getUserSetting();
        String mapperName = buildMapperFileName(tableInfo, info);
        String projectPath = ZGMiscUtil.stripPath(userSetting.getProjectPath());
        String mapperDir = ZGMiscUtil.convertPkgPath(userSetting.getMapperDir());
        String mapperDirPath = ZGMiscUtil.stripPath(userSetting.getMapperDirPathFull());
        List<String> list = new ArrayList<>();
        if (!StringUtils.isBlank(mapperDirPath)) {
            list.add(mapperDirPath);
        } else {
            if (!StringUtils.isBlank(projectPath)) {
                list.add(projectPath);
            }
            if (!StringUtils.isBlank(mapperDir)) {
                list.add(mapperDir);
            }
        }
        list.add(mapperName);

        String pathStr = String.format("%s%s.xml", File.separator, StringUtils.join(list, File.separator));
        String content = pathStr;
        if(info.getFunc().getMapperPathFunc() != null) {
            content = info.getFunc().getMapperPathFunc().get(tableInfo, info, pathStr);
        }
        return content;
    }

    public static String buildMapperFileName(ZGTableInfo tableInfo, ZGInfo info) {
        String tableName = buildTableName(tableInfo, info);
        String fileNameStr = ZGStringUtil.firstLetterUpper(ZGStringUtil.underscoreToUpperCamel(tableName))+info.getSysSetting().getMapperSuffix();
        String content = fileNameStr;
        if(info.getFunc().getMapperFileNameFunc() != null) {
            content = info.getFunc().getMapperFileNameFunc().get(tableInfo, info, fileNameStr);
        }
        return content;
    }

//    public static String buildMapperDocType(ZGTableInfo tableInfo, ZGInfo info) {
//        String docTypeStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >";
//        String content = docTypeStr;
//        if(info.getFunc().getMapperDocTypeFunc() != null) {
//            content = info.getFunc().getMapperDocTypeFunc().get(tableInfo, info, docTypeStr);
//        }
//        return content;
//    }

    public static String buildMapperFieldJdbcType(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String jdbcTypeStr = ZGMiscUtil.getColJdbcType(colInfo, info);
        String content = jdbcTypeStr;
        if(info.getFunc().getMapperFieldJdbcTypeFunc() != null) {
            content = info.getFunc().getMapperFieldJdbcTypeFunc().get(colInfo, tableInfo, info, jdbcTypeStr);
        }
        return content;
    }

    public static String buildMapperColumn(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String colNamePK = tableInfo.getPrimaryKeyCol() == null ? null : buildDaoClassFieldColName(colInfo, tableInfo, info);
        String colName = buildDaoClassFieldColName(colInfo, tableInfo, info);
        String fieldName = buildDaoClassFieldName(colInfo, tableInfo, info);
        String jdbcType = ZGMiscUtil.getColJdbcType(colInfo, info);
//        String resultStr = "1".equals(ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.ORDINAL_POSITION)))
//                && "YES".equals(ZGStringUtil.toString(colInfo.getJdbcColData().get(ZGJdbcColKeys.IS_AUTOINCREMENT))) ? "id" : "result";
        String resultStr = colNamePK != null && colNamePK .equals(colName) ? "id" : "result";
        String columnStr = String.format("<%s column=\"%s\" property=\"%s\" jdbcType=\"%s\" />",
                resultStr, colName, fieldName, jdbcType);
        String content = columnStr;
        if(info.getFunc().getMapperColumnFunc() != null) {
            content = info.getFunc().getMapperColumnFunc().get(colInfo, tableInfo, info, columnStr);
        }
        return content;
    }

    public static String buildMapperResultMap(ZGTableInfo tableInfo, ZGInfo info) {
        String daoName = buildDaoClassName(tableInfo, info);
        String daoPkg = buildDaoPkg(tableInfo, info);
        List<String> colStrList = new ArrayList<>();
        for (ZGTableColInfo colInfo : tableInfo.getColInfoList()) {
            String col = buildMapperColumn(colInfo, tableInfo, info);
            colStrList.add(col);
        }
        String resultMapStr = String.format("<resultMap id=\"BaseResultMap\" type=\"%s\" >%s</resultMap>",
                StringUtils.join(ZGMiscUtil.buildStrList(daoPkg, daoName), "."), StringUtils.join(colStrList, "\n\t"));
        String content = resultMapStr;
        if(info.getFunc().getMapperResultMapFunc() != null) {
            content = info.getFunc().getMapperResultMapFunc().get(tableInfo, info, resultMapStr);
        }
        return content;
    }

    public static String buildMapperBaseColumn(ZGTableInfo tableInfo, ZGInfo info) {
        List<String> colStrList = new ArrayList<>();
        for (ZGTableColInfo colInfo : tableInfo.getColInfoList()) {
            String colName = buildDaoClassFieldColName(colInfo, tableInfo, info);
            colStrList.add(colName);
        }
        String baseColumnStr = String.format("<sql id=\"Base_Column_List\" >\n%s\n</sql>",
                StringUtils.join(colStrList, ",\n\t"));
        String content = baseColumnStr;
        if(info.getFunc().getMapperBaseColumnFunc() != null) {
            content = info.getFunc().getMapperBaseColumnFunc().get(tableInfo, info, baseColumnStr);
        }
        return content;
    }

    public static String buildMapperMethod(ZGMethod method, ZGTableInfo tableInfo, ZGInfo info) {
        String methodStr = null;
        String content = methodStr;
        if(info.getFunc().getMapperMethodFunc() != null) {
            content = info.getFunc().getMapperMethodFunc().get(method, tableInfo, info, methodStr);
        }
        return content;
    }

    public static String buildMapperTxt(ZGTableInfo tableInfo, ZGInfo info, String txtStr) {
        String content = txtStr;
        if(info.getFunc().getMapperTxtFunc() != null) {
            content = info.getFunc().getMapperTxtFunc().get(tableInfo, info, txtStr);
        }
        return content;
    }

    public static JdbcFieldInfo buildJdbcFieldInfo(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info) {
        String colNamePK = tableInfo.getPrimaryKeyCol() == null ? null : buildDaoClassFieldColName(tableInfo.getPrimaryKeyCol(), tableInfo, info);
        String colName = buildDaoClassFieldColName(colInfo, tableInfo, info);
        String fieldName = buildDaoClassFieldName(colInfo, tableInfo, info);
        String jdbcType = ZGMiscUtil.getColJdbcType(colInfo, info);
        String filedPkg = buildDaoClassFieldPkg(colInfo, tableInfo, info);
        String fieldType = buildDaoClassFieldType(colInfo, tableInfo, info);
        String fieldRemark = buildDaoClassFieldRemark(colInfo, tableInfo, info);

        JdbcFieldInfo fieldInfo = new JdbcFieldInfo();
        fieldInfo.setColumnType(colNamePK != null && colNamePK .equals(colName) ? "id" : "result");
        fieldInfo.setColumnName(colName);
        fieldInfo.setFieldPkg(filedPkg);
        fieldInfo.setFieldType(fieldType);
        fieldInfo.setFieldRemark(fieldRemark);
        fieldInfo.setFieldName(fieldName);
        fieldInfo.setFieldNameFirstUpper(ZGStringUtil.firstLetterUpper(fieldName));
        fieldInfo.setJdbcType(jdbcType);
        return fieldInfo;
    }

    public static List<JdbcFieldInfo> buildJdbcFieldInfoList(ZGTableInfo tableInfo, ZGInfo info) {
        List<JdbcFieldInfo> fieldInfoList = new ArrayList<>();
        for (ZGTableColInfo colInfo : tableInfo.getColInfoList()) {
            JdbcFieldInfo fieldInfo = buildJdbcFieldInfo(colInfo, tableInfo, info);
            fieldInfoList.add(fieldInfo);
        }
        return fieldInfoList;
    }



}
