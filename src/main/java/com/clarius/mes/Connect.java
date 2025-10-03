package com.clarius.mes;

import java.sql.*;

public class Connect {
    public static void main(String[] args) {
/* 
        String url = "jdbc:oracle:thin:@localhost:1521/mes";
        String user = "admin";
        String password = "sunderland";


String url = "jdbc:oracle:thin:@//localhost:1521/XE";
String user = "system";
String password = "oracle";


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Oracle!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

        try ( Connection conn = OracleConnector.getConnection("admin", "sunderland") ){
            System.out.println("Connected to Oracle!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
