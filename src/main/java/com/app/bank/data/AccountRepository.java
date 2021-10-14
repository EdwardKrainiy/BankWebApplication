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
}
