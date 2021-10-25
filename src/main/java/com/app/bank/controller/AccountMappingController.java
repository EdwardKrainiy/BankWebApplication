package com.app.bank.controller;

import com.app.bank.model.Account;
import com.app.bank.model.AccountInfo;
import com.app.bank.service.AccountInfoService;
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

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping()
    public String showAllAccounts(Model model){
        model.addAttribute("accounts", accountService.findAllAccounts());
        return "account/accounts";
    }

    @GetMapping("/{accountId}")
    public String showAccountById(Model model, @PathVariable("accountId") int accountId){
        model.addAttribute("account", accountService.findById(accountId));
        model.addAttribute("accountInfo", accountInfoService.findAccountInfoById(accountId));
        return "account/accountById";
    }

    @GetMapping("/new")
    public String createNewAccount(Model model){
        model.addAttribute("account", new Account());
        return "account/newAccountForm";
    }

    @PostMapping()
    public String putNewAccount(@ModelAttribute("account") Account account){
        accountService.createAccount(account);
        return "redirect:/account";
    }

    @GetMapping("/{id}/edit")
    public String editAccount(Model model, @PathVariable("id") int accountId){
        model.addAttribute("account", accountService.findById(accountId));
        model.addAttribute("accountInfo", accountInfoService.findAccountInfoById(accountId));
        return "account/edit";
    }

    @PostMapping("/{id}")
    public String updateAccount(@ModelAttribute("account") Account account, @ModelAttribute("accountInfo") AccountInfo accountInfo) {
        accountService.updateAccount(account);
        accountInfoService.updateAccountInfo(accountInfo);
        return "redirect:/account";
    }

    @DeleteMapping("/{accountId}")
    public String deleteAccount(@PathVariable int accountId){
        accountService.deleteAccount(accountService.findById(accountId));
        return "redirect:/account";
    }
}
