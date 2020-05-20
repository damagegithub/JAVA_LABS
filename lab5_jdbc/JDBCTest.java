package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class JDBCTest {
    public static void main(String[] args) {
        //Упражнение1-2
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = getConnection("jdbc:derby://localhost:1527/JavaTunesDB;user=db_user1;password=111111;create=true");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());
            System.out.println(dbmd.getDriverVersion());
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getUserName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
