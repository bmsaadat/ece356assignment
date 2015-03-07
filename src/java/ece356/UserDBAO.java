package ece356;

import java.sql.*;

public class UserDBAO {
    public static final String url = "jdbc:mysql://snorkel.uwaterloo.ca:3306";
    //public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306/";
    public static final String user = "1user_ece356_test";
    public static final String pwd = "user_ece356_test";
    
    public static void testConnection()
            throws ClassNotFoundException, SQLException {
        Statement stmt;
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pwd);
        stmt = con.createStatement();
        con.close();
    }
}
