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
	private boolean inPlayerHand = false;
	private boolean outOfPlay = false;
	//constructor
	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	public Card(String cardFace) {
		face = cardFace;
		isJoker = true;
	}

	public void flipCard() {
		this.isFaceUp ^= this.isFaceUp;

	}

	public String getFaceValue() {
		if (isFaceUp == true) {
			return face;
		} else if (isFaceUp == false) {
			return null;
		}
		return null;
	}

	public String getSuit() {
		return this.suit;
	}

	public boolean isDealer() {
		return inDealersHand;
	}
	
	public boolean isPlayer() {
		return inPlayerHand;
	}

	@Override
	public String toString() {
		if (isFaceUp == true) {
			if (isJoker == false) {
				return face + " of " + suit;
			} else {
				return face;
			}
		} else {
			return "Card is Face Down";
		}

	}

}
