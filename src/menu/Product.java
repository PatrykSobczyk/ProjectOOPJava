package menu;

import enums.Category;
import enums.Size;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Product {
    private String mName;
    private Double mPrice;
    private Size mSize;
    private Category mCategory;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
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
}
