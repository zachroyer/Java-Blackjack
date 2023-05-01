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
public class BlackJackGame {

	// attributes

	private static Hand hand;
	private static int lastCardIndex;

	public static void main(String[] args) {
		Deck deck = new Deck("standard");
		deck.shuffle();

		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter your starting balance: $");
		int balance = scnr.nextInt();
		hand = new Hand(deck, balance, 0);

		int totalCardsDealt = 0;
		if (totalCardsDealt >= 34) {
			hand = new Hand(deck, balance, 0);
		}
		while (balance > 0) {

			System.out.println("\nYour current balance is: $" + hand.getPlayer().getBalance());
			System.out.println("Do you want to play again? (y/n)");
			String playAgain = scnr.nextLine();
			if (playAgain.equalsIgnoreCase("n")) {
				System.out.println("Thanks for playing! You won $" + balance);
				break;
			}

			hand = new Hand(deck, hand.getPlayer().getBalance(), hand.getNextCard());
		}
	}

}
