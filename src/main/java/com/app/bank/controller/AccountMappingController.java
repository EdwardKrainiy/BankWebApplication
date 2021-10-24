package com.app.bank.controller;

import com.app.bank.model.Account;
import com.app.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@ComponentScan(value = "com.app.bank")
public class AccountMappingController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public String showAllAccounts(Model model){
        model.addAttribute("accounts", accountService.findAllAccounts());
        return "account/accounts";
    }

    @GetMapping("/{accountId}")
    public String showAccountById(Model model, @PathVariable int accountId){
        model.addAttribute("account", accountService.findById(accountId));
        return "account/accountById";
    }

    @GetMapping("/new")
    public String createNewAccount(Model model, @ModelAttribute("account") Account account){
        return "account/newAccountForm";
    }

    @PostMapping()
    public String putNewAccount(Model model, @ModelAttribute("account") Account account){
        accountService.createAccount(account);
        return "redirect:/account";
    }

    @DeleteMapping("/{accountId}")
    public String deleteAccount(Model model, @PathVariable int accountId){
        accountService.deleteAccount(accountService.findById(accountId));
        return "redirect:/account";
    }
}
