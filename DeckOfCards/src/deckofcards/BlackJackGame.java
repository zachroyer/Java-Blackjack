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
public class BlackJackGame extends Deck {

	// attributes
	private int nextCard = 0;

	private int playerBalance = 50;

	public static void main(String[] args) {

		BlackJackGame mainGame = new BlackJackGame("standard");

		System.out.println(mainGame.getDeck().toString());

	}

	Scanner scnr = new Scanner(System.in);

	// methods
	public BlackJackGame(String deckType) {
		super(deckType);

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

			System.out.println("Dealing cards \n.\n.\n.");



		}
	}

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
