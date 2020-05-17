package jdbc;


import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ItemDAO {
    //C:\Users\Administrator\Documents\code\JAVA\JDBCLabs
    String filePath;
    String url;
    public PreparedStatement pst = null;
    ResultSet ret = null;
    Connection conn = null;

    public ItemDAO(String url)
    {
        this.url=url;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    List<MusicItem> searchById(Integer id)
    {
        List<MusicItem> result =new ArrayList<MusicItem>();
        try {
            assert conn != null;
            pst = conn.prepareStatement("select * from Item where ITEM_ID = "+Integer.toString(id));
            ret = pst.executeQuery();// 执行语句，得到结果集
            while (ret.next())
            {
                String ITEM_ID = ret.getString(1);
                String Title = ret.getString(2);
                String Artist = ret.getString(3);
                Date ReleaseDate = ret.getDate(4);
                String ListPrice = ret.getString(5);
                String Price = ret.getString(6);
                String Version = ret.getString(7);
                result.add(new MusicItem(ITEM_ID,Title,Artist,ReleaseDate,ListPrice,Price,Version));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return null;
    }
    List<MusicItem> searchByKeyword(String keyWord)
    {
        List<MusicItem> result =new ArrayList<MusicItem>();
        try {
            assert conn != null;
            pst = conn.prepareStatement("select * from Item where LIKE '%"+keyWord+"%'");
            ret = pst.executeQuery();
            while (ret.next())
            {
                String ITEM_ID = ret.getString(1);
                String Title = ret.getString(2);
                String Artist = ret.getString(3);
                Date ReleaseDate = ret.getDate(4);
                String ListPrice = ret.getString(5);
                String Price = ret.getString(6);
                String Version = ret.getString(7);
                result.add(new MusicItem(ITEM_ID,Title,Artist,ReleaseDate,ListPrice,Price,Version));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    void create(List<MusicItem> musicItem)
    {
        try {
            assert conn != null;
            for (MusicItem m :musicItem
                 ) {
                pst = conn.prepareStatement("INSERT INTO Item (Title,Artist,ReleaseDate,ListPrice,Price,Version) VALUES(?,?,?,?,?,?)");
                pst.setString(1,m.Title);
                pst.setString(2,m.Artist);
                pst.setDate(3,m.ReleaseDate);
                pst.setString(4,m.ListPrice);
                pst.setString(5,m.Price);
                pst.setInt(6,1);

                ret = pst.executeQuery();
            }

            int resultSet=pst.executeUpdate();
            if(resultSet>0){
                System.out.println("Success");
            }else{
                System.out.println("Fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    void close()
    {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
