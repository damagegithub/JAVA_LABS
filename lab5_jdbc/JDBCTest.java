package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.getDriver;

public class JDBCTest {
    public static void main(String[] args) {
        //Упражнение1-2
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/JavaTunesDB;user=db_user1;password=111111";

        try {
            //найти драйвер, который понимает данный URL.
            getDriver(url);
        } catch (SQLException throwables) {
            //Подходящий драйвер не найден
            throwables.printStackTrace();
            return;
        }
        /*
        try {
            //class ClientDriver extends ClientAutoloadedDriver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        try {
            conn = getConnection(url);
            DatabaseMetaData dbmd = conn.getMetaData();
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
