package net.zliss.tool.mybatis.generator.zgenerator.model;

import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassAttrFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldGetMethodFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldNameFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldPkgFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldRemarkFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldSetMethodFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassFieldTypeFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassNameFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoClassTxtFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoImportFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoPathFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.DaoPkgFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperBaseColumnFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperColumnFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperDocTypeFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperFieldJdbcTypeFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperMethodFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperPathFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperResultMapFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.MapperTxtFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryClassNameFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryClassTxtFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryImportFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryMethodFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryPathFunc;
import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGFunc.RepositoryPkgFunc;
import net.zliss.tool.mybatis.generator.zgenerator.exception.ZGException;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType;

import java.util.List;
import java.util.Map;

public class ZGInfoModel {

    public static class ZGInfo {
        private ZGUserSetting userSetting;
        private ZGSysSetting sysSetting;
        private List<ZGTableInfo> tableInfoList;
        private List<ZGException> exceptionList;
        private ZGFunc func;

        public ZGUserSetting getUserSetting() {
            return userSetting;
        }

        public void setUserSetting(ZGUserSetting userSetting) {
            this.userSetting = userSetting;
        }

        public ZGSysSetting getSysSetting() {
            return sysSetting;
        }

        public void setSysSetting(ZGSysSetting sysSetting) {
            this.sysSetting = sysSetting;
        }

        public List<ZGTableInfo> getTableInfoList() {
            return tableInfoList;
        }

        public void setTableInfoList(List<ZGTableInfo> tableInfoList) {
            this.tableInfoList = tableInfoList;
        }

        public List<ZGException> getExceptionList() {
            return exceptionList;
        }

        public void setExceptionList(List<ZGException> exceptionList) {
            this.exceptionList = exceptionList;
        }

        public ZGFunc getFunc() {
            return func;
        }

        public void setFunc(ZGFunc func) {
            this.func = func;
        }
    }

    public static class ZGSetting {
        private String url;
        private String user;
        private String password;
        private List<String> tableList;
        private String projectPath;
        private String javaPath;
        private String parentPkg;
        private String mapperDir;
        private String entityPkg;
        private String repositoryPkg;
        private String entityPkgFull;
        private String repositoryPkgFull;
        private String entityDirPathFull;
        private String repositoryDirPathFull;
        private String mapperDirPathFull;
        private String remarkFormat;

        private String mapperTemplatePath;
        private String entityTemplatePath;
        private String repositoryTemplatePath;
        private List<ZGMethod> methodList;
        private List<String> methodStrList;
        private String entitySuffix;
        private String repositorySuffix;
        private String mapperSuffix;
        private Map<Integer, JdbcJavaType> jdbcJavaTypeMap;
        private Map<Integer, String> jdbcTypeMap;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<String> getTableList() {
            return tableList;
        }

        public void setTableList(List<String> tableList) {
            this.tableList = tableList;
        }

        public String getProjectPath() {
            return projectPath;
        }

        public void setProjectPath(String projectPath) {
            this.projectPath = projectPath;
        }

        public String getJavaPath() {
            return javaPath;
        }

        public void setJavaPath(String javaPath) {
            this.javaPath = javaPath;
        }

        public String getParentPkg() {
            return parentPkg;
        }

        public void setParentPkg(String parentPkg) {
            this.parentPkg = parentPkg;
        }

        public String getMapperDir() {
            return mapperDir;
        }

        public void setMapperDir(String mapperDir) {
            this.mapperDir = mapperDir;
        }

        public String getEntityPkg() {
            return entityPkg;
        }

        public void setEntityPkg(String entityPkg) {
            this.entityPkg = entityPkg;
        }

        public String getRepositoryPkg() {
            return repositoryPkg;
        }

        public void setRepositoryPkg(String repositoryPkg) {
            this.repositoryPkg = repositoryPkg;
        }

        public String getEntityPkgFull() {
            return entityPkgFull;
        }

