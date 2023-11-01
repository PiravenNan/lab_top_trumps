package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Suit;
import com.example.top_trumps_start_code.services.TopTrumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/toptrumps")
public class TopTrumpsController {

    @Autowired
    TopTrumpService topTrumpService;

    @GetMapping
    public String getValue(){
        Card card = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
//        String checkedWinner = topTrumpService.checkWinner(card, card2);
        return topTrumpService.checkWinner(card, card2);
    }

//
//    @PatchMapping
//    public String handleCards(@RequestBody Rank rank, Suit suit){
//        Card card = new Card(Rank.EIGHT, Suit.DIAMONDS);
//        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
//        String checkedWinner = topTrumpService.checkWinner(card, card2);
//        return checkedWinner;
//    }



}
