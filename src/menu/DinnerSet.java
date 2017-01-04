package menu;

import main.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class DinnerSet implements Serializable {
    private String mName;
    private String[] mNames = {"Obiad szefa", "Obiad tesciowej", "Obiad ziecia", "Obiad rumowy", "Obiad zloty", "Obiad babci", "Obiad dziaka", "Obiad studenta", "Obiad niejadka", "Obiad polaka", "Obiad inzyniera", "Obiad kulawegokucharza", "Obiad kucharki"};
    private List<Product> mDinnerSet = new ArrayList<>();
    private double mDiscount;

    public DinnerSet(String name, List<Product> dinnerSet, int discount) {
        mName = name;
        mDinnerSet = dinnerSet;
        mDiscount = discount;
    }

    public DinnerSet(String name, List<Product> dinnerSet) {
        mName = name;
        mDinnerSet = dinnerSet;
        mDiscount = 0;
    }

    public DinnerSet(String name, int discount, Product... products) {
        mName = name;
        for (Product x : products) {
            mDinnerSet.add(x);
        }
        mDiscount = discount;
    }

    public DinnerSet(String name, Product... products) {
        mName = name;
        for (Product x : products) {
            mDinnerSet.add(x);
        }
    }

    public DinnerSet() {
        mName = mNames[(int) (Math.random() * (mNames.length - 1))];
        int count = new Random().nextInt(7) + 1;
        for (int i = 0; i < count; i++) {
            mDinnerSet.add(Main.getRestaurantMenu().get(new Random().nextInt(Main.getRestaurantMenu().size() - 1)));
        }
        mDiscount = count / 100;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Product> getDinnerSet() {
        return mDinnerSet;
    }

    public void setDinnerSet(List<Product> dinnerSet) {
        mDinnerSet = dinnerSet;
    }

    public double getPrice() {
        double price = 0;
        for (Product x : mDinnerSet) {
            price += x.getPrice();
        }
        return price * getDiscount();
    }

    public double getDiscount() {
        if (Double.compare(mDiscount, 0.0) == 0)
            return (100 - mDinnerSet.size()) / 100.0;
        else return (100 - mDiscount) / 100.0;

    }

    public void setDiscount(double discount) {
        mDiscount = discount;
    }

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
