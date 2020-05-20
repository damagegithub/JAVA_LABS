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
        List<MusicItem> musicItems = i.searchById(1);
        for (MusicItem x : musicItems
        ) {
            System.out.println(x.itemId + "\t" + x.title + "\t" + x.artist + "\t"
                    + x.releaseDate + "\t" + x.listPrice + "\t" + x.price + "\t" + x.version);

        }
        i.create(musicItems);

        i.close();


    }
}