        public void setEntityPkgFull(String entityPkgFull) {
            this.entityPkgFull = entityPkgFull;
        }

        public String getRepositoryPkgFull() {
            return repositoryPkgFull;
        }

        public void setRepositoryPkgFull(String repositoryPkgFull) {
            this.repositoryPkgFull = repositoryPkgFull;
        }

        public String getEntityDirPathFull() {
            return entityDirPathFull;
        }

        public void setEntityDirPathFull(String entityDirPathFull) {
            this.entityDirPathFull = entityDirPathFull;
        }

        public String getRepositoryDirPathFull() {
            return repositoryDirPathFull;
        }

        public void setRepositoryDirPathFull(String repositoryDirPathFull) {
            this.repositoryDirPathFull = repositoryDirPathFull;
        }

        public String getMapperDirPathFull() {
            return mapperDirPathFull;
        }

        public void setMapperDirPathFull(String mapperDirPathFull) {
            this.mapperDirPathFull = mapperDirPathFull;
        }

        public String getRemarkFormat() {
            return remarkFormat;
        }

        public void setRemarkFormat(String remarkFormat) {
            this.remarkFormat = remarkFormat;
        }

        public String getMapperTemplatePath() {
            return mapperTemplatePath;
        }

        public void setMapperTemplatePath(String mapperTemplatePath) {
            this.mapperTemplatePath = mapperTemplatePath;
        }

        public String getEntityTemplatePath() {
            return entityTemplatePath;
        }

        public void setEntityTemplatePath(String entityTemplatePath) {
            this.entityTemplatePath = entityTemplatePath;
        }

        public String getRepositoryTemplatePath() {
            return repositoryTemplatePath;
        }

        public void setRepositoryTemplatePath(String repositoryTemplatePath) {
            this.repositoryTemplatePath = repositoryTemplatePath;
        }

        public List<ZGMethod> getMethodList() {
            return methodList;
        }

        public void setMethodList(List<ZGMethod> methodList) {
            this.methodList = methodList;
        }

        public List<String> getMethodStrList() {
            return methodStrList;
        }

        public void setMethodStrList(List<String> methodStrList) {
            this.methodStrList = methodStrList;
        }

        public String getEntitySuffix() {
            return entitySuffix;
        }

        public void setEntitySuffix(String entitySuffix) {
            this.entitySuffix = entitySuffix;
        }

        public String getRepositorySuffix() {
            return repositorySuffix;
        }

        public void setRepositorySuffix(String repositorySuffix) {
            this.repositorySuffix = repositorySuffix;
        }

        public String getMapperSuffix() {
            return mapperSuffix;
        }

        public void setMapperSuffix(String mapperSuffix) {
            this.mapperSuffix = mapperSuffix;
        }

        public Map<Integer, JdbcJavaType> getJdbcJavaTypeMap() {
            return jdbcJavaTypeMap;
        }

        public void setJdbcJavaTypeMap(Map<Integer, JdbcJavaType> jdbcJavaTypeMap) {
            this.jdbcJavaTypeMap = jdbcJavaTypeMap;
        }

        public Map<Integer, String> getJdbcTypeMap() {
            return jdbcTypeMap;
        }

        public void setJdbcTypeMap(Map<Integer, String> jdbcTypeMap) {
            this.jdbcTypeMap = jdbcTypeMap;
        }
    }

    public static class ZGTemplateData {

        private String tableName;

        private String daoPath;
        private String daoPkg;
        private String daoImport;
        private String daoClassName;
        private String daoReference;
        private String daoObjectName;
        private List<String> daoClassAttrList;
        private List<String> daoClassFieldSetMethodList;
        private List<String> daoClassFieldGetMethodList;

        private String repositoryPath;
        private String repositoryPkg;
        private String repositoryImport;
        private String repositoryClassName;
        private String repositoryReference;

        private String mapperPath;
        private String mapperResultMap;
        private String mapperBaseColumn;

