package com.vaasuri.videopoker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestDeck
{

    @Test
    public void testDeck()
    {
        System.out.println("running testDeck");
        Deck deck = new Deck();
        checkDeck(deck);
    }

    private void checkDeck(Deck deck)
    {
        ArrayList<Card> cards = deck.getCards();
        assertEquals("num cards", 52, cards.size());
        HashSet<Card> hashCards = new HashSet<Card>();
        hashCards.addAll(cards);
        assertEquals("num unique cards", 52, hashCards.size());
    }

    @Test
    public void testShuffle()
    {
        System.out.println("running testShuffle");
        Deck deck = new Deck();
        ArrayList<Card> originalDeck = deck.getCards();
        deck.shuffle();
        checkDeck(deck);
        ArrayList<Card> shuffledDeck = deck.getCards();
        Card card1;
        Card card2;
        for (int i = 0; i < 52; i++) {
            card1 = originalDeck.get(i);
            card2 = shuffledDeck.get(i);
            if (!card1.equals(card2))
                return;
        }
        fail("deck is not shuffled at all");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDealTooManyCards() {
        System.out.println("running testDealTooManyCards");
        Deck deck = new Deck();
        deck.dealCards(100);
    }
    
    @Test
    public void testDealCards() {
        System.out.println("running testDealCards");
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> originalDeck = deck.getCards();
        ArrayList<Card> fiveCards = deck.dealCards(5);
        for (int i = 0; i < 5; i++) {
            if (!originalDeck.get(i).equals(fiveCards.get(i)))
                fail("did not draw cards from top of the deck");
        }
    }

}
