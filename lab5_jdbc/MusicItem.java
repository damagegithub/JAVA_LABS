package jdbc;

import java.sql.Date;

public class MusicItem {
    String itemId;
    String title;
    String artist;
    Date releaseDate;
    String listPrice;
    String price;
    String version;

    public MusicItem(String id, String title, String artist, Date releaseDate, String listPrice, String price, String version) {
        this.itemId = id;
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.listPrice = listPrice;
        this.price = price;
        this.version = version;
    }
}