        private String primaryKeyColName;
        private String primaryKeyJdbcType;
        private String primaryKeyFieldName;
        private String primaryKeyFieldPkg;
        private String primaryKeyFieldType;

        private List<String> methodStrList;

        private List<JdbcFieldInfo> fieldInfoList;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getDaoPath() {
            return daoPath;
        }

        public void setDaoPath(String daoPath) {
            this.daoPath = daoPath;
        }

        public String getDaoPkg() {
            return daoPkg;
        }

        public void setDaoPkg(String daoPkg) {
            this.daoPkg = daoPkg;
        }

        public String getDaoImport() {
            return daoImport;
        }

        public void setDaoImport(String daoImport) {
            this.daoImport = daoImport;
        }

        public String getDaoClassName() {
            return daoClassName;
        }

        public void setDaoClassName(String daoClassName) {
            this.daoClassName = daoClassName;
        }

        public String getDaoReference() {
            return daoReference;
        }

        public void setDaoReference(String daoReference) {
            this.daoReference = daoReference;
        }

        public String getDaoObjectName() {
            return daoObjectName;
        }

        public void setDaoObjectName(String daoObjectName) {
            this.daoObjectName = daoObjectName;
        }

        public List<String> getDaoClassAttrList() {
            return daoClassAttrList;
        }

        public void setDaoClassAttrList(List<String> daoClassAttrList) {
            this.daoClassAttrList = daoClassAttrList;
        }

        public List<String> getDaoClassFieldSetMethodList() {
            return daoClassFieldSetMethodList;
        }

        public void setDaoClassFieldSetMethodList(List<String> daoClassFieldSetMethodList) {
            this.daoClassFieldSetMethodList = daoClassFieldSetMethodList;
        }

        public List<String> getDaoClassFieldGetMethodList() {
            return daoClassFieldGetMethodList;
        }

        public void setDaoClassFieldGetMethodList(List<String> daoClassFieldGetMethodList) {
            this.daoClassFieldGetMethodList = daoClassFieldGetMethodList;
        }

        public String getRepositoryPath() {
            return repositoryPath;
        }

        public void setRepositoryPath(String repositoryPath) {
            this.repositoryPath = repositoryPath;
        }

        public String getRepositoryPkg() {
            return repositoryPkg;
        }

        public void setRepositoryPkg(String repositoryPkg) {
            this.repositoryPkg = repositoryPkg;
        }

        public String getRepositoryImport() {
            return repositoryImport;
        }

        public void setRepositoryImport(String repositoryImport) {
            this.repositoryImport = repositoryImport;
        }

        public String getRepositoryClassName() {
            return repositoryClassName;
        }

        public void setRepositoryClassName(String repositoryClassName) {
            this.repositoryClassName = repositoryClassName;
        }

        public String getRepositoryReference() {
            return repositoryReference;
        }

        public void setRepositoryReference(String repositoryReference) {
            this.repositoryReference = repositoryReference;
        }

        public String getMapperPath() {
            return mapperPath;
        }

        public void setMapperPath(String mapperPath) {
            this.mapperPath = mapperPath;
        }

        public String getMapperResultMap() {
            return mapperResultMap;
        }

        public void setMapperResultMap(String mapperResultMap) {
            this.mapperResultMap = mapperResultMap;
        }

        public String getMapperBaseColumn() {
            return mapperBaseColumn;
        }

        public void setMapperBaseColumn(String mapperBaseColumn) {
            this.mapperBaseColumn = mapperBaseColumn;
        }

        public String getPrimaryKeyColName() {
            return primaryKeyColName;
        }

        public void setPrimaryKeyColName(String primaryKeyColName) {
            this.primaryKeyColName = primaryKeyColName;
        }

        public String getPrimaryKeyJdbcType() {
            return primaryKeyJdbcType;
        }

