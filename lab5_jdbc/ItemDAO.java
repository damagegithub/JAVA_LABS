package jdbc;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ItemDAO implements Closeable {
    String filePath;
    String url;
    PreparedStatement pst = null;
    ResultSet ret = null;
    Connection conn = null;

    public ItemDAO(String url) {
        this.url = url;
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

    List<MusicItem> searchById(Integer id) {
        List<MusicItem> result = new ArrayList<MusicItem>();
        try {
            assert conn != null;
            pst = conn.prepareStatement("select * from Item where ITEM_ID = " + Integer.toString(id));
            ret = pst.executeQuery(); // 执行语句，得到结果集
            while (ret.next()) {
                String itemId = ret.getString(1);
                String title = ret.getString(2);
                String artist = ret.getString(3);
                Date releaseDate = ret.getDate(4);
                String listPrice = ret.getString(5);
                String price = ret.getString(6);
                String version = ret.getString(7);
                result.add(new MusicItem(itemId, title, artist, releaseDate, listPrice, price, version));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    List<MusicItem> searchByKeyword(String keyWord) {
        List<MusicItem> result = new ArrayList<MusicItem>();
        try {
            assert conn != null;
            pst = conn.prepareStatement("select * from Item where LIKE '%" + keyWord + "%'");
            ret = pst.executeQuery();
            while (ret.next()) {
                String itemId = ret.getString(1);
                String title = ret.getString(2);
                String artist = ret.getString(3);
                Date releaseDate = ret.getDate(4);
                String listPrice = ret.getString(5);
                String price = ret.getString(6);
                String version = ret.getString(7);
                result.add(new MusicItem(itemId, title, artist, releaseDate, listPrice, price, version));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    void create(List<MusicItem> musicItem) {
        try {
            assert conn != null;
            for (MusicItem m : musicItem
            ) {
                pst = conn.prepareStatement("INSERT INTO Item (Title,Artist,ReleaseDate,ListPrice,Price,Version) VALUES(?,?,?,?,?,?)");
                pst.setString(1, m.title);
                pst.setString(2, m.artist);
                pst.setDate(3, m.releaseDate);
                pst.setString(4, m.listPrice);
                pst.setString(5, m.price);
                pst.setInt(6, 1);

                ret = pst.executeQuery();
            }

            int resultSet = pst.executeUpdate();
            if (resultSet > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void close(AutoCloseable closeable) {
        //Class "PreparedStatement" "ResultSet" "Connection" they all "extends AutoCloseable"
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        //использовать private методы
        close(pst);
        close(ret);
        close(conn);
    }
}
