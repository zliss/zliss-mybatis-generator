package net.zliss.tool.mybatis.generator.zgenerator.util;

import net.zliss.tool.mybatis.generator.zgenerator.domain.ZGConstant.ZGJdbcColKeys;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableColInfo;
import net.zliss.tool.mybatis.generator.zgenerator.model.ZGInfoModel.ZGTableInfo;
import org.apache.commons.collections4.MapUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZGDbUtil {

    public static Connection getConnection(String url, String user, String password) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static ZGTableInfo getZGTableInfo(Connection conn, String table) throws SQLException {

        Map<String, Object> jdbcTableData = new LinkedHashMap<>();
        List<ZGTableColInfo> colInfoList = new ArrayList<>();
        ZGTableColInfo primaryKeyColInfo = null;
        ZGTableColInfo primaryKeyCol = null;

        DatabaseMetaData metaData = conn.getMetaData();
        String tableName = table;

        ResultSet tableRS = metaData.getTables(null, null, tableName, new String[] {"TABLE"});

        while (tableRS.next()) {
            ResultSetMetaData tableMetaData = tableRS.getMetaData();
            int jdbcTableDataCount = tableMetaData.getColumnCount();
            for (int i = 1; i < jdbcTableDataCount; i++) {
                String columnName = tableMetaData.getColumnName(i);
                Object columnValue = tableRS.getObject(i);
                jdbcTableData.put(columnName, columnValue);
            }

            ResultSet colResultSet = metaData.getColumns(null, null, tableName, null);

            while (colResultSet.next()) {

                ZGTableColInfo colInfo = new ZGTableColInfo();
                colInfoList.add(colInfo);

                Map<String, Object> jdbcColData = new LinkedHashMap<>();
                colInfo.setJdbcColData(jdbcColData);

                ResultSetMetaData colMetaData = colResultSet.getMetaData();
                int jdbcColDataCount = colMetaData.getColumnCount();
                for (int i = 1; i < jdbcColDataCount; i++) {
                    String columnName = colMetaData.getColumnName(i);
                    Object columnValue = colResultSet.getObject(i);
                    jdbcColData.put(columnName, columnValue);
                }
            }

            ResultSet colResultSetPrimaryKeys = metaData.getPrimaryKeys(null, null, tableName);

            while (colResultSetPrimaryKeys.next()) {

                ZGTableColInfo colInfo = new ZGTableColInfo();
                primaryKeyColInfo = colInfo;

                Map<String, Object> jdbcColData = new LinkedHashMap<>();
                colInfo.setJdbcColData(jdbcColData);

                ResultSetMetaData colMetaData = colResultSetPrimaryKeys.getMetaData();
                int jdbcColDataCount = colMetaData.getColumnCount();
                for (int i = 1; i < jdbcColDataCount; i++) {
                    String columnName = colMetaData.getColumnName(i);
                    Object columnValue = colResultSetPrimaryKeys.getObject(i);
                    jdbcColData.put(columnName, columnValue);
                }
            }

            if (primaryKeyColInfo != null) {
                for (ZGTableColInfo colInfo : colInfoList) {
                    if (colInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_NAME) != null
                            && colInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_NAME).equals(
                                    primaryKeyColInfo.getJdbcColData().get(ZGJdbcColKeys.COLUMN_NAME))) {
                        primaryKeyCol = colInfo;
                        break;
                    }
                }
            }
        }

        if (MapUtils.isEmpty(jdbcTableData)) {
            throw new RuntimeException("table:"+tableName+" not found");
        }

        ZGTableInfo tableInfo = new ZGTableInfo();
        tableInfo.setTableName(tableName);
        tableInfo.setColInfoList(colInfoList);
        tableInfo.setJdbcTableData(jdbcTableData);
        tableInfo.setPrimaryKeyCol(primaryKeyCol);
        tableInfo.setPrimaryKeyColInfo(primaryKeyColInfo);
        return tableInfo;
    }
}
