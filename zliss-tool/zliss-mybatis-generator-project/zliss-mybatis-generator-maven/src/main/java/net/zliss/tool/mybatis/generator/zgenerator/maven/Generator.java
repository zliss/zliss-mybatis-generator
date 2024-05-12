package net.zliss.tool.mybatis.generator.zgenerator.maven;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import net.zliss.tool.mybatis.generator.zgenerator.application.ZGenerator;
import net.zliss.tool.mybatis.generator.zgenerator.exception.ZGException;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGSetting;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Mojo(name = "generator")
public class Generator extends AbstractMojo {
    private final Log log = this.getLog();

    @Parameter(property = "url")
    private String url;
    @Parameter(property = "user")
    private String user;
    @Parameter(property = "password")
    private String password;
    @Parameter(property = "tables")
    private String tables;
    @Parameter(property = "projectPath")
    private String projectPath;
    @Parameter(property = "javaPath")
    private String javaPath;
    @Parameter(property = "parentPkg")
    private String parentPkg;
    @Parameter(property = "mapperDir")
    private String mapperDir;
    @Parameter(property = "entityPkg")
    private String entityPkg;
    @Parameter(property = "repositoryPkg")
    private String repositoryPkg;
    @Parameter(property = "entityPkgFull")
    private String entityPkgFull;
    @Parameter(property = "repositoryPkgFull")
    private String repositoryPkgFull;
    @Parameter(property = "entityDirPathFull")
    private String entityDirPathFull;
    @Parameter(property = "repositoryDirPathFull")
    private String repositoryDirPathFull;
    @Parameter(property = "mapperDirPathFull")
    private String mapperDirPathFull;
    @Parameter(property = "remarkFormat")
    private String remarkFormat;

    @Parameter(property = "mapperTemplatePath")
    private String mapperTemplatePath;
    @Parameter(property = "entityTemplatePath")
    private String entityTemplatePath;
    @Parameter(property = "repositoryTemplatePath")
    private String repositoryTemplatePath;
    @Parameter(property = "methods")
    private String methods;
    @Parameter(property = "entitySuffix")
    private String entitySuffix;
    @Parameter(property = "repositorySuffix")
    private String repositorySuffix;
    @Parameter(property = "mapperSuffix")
    private String mapperSuffix;

    @Parameter(property = "jdbcJavaTypeMapJson")
    private String jdbcJavaTypeMapJson;
    @Parameter(property = "jdbcTypeMapJson")
    private String jdbcTypeMapJson;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("[zliss-mybatis-generator] start");

        ZGSetting setting = new ZGSetting();
        setting.setUrl(StringUtils.isBlank(url) ? null : url);
        setting.setUser(StringUtils.isBlank(user) ? null : user);
        setting.setPassword(StringUtils.isBlank(password) ? null : password);
        setting.setTableList(StringUtils.isBlank(tables) ? null : new ArrayList<>(Arrays.asList(StringUtils.split(tables, ","))));
        setting.setProjectPath(StringUtils.isBlank(projectPath) ? null : projectPath);
        setting.setJavaPath(StringUtils.isBlank(javaPath) ? null : javaPath);
        setting.setParentPkg(StringUtils.isBlank(parentPkg) ? null : parentPkg);
        setting.setMapperDir(StringUtils.isBlank(mapperDir) ? null : mapperDir);
        setting.setEntityPkg(StringUtils.isBlank(entityPkg) ? null : entityPkg);
        setting.setRepositoryPkg(StringUtils.isBlank(repositoryPkg) ? null : repositoryPkg);
        setting.setEntityPkgFull(StringUtils.isBlank(entityPkgFull) ? null : entityPkgFull);
        setting.setRepositoryPkgFull(StringUtils.isBlank(repositoryPkgFull) ? null : repositoryPkgFull);
        setting.setEntityDirPathFull(StringUtils.isBlank(entityDirPathFull) ? null : entityDirPathFull);
        setting.setRepositoryDirPathFull(StringUtils.isBlank(repositoryDirPathFull) ? null : repositoryDirPathFull);
        setting.setMapperDirPathFull(StringUtils.isBlank(mapperDirPathFull) ? null : mapperDirPathFull);
        setting.setRemarkFormat(StringUtils.isBlank(remarkFormat) ? null : remarkFormat);
        setting.setMapperTemplatePath(StringUtils.isBlank(mapperTemplatePath) ? null : mapperTemplatePath);
        setting.setEntityTemplatePath(StringUtils.isBlank(entityTemplatePath) ? null : entityTemplatePath);
        setting.setRepositoryTemplatePath(StringUtils.isBlank(repositoryTemplatePath) ? null : repositoryTemplatePath);
        setting.setMethodStrList(StringUtils.isBlank(methods) ? null : new ArrayList<>(Arrays.asList(StringUtils.split(methods, ","))));

        setting.setEntitySuffix(StringUtils.isBlank(entitySuffix) ? null : entitySuffix);
        setting.setRepositorySuffix(StringUtils.isBlank(repositorySuffix) ? null : repositorySuffix);
        setting.setMapperSuffix(StringUtils.isBlank(mapperSuffix) ? null : mapperSuffix);
        setting.setJdbcJavaTypeMap(StringUtils.isBlank(jdbcJavaTypeMapJson) ? null : JSON.parseObject(jdbcJavaTypeMapJson, new TypeReference<Map<Integer, JdbcJavaType>>() {}));
        setting.setJdbcTypeMap(StringUtils.isBlank(jdbcTypeMapJson) ? null : JSON.parseObject(jdbcTypeMapJson, new TypeReference<Map<Integer, String>>() {}));
        ZGenerator generator = new ZGenerator(setting);

        boolean r = generator.build();

        if (!r) {
            log.info("[zliss-mybatis-generator] fail");
            for (ZGException exception : generator.getExceptionList()) {
                exception.getSourceException().printStackTrace();
            }
        } else {
            log.info("[zliss-mybatis-generator] success");
        }
    }
}
