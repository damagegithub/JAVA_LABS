package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {

    private short warrantyTime;

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("warrantyTime: %d \n", warrantyTime);
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + warrantyTime;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TechnicalItem other = (TechnicalItem) obj;
        if (warrantyTime != other.warrantyTime) {
            return false;
        }
        return true;
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
