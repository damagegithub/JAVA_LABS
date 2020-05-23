package ru.billing.client;

import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;
import ru.itmo.CatalogLoadException;
import ru.itmo.ItemAlreadyExistsException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class CatalogFileLoader implements CatalogLoader {
    private String fileName;

    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        File f = new File(fileName);
        FileInputStream fis = null;
        String line;
        Scanner scanner = null;
        try {
            fis = new FileInputStream(f);
            scanner = new Scanner(fis);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    break;
                }
                String[] itemFld = line.split(";");
                String name = itemFld[0];
                float price = Float.parseFloat(itemFld[1]);
                short expires = Short.parseShort(itemFld[2]);
                FoodItem item = new FoodItem(name, price, null, new Date(), expires);
                cat.addItem(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
