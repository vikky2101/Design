package deckofcards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {

  String name;
  List<Card> listOfCards;

  public Player(String name) {
    this.name = name;
    listOfCards = new ArrayList<>();
  }

}
