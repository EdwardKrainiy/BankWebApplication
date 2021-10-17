package com.app.bank.controller;

import com.app.bank.model.Account;
import com.app.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan(value = "com.app.bank")
public class MainPageController {
    private AccountService accountService;

    @Autowired
    private MainPageController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping("/")
    public String authController(Model model){
        List<Account> accounts = accountService.findAllAccounts();
        List<String> logins = new ArrayList<>();
        List<String> passwords = new ArrayList<>();

        for(Account a: accounts){
            logins.add(a.getLogin());
            passwords.add(a.getPassword());
        }

        model.addAttribute("accounts", accounts);
        return "greeting";
    }

    @GetMapping("/{accountId}")
    public String accountByIdController(Model model, @PathVariable int accountId){
        model.addAttribute("account", accountService.findById(accountId));
        return "accountById";
    }
}
