package menu;

import main.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje zestaw obiadowy
 */
public class DinnerSet implements Serializable {
    private String mName;
    private String[] mNames = {"Obiad szefa", "Obiad tesciowej", "Obiad ziecia", "Obiad rumowy", "Obiad zloty", "Obiad babci", "Obiad dziaka", "Obiad studenta", "Obiad niejadka", "Obiad polaka", "Obiad inzyniera", "Obiad kulawegokucharza", "Obiad kucharki"};
    private List<Product> mDinnerSet = new ArrayList<>();
    private double mDiscount;

    /**
     * Konstruktor losujacy zastawy obiadowej
     */

    public DinnerSet() {
        if (Main.getRestaurantMenu().size() > 0) {
            mName = mNames[(int) (Math.random() * (mNames.length - 1))];
            int count = new Random().nextInt(7) + 1;
            for (int i = 0; i < count; i++) {
                mDinnerSet.add(Main.getRestaurantMenu().get(new Random().nextInt(Main.getRestaurantMenu().size())));
            }
            mDiscount = count / 100;
        } else {
            System.out.println("Unfortunetly, menu is empty.");
        }
    }

    /**
     * Zwraca nazwe zastawy
     *
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * Ustawia nazwe zastawy
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Zwraca zestaw zlozony z pojedynczych posilkow
     * @return lista posilkow
     */
    public List<Product> getDinnerSet() {
        return mDinnerSet;
    }

    /**
     * Ustawia zestaw posilkow
     * @param dinnerSet
     */
    public void setDinnerSet(List<Product> dinnerSet) {
        mDinnerSet = dinnerSet;
    }

    /**
     * Zwraca cene po rabacie dla zestawow obiadowych
     * @return cena zestawu po rabacie
     */
    public double getPrice() {
        double price = 0;
        for (Product x : mDinnerSet) {
            price += x.getPrice();
        }
        return price * getDiscount();
    }

    /**
     * Zwraca znizke
     * @return zwraca znizke
     */
    public double getDiscount() {
        if (Double.compare(mDiscount, 0.0) == 0)
            return (100 - mDinnerSet.size()) / 100.0;
        else return (100 - mDiscount) / 100.0;
    }

    /**
     * Ustawia znizke
     * @param discount
     */
    public void setDiscount(double discount) {
        mDiscount = discount;
    }

    /**
     * dodaje posilek do zestawu obiadowego
     * @param product
     */
    public void addMeal(Product product) {
        mDinnerSet.add(product);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Dinner Set - " + getDinnerSet() +
                ", Discount - " + getDiscount();
    }
}