        public void setPrimaryKeyJdbcType(String primaryKeyJdbcType) {
            this.primaryKeyJdbcType = primaryKeyJdbcType;
        }

        public String getPrimaryKeyFieldName() {
            return primaryKeyFieldName;
        }

        public void setPrimaryKeyFieldName(String primaryKeyFieldName) {
            this.primaryKeyFieldName = primaryKeyFieldName;
        }

        public String getPrimaryKeyFieldPkg() {
            return primaryKeyFieldPkg;
        }

        public void setPrimaryKeyFieldPkg(String primaryKeyFieldPkg) {
            this.primaryKeyFieldPkg = primaryKeyFieldPkg;
        }

        public String getPrimaryKeyFieldType() {
            return primaryKeyFieldType;
        }

        public void setPrimaryKeyFieldType(String primaryKeyFieldType) {
            this.primaryKeyFieldType = primaryKeyFieldType;
        }

        public List<String> getMethodStrList() {
            return methodStrList;
        }

        public void setMethodStrList(List<String> methodStrList) {
            this.methodStrList = methodStrList;
        }

        public List<JdbcFieldInfo> getFieldInfoList() {
            return fieldInfoList;
        }

        public void setFieldInfoList(List<JdbcFieldInfo> fieldInfoList) {
            this.fieldInfoList = fieldInfoList;
        }
    }

    public static class JdbcFieldInfo {
        private String columnType;
        private String columnName;
        private String fieldPkg;
        private String fieldType;
        private String fieldName;
        private String fieldNameFirstUpper;
        private String fieldRemark;
        private String jdbcType;

        public String getColumnType() {
            return columnType;
        }

        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getFieldPkg() {
            return fieldPkg;
        }

        public void setFieldPkg(String fieldPkg) {
            this.fieldPkg = fieldPkg;
        }

        public String getFieldType() {
            return fieldType;
        }

        public void setFieldType(String fieldType) {
            this.fieldType = fieldType;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldNameFirstUpper() {
            return fieldNameFirstUpper;
        }

        public void setFieldNameFirstUpper(String fieldNameFirstUpper) {
            this.fieldNameFirstUpper = fieldNameFirstUpper;
        }

        public String getFieldRemark() {
            return fieldRemark;
        }

        public void setFieldRemark(String fieldRemark) {
            this.fieldRemark = fieldRemark;
        }

        public String getJdbcType() {
            return jdbcType;
        }

        public void setJdbcType(String jdbcType) {
            this.jdbcType = jdbcType;
        }
    }

    public static class ZGFunc {
        private DaoPathFunc daoPathFunc;
        private DaoPkgFunc daoPkgFunc;
        private DaoImportFunc daoImportFunc;
        private DaoClassNameFunc daoClassNameFunc;
        private DaoClassFieldTypeFunc daoClassFieldTypeFunc;
        private DaoClassFieldPkgFunc daoClassFieldPkgFunc;
        private DaoClassFieldNameFunc daoClassFieldNameFunc;
        private DaoClassFieldRemarkFunc daoClassFieldRemarkFunc;
        private DaoClassAttrFunc daoClassAttrFunc;
        private DaoClassFieldSetMethodFunc daoClassFieldSetMethodFunc;
        private DaoClassFieldGetMethodFunc daoClassFieldGetMethodFunc;
        private DaoClassTxtFunc daoClassTxtFunc;

        private RepositoryPathFunc repositoryPathFunc;
        private RepositoryPkgFunc repositoryPkgFunc;
        private RepositoryImportFunc repositoryImportFunc;
        private RepositoryClassNameFunc repositoryClassNameFunc;
        private RepositoryMethodFunc repositoryMethodFunc;
        private RepositoryClassTxtFunc repositoryClassTxtFunc;

