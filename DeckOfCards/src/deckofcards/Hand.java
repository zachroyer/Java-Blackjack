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
		playerBalance = balance;

		this.shuffle();
		this.shuffle();

		System.out.println("Press p to play...");
		String temp = scnr.nextLine();

		if ("p".equals(temp)) {
			System.out.println("Place Your Bet:");
			String bet = scnr.nextLine();
			while (Integer.parseInt(bet) > playerBalance) {
				System.out.println("Bet cannot be higher than your balance\n Place Your Bet:");
				bet = scnr.nextLine();
			}

			System.out.println("\nDealing cards \n.\n.\n.");

			// dealNextCard("dealer", true);
			dealNextCard("player", true);

			// dealNextCard("dealer", false);
			dealNextCard("player", true);

			System.out.println(displayDealerHand());
			System.out.println(displayPlayerHand());

		}
	}

	// Push Method

	private String displayDealerHand() {
		StringBuilder dealerHand = new StringBuilder();
		for (int i = 0; i <= nextCard; i++) {
			if ((getCard(i).isDealer())) {
				dealerHand = dealerHand.append(getCard(i).toString());

			}
		}
		return "Dealer's Hand: " + dealerHand;
	}

	private String displayPlayerHand() {
		StringBuilder playerHand = new StringBuilder();
		for (int i = 0; i < nextCard; i++) {
			if (!(getCard(i).isDealer())) {
				playerHand = playerHand.append(getCard(i).toString());

			}
		}
		return "Player's Hand: " + playerHand;
	}

	private String dealNextCard(String owner, boolean faceUp) {
		this.getCard(nextCard).assignTo(owner);
		if (faceUp &&  (!this.getCard(nextCard).isUp())) {
				this.getCard(nextCard).flipCard();
			
		}
		int temp = nextCard;
		System.out.println(nextCard);
		nextCard += 1;
		return this.getCard(temp).toString();
	}
}
