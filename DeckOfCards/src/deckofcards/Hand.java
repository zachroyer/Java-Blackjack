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

	private int nextCard;
	private int lastCardIndex;
	private Player player;
	int bet;
	Scanner scnr = new Scanner(System.in);

	// METHODS

	public Hand(Deck deckType, int balance, int lastCard) {
		super(deckType.getDeckType());
		nextCard = lastCardIndex;
		lastCardIndex = lastCard;
		player = new Player(balance);
		System.out.println(lastCardIndex);
		System.out.println(lastCard);
		this.shuffle();
		this.shuffle();

		System.out.println("Your Balance is : $" + player.getBalance());
		if (player.getBalance() > balance) {
			System.out.println("Would you like to Cash Out? \n Yes or No?");
			String cashout = scnr.nextLine();
			if ("yes".equalsIgnoreCase(cashout)) {
				System.out.println("You won $" + player.getBalance() + "! Thanks for playing!");
				System.exit(0);
			}
		}

		int choice;
		do {
			System.out.println("Press p to play...");
			choice = awaitPlayerInput();
		} while (choice != 0 && choice != 2);
	}

	public int getNextCard() {
		return this.nextCard;
	}

	// Recursive method for calling methods to play the game
	// Very proud of this one
	private int awaitPlayerInput() {
		String input = scnr.nextLine().toLowerCase();
		switch (input) {
			case "p":
				System.out.println("Place Your Bet:");
				bet = scnr.nextInt();
				while (bet > player.getBalance()) {
					System.out.println("Bet cannot be higher than your balance\n Place Your Bet:");
					bet = scnr.nextInt();
				}

				System.out.println("\nDealing cards \n.\n.\n.");

				dealNextCard("player", true).toString();
				dealNextCard("dealer", true).toString();
				dealNextCard("player", true).toString();
				Card dealerFacedown = dealNextCard("dealer", false);
				dealerFacedown.toString();

				System.out.println(displayDealerHand());
				System.out.println("Dealer's hand is worth: " + getHandValue("dealer") + "\n");

				System.out.println(displayPlayerHand());
				System.out.println("Player's hand is worth: " + getHandValue("player") + "\n");

				if (getHandValue("player") == 21) {
					player.updateToBalance(bet * 2);
					System.out.println("You won the round! You win $" + bet + "!");

				}
				while (getHandValue("player") < 21) {
					System.out.println("Press 'h' to hit, or 's' to stay: ");
					int stay = awaitPlayerInput();
					if (stay == 2) {
						break;
					}
				}

				dealerFacedown.flipCard();

				while (getHandValue("dealer") < 17) {
					dealNextCard("dealer", false);
					displayDealerHand();

				}

				return 0;
			case "h":
				hit();
				return 0;

			case "s":
				return 2;
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
				player.updateToBalance(bet * -1);
				System.out.println("You bust! You lose $" + bet + "!");
			}
		} else {
			player.updateToBalance(bet * 2);
			System.out.println("You won the round! You win $" + bet + "!");
		}
	}

	private String displayDealerHand() {
		StringBuilder dealerHand = new StringBuilder();
		dealerHand.append("\n");
		for (int i = lastCardIndex; i < nextCard; i++) {
			if ((getCard(i).isDealer())) {
				dealerHand.append(getCard(i).toString() + "\n");
			}
		}
		return "Dealer's Hand: " + dealerHand;
	}

	private String displayPlayerHand() {
		StringBuilder playerHand = new StringBuilder();
		playerHand.append("\n");
		for (int i = lastCardIndex; i < nextCard; i++) {
			if (!(getCard(i).isDealer())) {
				playerHand.append(getCard(i).toString() + "\n");

			}
		}
		return "Player's Hand: " + playerHand;
	}

	private Card dealNextCard(String owner, boolean faceUp) {
		this.getCard(nextCard).assignTo(owner);
		if (faceUp && (!this.getCard(nextCard).isUp())) {
			this.getCard(nextCard).flipCard();
		}
		int temp = nextCard;
		nextCard += 1;

		return this.getCard(temp);
	}

	public int getHandValue(String owner) {
		int value = 0;
		int numAces = 0;

		if ("player".equalsIgnoreCase(owner)) {
			for (int i = lastCardIndex; i < nextCard; i++) {
				if (!(getCard(i).isDealer())) {
					int cardValue = getCard(i).getValue();
					if (cardValue == 11) {
						numAces++;
					}
					value += cardValue;
				}
			}
		} else if ("dealer".equalsIgnoreCase(owner)) {

			for (int i = lastCardIndex; i < nextCard; i++) {
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

	public Player getPlayer() {
		return this.player;
	}
}
