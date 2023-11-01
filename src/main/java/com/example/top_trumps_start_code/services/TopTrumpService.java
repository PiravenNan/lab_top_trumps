package com.example.top_trumps_start_code.services;


import com.example.top_trumps_start_code.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpService {

    private Card card;
    private boolean higher;
    private ArrayList<Card> cards;

    public void startNewGame(){
        this.cards = new ArrayList<>();
    }

    public void addCards(Card card, Card card1){
        this.cards.add(card);
        this.cards.add(card1);
    }

    public String checkWinner(){
        if (this.cards.get(0).getCardValue() > this.cards.get(1).getCardValue()){
            return card.getSuit() + "wins!";
        } else if (this.cards.get(1).getCardValue() > this.cards.get(1).getCardValue()){
            return this.cards.get(1).getSuit() + " wins!";
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