        private MapperPathFunc mapperPathFunc;
        private MapperDocTypeFunc mapperFileNameFunc;
        private MapperDocTypeFunc mapperDocTypeFunc;
        private MapperFieldJdbcTypeFunc mapperFieldJdbcTypeFunc;
        private MapperColumnFunc mapperColumnFunc;
        private MapperResultMapFunc mapperResultMapFunc;
        private MapperBaseColumnFunc mapperBaseColumnFunc;
        private MapperMethodFunc mapperMethodFunc;
        private MapperTxtFunc mapperTxtFunc;

        public DaoPathFunc getDaoPathFunc() {
            return daoPathFunc;
        }

        public void setDaoPathFunc(DaoPathFunc daoPathFunc) {
            this.daoPathFunc = daoPathFunc;
        }

        public DaoPkgFunc getDaoPkgFunc() {
            return daoPkgFunc;
        }

        public void setDaoPkgFunc(DaoPkgFunc daoPkgFunc) {
            this.daoPkgFunc = daoPkgFunc;
        }

        public DaoImportFunc getDaoImportFunc() {
            return daoImportFunc;
        }

        public void setDaoImportFunc(DaoImportFunc daoImportFunc) {
            this.daoImportFunc = daoImportFunc;
        }

        public DaoClassNameFunc getDaoClassNameFunc() {
            return daoClassNameFunc;
        }

        public void setDaoClassNameFunc(DaoClassNameFunc daoClassNameFunc) {
            this.daoClassNameFunc = daoClassNameFunc;
        }

        public DaoClassFieldTypeFunc getDaoClassFieldTypeFunc() {
            return daoClassFieldTypeFunc;
        }

        public void setDaoClassFieldTypeFunc(DaoClassFieldTypeFunc daoClassFieldTypeFunc) {
            this.daoClassFieldTypeFunc = daoClassFieldTypeFunc;
        }

        public DaoClassFieldPkgFunc getDaoClassFieldPkgFunc() {
            return daoClassFieldPkgFunc;
        }

        public void setDaoClassFieldPkgFunc(DaoClassFieldPkgFunc daoClassFieldPkgFunc) {
            this.daoClassFieldPkgFunc = daoClassFieldPkgFunc;
        }

        public DaoClassFieldNameFunc getDaoClassFieldNameFunc() {
            return daoClassFieldNameFunc;
        }

        public void setDaoClassFieldNameFunc(DaoClassFieldNameFunc daoClassFieldNameFunc) {
            this.daoClassFieldNameFunc = daoClassFieldNameFunc;
        }

        public DaoClassFieldRemarkFunc getDaoClassFieldRemarkFunc() {
            return daoClassFieldRemarkFunc;
        }

        public void setDaoClassFieldRemarkFunc(DaoClassFieldRemarkFunc daoClassFieldRemarkFunc) {
            this.daoClassFieldRemarkFunc = daoClassFieldRemarkFunc;
        }

        public DaoClassAttrFunc getDaoClassAttrFunc() {
            return daoClassAttrFunc;
        }

        public void setDaoClassAttrFunc(DaoClassAttrFunc daoClassAttrFunc) {
            this.daoClassAttrFunc = daoClassAttrFunc;
        }

        public DaoClassFieldSetMethodFunc getDaoClassFieldSetMethodFunc() {
            return daoClassFieldSetMethodFunc;
        }

        public void setDaoClassFieldSetMethodFunc(DaoClassFieldSetMethodFunc daoClassFieldSetMethodFunc) {
            this.daoClassFieldSetMethodFunc = daoClassFieldSetMethodFunc;
        }

        public DaoClassFieldGetMethodFunc getDaoClassFieldGetMethodFunc() {
            return daoClassFieldGetMethodFunc;
        }

        public void setDaoClassFieldGetMethodFunc(DaoClassFieldGetMethodFunc daoClassFieldGetMethodFunc) {
            this.daoClassFieldGetMethodFunc = daoClassFieldGetMethodFunc;
        }

        public DaoClassTxtFunc getDaoClassTxtFunc() {
            return daoClassTxtFunc;
        }

