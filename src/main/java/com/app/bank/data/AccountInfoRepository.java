package com.app.bank.data;


import com.app.bank.model.AccountInfo;
import org.springframework.stereotype.Component;

@Component
public class AccountInfoRepository extends EntityRepository<AccountInfo> {
    @Override
    public String getTableName() {
        return "Accountinfo";
    }

    public AccountInfo findById(int accountId){
        return (AccountInfo) transactionManager.getSessionFactory().openSession().createQuery("from AccountInfo where accountId =: accountId ")
                .setParameter("accountId", accountId).uniqueResult();
    }
}