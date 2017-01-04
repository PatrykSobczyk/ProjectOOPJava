package menu;

import enums.Category;
import enums.Size;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Meal extends Product implements Serializable {
    private String mIngredients;
    private String mIngredientsTab[] = {"Brokul", "Cukier", "Glukoza", "Laktoza", "Mieso", "Konserwanty", "Szpinak", "Maka", "Jeczmien", "Groch", "E205", "Kapusta", "E450", "E250", "E985", "E997"};

    public Meal(String name, Double price, Category category, Size size, String ingredients) {
        super(name, price, category, size);
        mIngredients = ingredients;
    }

    public Meal(String name, Double price, Category category, String ingredients) {
        super(name, price, category);
        mIngredients = ingredients;
    }

    public Meal() {
        super();
        mIngredients = mIngredientsTab[(int) (Math.random() * (mIngredientsTab.length - 1))];
    }

    public String getIngredients() {
        return mIngredients;
    }

    public void setIngredients(String ingredients) {
        mIngredients = ingredients;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Ingredients - " + getIngredients();
    }
}
