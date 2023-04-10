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
import java.util.Random;
import java.util.Collections;

public class Deck {

	Random rand = new Random();
	public String suits[] = {"Hearts", "Spades", "Clubs", "Diamonds"};
	public String face[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "King", "Queen", "Jack"};
	private final int pinochleFaces[] = {0, 8, 9, 10, 11, 12};
	private ArrayList<Card> deck = new ArrayList<>();

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

	public ArrayList<Card> getDeck() {
		return this.deck;
	}

	public Card getCard(int index) {
		return this.deck.get(index);
	}

	private void standardDeck() {
		for (String face1 : face) {
			if (!"Joker".equals(face1)) {
				for (int p = 0; p <= 3; p++) {
					deck.add(new Card(face1, suits[p]));
				}
			} else {
				deck.add(new Card(face1));
			}
		}
	}

	private void pinochleDeck() {
		for (int pin : pinochleFaces) {
			for (int p = 0; p <= 3; p++) {
				deck.add(new Card(face[pin], suits[p]));
				deck.add(new Card(face[pin], suits[p]));
			}
		}
	}

	private void canastaDeck() {
		for (String face1 : face) {
			if (!"Joker".equals(face1)) {
				for (int p = 0; p <= 3; p++) {
					deck.add(new Card(face1, suits[p]));
					deck.add(new Card(face1, suits[p]));
				}
			} else {
				for (int i = 0; i <= 3; i++) {
					deck.add(new Card(face1));
				}
			}
		}
	}

	@Override
	public String toString() {
		//return cards in deck
		String deckToString = "";
		for (Card i : deck) {
			for (int l = 0; l > 3; l++) {
				if (i != deck.get(deck.size() - 1)) {
					deckToString = deckToString.concat(" " + i.toString() + ",");
				} else {

					deckToString = deckToString.concat(" " + i.toString());
				}

					deckToString = deckToString.concat("\r");
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
		for (Card i : this.deck) {
			int randomIndex = rand.nextInt(deck.size());
			Card temp = deck.get(randomIndex);
			deck.set(randomIndex, (i));
			deck.set(deck.indexOf(i), temp);
		}

	}
}
