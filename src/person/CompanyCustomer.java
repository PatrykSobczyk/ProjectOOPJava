package person;

import javafx.collections.ObservableList;
import world.Address;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class CompanyCustomer extends Customer implements Serializable {
    private Address mCorrespondenceAddress;
    private String mAccountNumber;
    private String mREGON;

    public CompanyCustomer() {
        super();
        mCorrespondenceAddress = new Address();
        mAccountNumber = String.valueOf("83-6094-5999-5555-0000-9999-" + String.valueOf((int) (Math.random() * ((9999 - 1000) + 1) + 1000)));
        mREGON = String.valueOf("1234567890" + String.valueOf((int) (Math.random() * ((9999 - 1000) + 1) + 1000)));
    }

    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, Address address, String email, Address correspondenceAddress, String accountNumber, String REGON) {
        super(name, surname, ID, phoneNumber, address, email);
        mCorrespondenceAddress = correspondenceAddress;
        mAccountNumber = accountNumber;
        mREGON = REGON;
        configPicture(address.getPosition(), ID);
    }


    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, String email, Address correspondenceAddress, String accountNumber, String REGON) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), email, correspondenceAddress, accountNumber, REGON);
    }

    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, String email, int longitudeCorrespondence, int latitudeCorrespondence, String cityNameCorrespondence, String accountNumber, String REGON) {
        this(name, surname, ID, phoneNumber, longitude, latitude, cityName, email, new Address(longitudeCorrespondence, latitudeCorrespondence, cityName), accountNumber, REGON);

    }

    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, int longitudeCorrespondence, int latitudeCorrespondence, String cityNameCorrespondence, String accountNumber, String REGON) {
        this(name, surname, ID, phoneNumber, longitude, latitude, cityName, "", new Address(longitude, latitude, cityName), accountNumber, REGON);
    }

    public Address getCorrespondenceAddress() {
        return mCorrespondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        mCorrespondenceAddress = correspondenceAddress;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        mAccountNumber = accountNumber;
    }

    public String getREGON() {
        return mREGON;
    }

    public void setREGON(String REGON) {
        mREGON = REGON;
    }

    @Override
    public String toString() {
        return super.toString() + ", my Correspondence Adress - " + this.getCorrespondenceAddress() +
                ", my Account Number - " + this.getAccountNumber() +
                ", my REGON - " + this.getREGON();
    }

    @Override
    public ObservableList<String> customerDetailsList() {
        ObservableList<String> list2 = super.customerDetailsList();
        list2.add("Correspondence Address " + String.valueOf(getCorrespondenceAddress()));
        list2.add("Account Number " + String.valueOf(getAccountNumber()));
        list2.add("REGON " + String.valueOf(getREGON()));
        return list2;
    }

    @Override
    public String getBigImageURL() {
        return "/images/companycustomerbig.png";
    }

    @Override
    public String getSmallImageURL() {
        return "/images/companycustomer.png";
    }


}
