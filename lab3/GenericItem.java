
public class GenericItem implements Cloneable {

	public int ID;// ID товара
	public String name;// Наименование товара
	public float price;// Цена товара
	public String placeOfProduction;
	public Category category = Category.GENERAL;
	static int currentID=0;

	public GenericItem() {
		this.ID = GenericItem.currentID++;
	}

	public GenericItem(String name, float price, GenericItem analog) {
		this.name = name;
		this.price = price;
		this.category = analog.category;
		this.ID = GenericItem.currentID++;

	}

	public GenericItem(String name, float price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.ID = GenericItem.currentID++;
	}

	void printAll() {
		System.out.printf("ID: %d , Name: %-20s , price:%5.2f ,Category: %s ,Made in %s\n", ID, name, price, category,
				placeOfProduction);
	}

	public int hashCode() {
		int hash = 17;
		hash += this.name.hashCode();
		hash = hash * 31 + this.ID;
		hash += (hash << 10);
		hash ^= (hash >> 6);
		return hash;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof GenericItem))
			return false;
		GenericItem g = (GenericItem) o;
		if (this.ID == g.ID && this.price == g.price && this.name == g.name
				&& this.placeOfProduction == g.placeOfProduction && this.category == g.category) {
			return true;
		}
		return false;
	}

	public Object clone() {
		GenericItem o = null;
		try {
			o = (GenericItem) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public String toString() {
		return super.toString();
	}
}
