package jdbc;

import java.util.List;

public class ItemDaoMain {
    public static void main(String[] args) {

        ItemDAO i = new ItemDAO("jdbc:derby://localhost:1527/JavaTunesDB;user=db_user1;password=111111;create=tru");

        //Упражнение1-3
        i.searchById(1);
        //Упражнение1-4
        i.searchByKeyword("of");
        i.searchByKeyword("Gay");
        List<MusicItem> musicItems=i.searchById(1);
        for (MusicItem x:musicItems
        ) {System.out.println(x.ITEM_ID + "\t" + x.Title + "\t" + x.Artist + "\t"
                + x.ReleaseDate + "\t" + x.ListPrice + "\t" + x.Price + "\t" + x.Version);

        }
        i.create(musicItems);

        i.close();


    }
}
