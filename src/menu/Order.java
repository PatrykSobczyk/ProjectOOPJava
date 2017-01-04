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
 * Implementuje zamowienie
 */
public class Order implements Serializable {
    private List<Product> mSetOfMeals = new ArrayList<>();
    private List<DinnerSet> mSetOfDinnerSets = new ArrayList<>();
    private Customer mCustomer;
    private Date mDate;

    /**
     * Konstruktor zamowienia
     *
     * @param setOfMeals
     * @param setOfDinnerSets
     * @param customer
     */
    public Order(List<Product> setOfMeals, List<DinnerSet> setOfDinnerSets, Customer customer) {
        mSetOfMeals.addAll(setOfMeals);
        mSetOfDinnerSets.addAll(setOfDinnerSets);
        mCustomer = customer;
        mDate = new Date();
    }

    /**
     * Konstruktor zamowienia
     * @param setOfMeals
     * @param setOfDinnerSets
     * @param customer
     * @param date
     */
    public Order(List<Product> setOfMeals, List<DinnerSet> setOfDinnerSets, Customer customer, Date date) {
        mSetOfMeals.addAll(setOfMeals);
        mSetOfDinnerSets.addAll(setOfDinnerSets);
        mCustomer = customer;
        mDate = date;
    }

    /**
     * Konstruktor zamowienia
     * @param product
     * @param customer
     */
    public Order(Product product, Customer customer) {
        mSetOfMeals.add(product);
        mCustomer = customer;
    }

    /**
     * Konstruktor losowego zamowienia
     */
    public Order() {
        mSetOfMeals.addAll(createListOfProducts());
        mSetOfDinnerSets.addAll(createListOfDinnerSets());
        mCustomer = Main.getCustomers().get(new Random().nextInt(Main.getCustomers().size()));
        mDate = new Date();
    }

    /**
     * Zwraca liste produktow
     * @return lista produktow
     */
    public List<Product> getSetOfMeals() {
        return mSetOfMeals;
    }

    /**
     * Ustawia zbior produktow
     * @param setOfMeals
     */
    public void setSetOfMeals(List<Product> setOfMeals) {
        mSetOfMeals = setOfMeals;
    }

    /**
     * Zwraca liste zestawow obiadowych
     * @return lista zestawow obiadowych
     */
    public List getSetOfDinnerSets() {
        return mSetOfDinnerSets;
    }

    /**
     * Ustawia zbior zestawow obiadowych
     * @param setOfDinnerSets
     */
    public void setSetOfDinnerSets(List<DinnerSet> setOfDinnerSets) {
        mSetOfDinnerSets = setOfDinnerSets;
    }

    /**
     * Zwraca wlasciciela zamowienia
     * @return wlasciciela zamowienia
     */
    public Customer getCustomer() {
        return mCustomer;
    }

    /**
     * Ustawia wlasciciela zamowienia
     * @param customer
     */
    public void setCustomer(Customer customer) {
        mCustomer = customer;
    }

    /**
     * Zwraca date zamowienia
     * @return data zamowienia
     */
    public Date getDate() {
        return mDate;
    }

    /**
     * Ustawia date zamowienia
     * @param date
     */
    public void setDate(Date date) {
        mDate = date;
    }

    /**
     * Dodaje produkt do zamowienia
     * @param product
     */
    public void addMealToOrder(Product product) {
        mSetOfMeals.add(product);
    }

    /**
     * Dodaje zestaw obiadowy do zamowienia
     * @param dinnerSet
     */
    public void addDinnerSetToOrder(DinnerSet dinnerSet) {
        mSetOfDinnerSets.add(dinnerSet);
    }

    /**
     * Zwraca cene zamowienia po rabatach i doliczeniu oplaty paliwowej
     * @return cena zamowienia
     */
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

    /**
     * Kreuje liste produktow
     * @return lista produktow
     */
    public ArrayList<Product> createListOfProducts() {
        ArrayList<Product> list = new ArrayList<>();
        int count = new Random().nextInt(7) + 1;
        for (int i = 0; i < count; i++) {
            list.add(Main.getRestaurantMenu().get(new Random().nextInt(Main.getRestaurantMenu().size())));
        }
        return list;
    }

    /**
     * Kreuje liste zestawow obiadowych
     * @return
     */
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
