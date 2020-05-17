package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOracle {
    public static void main (String[] args)
    {
        String url="jdbc:oracle:thin:@localhost:1521:test";	//test为数据库名称，1521为连接数据库的默认端口
        String user="db_user2";
        String password="111111";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            String sql = "select * from t_user where user_id = ?";
            pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, "root");

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("user:" + rs.getString("user_id") + "  password" + rs.getString("password"));
            }else{
                System.out.println("not info for user " + rs.getString("user_id") );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
