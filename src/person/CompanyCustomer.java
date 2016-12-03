package person;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class CompanyCustomer extends Customer {
    private String mCorrespondenceAddress;
    private String mAccountNumber;
    private String mREGON;

    public String getCorrespondenceAddress() {
        return mCorrespondenceAddress;
    }

    public void setCorrespondenceAddress(String correspondenceAddress) {
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
}
