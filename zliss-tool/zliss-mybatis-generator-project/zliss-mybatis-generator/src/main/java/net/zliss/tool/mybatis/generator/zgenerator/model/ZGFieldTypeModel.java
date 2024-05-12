package net.zliss.tool.mybatis.generator.zgenerator.model;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZGFieldTypeModel {

    public static class JdbcJavaTypes {
        public static final JdbcJavaType STRING = new JdbcJavaType("String", null);
        public static final JdbcJavaType BIG_DECIMAL = new JdbcJavaType("BigDecimal", "java.math.BigDecimal");
        public static final JdbcJavaType BOOLEAN = new JdbcJavaType("Boolean", null);
        public static final JdbcJavaType BYTE = new JdbcJavaType("Byte", null);
        public static final JdbcJavaType SHORT = new JdbcJavaType("Short", null);
        public static final JdbcJavaType INTEGER = new JdbcJavaType("Integer", null);
        public static final JdbcJavaType LONG = new JdbcJavaType("Long", null);
        public static final JdbcJavaType FLOAT = new JdbcJavaType("float", null);
        public static final JdbcJavaType DOUBLE = new JdbcJavaType("double", null);
        public static final JdbcJavaType BYTEARRAY = new JdbcJavaType("byte[]", null);
        public static final JdbcJavaType DATE = new JdbcJavaType("Date", "java.sql.Date");
        public static final JdbcJavaType TIME = new JdbcJavaType("Time", "java.sql.Time");
        public static final JdbcJavaType TIMESTAMP = new JdbcJavaType("Timestamp", "java.sql.Timestamp");
        public static final JdbcJavaType BLOB = new JdbcJavaType("Blob", "java.sql.Blob");
        public static final JdbcJavaType CLOB = new JdbcJavaType("Blob", "java.sql.Clob");
        public static final JdbcJavaType NCLOB = new JdbcJavaType("Blob", "java.sql.NClob");
    }

//    public static class JdbcTypeItem {
//        private JdbcType jdbcType;
//        private JdbcJavaType jdbcJavaType;
//
//        public JdbcTypeItem(JdbcType jdbcType, JdbcJavaType jdbcJavaType) {
//            this.jdbcType = jdbcType;
//            this.jdbcJavaType = jdbcJavaType;
//        }
//    }
//
//    public static class JdbcType {
//        private String name;
//        private Integer val;
//
//        public JdbcType(String name, Integer val) {
//            this.name = name;
//            this.val = val;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public Integer getVal() {
//            return val;
//        }
//    }

    public static class JdbcJavaType {
        private String type;
        private String pkg;

        public JdbcJavaType(String type, String pkg) {
            this.type = type;
            this.pkg = pkg;
        }

        public String getType() {
            return type;
        }

        public String getPkg() {
            return pkg;
        }
    }
}
