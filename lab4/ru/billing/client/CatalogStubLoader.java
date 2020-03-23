package ru.billing.client;
import java.util.Date;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

public class CatalogStubLoader implements CatalogLoader {
	Category accessibility = Category.GENERAL;
	@Override
	public void load(ItemCatalog cat) {
		GenericItem item1 = new GenericItem("Sony TV",23000,Category.GENERAL); 
		FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10); 
		cat.addItem(item1); 
		cat.addItem(item2);
	}

}
