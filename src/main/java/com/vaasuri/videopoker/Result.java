package com.vaasuri.videopoker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Result
{
    public static int[] WINNING_ODDS = {0, 250, 50, 25, 9, 6, 4, 3, 2, 1};
    
    enum WinType {
        NOWIN, ROYALFLUSH, STRAIGHTFLUSH, FOUROFAKIND, FULLHOUSE, FLUSH, STRAIGHT, THREEOFAKIND, TWOPAIR, JACKSORBETTER;
    }
    
    private WinType winType;
    private ArrayList<Card> hand;
    private int winnings;
    
    public Result(ArrayList<Card> hand) {
        if (hand.size() != 5)
            throw new IllegalArgumentException("Invalid number of cards in hand");
        this.hand = hand;
        
        if (isRoyalFlush())
            winType = WinType.ROYALFLUSH;
        else if (isStraightFlush())
            winType = WinType.STRAIGHTFLUSH;
        else if (isFourOfAKind())
            winType = WinType.FOUROFAKIND;
        else if (isFullHouse())
            winType = WinType.FULLHOUSE;
        else if (isFlush())
            winType = WinType.FLUSH;
        else if (isStraight())
            winType = WinType.STRAIGHT;
        else if (isThreeOfAKind())
            winType = WinType.THREEOFAKIND;
        else if (isTwoPair())
            winType = WinType.TWOPAIR;
        else if (isJacksOrBetter())
            winType = WinType.JACKSORBETTER;
        else
            winType = WinType.NOWIN;
        
        winnings = WINNING_ODDS[winType.ordinal()];
    }
    
    public static class cardComparator implements Comparator<Card> {

        @Override
        public int compare(Card card1, Card card2)
        {
            if (card1.getNumber() == card2.getNumber())
                return card1.getSuit().ordinal() - card2.getSuit().ordinal();
            else
                return card1.getNumber() - card2.getNumber();
        }
        
    }
    
    public boolean isRoyalFlush() {
        Card.Suit suit = hand.get(0).getSuit();
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        int cardNumber = 1;
        for (Card card : sortedCards) {
            if (card.getSuit() != suit || card.getNumber() != cardNumber)
                return false;
            if (cardNumber == 1)
                cardNumber = 10;
            else
                cardNumber++;
        }
        
        return true;
    }
    
    public boolean isStraightFlush() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        Card.Suit suit = sortedCards.first().getSuit();
        int cardNumber = sortedCards.first().getNumber();

        for (Card card : sortedCards) {
            if (card.getSuit() != suit || card.getNumber() != cardNumber)
                return false;
                
            cardNumber++;
        }
        
        return true;
    }
    
    public boolean isFourOfAKind() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        
        int previousCardNumber = sortedCards.first().getNumber();
        sortedCards.remove(sortedCards.first());
        int similarCount = 1;

        for (Card card : sortedCards) {
            int cardNumber = card.getNumber();
            if (cardNumber == previousCardNumber)
                similarCount++;
            else
                similarCount = 1;
            if (similarCount == 4)
                break;
            previousCardNumber = cardNumber;
        }
        
        return (similarCount == 4);
    }
    
    public boolean isFullHouse() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        
        Card card1 = sortedCards.pollFirst();
        Card card2 = sortedCards.pollFirst();
        Card card3 = sortedCards.pollFirst();
        Card card4 = sortedCards.pollFirst();
        Card card5 = sortedCards.pollFirst();
        
        if ((card1.getNumber() == card2.getNumber()) &&
                (card2.getNumber() == card3.getNumber())) {
            return (card4.getNumber() == card5.getNumber());
        }
        else if (card1.getNumber() == card2.getNumber()) {
            return ((card3.getNumber() == card4.getNumber()) && 
                    (card4.getNumber() == card5.getNumber()));            
        }
        
        return false;
    }
    
    public boolean isFlush() {
        Card.Suit suit = hand.get(0).getSuit();
        
        for (Card card : hand) {
            if (card.getSuit() != suit)
                return false;
        }
        
        return true;
        
    }
    
    public boolean isStraight() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        int cardNumber = sortedCards.first().getNumber();
        for (Card card : sortedCards) {
            if (card.getNumber() != cardNumber)
                return false;               
            cardNumber++;
        }
        
        return true;
        
    }
    
    public boolean isThreeOfAKind() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        
        int previousCardNumber = sortedCards.first().getNumber();
        sortedCards.remove(sortedCards.first());
        int similarCount = 1;

        for (Card card : sortedCards) {
            int cardNumber = card.getNumber();
            if (cardNumber == previousCardNumber)
                similarCount++;
            else
                similarCount = 1;
            if (similarCount == 3)
                break;
            previousCardNumber = cardNumber;
        }
        
        return (similarCount == 3);
        
    }
    
    public boolean isTwoPair() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        
        Card card1 = sortedCards.pollFirst();
        Card card2 = sortedCards.pollFirst();
        Card card3 = sortedCards.pollFirst();
        Card card4 = sortedCards.pollFirst();
        Card card5 = sortedCards.pollFirst();
        
        if ((card1.getNumber() == card2.getNumber()) && card3.getNumber() == card4.getNumber()) {
            return true;
        }
        else if (card1.getNumber() == card2.getNumber() && 
                (card4.getNumber() == card5.getNumber())) {
            return true;            
        }
        else if (card2.getNumber() == card3.getNumber() && card4.getNumber() == card5.getNumber()) {
            return true;
        }
        
        return false;
        
    }
    
    public boolean isJacksOrBetter() {
        TreeSet<Card> sortedCards = new TreeSet<Card>(new cardComparator());
        sortedCards.addAll(hand);
        
        Card card1 = sortedCards.pollFirst();
        Card card2 = sortedCards.pollFirst();
        Card card3 = sortedCards.pollFirst();
        Card card4 = sortedCards.pollFirst();
        Card card5 = sortedCards.pollFirst();
        
        if ((card1.getNumber() == card2.getNumber()) && card1.getNumber() >= 11) {
            return true;
        }
        else if (card2.getNumber() == card3.getNumber() && card2.getNumber() >= 11) {
            return true;            
        }
        else if (card3.getNumber() == card4.getNumber() && card3.getNumber() >= 11) {
            return true;
        }
        else if (card4.getNumber() == card5.getNumber() && card4.getNumber() >= 11)
            return true;
        
        return false;
    }

    public WinType getWinType()
    {
        return winType;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public int getWinnings()
    {
        return winnings;
    }
    
    
}
