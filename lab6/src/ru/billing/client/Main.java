package ru.billing.client;
import ru.billing.stocklist.ItemCatalog;
import ru.itmo.CatalogLoadException;

public class Main {
	public static void main(String[] args) {
		 System.out.println("\n------------------------------------------------------------\nLAB6\n");
		 CatalogLoader loader = new CatalogStubLoader(); 
		 ItemCatalog ic=new ItemCatalog();
		 
			try {
				loader.load(ic);
				loader.load(ic);
				//§á§à§Ó§ä§à§â§ß§í§Û ID §Ó§í§Ù§í§Ó§Ñ§Ö§ä §Ú§ã§Ü§Ý§ð§é§Ö§ß§Ú§Ö
			} catch (CatalogLoadException e) {
				e.printStackTrace();
			}
			ic.printItems();
	}

}
