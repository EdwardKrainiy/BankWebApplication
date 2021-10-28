package com.app.bank.controller;

import com.app.bank.model.Account;
import com.app.bank.model.AccountInfo;
import com.app.bank.service.AccountInfoService;
import com.app.bank.service.AccountService;
import com.app.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
@ComponentScan(value = "com.app.bank")
public class AccountMappingController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CardService cardService;

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
        model.addAttribute("cardInfo", cardService.findCardByAccountId(accountId));
        return "account/accountById";
    }

    @GetMapping("/new")
    public String createNewAccount(Model model){
        model.addAttribute("account", new Account());
        return "account/newAccountForm";
    }

    @PostMapping()
    public String putNewAccount(@ModelAttribute("account") @Valid Account account,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "account/new";
        }
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
    public String updateAccount(@ModelAttribute("account") @Valid Account account, @ModelAttribute("accountInfo") @Valid AccountInfo accountInfo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "account/edit";
        }
        accountService.updateAccount(account);
        return "redirect:/account";
    }

    @DeleteMapping("/{accountId}")
    public String deleteAccount(@PathVariable int accountId){
        accountInfoService.deleteAccountInfo(accountInfoService.findAccountInfoById(accountId));
        cardService.deleteCard(cardService.findCardByAccountId(accountId));
        accountService.deleteAccount(accountService.findById(accountId));
        return "redirect:/account";
    }
}
