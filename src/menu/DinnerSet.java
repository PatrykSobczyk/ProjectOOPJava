package menu;

import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class DinnerSet extends Product {
    private List<Meal> mDinnerSet;
    private int mDiscount;

    public List<Meal> getDinnerSet() {
        return mDinnerSet;
    }

    public void setDinnerSet(List<Meal> dinnerSet) {
        mDinnerSet = dinnerSet;
    }

    public int getDiscount() {
        return mDiscount;
    }

    public void setDiscount(int discount) {
        mDiscount = discount;
    }
}
