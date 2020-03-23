public class TechnicalItem extends GenericItem {

	public short warrantyTime;

	@Override
	void printAll() {
		super.printAll();
		System.out.printf("warrantyTime: %d \n", warrantyTime);
	}

	public int hashCode() {
		int hash = 17;
		hash += this.name.hashCode();
		hash = hash * 31 + this.ID;
		hash = hash * 31 + this.warrantyTime;
		hash += (hash << 10);
		hash ^= (hash >> 6);
		return hash;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof TechnicalItem))
			return false;
		TechnicalItem t = (TechnicalItem) o;
		if (this.warrantyTime == t.warrantyTime && super.equals(t)) {
			return true;
		}
		return false;

	}

	public Object clone() {
		TechnicalItem o = null;
		o = (TechnicalItem) super.clone();
		o.warrantyTime = this.warrantyTime;
		return o;
	}

	public String toString() {
		return super.toString();
	}
}