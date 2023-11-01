package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Suit;
import com.example.top_trumps_start_code.services.TopTrumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/toptrumps")
public class TopTrumpsController {

    @Autowired
    TopTrumpService topTrumpService;

    @GetMapping
    public ArrayList<String> getGameStarted(){
        topTrumpService.startNewGame();
        return topTrumpService.getDeckOfcards();
    }

    @PatchMapping
    public String handleCards(@RequestBody ArrayList<Card> cardList){
        Boolean isCard1 = topTrumpService.isCardStillInDeck(cardList.get(0));
        Boolean isCard2 = topTrumpService.isCardStillInDeck(cardList.get(1));
        if (isCard1 && isCard2 ){
            topTrumpService.removeCardsFromDeck(cardList.get(0),cardList.get(1));
            return topTrumpService.checkWinner(cardList.get(0), cardList.get(1));
        }else{
            String errorMessage = "";
            if (!isCard1){
                errorMessage += cardList.get(0).getRank()+" of "+ cardList.get(0).getSuit() + " is not in deck ";
            }else{
            }
            if (!isCard2){
                errorMessage += cardList.get(1).getRank()+" of "+ cardList.get(1).getSuit() + " is not in deck ";
            }
            return errorMessage;
        }
    }




}
