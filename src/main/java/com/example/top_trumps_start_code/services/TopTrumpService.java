package com.example.top_trumps_start_code.services;


import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

@Service
public class TopTrumpService {

    private Card card;
    private boolean higher;
    private ArrayList<String> deckOfcards;

    public void startNewGame(){
        this.deckOfcards = new ArrayList<>();
        EnumSet.allOf(Suit.class)
                        .forEach(Suit ->{
                            EnumSet.allOf(Rank.class)
                                    .forEach(Rank ->{
                                        Card newCard = new Card(Rank,Suit);
                                        deckOfcards.add(newCard.getRank()+" of "+ newCard.getSuit());
                                    });
                        });


    }


    public boolean isCardStillInDeck(Card card){
        return (this.deckOfcards.contains(card.getRank()+" of "+ card.getSuit()));
    }

    public void removeCardsFromDeck(Card card1, Card card2){
        this.deckOfcards.remove(card1.getRank()+" of "+ card1.getSuit());
        this.deckOfcards.remove(card2.getRank()+" of "+ card2.getSuit());
    }

    public String checkWinner(Card card1, Card card2){
        if (card1.getCardValue() > card2.getCardValue()){
            return card1.getRank()+" of "+ card1.getSuit() + " wins!";
        } else if (card2.getCardValue() > card1.getCardValue()){
            return card2.getRank()+" of "+ card2.getSuit() + " wins!";
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

    public ArrayList<String> getDeckOfcards() {
        return deckOfcards;
    }

    public void setDeckOfcards(ArrayList<String> deckOfcards) {
        this.deckOfcards = deckOfcards;
    }
}
