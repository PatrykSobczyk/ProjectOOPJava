package person;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class RegularCustomer extends Customer {
    private int mLoyaltyPoints;
    private int mDiscount;
    private boolean mDiscountCoupon;

    public int getLoyaltyPoints() {
        return mLoyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        mLoyaltyPoints = loyaltyPoints;
    }

    public int getDiscount() {
        return mDiscount;
    }

    public void setDiscount(int discount) {
        mDiscount = discount;
    }

    public boolean isDiscountCoupon() {
        return mDiscountCoupon;
    }

    public void setDiscountCoupon(boolean discountCoupon) {
        mDiscountCoupon = discountCoupon;
    }
}