        public void setDaoClassTxtFunc(DaoClassTxtFunc daoClassTxtFunc) {
            this.daoClassTxtFunc = daoClassTxtFunc;
        }

        public RepositoryPathFunc getRepositoryPathFunc() {
            return repositoryPathFunc;
        }

        public void setRepositoryPathFunc(RepositoryPathFunc repositoryPathFunc) {
            this.repositoryPathFunc = repositoryPathFunc;
        }

        public RepositoryPkgFunc getRepositoryPkgFunc() {
            return repositoryPkgFunc;
        }

        public void setRepositoryPkgFunc(RepositoryPkgFunc repositoryPkgFunc) {
            this.repositoryPkgFunc = repositoryPkgFunc;
        }

        public RepositoryImportFunc getRepositoryImportFunc() {
            return repositoryImportFunc;
        }

        public void setRepositoryImportFunc(RepositoryImportFunc repositoryImportFunc) {
            this.repositoryImportFunc = repositoryImportFunc;
        }

        public RepositoryClassNameFunc getRepositoryClassNameFunc() {
            return repositoryClassNameFunc;
        }

        public void setRepositoryClassNameFunc(RepositoryClassNameFunc repositoryClassNameFunc) {
            this.repositoryClassNameFunc = repositoryClassNameFunc;
        }

        public RepositoryMethodFunc getRepositoryMethodFunc() {
            return repositoryMethodFunc;
        }

        public void setRepositoryMethodFunc(RepositoryMethodFunc repositoryMethodFunc) {
            this.repositoryMethodFunc = repositoryMethodFunc;
        }

        public RepositoryClassTxtFunc getRepositoryClassTxtFunc() {
            return repositoryClassTxtFunc;
        }

        public void setRepositoryClassTxtFunc(RepositoryClassTxtFunc repositoryClassTxtFunc) {
            this.repositoryClassTxtFunc = repositoryClassTxtFunc;
        }

        public MapperPathFunc getMapperPathFunc() {
            return mapperPathFunc;
        }

        public void setMapperPathFunc(MapperPathFunc mapperPathFunc) {
            this.mapperPathFunc = mapperPathFunc;
        }

        public MapperDocTypeFunc getMapperFileNameFunc() {
            return mapperFileNameFunc;
        }

        public void setMapperFileNameFunc(MapperDocTypeFunc mapperFileNameFunc) {
            this.mapperFileNameFunc = mapperFileNameFunc;
        }

        public MapperDocTypeFunc getMapperDocTypeFunc() {
            return mapperDocTypeFunc;
        }

        public void setMapperDocTypeFunc(MapperDocTypeFunc mapperDocTypeFunc) {
            this.mapperDocTypeFunc = mapperDocTypeFunc;
        }

        public MapperFieldJdbcTypeFunc getMapperFieldJdbcTypeFunc() {
            return mapperFieldJdbcTypeFunc;
        }

        public void setMapperFieldJdbcTypeFunc(MapperFieldJdbcTypeFunc mapperFieldJdbcTypeFunc) {
            this.mapperFieldJdbcTypeFunc = mapperFieldJdbcTypeFunc;
        }

        public MapperColumnFunc getMapperColumnFunc() {
            return mapperColumnFunc;
        }

        public void setMapperColumnFunc(MapperColumnFunc mapperColumnFunc) {
            this.mapperColumnFunc = mapperColumnFunc;
        }

        public MapperResultMapFunc getMapperResultMapFunc() {
            return mapperResultMapFunc;
        }

        public void setMapperResultMapFunc(MapperResultMapFunc mapperResultMapFunc) {
            this.mapperResultMapFunc = mapperResultMapFunc;
        }

        public MapperBaseColumnFunc getMapperBaseColumnFunc() {
            return mapperBaseColumnFunc;
        }

        public void setMapperBaseColumnFunc(MapperBaseColumnFunc mapperBaseColumnFunc) {
            this.mapperBaseColumnFunc = mapperBaseColumnFunc;
        }

