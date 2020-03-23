package ru.billing.stocklist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCatalog {
	private Map<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
	private List<GenericItem> ALCatalog = new ArrayList<GenericItem>();

	public void addItem(GenericItem item) {
		catalog.put(item.getID(),item); // Добавляем товар в HashMap
		ALCatalog.add(item); // Добавляем тот же товар в ArrayList
	}

	public void printItems() {
		for (GenericItem i : ALCatalog) {
			System.out.println(i);
		}
	}


	public Map<Integer, GenericItem> getCatalog() {
		return catalog;
	}

	public void setCatalog(Map<Integer, GenericItem> catalog) {
		this.catalog = catalog;
	}

	public List<GenericItem> getALCatalog() {
		return ALCatalog;
	}

	public void setALCatalog(List<GenericItem> aLCatalog) {
		ALCatalog = aLCatalog;
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
		for (GenericItem i : ALCatalog) {
			if (i.getID() == id)
				return i;
		}
		return null;
	}
}
