package deckofcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

enum SUIT {
	HEART, SPADE, DIAMOND, CLUBS
};

enum RANK {
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
};

public class DeckOfCard {

	private ArrayList<Card> cards;
	private ArrayList<Player> players;

	public DeckOfCard(int no_players) {

		// initilaize deck of cards
		cards = new ArrayList<>();
		players = new ArrayList<>();
		for (SUIT suit : SUIT.values()) {
			for (RANK rank : RANK.values())
				cards.add(new Card(suit, rank));
		}

		for (int i = 0; i < no_players; i++) {
			players.add(new Player("Player" + i + 1));
		}

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void deal() {
		int n = players.size();
		int i = 0;
		for (Card card : cards) {
			players.get(i % n).listOfCards.add(card);
		}
	}

}
