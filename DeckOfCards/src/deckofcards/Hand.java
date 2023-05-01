/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deckofcards;

import java.util.Scanner;

/**
 *
 * @author zachroyer
 */

public class Hand extends Deck {
	// ATTRIBUTES

	int nextCard;
	private int playerBalance;
	Scanner scnr = new Scanner(System.in);

	// METHODS

	public Hand(String deckType, int balance) {
		super(deckType);
		nextCard = 0;
		player = new 
		playerBalance = balance;

		this.shuffle();
		this.shuffle();

		System.out.println("Your Balance is : $" + playerBalance);
		if (playerBalance > balance) {
			System.out.println("Would you like to Cash Out? \n Yes or No?");
			String cashout = scnr.nextLine();
			if ("yes".equalsIgnoreCase(cashout)) {
				System.out.println("You won $" + playerBalance + "! Thanks for playing!");
				System.exit(0);
			}
		}
		System.out.println("Press p to play...");

		awaitPlayerInput();



	}

	// Recursive method for calling methods to play the game
	// Very proud of this one
	private boolean awaitPlayerInput() {
		String input = scnr.nextLine().toLowerCase();
		switch (input) {
			case "p":
				System.out.println("Place Your Bet:");
				String bet = scnr.nextLine();
				while (Integer.parseInt(bet) > playerBalance) {
					System.out.println("Bet cannot be higher than your balance\n Place Your Bet:");
					bet = scnr.nextLine();
				}

				System.out.println("\nDealing cards \n.\n.\n.");

				dealNextCard("player", true);
				dealNextCard("dealer", true);
				dealNextCard("player", true);
				dealNextCard("dealer", false);

				System.out.println(displayDealerHand());
				System.out.println("Dealer's hand is worth: " + getHandValue("dealer") + "\n");

				System.out.println(displayPlayerHand());
				System.out.println("Player's hand is worth: " + getHandValue("player") + "\n");

				while (getHandValue("player") < 21) {
					System.out.println("Press 'h' to hit, or 's' to stay: ");
					boolean stay = awaitPlayerInput();
					if (stay) {
						break;
					}
				}

				return true;
			case "h":
				hit();
				return false;

			case "s":
				return true;
			default:
				return awaitPlayerInput();
		}

	}

	// Hit Method
	private void hit() {
		if (getHandValue("player") != 21) {
			dealNextCard("player", true);
			System.out.println(displayPlayerHand());
			System.out.println("Player's hand is worth: " + getHandValue("player") + "\n");
			if (getHandValue("player") > 21) {
				player.subtracFromBalance(bet);
			}
		}
	}

	private String displayDealerHand() {
		StringBuilder dealerHand = new StringBuilder();
		dealerHand.append("\n");
		for (int i = 0; i < nextCard; i++) {
			if ((getCard(i).isDealer())) {
				dealerHand.append(getCard(i).toString() + "\n");
			}
		}
		return "Dealer's Hand: " + dealerHand;
	}

	private String displayPlayerHand() {
		StringBuilder playerHand = new StringBuilder();
		playerHand.append("\n");
		for (int i = 0; i < nextCard; i++) {
			if (!(getCard(i).isDealer())) {
				playerHand = playerHand.append(getCard(i).toString() + "\n");

			}
		}
		return "Player's Hand: " + playerHand;
	}

	private String dealNextCard(String owner, boolean faceUp) {
		this.getCard(nextCard).assignTo(owner);
		if (faceUp && (!this.getCard(nextCard).isUp())) {
			this.getCard(nextCard).flipCard();
		}

		int temp = nextCard;
		nextCard += 1;
		return this.getCard(temp).toString();
	}

	public int getHandValue(String owner) {
		int value = 0;
		int numAces = 0;

		if ("player".equalsIgnoreCase(owner)) {
			for (int i = 0; i < nextCard; i++) {
				if (!(getCard(i).isDealer())) {
					int cardValue = getCard(i).getValue();
					if (cardValue == 11) {
						numAces++;
					}
					value += cardValue;
				}
			}
		} else if ("dealer".equalsIgnoreCase(owner)) {

			for (int i = 0; i < nextCard; i++) {
				if ((getCard(i).isDealer())) {
					int cardValue = getCard(i).getValue();
					if (cardValue == 11) {
						numAces++;
					}
					value += cardValue;
				}
			}
		}

		while (numAces > 0 && value > 21) {
			value -= 10;
			numAces--;
		}
		return value;

	}
}