        public MapperMethodFunc getMapperMethodFunc() {
            return mapperMethodFunc;
        }

        public void setMapperMethodFunc(MapperMethodFunc mapperMethodFunc) {
            this.mapperMethodFunc = mapperMethodFunc;
        }

        public MapperTxtFunc getMapperTxtFunc() {
            return mapperTxtFunc;
        }

        public void setMapperTxtFunc(MapperTxtFunc mapperTxtFunc) {
            this.mapperTxtFunc = mapperTxtFunc;
        }
    }

    public static class ZGMethod {
        private String methodName;
        private ZGMethodItem methodItem;

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public ZGMethodItem getMethodItem() {
            return methodItem;
        }

        public void setMethodItem(ZGMethodItem methodItem) {
            this.methodItem = methodItem;
        }
    }

    public static class ZGMethodItem {
        private String name;

        public ZGMethodItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class ZGTableInfo {
        private String tableName;
        private Map<String, Object> jdbcTableData;
        private List<ZGTableColInfo> colInfoList;
        private ZGTableColInfo primaryKeyCol;
        private ZGTableColInfo primaryKeyColInfo;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public Map<String, Object> getJdbcTableData() {
            return jdbcTableData;
        }

        public void setJdbcTableData(Map<String, Object> jdbcTableData) {
            this.jdbcTableData = jdbcTableData;
        }

        public List<ZGTableColInfo> getColInfoList() {
            return colInfoList;
        }

        public void setColInfoList(List<ZGTableColInfo> colInfoList) {
            this.colInfoList = colInfoList;
        }

        public ZGTableColInfo getPrimaryKeyCol() {
            return primaryKeyCol;
        }

        public void setPrimaryKeyCol(ZGTableColInfo primaryKeyCol) {
            this.primaryKeyCol = primaryKeyCol;
        }

        public ZGTableColInfo getPrimaryKeyColInfo() {
            return primaryKeyColInfo;
        }

        public void setPrimaryKeyColInfo(ZGTableColInfo primaryKeyColInfo) {
            this.primaryKeyColInfo = primaryKeyColInfo;
        }
    }

    public static class ZGTableColInfo {
        private Map<String, Object> jdbcColData;

        public Map<String, Object> getJdbcColData() {
            return jdbcColData;
        }

        public void setJdbcColData(Map<String, Object> jdbcColData) {
            this.jdbcColData = jdbcColData;
        }
    }

    public static class ZGUserSetting {
        private String url;
        private String user;
        private String password;
        private List<String> tableList;
        private String projectPath;
        private String javaPath;
        private String parentPkg;
        private String mapperDir;
        private String daoPkg;
        private String repositoryPkg;
        private String daoPkgFull;
        private String repositoryPkgFull;
        private String daoDirPathFull;
        private String repositoryDirPathFull;
        private String mapperDirPathFull;
        private String remarkFormat;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public List<String> getTableList() {
            return tableList;
        }

