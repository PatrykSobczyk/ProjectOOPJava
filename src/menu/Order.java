package menu;

import person.Customer;

import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Order {
    private List mSetOfMeals;
    private List mSetOfDinnerSets;
    private Customer mCustomer;

    public List getSetOfMeals() {
        return mSetOfMeals;
    }

    public void setSetOfMeals(List setOfMeals) {
        mSetOfMeals = setOfMeals;
    }

    public List getSetOfDinnerSets() {
        return mSetOfDinnerSets;
    }

    public void setSetOfDinnerSets(List setOfDinnerSets) {
        mSetOfDinnerSets = setOfDinnerSets;
    }

    public Customer getCustomer() {
        return mCustomer;
    }

    public void setCustomer(Customer customer) {
        mCustomer = customer;
    }
}
