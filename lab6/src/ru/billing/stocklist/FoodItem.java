package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome = new Date();
    private short expires;

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this(name, price, expires);
        this.dateOfIncome = date;
    }

    public FoodItem(String name, float price, short expires) {
        this(name);
        this.setPrice(price);
        this.expires = expires;
    }

    public FoodItem(String name) {
        this.setName(name);
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.printf("date of income:%s,expires:%d days \n", dateOfIncome.toString(), expires);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dateOfIncome == null) ? 0 : dateOfIncome.hashCode());
        result = prime * result + expires;
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
        FoodItem other = (FoodItem) obj;
        if (dateOfIncome == null) {
            if (other.dateOfIncome != null) {
                return false;
            }
        } else if (!dateOfIncome.equals(other.dateOfIncome)) {
            return false;
        }
        if (expires != other.expires) {
            return false;
        }
        return true;
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
