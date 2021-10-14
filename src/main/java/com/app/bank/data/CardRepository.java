package com.app.bank.data;

import com.app.bank.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardRepository extends EntityRepository<Card> {

    @Override
    public String getTableName() {
        return "Card";
    }

    public Card findByAccountId(int accountId){
        return (Card) transactionManager.getSessionFactory().openSession().createQuery("from Card where accountId =: accountId ")
                .setParameter("accountId", accountId).uniqueResult();
    }
}
