package com.app.bank.controller;

import com.app.bank.model.Account;
import com.app.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String home(Model model){
        List<Account> accounts = accountService.findAllAccounts();
        model.addAttribute("accounts", accounts);
        return "greeting";
    }
}
