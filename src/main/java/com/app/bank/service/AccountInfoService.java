package com.app.bank.service;

import com.app.bank.data.AccountInfoRepository;
import com.app.bank.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan("com.app.bank.service")
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public AccountInfoService(){};

    public AccountInfo findAccountInfoById(int id){
        return accountInfoRepository.findById(id);
    }

    public List<AccountInfo> findAllAccountInfos(){
        return accountInfoRepository.findAll();
    }

    public void saveAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.create(accountInfo);
    }

    public void updateAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.update(accountInfo);
    }

    public void deleteAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.delete(accountInfo);
    }
}
