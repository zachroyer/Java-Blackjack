/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deckofcards;

import java.util.Collections;

/**
 *
 * @author zachroyer
 */
public class DeckOfCards {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Deck standardSample = new Deck("standard");
		Deck pinochleSample = new Deck("pinochle");
		Deck canastaSample = new Deck("canasta");

		System.out.println(standardSample.toString());
		System.out.println("");
		standardSample.shuffle();
		System.out.println(standardSample.toString());
		System.out.println("");
		System.out.println(pinochleSample.toString());
		System.out.println("");
		pinochleSample.shuffle();
		System.out.println(canastaSample.toString());
		System.out.println("");
		canastaSample.shuffle();
		System.out.println(canastaSample.toString());
	}
}