        public void setTableList(List<String> tableList) {
            this.tableList = tableList;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getProjectPath() {
            return projectPath;
        }

        public void setProjectPath(String projectPath) {
            this.projectPath = projectPath;
        }

        public String getJavaPath() {
            return javaPath;
        }

        public void setJavaPath(String javaPath) {
            this.javaPath = javaPath;
        }

        public String getParentPkg() {
            return parentPkg;
        }

        public void setParentPkg(String parentPkg) {
            this.parentPkg = parentPkg;
        }

        public String getMapperDir() {
            return mapperDir;
        }

        public void setMapperDir(String mapperDir) {
            this.mapperDir = mapperDir;
        }

        public String getDaoPkg() {
            return daoPkg;
        }

        public void setDaoPkg(String daoPkg) {
            this.daoPkg = daoPkg;
        }

        public String getRepositoryPkg() {
            return repositoryPkg;
        }

        public void setRepositoryPkg(String repositoryPkg) {
            this.repositoryPkg = repositoryPkg;
        }

        public String getDaoPkgFull() {
            return daoPkgFull;
        }

        public void setDaoPkgFull(String daoPkgFull) {
            this.daoPkgFull = daoPkgFull;
        }

        public String getRepositoryPkgFull() {
            return repositoryPkgFull;
        }

        public void setRepositoryPkgFull(String repositoryPkgFull) {
            this.repositoryPkgFull = repositoryPkgFull;
        }

        public String getDaoDirPathFull() {
            return daoDirPathFull;
        }

        public void setDaoDirPathFull(String daoDirPathFull) {
            this.daoDirPathFull = daoDirPathFull;
        }

        public String getRepositoryDirPathFull() {
            return repositoryDirPathFull;
        }

        public void setRepositoryDirPathFull(String repositoryDirPathFull) {
            this.repositoryDirPathFull = repositoryDirPathFull;
        }

        public String getMapperDirPathFull() {
            return mapperDirPathFull;
        }

        public void setMapperDirPathFull(String mapperDirPathFull) {
            this.mapperDirPathFull = mapperDirPathFull;
        }

        public String getRemarkFormat() {
            return remarkFormat;
        }

        public void setRemarkFormat(String remarkFormat) {
            this.remarkFormat = remarkFormat;
        }
    }

    public static class ZGSysSetting {
        private String mapperTemplatePath;
        private String daoTemplatePath;
        private String repositoryTemplatePath;
        private List<ZGMethod> methodList;
        private List<String> methodStrList;
        private String daoSuffix;
        private String repositorySuffix;
        private String mapperSuffix;
        private Map<Integer, JdbcJavaType> jdbcJavaTypeMap;
        private Map<Integer, String> jdbcTypeMap;

        public String getMapperTemplatePath() {
            return mapperTemplatePath;
        }

        public void setMapperTemplatePath(String mapperTemplatePath) {
            this.mapperTemplatePath = mapperTemplatePath;
        }

        public String getDaoTemplatePath() {
            return daoTemplatePath;
        }

        public void setDaoTemplatePath(String daoTemplatePath) {
            this.daoTemplatePath = daoTemplatePath;
        }

        public String getRepositoryTemplatePath() {
            return repositoryTemplatePath;
        }



        public void setRepositoryTemplatePath(String repositoryTemplatePath) {
            this.repositoryTemplatePath = repositoryTemplatePath;
        }

        public List<ZGMethod> getMethodList() {
            return methodList;
        }

        public void setMethodList(List<ZGMethod> methodList) {
            this.methodList = methodList;
        }

        public List<String> getMethodStrList() {
            return methodStrList;
        }

        public void setMethodStrList(List<String> methodStrList) {
            this.methodStrList = methodStrList;
        }

        public String getDaoSuffix() {
            return daoSuffix;
        }

        public void setDaoSuffix(String daoSuffix) {
            this.daoSuffix = daoSuffix;
        }

        public String getRepositorySuffix() {
            return repositorySuffix;
        }

        public void setRepositorySuffix(String repositorySuffix) {
            this.repositorySuffix = repositorySuffix;
        }

        public String getMapperSuffix() {
            return mapperSuffix;
        }

        public void setMapperSuffix(String mapperSuffix) {
            this.mapperSuffix = mapperSuffix;
        }

        public Map<Integer, JdbcJavaType> getJdbcJavaTypeMap() {
            return jdbcJavaTypeMap;
        }

        public void setJdbcJavaTypeMap(Map<Integer, JdbcJavaType> jdbcJavaTypeMap) {
            this.jdbcJavaTypeMap = jdbcJavaTypeMap;
        }

        public Map<Integer, String> getJdbcTypeMap() {
            return jdbcTypeMap;
        }

        public void setJdbcTypeMap(Map<Integer, String> jdbcTypeMap) {
            this.jdbcTypeMap = jdbcTypeMap;
        }
    }
}
