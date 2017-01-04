package menu;

import enums.Category;
import enums.Size;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje posilek
 */
public class Meal extends Product implements Serializable {
    private String mIngredients;
    private String mIngredientsTab[] = {"Brokul", "Cukier", "Glukoza", "Laktoza", "Mieso", "Konserwanty", "Szpinak", "Maka", "Jeczmien", "Groch", "E205", "Kapusta", "E450", "E250", "E985", "E997"};

    /**
     * Konstruktor posilku
     *
     * @param name
     * @param price
     * @param category
     * @param size
     * @param ingredients
     */
    public Meal(String name, Double price, Category category, Size size, String ingredients) {
        super(name, price, category, size);
        mIngredients = ingredients;
    }

    /**
     * Konstruktor posilku
     * @param name
     * @param price
     * @param category
     * @param ingredients
     */
    public Meal(String name, Double price, Category category, String ingredients) {
        super(name, price, category);
        mIngredients = ingredients;
    }

    /**
     * Konstruktor losowy posilku
     */
    public Meal() {
        super();
        mIngredients = mIngredientsTab[(int) (Math.random() * (mIngredientsTab.length - 1))];
    }

    /**
     * Zwraca skladniki
     * @return nazwa skladniku
     */

    public String getIngredients() {
        return mIngredients;
    }

    /**
     * Ustawia skladniki
     * @param ingredients
     */
    public void setIngredients(String ingredients) {
        mIngredients = ingredients;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Ingredients - " + getIngredients();
    }
}
