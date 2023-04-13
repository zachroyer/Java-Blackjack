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
import java.util.ArrayList;

public class Hand extends Deck {
	// ATTRIBUTES

	int nextCard;
	private int playerBalance;  //make a setter for the balance 

	Scanner scnr = new Scanner(System.in);

	// METHODS

	public Hand (String deckType) {	
		super(deckType);
		nextCard = 0;	


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




	}}

	//Push Method

	private StringBuilder displayDealerHand() {
		StringBuilder dealerHand = new StringBuilder();
		for (int i = 0; i <= nextCard; i++) {
			if ((getCard(i).isDealer())) {
				dealerHand = dealerHand.append(getCard(i).toString());

			}
		}
		return dealerHand;
	}

	private StringBuilder displayPlayerHand() {
		StringBuilder playerHand = new StringBuilder();
		for (int i = 0; i < nextCard; i++) {
			if ((!getCard(i).isDealer())) {
				playerHand = playerHand.append(getCard(i).toString());

			}
		}
		return playerHand;
	}

	private String dealNextCard(String owner) {
		this.getCard(nextCard).assignTo(owner);
		this.getCard(nextCard).flipCard();
		int temp = nextCard;
		nextCard += 1;
		return this.getCard(temp).toString();
	}
}

}
