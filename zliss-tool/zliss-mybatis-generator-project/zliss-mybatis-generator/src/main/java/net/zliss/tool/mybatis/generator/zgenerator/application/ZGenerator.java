package net.zliss.tool.mybatis.generator.zgenerator.application;

import net.zliss.tool.mybatis.generator.zgenerator.exception.ZGException;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGFunc;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGSetting;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTemplateData;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGUserSetting;
import net.zliss.tool.mybatis.generator.zgenerator.util.ZGBuildUtil;
import net.zliss.tool.mybatis.generator.zgenerator.util.ZGDbUtil;
import net.zliss.tool.mybatis.generator.zgenerator.util.ZGMiscUtil;
import net.zliss.tool.mybatis.generator.zgenerator.util.ZGVelocityUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZGenerator {

    private List<ZGException> exceptionList;

    private ZGSetting setting;

    public ZGenerator(String jdbcUrl, String user, String password, String tables,
                      String projectPath, String parentPkg) {
        setting = ZGMiscUtil.buildZGSetting(jdbcUrl, user, password, new ArrayList<>(Arrays.asList(StringUtils.split(tables, ","))),
                projectPath, parentPkg, null, null, null);
    }

    public ZGenerator(String jdbcUrl, String user, String password, String tables,
                      String projectPath, String parentPkg, String mapperDir,
                      String daoPkg, String repositoryPkg) {
        setting = ZGMiscUtil.buildZGSetting(jdbcUrl, user, password, new ArrayList<>(Arrays.asList(StringUtils.split(tables, ","))),
                projectPath, parentPkg, mapperDir, daoPkg, repositoryPkg);
    }

    public ZGenerator(String jdbcUrl, String user, String password, List<String> tables,
                      String projectPath, String parentPkg, String mapperDir,
                      String daoPkg, String repositoryPkg) {
        setting = ZGMiscUtil.buildZGSetting(jdbcUrl, user, password, tables, projectPath, parentPkg, mapperDir, daoPkg, repositoryPkg);
    }

    public ZGenerator(ZGSetting setting) {
        this.setting = setting;
    }

    public boolean build() {
        try {
            buildInner();
        } catch (Exception e) {
            addException(new ZGException(1001, "build error", e));
        }
        return CollectionUtils.isEmpty(exceptionList);
    }

    private void addException(ZGException exception) {
        if (exceptionList == null) {
            exceptionList = new ArrayList<>();
        }
        exceptionList.add(exception);
    }

    public List<ZGException> getExceptionList() {
        return exceptionList;
    }

    private void buildInner() throws SQLException, IOException {
        ZGUserSetting userSetting = ZGMiscUtil.buildZGUserSetting(setting);

        ZGInfo zgInfo = new ZGInfo();
        zgInfo.setUserSetting(userSetting);

        zgInfo.setSysSetting(ZGMiscUtil.buildZGSysSetting(setting));

        List<ZGTableInfo> tableInfoList = new ArrayList<>();
        zgInfo.setTableInfoList(tableInfoList);

        ZGFunc func = new ZGFunc();
        zgInfo.setFunc(func);

        try (Connection conn = ZGDbUtil.getConnection(userSetting.getUrl(), userSetting.getUser(), userSetting.getPassword())) {
            for (String table : userSetting.getTableList()) {
                ZGTableInfo tableInfo = ZGDbUtil.getZGTableInfo(conn, table);
                tableInfoList.add(tableInfo);
            }
        }

        for (ZGTableInfo tableInfo : zgInfo.getTableInfoList()) {
            ZGTemplateData templateData = ZGVelocityUtil.buildTemplateData(zgInfo, tableInfo);
            VelocityContext context = ZGVelocityUtil.buildVelocityContext(zgInfo, tableInfo, templateData);

            Template templateDao = ZGVelocityUtil.getTemplate(zgInfo.getSysSetting().getDaoTemplatePath());
            String contentDao = ZGVelocityUtil.mergeTemplate(templateDao, context);
            String finalContentDao = ZGBuildUtil.buildDaoClassTxt(tableInfo, zgInfo, contentDao);
            ZGMiscUtil.writeToFile(templateData.getDaoPath(), finalContentDao);

            Template templateRepository = ZGVelocityUtil.getTemplate(zgInfo.getSysSetting().getRepositoryTemplatePath());
            String contentRepository = ZGVelocityUtil.mergeTemplate(templateRepository, context);
            String finalContentRepository = ZGBuildUtil.buildRepositoryClassTxt(tableInfo, zgInfo, contentRepository);
            ZGMiscUtil.writeToFile(templateData.getRepositoryPath(), finalContentRepository);

            Template templateMapper = ZGVelocityUtil.getTemplate(zgInfo.getSysSetting().getMapperTemplatePath());
            String contentMapper = ZGVelocityUtil.mergeTemplate(templateMapper, context);
            String finalContentMapper = ZGBuildUtil.buildMapperTxt(tableInfo, zgInfo, contentMapper);
            ZGMiscUtil.writeToFile(templateData.getMapperPath(), finalContentMapper);
        }
    }
}
