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
public class BlackJackGame extends Hand {

	// attributes

	public BlackJackGame(String deckType, int balance) {
		super(deckType);
		balance = 50;

	}

	public static void main(String[] args) {

		BlackJackGame mainGame = new BlackJackGame("standard");

		System.out.println(mainGame.getDeck().toString());

	}
}

