package com.vaasuri.videopoker;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestResult
{

    @Test
    public void testResult()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 10));
        hand.add(new Card(Card.Suit.CLUBS, 10));
        hand.add(new Card(Card.Suit.DIAMONDS, 13));
        hand.add(new Card(Card.Suit.HEARTS, 2));
        hand.add(new Card(Card.Suit.SPADES, 7));
        
        Result result = new Result(hand);
        
        assertEquals("winType", Result.WinType.NOWIN.name(), result.getWinType().name());
        assertEquals("winnings", 0, result.getWinnings());
        
    }

    @Test
    public void testIsRoyalFlush()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.SPADES, 11));
        hand.add(new Card(Card.Suit.SPADES, 12));
        hand.add(new Card(Card.Suit.SPADES, 13));
        hand.add(new Card(Card.Suit.SPADES, 10));
        
        Result result = new Result(hand);
        
        assertEquals("winType", Result.WinType.ROYALFLUSH.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.ROYALFLUSH.ordinal()], result.getWinnings());
    }

    @Test
    public void testIsStraightFlush()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.SPADES, 2));
        hand.add(new Card(Card.Suit.SPADES, 5));
        hand.add(new Card(Card.Suit.SPADES, 3));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        Result result = new Result(hand);
        
        assertEquals("winType", Result.WinType.STRAIGHTFLUSH.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.STRAIGHTFLUSH.ordinal()], result.getWinnings());
    }

    @Test
    public void testIsFourOfAKind()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.CLUBS, 1));
        hand.add(new Card(Card.Suit.HEARTS, 1));
        hand.add(new Card(Card.Suit.DIAMONDS, 1));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        ArrayList<Card> hand2 = new ArrayList<Card>();
        hand2.add(new Card(Card.Suit.SPADES, 1));
        hand2.add(new Card(Card.Suit.CLUBS, 4));
        hand2.add(new Card(Card.Suit.HEARTS, 4));
        hand2.add(new Card(Card.Suit.DIAMONDS, 4));
        hand2.add(new Card(Card.Suit.SPADES, 4));
        
        Result result = new Result(hand);
        Result result2 = new Result(hand2);
        
        assertEquals("winType", Result.WinType.FOUROFAKIND.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.FOUROFAKIND.ordinal()], result.getWinnings());
        
        assertEquals("winType", Result.WinType.FOUROFAKIND.name(), result2.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.FOUROFAKIND.ordinal()], result2.getWinnings());
    }

    @Test
    public void testIsFullHouse()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.CLUBS, 1));
        hand.add(new Card(Card.Suit.HEARTS, 1));
        hand.add(new Card(Card.Suit.DIAMONDS, 4));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        ArrayList<Card> hand2 = new ArrayList<Card>();
        hand2.add(new Card(Card.Suit.SPADES, 4));
        hand2.add(new Card(Card.Suit.CLUBS, 4));
        hand2.add(new Card(Card.Suit.HEARTS, 4));
        hand2.add(new Card(Card.Suit.DIAMONDS, 1));
        hand2.add(new Card(Card.Suit.SPADES, 1));
        
        Result result = new Result(hand);
        Result result2 = new Result(hand2);
        
        assertEquals("winType", Result.WinType.FULLHOUSE.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.FULLHOUSE.ordinal()], result.getWinnings());
        
        assertEquals("winType", Result.WinType.FULLHOUSE.name(), result2.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.FULLHOUSE.ordinal()], result2.getWinnings());
    }

    @Test
    public void testIsFlush()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.SPADES, 4));
        hand.add(new Card(Card.Suit.SPADES, 7));
        hand.add(new Card(Card.Suit.SPADES, 10));
        hand.add(new Card(Card.Suit.SPADES, 5));
        
        Result result = new Result(hand);
        
        assertEquals("winType", Result.WinType.FLUSH.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.FLUSH.ordinal()], result.getWinnings());
    }

    
    // Test for if hand is a straight
    @Test
    public void testIsStraight()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.HEARTS, 2));
        hand.add(new Card(Card.Suit.CLUBS, 5));
        hand.add(new Card(Card.Suit.DIAMONDS, 3));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        Result result = new Result(hand);
        
        assertEquals("winType", Result.WinType.STRAIGHT.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.STRAIGHT.ordinal()], result.getWinnings());
    }

    @Test
    public void testIsThreeOfAKind()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 5));
        hand.add(new Card(Card.Suit.CLUBS, 1));
        hand.add(new Card(Card.Suit.HEARTS, 1));
        hand.add(new Card(Card.Suit.DIAMONDS, 1));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        ArrayList<Card> hand2 = new ArrayList<Card>();
        hand2.add(new Card(Card.Suit.SPADES, 5));
        hand2.add(new Card(Card.Suit.CLUBS, 6));
        hand2.add(new Card(Card.Suit.HEARTS, 4));
        hand2.add(new Card(Card.Suit.DIAMONDS, 4));
        hand2.add(new Card(Card.Suit.SPADES, 4));
        
        Result result = new Result(hand);
        Result result2 = new Result(hand2);
        
        assertEquals("winType", Result.WinType.THREEOFAKIND.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.THREEOFAKIND.ordinal()], result.getWinnings());
        
        assertEquals("winType", Result.WinType.THREEOFAKIND.name(), result2.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.THREEOFAKIND.ordinal()], result2.getWinnings());
    }

    @Test
    public void testIsTwoPair()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.CLUBS, 1));
        hand.add(new Card(Card.Suit.HEARTS, 3));
        hand.add(new Card(Card.Suit.DIAMONDS, 4));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        ArrayList<Card> hand2 = new ArrayList<Card>();
        hand2.add(new Card(Card.Suit.SPADES, 4));
        hand2.add(new Card(Card.Suit.CLUBS, 5));
        hand2.add(new Card(Card.Suit.HEARTS, 5));
        hand2.add(new Card(Card.Suit.DIAMONDS, 1));
        hand2.add(new Card(Card.Suit.SPADES, 1));
        
        Result result = new Result(hand);
        Result result2 = new Result(hand2);
        
        assertEquals("winType", Result.WinType.TWOPAIR.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.TWOPAIR.ordinal()], result.getWinnings());
        
        assertEquals("winType", Result.WinType.TWOPAIR.name(), result2.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.TWOPAIR.ordinal()], result2.getWinnings());
    }

    @Test
    public void testIsJacksOrBetter()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Card.Suit.SPADES, 1));
        hand.add(new Card(Card.Suit.HEARTS, 2));
        hand.add(new Card(Card.Suit.CLUBS, 11));
        hand.add(new Card(Card.Suit.DIAMONDS, 11));
        hand.add(new Card(Card.Suit.SPADES, 4));
        
        ArrayList<Card> hand2 = new ArrayList<Card>();
        hand2.add(new Card(Card.Suit.SPADES, 12));
        hand2.add(new Card(Card.Suit.CLUBS, 5));
        hand2.add(new Card(Card.Suit.HEARTS, 3));
        hand2.add(new Card(Card.Suit.DIAMONDS, 12));
        hand2.add(new Card(Card.Suit.SPADES, 1));
        
        Result result = new Result(hand);
        Result result2 = new Result(hand2);
        
        assertEquals("winType", Result.WinType.JACKSORBETTER.name(), result.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.JACKSORBETTER.ordinal()], result.getWinnings());
        
        assertEquals("winType", Result.WinType.JACKSORBETTER.name(), result2.getWinType().name());
        assertEquals("winnings", Result.WINNING_ODDS[Result.WinType.JACKSORBETTER.ordinal()], result2.getWinnings());
    }

}
