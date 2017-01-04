package menu;

import enums.Category;
import enums.Size;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje produkt
 */
public class Product implements Serializable {
    private String mName;
    private String[] mNames = {"Kebab", "Spaggetti", "Pizza Japonska", "Pizza Chinska", "Ryba po poznansku", "Sos brokulowy", "Cola", "Pepsi", "Wingornowowy sok", "Jajecznica", "Grzybowa", "Liczi", "Arbuz po finsku", "Amerykanka"};
    private double mPrice;
    private Size mSize;
    private Category mCategory;

    /**
     * Konsktuktor produktu
     *
     * @param name
     * @param price
     * @param category
     * @param size
     */
    public Product(String name, Double price, Category category, Size size) {
        mName = name;
        mPrice = price;
        mCategory = category;
        mSize = size;
    }

    /**
     * Konsktuktor produktu
     * @param name
     * @param price
     * @param category
     */
    public Product(String name, Double price, Category category) {
        mName = name;
        mPrice = price;
        mSize = Size.STANDARD;
        mCategory = category;
    }

    /**
     * Konsktuktor losowy produktu
     */
    public Product() {
        mName = mNames[(int) (Math.random() * (mNames.length - 1))];
        mPrice = Math.round(Math.random() * ((100 - 10) + 10));
        mSize = Size.values()[new Random().nextInt(Size.values().length)];
        mCategory = Category.values()[new Random().nextInt(Size.values().length)];
    }

    /**
     * Zwraca nazwe produktu
     * @return nazwa
     */
    public String getName() {
        return mName;
    }

    /**
     * Ustawia nazwe produktu
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Zwraca cene produktu
     * @return cena
     */
    public double getPrice() {
        return mPrice;
    }

    /**
     * Ustawia cene
     * @param price
     */
    public void setPrice(double price) {
        mPrice = price;
    }

    /**
     * Zwraca rozmiar produktu
     * @return enum z rozmiarem
     */
    public Size getSize() {
        return mSize;
    }

    /**
     * Ustawia rozmiar produktu
     * @param size
     */
    public void setSize(Size size) {
        mSize = size;
    }

    /**
     * Zwraca kategorie produktu
     * @return enum z kategoria
     */
    public Category getCategory() {
        return mCategory;
    }

    /**
     * Ustawia kategorie produktu
     * @param category
     */
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
