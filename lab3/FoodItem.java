import java.util.Date;


public class FoodItem extends GenericItem {
	public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
		this(name, price, expires);
		this.dateOfIncome = date;
	}

	public FoodItem(String name, float price, short expires) {
		this(name);
		this.price = price;
		this.expires = expires;
	}

	public FoodItem(String name) {
		this.name=name;
	}

	public Date dateOfIncome = new Date();
	public short expires;

	@Override
	void printAll() {
		super.printAll();
		System.out.printf("date of income:%s,expires:%d days \n", dateOfIncome.toString(), expires);
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
		if (!(o instanceof FoodItem))
			return false;
		FoodItem f = (FoodItem) o;
		if (this.dateOfIncome == f.dateOfIncome && this.expires == f.expires && super.equals(f)) {
			return true;
		}
		return false;
	}

	public Object clone() {
		FoodItem o = null;
		o = (FoodItem) super.clone();
		return o;
	}

	public String toString() {
		return super.toString();
	}
}