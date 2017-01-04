package person;

import javafx.collections.ObservableList;
import menu.Order;
import world.Address;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class RegularCustomer extends Customer implements Serializable {
    private int mLoyaltyPoints;
    private double mDiscount;

    /**
     * Konstruktor klienta stalego
     *
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param address
     * @param email
     * @param loyaltyPoints
     * @param discount
     */
    public RegularCustomer(String name, String surname, int ID, String phoneNumber, Address address, String email, int loyaltyPoints, int discount) {
        super(name, surname, ID, phoneNumber, address, email);
        mLoyaltyPoints = loyaltyPoints;
        mDiscount = discount;
        configPicture(address.getPosition(), ID);
    }

    /**
     * Konstruktor klienta stalego
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param longitude
     * @param latitude
     * @param cityName
     * @param email
     * @param loyaltyPoints
     * @param discount
     */
    public RegularCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, String email, int loyaltyPoints, int discount) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), email, loyaltyPoints, discount);
    }

    /**
     * Konstruktor klienta stalego
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param address
     * @param loyaltyPoints
     * @param discount
     */
    public RegularCustomer(String name, String surname, int ID, String phoneNumber, Address address, int loyaltyPoints, int discount) {
        this(name, surname, ID, phoneNumber, address, "", loyaltyPoints, discount);
    }

    /**
     * Konstruktor klienta stalego
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param longitude
     * @param latitude
     * @param cityName
     * @param loyaltyPoints
     * @param discount
     */
    public RegularCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, int loyaltyPoints, int discount) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), "", loyaltyPoints, discount);
    }

    /**
     * Konstruktor losowy klienta stalego
     */
    public RegularCustomer() {
        super();
        mLoyaltyPoints = (int) (Math.random() * ((10000 - 100) + 1));
        mDiscount = Math.round(Math.random() * ((40 - 1) + 1));
    }

    /**
     * Zwraca punkty lojalnosciowe
     * @return punkty lojalnosciowe
     */
    public int getLoyaltyPoints() {
        return mLoyaltyPoints;
    }

    /**
     * Ustawia punkty lojalnosciowe
     * @param loyaltyPoints
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        mLoyaltyPoints = loyaltyPoints;
    }

    /**
     * Zwraca znizke
     * @return
     */
    public double getDiscount() {
        return mDiscount / 100.0;
    }

    /**
     * Ustawia znizke
     * @param discount
     */
    public void setDiscount(double discount) {
        mDiscount = discount;
    }

    /**
     * Sprawdza czy jest kupon rabatowy
     * @return
     */
    public boolean isDiscountCoupon() {
        if (mLoyaltyPoints > 1000) {
            mLoyaltyPoints -= 1000;
            return true;
        } else {
            return false;
        }


    }

    /**
     * Placi za zamowienie
     * @param order
     */
    @Override
    public void payToOrder(Order order) {
        double price = order.getTotalPrice() * this.getDiscount();
        if (this.isDiscountCoupon() && price > 100) {
            mLoyaltyPoints += (int) price - 100;
        } else {
            mLoyaltyPoints += (int) order.getTotalPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", my Loyalty Points - " + this.getLoyaltyPoints() +
                ", my Discount - " + this.getDiscount() +
                ", my Discount Coupon - " + this.isDiscountCoupon();
    }

    /**
     * Zwraca szczegolowe dane o kliencie stalym
     * @return obserowanan lista
     */
    @Override
    public ObservableList<String> customerDetailsList() {
        ObservableList<String> list2 = super.customerDetailsList();
        list2.add("Loyalty Points " + String.valueOf(getLoyaltyPoints()));
        list2.add("Discount " + String.valueOf(getDiscount()));
        return list2;
    }

    /**
     * Zwraca adres duzego obrazeka
     * @return adres duzego obrazka
     */
    @Override
    public String getBigImageURL() {
        return "/images/regularcustomerbig.png";
    }

    /**
     * Zwraca adres malego obrazeka
     * @return adres malego obrazka
     */
    @Override
    public String getSmallImageURL() {
        return "/images/regularcustomer.png";
    }
}
