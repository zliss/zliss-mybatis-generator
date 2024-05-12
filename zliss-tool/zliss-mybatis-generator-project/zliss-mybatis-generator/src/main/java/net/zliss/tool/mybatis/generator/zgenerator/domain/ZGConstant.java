package net.zliss.tool.mybatis.generator.zgenerator.domain;

import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGMethodItem;

public class ZGConstant {
    public static class ZGPackages {
        public static final String JAVA_UTIL_LIST = "java.util.List";
        public static final String ORG_APACHE_IBATIS_ANNOTATIONS_PARAM = "org.apache.ibatis.annotations.Param";
        public static final String ORG_SPRINGFRAMEWORK_STEREOTYPE_REPOSITORY = "org.springframework.stereotype.Repository";
        public static final String ORG_SPRINGFRAMEWORK_DATA_DOMAIN_PAGEABLE = "org.springframework.data.domain.Pageable";

        private ZGPackages() {}
    }
    public static class ZGJdbcColKeys {
        public static final String TABLE_CAT = "TABLE_CAT";
        public static final String TABLE_NAME = "TABLE_NAME";
        public static final String COLUMN_NAME = "COLUMN_NAME";
        public static final String DATA_TYPE = "DATA_TYPE";
        public static final String TYPE_NAME = "TYPE_NAME";
        public static final String COLUMN_SIZE = "COLUMN_SIZE";
        public static final String BUFFER_LENGTH = "BUFFER_LENGTH";
        public static final String DECIMAL_DIGITS = "DECIMAL_DIGITS";
        public static final String NUM_PREC_RADIX = "NUM_PREC_RADIX";
        public static final String NULLABLE = "NULLABLE";
        public static final String REMARKS = "REMARKS";
        public static final String COLUMN_DEF = "COLUMN_DEF";
        public static final String SQL_DATA_TYPE = "SQL_DATA_TYPE";
        public static final String SQL_DATETIME_SUB = "SQL_DATETIME_SUB";
        public static final String ORDINAL_POSITION = "ORDINAL_POSITION";
        public static final String IS_NULLABLE = "IS_NULLABLE";
        public static final String IS_AUTOINCREMENT = "IS_AUTOINCREMENT";

        private ZGJdbcColKeys() {}
    }

    public static class ZGJdbcTableKeys {
        public static final String TABLE_CAT = "TABLE_CAT";
        public static final String TABLE_NAME = "TABLE_NAME";
        public static final String TABLE_TYPE = "TABLE_TYPE";
        public static final String REMARKS = "REMARKS";

        private ZGJdbcTableKeys() {}
    }

    public static class ZGMethods {
        public static final ZGMethodItem SELECT_BY_PRIMARY_KEY = new ZGMethodItem("selectByPrimaryKey");
        public static final ZGMethodItem INSERT = new ZGMethodItem("insert");
//        public static final ZGMethodItem INSERT_SELECTIVE = new ZGMethodItem("insertSelective");
        public static final ZGMethodItem UPDATE_BY_PRIMARY_KEY = new ZGMethodItem("updateByPrimaryKey");
//        public static final ZGMethodItem UPDATE_BY_PRIMARY_KEY_SELECTIVE = new ZGMethodItem("updateByPrimaryKeySelective");
        public static final ZGMethodItem DELETE_BY_PRIMARY_KEY = new ZGMethodItem("deleteByPrimaryKey");
        public static final ZGMethodItem SELECT_COUNT = new ZGMethodItem("selectCount");
        public static final ZGMethodItem SELECT_PAGE = new ZGMethodItem("selectPage");

        private ZGMethods() {}
    }
}
