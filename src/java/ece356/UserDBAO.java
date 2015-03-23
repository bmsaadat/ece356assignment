package ece356; 

import java.sql.*;
import java.util.*;
import java.security.SecureRandom; 
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.codec.binary.BaseNCodec; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class UserDBAO {

    public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306";
    //public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306/";
    public static final String nid = "bmsaadat";
    public static final String user = "user_" + nid;
    public static final String pwd = "user_" + nid;

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException, NamingException {
        InitialContext cxt = new InitialContext(); 
        if (cxt == null) {
            throw new RuntimeException("Unable to create naming context!");
        }
        Context dbContext = (Context) cxt.lookup("java:comp/env"); 
        DataSource ds = (DataSource) dbContext.lookup("jdbc/myDatasource");
        if (ds == null) {
        throw new RuntimeException("Data source not found!");
        }
        Connection con = ds.getConnection();
        
        
        
        /*Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pwd);*/
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
    
   private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
    }
   
    public static void syncSampleData() 
       throws ClassNotFoundException, SQLException, NamingException 
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        DoctorData ret;
        try 
        {
            con = getConnection();          
            pstmt = con.prepareStatement("INSERT INTO userType (userType) VALUES ('doctor');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO userType (userType) VALUES ('patient');");
            pstmt.executeUpdate();

            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('surgeon');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('family');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('cardiologist');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('eye');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('brain');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO specializationType (specTypeName) VALUES ('ENT');");
            pstmt.executeUpdate();
            
            String salt = generateSalt(); 
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('bmsaadat', '"+salt+"', SHA2(CONCAT('"+salt+"', 'password123'), 256), 'Behroz', 'M', 'Saadat', 'behrozsaadat@gmail.com', 1);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctor VALUES ('bmsaadat', 2012, 'male');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('bmsaadat', 5);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('bmsaadat', 4);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('bmsaadat', 3);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO workAddress VALUES (1, 'Glenora Dr', 1329, NULL, 'London', 'Ontario', 'N5X1T6', 'bmsaadat');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO workAddress VALUES (4, 'Glengarry', 123, NULL, 'Sarnia', 'Ontario', 'B6G3D2', 'bmsaadat');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO workAddress VALUES (5, 'Adelaide', 1, NULL, 'London', 'Ontario', 'H6G3D2', 'bmsaadat');");
            pstmt.executeUpdate();
            
            salt = generateSalt(); 
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('sabash', '"+salt+"', SHA2(CONCAT('"+salt+"', 'weakPassword'), 256), 'Sabashan', '', 'Ragavan', 'sabes@gmail.com', 1);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctor VALUES ('sabash', 1993, 'male');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('sabash', 1);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('sabash', 4);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO workAddress VALUES (2, 'Lester St.', 231, NULL, 'Waterloo', 'Ontario', 'N6Y1T2', 'sabash');");
            pstmt.executeUpdate();
            
            salt = generateSalt(); 
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('abishek', '"+salt+"', SHA2(CONCAT('"+salt+"', 'weakPassword123'), 256), 'Abishek', '', 'Sisodia', 'abishek@gmail.com', 1);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctor VALUES ('abishek', 2000, 'male');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO doctorSpecialization VALUES ('abishek', 6);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO workAddress VALUES (3, 'Bay St.', 1329, 8, 'Toronto', 'Ontario', 'Y6T6K4', 'abishek');");
            pstmt.executeUpdate();
            
            salt = generateSalt(); 
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('bmsaadat_patient', '"+salt+"', SHA2(CONCAT('"+salt+"', 'weakPassword123'), 256), 'Behroz', 'M', 'Saadat', 'bms_300@gmail.com', 2);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO patient VALUES ('bmsaadat_patient', 'London', 'Ontario');");
            pstmt.executeUpdate(); 

            salt = generateSalt(); 
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('sabash_patient', '"+salt+"', SHA2(CONCAT('"+salt+"', 'password123'), 256), 'Sabashan', '', 'Ragavan', 'sabes_patient@gmail.com', 2);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO patient VALUES ('sabash_patient', 'Waterloo', 'Ontario');");
            pstmt.executeUpdate();
            
            salt = generateSalt();             
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('abishek_patient', '"+salt+"', SHA2(CONCAT('"+salt+"', 'password123'), 256), 'Abishek', '', 'Sisodia', 'abishek_patient@gmail.com', 2);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO patient VALUES ('abishek_patient', 'Edmonton', 'Alberta');");
            pstmt.executeUpdate(); 
            
            salt = generateSalt();
            pstmt = con.prepareStatement("INSERT INTO user VALUES ('john', '"+salt+"', SHA2(CONCAT('"+salt+"', 'password123'), 256), 'John', '', 'Doe', 'john@gmail.com', 2);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO patient VALUES ('john', 'Toronto', 'Ontario');");
            pstmt.executeUpdate();
            
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('bmsaadat_patient', 'sabash_patient', 0);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('bmsaadat_patient', 'abishek_patient', 0);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('sabash_patient', 'abishek_patient', 1);");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('bmsaadat_patient', 'john', 1);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('john', 'sabash_patient', 1);");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO friend VALUES ('abishek_patient', 'john', 1);");
            pstmt.executeUpdate();             

            pstmt = con.prepareStatement("INSERT INTO review VALUES (1, 'bmsaadat', 'bmsaadat_patient', '2014-11-01 12:45:34', 3, 'Great Doctor!!!! He did everything for me properly... bleh bleh');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO review VALUES (2, 'bmsaadat', 'bmsaadat_patient', '2014-11-02 12:45:34', 2, 'My second visit was not too great...');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (3, 'bmsaadat', 'bmsaadat_patient', '2014-11-03 12:45:34', 1, 'My third visit was horrendous!');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO review VALUES (4, 'bmsaadat', 'abishek_patient', '2014-11-04 12:45:34', 5, 'Good job doctor');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (5, 'bmsaadat', 'sabash_patient', '2014-11-05 12:45:34', 4, 'Good job doctor behroz!!');");
            pstmt.executeUpdate();     

            pstmt = con.prepareStatement("INSERT INTO review VALUES (6, 'sabash', 'bmsaadat_patient', '2014-11-06 12:45:34', 5, 'Great Doctor!!!! He did everything for me properly... bleh bleh');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (7, 'sabash', 'sabash_patient', '2014-11-07 12:45:34', 4, 'YES good JOB');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO review VALUES (8, 'sabash', 'abishek_patient', '2014-11-08 12:45:34', 5, 'My stomach hurts');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (9, 'sabash', 'sabash_patient', '2014-11-09 12:45:34', 3, 'YEAH BUDDY');");
            pstmt.executeUpdate();  

            pstmt = con.prepareStatement("INSERT INTO review VALUES (10, 'abishek', 'sabash_patient', '2014-11-01 12:45:34', 1, 'BAD DOCTOR');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (11, 'abishek', 'bmsaadat_patient', '2014-11-02 12:45:34', 1, 'BAD DOCTOR !!!');");
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO review VALUES (12, 'abishek', 'abishek_patient', '2014-11-03 12:45:34', 1, 'BAD DOCTOR BAD BAD!!');");
            pstmt.executeUpdate(); 
            pstmt = con.prepareStatement("INSERT INTO review VALUES (13, 'abishek', 'abishek_patient', '2014-11-04 12:45:34', 1, 'BAD DOCTOR A!!!');");
            pstmt.executeUpdate();         
        } 
        finally 
        {
            if (pstmt != null) 
            {
               pstmt.close();
            }
            if (con != null) 
            {
                con.close();
            }
       }
    }
    
    public static String getSalt(String username)
             throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        UserData ret;
        try 
        {
            con = getConnection();
            String query = "select COUNT(*)as numRecords, password_salt from user INNER JOIN userType ON user.userTypeID = userType.userTypeID where user.username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet resultSet;
            resultSet = pstmt.executeQuery();
            resultSet.next();
            
            if(resultSet.getInt("numRecords") > 0)
            {
                return resultSet.getString("password_salt"); 
            }
            else
                return null; 
        } 
        catch (Exception e) 
        {
            System.out.println("EXCEPTION:%% " + e);
        } 
        finally 
        {
            if (pstmt != null) 
            {
                pstmt.close();
            }
            if (con != null) 
            {
                con.close();
            }
        }
        return null;
    }
    
    public static UserData queryUser(String username, String password, String salt)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        UserData ret;
        try 
        {
           
            con = getConnection();
            String query = "select COUNT(*) as numRecords, username, first_name, middle_initial, last_name, email_address, userType from user INNER JOIN userType ON user.userTypeID = userType.userTypeID where user.username = ? and user.password_hash = SHA2(CONCAT('"+salt+"', '"+password+"'), 256)";
            
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet resultSet;
            resultSet = pstmt.executeQuery();
            resultSet.next();
            ret = new UserData();
                        
            if(resultSet.first()) {
                ret.userName = resultSet.getString("username");
                ret.firstName = resultSet.getString("first_name");
                ret.lastName = resultSet.getString("last_name");
                ret.middleInitial = resultSet.getString("middle_initial");
                ret.emailAddress = resultSet.getString("email_address");
                ret.userType = resultSet.getString("userType");
            }
            else
            {
                ret = null; 
            }
            return ret;
        } 
        catch (Exception e) 
        {
            System.out.println("EXCEPTION:%% " + e);
        } 
        finally 
        {
            if (pstmt != null) 
            {
                pstmt.close();
            }
            if (con != null) 
            {
                con.close();
            }
        }
        return null;
    }

    public static void writeReview(ReviewData review)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement("INSERT INTO review (doc_username, patient_username, date, rating, comment) VALUES (?, ?, NOW(), ?, ?);");
            pstmt.setString(1, review.getDoctorUsername());
            pstmt.setString(2, review.getPatientUsername());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getComment());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static FriendShipStatus addFriend(String friendA, String friendB)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();            
            // First check if sender has already sent a request to receiver in the past
                // If he has, then check if it's accepted
                    // If it is accepted, then return ALREADY_FRIENDS
                    // If it is not accepted, then return WAITING_FOR_ACCEPT
                // If he hasn't then check if the receiver has sent a request to sender in the past
                    // If he hasn't, then make an INSERT and return REQUEST_SENT
                    // If he has, then check if it's accepted
                        // If it's not accepted, then UPDATE and make isAccepted = true and return FRIENDSHIP_ESTABLISHED                            
                        // If it is accepted, then return ALREADY_FRIENDS                        
            
            // Find if this request is already there
            String query = "SELECT * FROM friend where sent_username = ? AND recieved_username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, friendA);
            pstmt.setString(2, friendB);

            ResultSet resultSet;
            resultSet = pstmt.executeQuery();
            resultSet.next();
            
            if(resultSet.first()) {
                System.out.println("RESULT SET: " + resultSet.getString("sent_username") + " " + resultSet.getString("recieved_username"));
                boolean isAccepted = resultSet.getBoolean("isAccepted");
                if (isAccepted) {
                    return FriendShipStatus.ALREADY_FRIENDS;
                } else {
                    return FriendShipStatus.WAITING_FOR_ACCEPT;
                }                
            } else {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, friendB);
                pstmt.setString(2, friendA);
                resultSet = pstmt.executeQuery();
                resultSet.next();
                if(resultSet.first()) {
                System.out.println("RESULT SET: " + resultSet.getString("sent_username") + " " + resultSet.getString("recieved_username"));
                    boolean isAccepted = resultSet.getBoolean("isAccepted");
                    if (isAccepted) {
                        return FriendShipStatus.ALREADY_FRIENDS;
                    } else {
                        String update = "UPDATE friend SET isAccepted = ? where sent_username = ? AND recieved_username = ?;";
                        pstmt = con.prepareStatement(update);
                        pstmt.setBoolean(1, true);
                        pstmt.setString(2, friendB);
                        pstmt.setString(3, friendA);
                        pstmt.executeUpdate();
                        return FriendShipStatus.FRIENDSHIP_ESTABLISHED;
                    }
                } else {
                    pstmt = con.prepareStatement("INSERT INTO friend (sent_username, recieved_username) VALUES (?, ?);");
                    pstmt.setString(1, friendA);
                    pstmt.setString(2, friendB);
                    pstmt.executeUpdate();
                    return FriendShipStatus.REQUEST_SENT;
                }               
            }           
        } 
        finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static DoctorData queryDoctor(String userName)
        throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        DoctorData ret;
        try {
            con = getConnection();

            // Query for general doctor information
            String query = "SELECT * FROM doctorView where username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);

            ResultSet resultSet;
            resultSet = pstmt.executeQuery();
            resultSet.next();
            ret = new DoctorData();
            ret.userName = resultSet.getString("username");
            ret.firstName = resultSet.getString("first_name");
            ret.lastName = resultSet.getString("last_name");
            ret.middleInitial = resultSet.getString("middle_initial");
            ret.gender = resultSet.getString("gender");
            ret.emailAddress = resultSet.getString("email_address");
            ret.yearsLicensed = resultSet.getInt("yearsLicensed");
            ret.averageRating = resultSet.getInt("averageRating");
            ret.numberOfReviews = resultSet.getInt("numberOfReviews");

            // Query for work addresses of doctor
            query = "SELECT * FROM doctorWorkAddressView where doc_address_username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<WorkAddressData> workAddressList = new ArrayList<WorkAddressData>();
            ret.workAddressList = workAddressList;
            while (resultSet.next()) {
                WorkAddressData workAddress = new WorkAddressData();
                workAddress.city = resultSet.getString("city");
                workAddress.state = resultSet.getString("state");
                workAddress.postalCode = resultSet.getString("postal_code");
                workAddress.streetName = resultSet.getString("street_name");
                workAddress.streetNumber = resultSet.getInt("street_number");
                workAddress.unitNumber = resultSet.getString("street_unit_number");
                workAddressList.add(workAddress);
            }

            // Query for specializations of doctor
            query = "SELECT * FROM doctorSpecializationView where doc_spec_username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<String> specializationList = new ArrayList<String>();
            ret.specializationList = specializationList;
            while (resultSet.next()) {
                String specialization = resultSet.getString("specTypeName");
                specializationList.add(specialization);
            }

            // Query for reviews of doctor
            query = "SELECT * FROM review where doc_username = ? order by date desc";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<ReviewData> reviewList = new ArrayList<ReviewData>();
            ret.reviewList = reviewList;
            while (resultSet.next()) {
                ReviewData review = new ReviewData();
                review.comment = resultSet.getString("comment");
                review.reviewId = resultSet.getString("reviewId");
                review.doctorUsername = resultSet.getString("doc_username");
                review.patientUsername = resultSet.getString("patient_username");
                review.date = resultSet.getDate("date");
                review.rating = resultSet.getInt("rating");
                reviewList.add(review);
            }

            return ret;
        } catch (Exception e) {
            System.out.println("EXCEPTION:%% " + e);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
   public static ArrayList<DoctorData> queryDoctor(HashMap<String, String> doctorParam, String user) 
        throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ArrayList<DoctorData> ret;
        try { 
            con = getConnection();
            String query; 
            if(doctorParam.containsKey("reviewByFriends") && doctorParam.get("reviewByFriends").equals("yes"))
            {
                query = "select * from " +
                            "(select recieved_username as username from friend where sent_username = '"+user+"' AND isAccepted = true " +
                            "union " +
                            "select sent_username as username from friend where recieved_username = '"+user+"' AND isAccepted = true ) " +
                            "as friends inner join doctorSearchView on doctorSearchView.patient_username = friends.username "
                            ;
                   // pstmt = con.prepareStatement(query);
            }
            else
            {
                query = "SELECT * FROM doctorSearchView "
                    ;
                    //pstmt = con.prepareStatement(query);

            }
            // Query for general doctor information
            ArrayList<String> keys = new ArrayList<String>(doctorParam.keySet()); 
            ArrayList<String> values = new ArrayList<String>(doctorParam.values()); 

            HashMap<Integer, Integer> h1 = new HashMap<>();
            int counter=0; 
            if (!keys.isEmpty()) 
            {
                counter++; 
                query = query + " where";
                for (String key : keys) 
                {
                    if(!key.equals("averageRating") && !key.equals("yearsLicensed"))
                    {
                        query = query + " " + key + " LIKE ?";
                        query += " AND";
                    }
                    else
                    {
                        query = query + " " + key + " >= ?";
                        query += " AND";   
                        h1.put(counter, counter); 
                    }
                    counter++;
                }
                query = query.substring(0, query.length()-4);
                System.out.println(query);
            }
            
            query += " group by first_name, last_name, gender, averageRating, numberOfReviews";

            pstmt = con.prepareStatement(query);
            
            if (!values.isEmpty()) {
                counter = 1;
                for(String value : values) 
                {
                    if(!h1.containsKey(counter))
                    {
                        pstmt.setString(counter, "%" + value + "%");
                    }
                    else
                    {
                        pstmt.setString(counter, value);
                    }
                    counter++;
                }
            }
            System.out.println(pstmt);
            ResultSet resultSet;
            resultSet = pstmt.executeQuery();           

            ret = new ArrayList();

            while (resultSet.next()) {
                 DoctorData doctor = new DoctorData();
                 doctor.firstName = resultSet.getString("first_name");
                 doctor.middleInitial = resultSet.getString("middle_initial");
                 doctor.lastName = resultSet.getString("last_name");
                 doctor.gender = resultSet.getString("gender");
                 doctor.averageRating = resultSet.getInt("averageRating");
                 doctor.numberOfReviews = resultSet.getInt("numberOfReviews");
                 ret.add(doctor);
             }
             return ret;
        } 
        catch (Exception e) 
        {
            System.out.println("EXCEPTION:%% " + e);
        } 
        finally 
        {
            if (pstmt != null) 
            {
                pstmt.close();
            }
            if (con != null) 
            {
                con.close();
            }
        }
        return null;
    }
            /*resultSet.next();
            ret = new DoctorData();
            ret.userName = resultSet.getString("username");
            ret.firstName = resultSet.getString("first_name");
            ret.lastName = resultSet.getString("last_name");
            ret.middleInitial = resultSet.getString("middle_initial");
            ret.gender = resultSet.getString("gender");
            ret.emailAddress = resultSet.getString("email_address");
            ret.yearsLicensed = resultSet.getInt("yearsLicensed");
            ret.averageRating = resultSet.getInt("averageRating");
            ret.numberOfReviews = resultSet.getInt("numberOfReviews");

            // Query for work addresses of doctor
            query = "SELECT * FROM doctorWorkAddressView where doc_address_username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<WorkAddressData> workAddressList = new ArrayList<WorkAddressData>();
            ret.workAddressList = workAddressList;
            while (resultSet.next()) {
                WorkAddressData workAddress = new WorkAddressData();
                workAddress.city = resultSet.getString("city");
                workAddress.state = resultSet.getString("state");
                workAddress.postalCode = resultSet.getString("postal_code");
                workAddress.streetName = resultSet.getString("street_name");
                workAddress.streetNumber = resultSet.getInt("street_number");
                workAddress.unitNumber = resultSet.getString("street_unit_number");
                workAddressList.add(workAddress);
            }

            // Query for specializations of doctor
            query = "SELECT * FROM doctorSpecializationView where doc_spec_username = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<String> specializationList = new ArrayList<String>();
            ret.specializationList = specializationList;
            while (resultSet.next()) {
                String specialization = resultSet.getString("specTypeName");
                specializationList.add(specialization);
            }

            // Query for reviews of doctor
            query = "SELECT * FROM review where doc_username = ? order by date desc";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            resultSet = pstmt.executeQuery();

            ArrayList<ReviewData> reviewList = new ArrayList<ReviewData>();
            ret.reviewList = reviewList;
            while (resultSet.next()) {
                ReviewData review = new ReviewData();
                review.comment = resultSet.getString("comment");
                review.reviewId = resultSet.getString("reviewId");
                review.doctorUsername = resultSet.getString("doc_username");
                review.patientUsername = resultSet.getString("patient_username");
                review.date = resultSet.getDate("date");
                review.rating = resultSet.getInt("rating");
                reviewList.add(review);
            }

            return ret;*/
   
    public static ArrayList<PatientData> queryPatients(String username, String state, String city)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ArrayList<PatientData> ret;
        try {
            con = getConnection();
            
            ArrayList<String> keys = new ArrayList();
            ArrayList<String> values = new ArrayList();
            if (username != null && username != "") {
                keys.add("patient_username");
                values.add(username);
            }
            
            if (state != null && state != "") {
                keys.add("home_address_state");
                values.add(state);
            }
            
            if (city != null && city != "") {
                keys.add("home_address_city");
                values.add(city);
            }
            

            // Query for general doctor information
            String query = "SELECT * FROM patientSearchView";
            if (!keys.isEmpty()) {
                query = query + " where";
                for (String key : keys) {
                    query = query + " " + key + " LIKE ?";
                    query += " AND";
                }
                query = query.substring(0, query.length()-4);
                System.out.println(query);
            }
            pstmt = con.prepareStatement(query);
            
            if (!values.isEmpty()) {
                int count = 1;
                for(String value : values) {
                    pstmt.setString(count, "%" + value + "%");
                    count++;
                }
            }

            ResultSet resultSet;
            resultSet = pstmt.executeQuery();           

            ret = new ArrayList();

            while (resultSet.next()) {
                PatientData patient = new PatientData();
                patient.userName = resultSet.getString("patient_username");
                patient.city = resultSet.getString("home_address_city");
                patient.state = resultSet.getString("home_address_state");
                patient.numberOfReviews = resultSet.getInt("numberOfReviews");
                patient.lastReviewDate = resultSet.getTimestamp("lastReviewDate");
                ret.add(patient);
            }

            return ret;
        } catch (Exception e) {
            System.out.println("EXCEPTION:%% " + e);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public static ArrayList<UserData> queryFriendRequests(String userName)
        throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();

            // Query for general doctor information
            String query = "select friend.sent_username, friend.recieved_username, user.email_address from friend " +
            "inner join user on friend.sent_username = user.username where friend.isAccepted = 0 " +
            "AND friend.recieved_username = ?;";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);

            ResultSet resultSet;
            resultSet = pstmt.executeQuery();
            
            ArrayList<UserData> patientViewRequestList = new ArrayList<UserData>();
            while (resultSet.next()) {
                UserData user = new UserData();
                user.userName = resultSet.getString("sent_username");
                user.emailAddress = resultSet.getString("email_address");
                patientViewRequestList.add(user);
            }
            return patientViewRequestList;
        } catch (Exception e) {
            System.out.println("EXCEPTION:%% " + e);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserData loggedInUser = (UserData) session.getAttribute("userData");
        return loggedInUser != null;        
    }
}
