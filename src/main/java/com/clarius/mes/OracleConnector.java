package com.clarius.mes;

import java.sql.*;

public class OracleConnector {
    public static Connection getConnection(String username, String password) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@oracle-xe:1521:XEPDB1";
        //String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        return DriverManager.getConnection(url, username, password);
    }
}
