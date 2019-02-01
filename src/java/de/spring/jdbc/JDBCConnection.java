package de.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public static void main (String[] args) {

        String name = "root";
        String pass = "root";
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {

            System.out.println("Connecting to database: " + jdbcURL);
            Connection myConn = DriverManager.getConnection(jdbcURL, name, pass);
            System.out.println("Connection online = " + !myConn.isClosed());
            myConn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
