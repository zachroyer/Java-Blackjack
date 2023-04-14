/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deckofcards;

/**
 *
 * @author zachroyer
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	Random rand = new Random();
	private String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
	private String[] face = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "King", "Queen", "Jack"};
	private final int[] pinochleFaces = {0, 8, 9, 10, 11, 12};
	private ArrayList<Card> cardDeck = new ArrayList<>();

	/**
	 *
	 * @param deckType
	 */
	public Deck(String deckType) {
		if (deckType.equalsIgnoreCase("Standard")) {
			standardDeck();
		}

		if (deckType.equalsIgnoreCase("Pinochle")) {
			pinochleDeck();
		}

		if (deckType.equalsIgnoreCase("Canasta")) {
			canastaDeck();
		}
	}

	public List<Card> getDeck() {
		return this.cardDeck;
	}

	public Card getCard(int index) {
		return this.cardDeck.get(index);
	}

	private void standardDeck() {
		for (String face1 : face) {
			if (!"Joker".equals(face1)) {
				for (int p = 0; p <= 3; p++) {
					cardDeck.add(new Card(face1, suits[p]));
				}
			} else {
				cardDeck.add(new Card(face1));
			}
		}
	}

	private void pinochleDeck() {
		for (int pin : pinochleFaces) {
			for (int p = 0; p <= 3; p++) {
				cardDeck.add(new Card(face[pin], suits[p]));
				cardDeck.add(new Card(face[pin], suits[p]));
			}
		}
	}

	private void canastaDeck() {
		for (String face1 : face) {
			if (!"Joker".equals(face1)) {
				for (int p = 0; p <= 3; p++) {
					cardDeck.add(new Card(face1, suits[p]));
					cardDeck.add(new Card(face1, suits[p]));
				}
			} else {
				for (int i = 0; i <= 3; i++) {
					cardDeck.add(new Card(face1));
				}
			}
		}
	}

	@Override
	public String toString() {
		String deckToString = "";
		for (Card i : cardDeck) {
			for (int l = 0; l > 3; l++) {
				if (i != cardDeck.get(cardDeck.size() - 1)) {
					deckToString = deckToString.concat(" " + i.toString() + ",");
				} else {

					deckToString = deckToString.concat(" " + i.toString());
				}

					deckToString = deckToString.concat("\n");
			}

		}
		return deckToString;
//	}
//
//	public void removeJokers() {
//		for (Card i : deck) {
//			if (i.getFaceValue() == "Joker") {
//
//				deck.remove(i);
//			}
//		}
	}

	public void shuffle() {
		for (Card i : this.cardDeck) {
			int randomIndex = rand.nextInt(cardDeck.size());
			Card temp = cardDeck.get(randomIndex);
			cardDeck.set(randomIndex, (i));
			cardDeck.set(cardDeck.indexOf(i), temp);
		}

	}
}
