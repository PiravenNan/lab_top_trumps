package com.example.top_trumps_start_code.services;


import com.example.top_trumps_start_code.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpService {

    private Card card;
    private boolean higher;
    private ArrayList<Card> cards;

    public TopTrumpService(Card card, boolean higher, ArrayList<Card> cards) {
        this.card = card;
        this.higher = higher;
        this.cards = cards;
    }

    public String checkWinner(Card card, Card card2){
        if (card.getCardValue() > card2.getCardValue()){
            return card.getSuit() + "wins!";
        } else if (card2.getCardValue() > card.getCardValue()){
            return card2.getSuit() + " wins!";
        } else {
            return "Draw!";
        }
    }



    public TopTrumpService() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isHigher() {
        return higher;
    }

    public void setHigher(boolean higher) {
        this.higher = higher;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
