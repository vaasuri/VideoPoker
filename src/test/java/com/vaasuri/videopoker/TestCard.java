package com.vaasuri.videopoker;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard
{

    @Test
    public void testCard()
    {
        Card card = new Card(Card.Suit.DIAMONDS, 5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBadCard() {
        Card card2 = new Card(Card.Suit.DIAMONDS, 45);
    }

    @Test
    public void testToString()
    {
        Card spadeKing = new Card(Card.Suit.SPADES, 13);
        Card diamondQueen = new Card(Card.Suit.DIAMONDS, 12);
        Card clubSeven = new Card(Card.Suit.CLUBS, 7);
        
        assertEquals("King Spades", spadeKing.toString());
        assertEquals("Queen Diamonds", diamondQueen.toString());
        assertEquals("7 Clubs", clubSeven.toString());

    }
    

}
