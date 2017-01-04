package menu;

import main.Main;
import person.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Order implements Serializable {
    private List<Product> mSetOfMeals = new ArrayList<>();
    private List<DinnerSet> mSetOfDinnerSets = new ArrayList<>();
    private Customer mCustomer;
    private Date mDate;

    public Order(List<Product> setOfMeals, List<DinnerSet> setOfDinnerSets, Customer customer) {
        mSetOfMeals.addAll(setOfMeals);
        mSetOfDinnerSets.addAll(setOfDinnerSets);
        mCustomer = customer;
        mDate = new Date();
    }

    public Order(List<Product> setOfMeals, List<DinnerSet> setOfDinnerSets, Customer customer, Date date) {
        mSetOfMeals.addAll(setOfMeals);
        mSetOfDinnerSets.addAll(setOfDinnerSets);
        mCustomer = customer;
        mDate = date;
    }

    public Order(Product product, Customer customer) {
        mSetOfMeals.add(product);
        mCustomer = customer;
    }

    public Order() {
        mSetOfMeals.addAll(createListOfProducts());
        mSetOfDinnerSets.addAll(createListOfDinnerSets());
        mCustomer = Main.getCustomers().get(new Random().nextInt(Main.getCustomers().size()));
        mDate = new Date();
    }

    public List<Product> getSetOfMeals() {
        return mSetOfMeals;
    }

    public void setSetOfMeals(List<Product> setOfMeals) {
        mSetOfMeals = setOfMeals;
    }

    public List getSetOfDinnerSets() {
        return mSetOfDinnerSets;
    }

    public void setSetOfDinnerSets(List<DinnerSet> setOfDinnerSets) {
        mSetOfDinnerSets = setOfDinnerSets;
    }

    public Customer getCustomer() {
        return mCustomer;
    }

    public void setCustomer(Customer customer) {
        mCustomer = customer;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void addMealToOrder(Product product) {
        mSetOfMeals.add(product);
    }

    public void addDinnerSetToOrder(DinnerSet dinnerSet) {
        mSetOfDinnerSets.add(dinnerSet);
    }

    public double getTotalPrice() {
        double price = 0.0;
        for (Product x : mSetOfMeals) {
            price += x.getPrice();
        }
        for (DinnerSet x : mSetOfDinnerSets) {
            price += x.getPrice();
        }
        if (Double.compare(price, 100.0) < 0) {
            price += 10.0;
        }
        int distance = mCustomer.getAddress().getDistanceToRestaurant();
        if (distance > 800) {
            price += distance * 0.01;
        }
        return price;
    }

    public ArrayList<Product> createListOfProducts() {
        ArrayList<Product> list = new ArrayList<>();
        int count = new Random().nextInt(7) + 1;
        for (int i = 0; i < count; i++) {
            list.add(Main.getRestaurantMenu().get(new Random().nextInt(Main.getRestaurantMenu().size())));
        }
        return list;
    }

    public ArrayList<DinnerSet> createListOfDinnerSets() {
        ArrayList<DinnerSet> list = new ArrayList<>();
        int count = new Random().nextInt(4) + 1;
        for (int i = 0; i < count; i++) {
            list.add(new DinnerSet());
        }
        return list;
    }

    @Override
    public String toString() {
        return mSetOfMeals +
                ", " + mSetOfDinnerSets +
                ", " + mCustomer +
                ", " + mDate;
    }
}
