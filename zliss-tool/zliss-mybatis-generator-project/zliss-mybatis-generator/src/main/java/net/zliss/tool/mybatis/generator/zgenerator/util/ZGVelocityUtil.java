package net.zliss.tool.mybatis.generator.zgenerator.util;

import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableColInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTemplateData;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ZGVelocityUtil {

    public static ZGTemplateData buildTemplateData(ZGInfo zgInfo, ZGTableInfo tableInfo) {
        ZGTemplateData templateData = new ZGTemplateData();
        templateData.setTableName(ZGBuildUtil.buildTableName(tableInfo, zgInfo));

        templateData.setDaoPath(ZGBuildUtil.buildDaoPath(tableInfo, zgInfo));
        templateData.setDaoPkg(ZGBuildUtil.buildDaoPkg(tableInfo, zgInfo));
        templateData.setDaoImport(ZGBuildUtil.buildDaoImport(tableInfo, zgInfo));
        templateData.setDaoClassName(ZGBuildUtil.buildDaoClassName(tableInfo, zgInfo));
        templateData.setDaoReference(ZGBuildUtil.buildDaoReference(tableInfo, zgInfo));
        templateData.setDaoObjectName(ZGBuildUtil.buildDaoObjectName(tableInfo, zgInfo));
        List<String> daoClassAttrList = new ArrayList<>();
        templateData.setDaoClassAttrList(daoClassAttrList);
        List<String> daoClassFieldSetMethodList = new ArrayList<>();
        templateData.setDaoClassFieldSetMethodList(daoClassFieldSetMethodList);
        List<String> daoClassFieldGetMethodList = new ArrayList<>();
        templateData.setDaoClassFieldGetMethodList(daoClassFieldGetMethodList);

        for (ZGTableColInfo colInfo : tableInfo.getColInfoList()) {
            daoClassAttrList.add(ZGBuildUtil.buildDaoClassAttr(colInfo, tableInfo, zgInfo));
            daoClassFieldSetMethodList.add(ZGBuildUtil.buildDaoClassFieldSetMethod(colInfo, tableInfo, zgInfo));
            daoClassFieldGetMethodList.add(ZGBuildUtil.buildDaoClassFieldGetMethod(colInfo, tableInfo, zgInfo));
        }

        templateData.setRepositoryPath(ZGBuildUtil.buildRepositoryPath(tableInfo, zgInfo));
        templateData.setRepositoryPkg(ZGBuildUtil.buildRepositoryPkg(tableInfo, zgInfo));
        templateData.setRepositoryImport(ZGBuildUtil.buildRepositoryImport(tableInfo, zgInfo));
        templateData.setRepositoryClassName(ZGBuildUtil.buildRepositoryClassName(tableInfo, zgInfo));
        templateData.setRepositoryReference(ZGBuildUtil.buildRepositoryReference(tableInfo, zgInfo));

        templateData.setMapperPath(ZGBuildUtil.buildMapperPath(tableInfo, zgInfo));
        templateData.setMapperResultMap(ZGBuildUtil.buildMapperResultMap(tableInfo, zgInfo));
        templateData.setMapperBaseColumn(ZGBuildUtil.buildMapperBaseColumn(tableInfo, zgInfo));

        if (tableInfo.getPrimaryKeyCol() != null) {
            templateData.setPrimaryKeyColName(ZGBuildUtil.buildDaoClassFieldColName(tableInfo.getPrimaryKeyCol(), tableInfo, zgInfo));
            templateData.setPrimaryKeyFieldPkg(ZGBuildUtil.buildDaoClassFieldPkg(tableInfo.getPrimaryKeyCol(), tableInfo, zgInfo));
            templateData.setPrimaryKeyFieldType(ZGBuildUtil.buildDaoClassFieldType(tableInfo.getPrimaryKeyCol(), tableInfo, zgInfo));
            templateData.setPrimaryKeyFieldName(ZGBuildUtil.buildDaoClassFieldName(tableInfo.getPrimaryKeyCol(), tableInfo, zgInfo));
            templateData.setPrimaryKeyJdbcType(ZGBuildUtil.buildMapperFieldJdbcType(tableInfo.getPrimaryKeyCol(), tableInfo, zgInfo));
        }

        templateData.setMethodStrList(zgInfo.getSysSetting().getMethodStrList());

        templateData.setFieldInfoList(ZGBuildUtil.buildJdbcFieldInfoList(tableInfo, zgInfo));

        return templateData;
    }

    public static VelocityContext buildVelocityContext(ZGInfo zgInfo, ZGTableInfo tableInfo, ZGTemplateData templateData) {
        VelocityContext context = new VelocityContext();
        context.put("info", zgInfo);
        context.put("table", tableInfo);
        context.put("templateData", templateData);
        return context;
    }

    public static Template getTemplate(String vmPath) {
        VelocityEngine velocityEngine = new VelocityEngine();
        boolean isRelativePath = !(new File(vmPath).isAbsolute());
        if (isRelativePath) {
            String resourceLoaderPath = System.getProperty("java.io.tmpdir");
            velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, resourceLoaderPath);
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
            velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        } else {
            int index = vmPath.lastIndexOf(File.separator);
            velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, vmPath.substring(0, index + 1));
            vmPath = vmPath.substring(index);
        }
        velocityEngine.init();

        Template template = velocityEngine.getTemplate(vmPath);
        return template;
    }

    public static String mergeTemplate(Template template, VelocityContext context) {
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String content = writer.toString();
        return content;
    }

}
