package deckofcards;

public class Player {
    private int balance;

    public Player(int startingBalance) {
       balance = startingBalance; 
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void updateToBalance(int bet) {
        this.balance += bet;
    }

    public int getBalance() {
        return this.balance;
    }
}
