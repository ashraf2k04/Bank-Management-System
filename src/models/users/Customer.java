package models.users;

import java.util.ArrayList;
import java.util.List;

import models.accounts.BankAccount;

public class Customer extends User {

    private String ssn;
    private String aadhaarNo;
    private String panNo;
    private String contactNumber;

    private final List<BankAccount> accounts;

    public Customer() {

        accounts = new ArrayList<>();

    }

    public Customer(String id,
                    String firstName,
                    String lastName,
                    String email,
                    String password,
                    String address,
                    String dob,
                    String ssn,
                    String aadhaarNo,
                    String panNo,
                    String contactNumber) {

        super(id,
                firstName,
                lastName,
                email,
                password,
                address,
                dob);

        this.ssn = ssn;
        this.aadhaarNo = aadhaarNo;
        this.panNo = panNo;
        this.contactNumber = contactNumber;

        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {

        accounts.add(account);

    }

    public void removeAccount(BankAccount account) {

        accounts.remove(account);

    }

    public List<BankAccount> getAccounts() {

        return accounts;

    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nSSN         : " + ssn +
                "\nAADHAAR     : " + aadhaarNo +
                "\nPAN         : " + panNo +
                "\nCONTACT     : " + contactNumber +
                "\nACCOUNTS    : " + accounts.size();

    }

}