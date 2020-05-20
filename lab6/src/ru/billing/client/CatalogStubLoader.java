package ru.billing.client;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.itmo.CatalogLoadException;
import ru.itmo.ItemAlreadyExistsException;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {
    Category accessibility = Category.GENERAL;

    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        item1.setId(0);
        // ���٧ާ֧ߧڧ�� ID, ����ҧ� ��է֧ݧѧ�� �ӧ�٧ާ�اߧ�� ���ӧ���֧ߧڧ�
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        try {
            cat.addItem(item1);
            cat.addItem(item2);
        } catch (ItemAlreadyExistsException e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new CatalogLoadException(e);
        }
    }

}
