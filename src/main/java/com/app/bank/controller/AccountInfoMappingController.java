package com.app.bank.controller;

import com.app.bank.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
@ComponentScan(value = "com.app.bank")
public class AccountInfoMappingController {
    @Autowired
    private AccountInfoService infoService;

        @GetMapping()
        public String showAllInfos(Model model){
            model.addAttribute("infos", infoService.findAllAccountInfos());
            return "info/infos";
        }

        @GetMapping("/{infoId}")
        public String accountByIdController(Model model, @PathVariable int infoId){
            model.addAttribute("account", infoService.findAccountInfoById(infoId));
            return "info/infoById";
        }
}
