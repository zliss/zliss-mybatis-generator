package net.zliss.tool.mybatis.generator.zgenerator.domain;

import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableColInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGMethod;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableInfo;

public class ZGFunc {
    public interface DaoPathFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String pathStr);
    }
    public interface DaoPkgFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String pkgStr);
    }
    public interface DaoImportFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String importStr);
    }
    public interface DaoClassNameFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String nameStr);
    }
    public interface DaoClassFieldTypeFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String typeStr);
    }
    public interface DaoClassFieldPkgFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String pkgStr);
    }
    public interface DaoClassFieldNameFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String nameStr);
    }
    public interface DaoClassFieldRemarkFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String remarkStr);
    }
    public interface DaoClassAttrFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String attrStr);
    }
    public interface DaoClassFieldSetMethodFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String methodStr);
    }
    public interface DaoClassFieldGetMethodFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String methodStr);
    }
    public interface DaoClassTxtFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String txtStr);
    }

    public interface RepositoryPathFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String pathStr);
    }
    public interface RepositoryPkgFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String pkgStr);
    }
    public interface RepositoryImportFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String importStr);
    }
    public interface RepositoryClassNameFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String nameStr);
    }
    public interface RepositoryMethodFunc {
        String get(ZGMethod method, ZGTableInfo tableInfo, ZGInfo info, String methodStr);
    }
    public interface RepositoryClassTxtFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String txtStr);
    }

    public interface MapperPathFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String pathStr);
    }
    public interface MapperDocTypeFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String fileNameStr);
    }
    public interface MapperFieldJdbcTypeFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String jdbcTypeStr);
    }
    public interface MapperColumnFunc {
        String get(ZGTableColInfo colInfo, ZGTableInfo tableInfo, ZGInfo info, String columnStr);
    }
    public interface MapperResultMapFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String resultMapStr);
    }
    public interface MapperBaseColumnFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String baseColumnStr);
    }
    public interface MapperMethodFunc {
        String get(ZGMethod method, ZGTableInfo tableInfo, ZGInfo info, String methodStr);
    }
    public interface MapperTxtFunc {
        String get(ZGTableInfo tableInfo, ZGInfo info, String txtStr);
    }
}
