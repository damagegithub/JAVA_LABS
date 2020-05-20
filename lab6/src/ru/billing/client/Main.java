package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;
import ru.itmo.CatalogLoadException;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n------------------------------------------------------------\nLAB6\n");
        CatalogLoader loader = new CatalogStubLoader();
        ItemCatalog ic = new ItemCatalog();

        try {
            loader.load(ic);
            loader.load(ic);
            // Исключение
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }
        ic.printItems();
    }
}
