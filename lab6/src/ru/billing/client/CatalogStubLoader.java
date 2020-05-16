package ru.billing.client;
import java.util.Date;

import javax.xml.catalog.CatalogException;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.itmo.CatalogLoadException;
import ru.itmo.ItemAlreadyExistsException;

public class CatalogStubLoader implements CatalogLoader {
	Category accessibility = Category.GENERAL;
	@Override
	public void load(ItemCatalog cat) throws CatalogLoadException {
		GenericItem item1 = new GenericItem("Sony TV",23000,Category.GENERAL); 
		item1.setID(0);
		//§ª§Ù§Þ§Ö§ß§Ú§ä§Ö ID, §é§ä§à§Ò§í §ã§Õ§Ö§Ý§Ñ§ä§î §Ó§à§Ù§Þ§à§Ø§ß§í§Þ §á§à§Ó§ä§à§â§Ö§ß§Ú§Ö
		FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10);
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
