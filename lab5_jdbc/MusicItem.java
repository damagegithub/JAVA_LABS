package jdbc;

import java.sql.Date;

public class MusicItem {
    String ITEM_ID ;
    String Title ;
    String Artist ;
    Date ReleaseDate ;
    String ListPrice ;
    String Price  ;
    String Version ;
    public MusicItem(String id,String Title, String Artist , Date ReleaseDate ,String  ListPrice , String Price  , String Version )
    {
        this.ITEM_ID=id;
        this.Title=Title;
        this.Artist=Artist;
        this.ReleaseDate=ReleaseDate;
        this.ListPrice=ListPrice;
        this.Price=Price;
        this.Version=Version;
    }
}
