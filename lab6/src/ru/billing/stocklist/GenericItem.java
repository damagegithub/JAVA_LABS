package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    static int currentID = 0;
    private int id; // ID товара
    private String name; // Наименование товара
    private float price; // Цена товара
    private String placeOfProduction;
    private Category category = Category.GENERAL;

    public GenericItem() {
        this.id = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.id = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = analog.category;
    }

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = GenericItem.currentID++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setPlaceOfProduction(String placeOfProduction) {
        this.placeOfProduction = placeOfProduction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f ,Category: %s ,Made in %s\n", id, name, price, category,
                placeOfProduction);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((placeOfProduction == null) ? 0 : placeOfProduction.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GenericItem other = (GenericItem) obj;
        if (id != other.id) {
            return false;
        }
        if (category != other.category) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (placeOfProduction == null) {
            if (other.placeOfProduction != null) {
                return false;
            }
        } else if (!placeOfProduction.equals(other.placeOfProduction)) {
            return false;
        }
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        return true;
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
