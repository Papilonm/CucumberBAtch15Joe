package DBTest;

import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
           Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");

            Statement statement=conn.createStatement();
            ResultSet rset= statement.executeQuery("Select Firstname,Lastname from person");
            rset.next();

            String fName=rset.getString("FirstName");
            String lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

            rset.next();

             fName=rset.getString("FirstName");
             lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
