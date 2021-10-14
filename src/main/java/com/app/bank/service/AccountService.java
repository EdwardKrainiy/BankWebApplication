package com.app.bank.service;

import com.app.bank.data.AccountRepository;
import com.app.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan("com.app.bank.service")
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account findAccount(int number){
        return accountRepository.findById(number);
    }

    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findByLogin(String login){
        return accountRepository.findByLogin(login);
    }

    public int createAccount(Account account){
        return accountRepository.create(account);
    }

    public void updateAccount(Account account){
        accountRepository.update(account);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
