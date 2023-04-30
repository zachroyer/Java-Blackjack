/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deckofcards;

/**
 *
 * @author zachroyer
 */
public class Card {

	private String face;
	private String suit;
	private boolean isJoker = false;
	private boolean isFaceUp = false;
	private boolean inDealersHand;

	// constructor
	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	public Card(String cardFace) {
		face = cardFace;
		isJoker = true;
	}

	public int getValue() {

		int value = 0;
		if (isFaceUp) {
			switch (face) {
				case "Ace":
					value = 11;
					break;
				case "2":
					value = 2;
					break;
				case "3":
					value = 3;
					break;
				case "4":
					value = 4;
					break;
				case "5":
					value = 5;
					break;
				case "6":
					value = 6;
					break;
				case "7":
					value = 7;
					break;
				case "8":
					value = 8;
					break;
				case "9":
					value = 9;
					break;
				default:
					value = 10;
					break;
			}
		}
		return value;
	}

	public void flipCard() {
		this.isFaceUp = !this.isFaceUp;

	}

	public String getFaceValue() {
		if (isFaceUp) {
			return face;
		} else {
			return null;
		}
	}

	public boolean isUp() {
		return isFaceUp;
	}

	public String getSuit() {
		return this.suit;
	}

	public boolean isDealer() {
		if (inDealersHand) {
			return true;
		}
		return false;
	}

	public void assignTo(String hand) {
		if ("dealer".equals(hand)) {
			inDealersHand = true;
		} else if ("player".equals(hand))
			inDealersHand = false;
	}

	@Override
	public String toString() {
		if (isFaceUp == true) {
			if (!isJoker) {
				return face + " of " + suit;
			} else {
				return face;
			}
		} else {
			return "Card is Face Down";
		}

	}

}
