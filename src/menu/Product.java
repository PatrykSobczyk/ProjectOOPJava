package menu;

import enums.Category;
import enums.Size;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Product implements Serializable {
    private String mName;
    private String[] mNames = {"Kebab", "Spaggetti", "Pizza Japonska", "Pizza Chinska", "Ryba po poznansku", "Sos brokulowy", "Cola", "Pepsi", "Wingornowowy sok", "Jajecznica", "Grzybowa", "Liczi", "Arbuz po finsku", "Amerykanka"};
    private double mPrice;
    private Size mSize;
    private Category mCategory;

    public Product(String name, Double price, Category category, Size size) {
        mName = name;
        mPrice = price;
        mCategory = category;
        mSize = size;
    }

    public Product(String name, Double price, Category category) {
        mName = name;
        mPrice = price;
        mSize = Size.STANDARD;
        mCategory = category;
    }

    public Product() {
        mName = mNames[(int) (Math.random() * (mNames.length - 1))];
        mPrice = Math.round(Math.random() * ((100 - 10) + 10));
        mSize = Size.values()[new Random().nextInt(Size.values().length)];
        mCategory = Category.values()[new Random().nextInt(Size.values().length)];
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public Size getSize() {
        return mSize;
    }

    public void setSize(Size size) {
        mSize = size;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    @Override
    public String toString() {
        return "Name - " + this.getName() +
                ", Price - " + this.getPrice() +
                ", Size - " + this.getSize() +
                ", Category - " + this.getCategory();
    }
}
