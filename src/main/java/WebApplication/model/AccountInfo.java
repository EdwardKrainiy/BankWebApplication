package WebApplication.model;

import java.util.Objects;

public class AccountInfo extends BaseEntity {

    private int accountId;

    private String firstname;

    private String lastname;

    private String patronymic;

    private String phoneNumber;

    private double balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInfo that = (AccountInfo) o;
        return id == that.id && accountId == that.accountId && balance == that.balance && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, firstname, lastname, patronymic, phoneNumber, balance);
    }

    public AccountInfo(int accountId, String firstname, String lastname, String patronymic, String phoneNumber, double balance) {
        this.accountId = accountId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public AccountInfo() {
    }
}
