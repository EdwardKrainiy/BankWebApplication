package com.app.bank.data;


import com.app.bank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository extends EntityRepository<Account> {

    @Override
    public String getTableName() {
        return "Account";
    }

    public Account findByLogin(String login){
        return (Account) transactionManager.getSessionFactory().openSession().createQuery("from Account where login =:login ")
                .setParameter("login", login).uniqueResult();
    }

    public Account findById(int accountId){
        return (Account) transactionManager.getSessionFactory().openSession().createQuery("from Account where id =: accountId").setParameter("accountId", accountId).uniqueResult();
    }
}
