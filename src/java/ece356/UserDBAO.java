package ece356;

import java.sql.*;

public class UserDBAO {
    public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306";
    //public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306/";
    public static final String nid = "bmsaadat";
    public static final String user = "user_" + nid;
    public static final String pwd = "user_" + nid;    
    
    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pwd);
        Statement stmt = null;
        try {
            con.createStatement();
            stmt = con.createStatement();
            stmt.execute("USE ece356db_" + nid);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return con;
    }
    
    public static DoctorData queryDoctor(String userName)
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       PreparedStatement pstmt = null;
       DoctorData ret;
       System.out.println("TESTING");
       try {
           con = getConnection();

           /* Build SQL query */
           String query = "SELECT * FROM doctorView where username = " + userName;
           
           pstmt = con.prepareStatement(query);          

           ResultSet resultSet;
           resultSet = pstmt.executeQuery();

           ret = new DoctorData();
           ret.userName = resultSet.getString("username");
           ret.firstName = resultSet.getString("first_name");
           ret.lastName = resultSet.getString("last_name");

           return ret;
       } finally {
           if (pstmt != null) {
               pstmt.close();
           }
           if (con != null) {
               con.close();
           }
       }
   }
}
