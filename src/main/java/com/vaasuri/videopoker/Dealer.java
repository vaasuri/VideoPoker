package com.vaasuri.videopoker;

public class Dealer
{
    
    
    private User user;
    private Deck deck;

    public Dealer(User user, Deck deck)
    {
        this.user = user;
        this.deck = deck;
    }

    public void deal()
    {
        deck.shuffle();
        user.receiveHand(deck.dealCards(5));
        
    }

    public void reDeal(int[] replaceCards)
    {
        if (replaceCards == null)
            throw new IllegalArgumentException("bad argument");
        if (replaceCards.length == 0)
            return;
        if (replaceCards.length > 5)
            throw new IllegalArgumentException("attempting to replace too many cards");
        for (int index : replaceCards) {
            user.replaceCardOnHand(index, deck.dealSingleCard());
        }
    }

    public Result computeResult()
    {
        return new Result(user.getHand());
    }


    public void updateUserBalance(Result result)
    {
        int balance = user.getBalance();
        if (result.getWinType() == Result.WinType.NOWIN)
            balance -= 1;
        else
            balance += result.getWinnings();
        user.setBalance(balance);
        
    }

}
