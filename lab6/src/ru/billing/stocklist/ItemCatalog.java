package ru.billing.stocklist;

import ru.itmo.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCatalog {
    private Map<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private List<GenericItem> alCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        Integer id = item.getId();
        // lab6
        if (!catalog.containsKey(id)) {
            catalog.put(item.getId(), item); // HashMap
            alCatalog.add(item); // ArrayList
        } else {
            throw new ItemAlreadyExistsException(item.getName() + " already existed");
        }

    }

    public void printItems() {
        for (GenericItem i : alCatalog) {
            System.out.println(i);
        }
    }

    public Map<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    public void setCatalog(Map<Integer, GenericItem> catalog) {
        this.catalog = catalog;
    }

    public List<GenericItem> getAlCatalog() {
        return alCatalog;
    }

    public void setAlCatalog(List<GenericItem> alCatalog) {
        this.alCatalog = alCatalog;
    }

    public GenericItem findItemByID(int id) {
        // Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : alCatalog) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }
}
