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

	//attributes
	private int nextCard = 0;

	public static void main(String[] args) {

		BlackJackGame mainGame = new BlackJackGame("standard");

		System.out.println(mainGame.getDeck().toString());
	}
	Scanner scnr = new Scanner(System.in);

	//methods
	public BlackJackGame(String deckType) {
		super(deckType);

		this.shuffle();

		System.out.println("Press p to play the game");
		String temp = scnr.nextLine();

		if ("p".equals(temp)) {
			System.out.println("Dealing cards .");
			System.out.println(".");
			System.out.println(".");
			System.out.println(".");
			System.out.println(".");

			displayDealerHand();
			displayPlayerHand();
		}
	}

	private String displayDealerHand() {
		String dealerHand = "";
		for (int i = 0; i < nextCard; i++) {
			if (i != (nextCard - 1)) {
				if (getCard(i).isDealer() == true) {
					dealerHand = dealerHand + (getCard(i).toString());
				}
			}
		}
		return dealerHand;
	}

	private String displayPlayerHand() {
		String playerHand = "";
		for (int i = 0; i < nextCard; i++) {
			if (i != (nextCard - 1)) {
				if(getCard(i).isPlayer() == true) {
					playerHand = playerHand + (getCard(i).toString());
				}	
			}
		}
		return playerHand;
	}
}
