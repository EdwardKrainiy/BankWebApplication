package com.app.bank.service;

import com.app.bank.data.CardRepository;
import com.app.bank.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan("com.app.bank.service")

public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card findCard(int id){
        return cardRepository.findById(id);
    }

    public Card findCardByAccountId(int accountId){
        return cardRepository.findByAccountId(accountId);
    }

    public List<Card> findAllCards(){
        return cardRepository.findAll();
    }

    public void saveCard(Card card){
        cardRepository.create(card);
    }

    public void updateCard(Card card){
        cardRepository.update(card);
    }

    public void deleteCard(Card card){
        cardRepository.delete(card);
    }
}
