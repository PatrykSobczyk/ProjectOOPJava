package person;

import javafx.collections.ObservableList;
import world.Address;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje klienta firmowego
 */
public class CompanyCustomer extends Customer implements Serializable {
    private Address mCorrespondenceAddress;
    private String mAccountNumber;
    private String mREGON;

    /**
     * Konstruktor losowy pracownika firmowego
     */
    public CompanyCustomer() {
        super();
        mCorrespondenceAddress = new Address();
        mAccountNumber = String.valueOf("83-6094-5999-5555-0000-9999-" + String.valueOf((int) (Math.random() * ((9999 - 1000) + 1) + 1000)));
        mREGON = String.valueOf("1234567890" + String.valueOf((int) (Math.random() * ((9999 - 1000) + 1) + 1000)));
    }

    /**
     * Konstruktor pracownika firmowego
     *
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param address
     * @param email
     * @param correspondenceAddress
     * @param accountNumber
     * @param REGON
     */
    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, Address address, String email, Address correspondenceAddress, String accountNumber, String REGON) {
        super(name, surname, ID, phoneNumber, address, email);
        mCorrespondenceAddress = correspondenceAddress;
        mAccountNumber = accountNumber;
        mREGON = REGON;
        configPicture(address.getPosition(), ID);
    }

    /**
     * Konstruktor pracownika firmowego
     * @param name
     * @param surname
     * @param ID
     * @param phoneNumber
     * @param longitude
     * @param latitude
     * @param cityName
     * @param email
     * @param correspondenceAddress
     * @param accountNumber
     * @param REGON
     */

    public CompanyCustomer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, String email, Address correspondenceAddress, String accountNumber, String REGON) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), email, correspondenceAddress, accountNumber, REGON);
    }

    /**
     * Zwraca adres korespondencyjny
     * @return adres korespondencyjny
     */
    public Address getCorrespondenceAddress() {
        return mCorrespondenceAddress;
    }

    /**
     * Ustawia adres korespondencyjny
     * @param correspondenceAddress
     */
    public void setCorrespondenceAddress(Address correspondenceAddress) {
        mCorrespondenceAddress = correspondenceAddress;
    }

    /**
     * Zwraca numer konta
     * @return numer konta
     */
    public String getAccountNumber() {
        return mAccountNumber;
    }

    /**
     * Ustawia numer konta
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        mAccountNumber = accountNumber;
    }

    /**
     * Zwraca REGON
     * @return REGON
     */
    public String getREGON() {
        return mREGON;
    }

    /**
     * Ustawia REGON
     * @param REGON
     */
    public void setREGON(String REGON) {
        mREGON = REGON;
    }

    @Override
    public String toString() {
        return super.toString() + ", my Correspondence Adress - " + this.getCorrespondenceAddress() +
                ", my Account Number - " + this.getAccountNumber() +
                ", my REGON - " + this.getREGON();
    }

    /**
     * Implementuje liste z szczegolami dla pracownika firmowego
     * @return obserwowana lista z detalami dla pracownika firmoawego
     */
    @Override
    public ObservableList<String> customerDetailsList() {
        ObservableList<String> list2 = super.customerDetailsList();
        list2.add("Correspondence Address " + String.valueOf(getCorrespondenceAddress()));
        list2.add("Account Number " + String.valueOf(getAccountNumber()));
        list2.add("REGON " + String.valueOf(getREGON()));
        return list2;
    }

    /**
     * Implementuje adres duzego obrazka
     * @return adres do duzego obrazka
     */
    @Override
    public String getBigImageURL() {
        return "/images/companycustomerbig.png";
    }

    /**
     * Implementuje adres malego obrazka
     * @return adres do malego obrazka
     */
    @Override
    public String getSmallImageURL() {
        return "/images/companycustomer.png";
    }


}
