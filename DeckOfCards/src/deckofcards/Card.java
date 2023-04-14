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
	private boolean inDealersHand = true;

	// constructor
	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	public Card(String cardFace) {
		face = cardFace;
		isJoker = true;
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
		if ("dealer".equalsIgnoreCase(hand)) {
			inDealersHand = true;
		}
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
