package com.app.bank.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "accountinfo")
public class AccountInfo extends BaseEntity {

    @Column(name = "AccountId")
    private int accountId;

    @Column(name = "Firstname")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "First name size should be between 2 and 30 characters")
    private String firstname;

    @Column(name = "Lastname")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 30, message = "Last name size should be between 2 and 30 characters")
    private String lastname;

    @Column(name = "Patronymic")
    @Size(min = 2, max = 30, message = "Patronymic size should be between 2 and 30 characters")
    private String patronymic;

    @Column(name = "PhoneNumber")
    @Size(min = 8, max = 8, message = "Phone number size should be between 2 and 30 characters")
    @Pattern(regexp = "[0-9]")
    private String phoneNumber;

    @Column(name = "Balance")
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
