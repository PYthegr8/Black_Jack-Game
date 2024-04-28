/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description: This program creates a Deck, which hold a set of cards and be able to shuffle and deal the cards. There is a Deck method 
                that generates an arraylist and calls the build() method to generate a standard 52 card deck. There is a size method to get the size of the deck.
                There is a deal method to return the top card(position0). There is also a shuffle method to put the deck in a uniformly random order. I used the fisher-Yates
                algorithm for that. I finally used the toString to display the contents of the deck in a nice format
 */



import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    private ArrayList<Card> deck;
    public Deck() {
        deck = new  ArrayList<Card>();
        build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {

        for (int i = 2; i <= 9; i++) {

            for (int j = 0; j < 4; j++) {
                Card cd = new Card(i);
                deck.add(cd);

            }
        }

        for (int i =0; i<4; i++){
            Card cd = new Card(11);
            deck.add(cd);
        }

        for (int i = 0; i < 16;i++){
            Card cd = new Card(10);
            deck.add(cd);
        }
        
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        return deck.remove(0);
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        
        Random rand = new Random();
        int rdm_idx;
        Card temp;
        for (int i = deck.size() - 1; i >= 0; i--) {
            rdm_idx = rand.nextInt(i + 1);
            temp = deck.get(rdm_idx);
            deck.set(rdm_idx, deck.get(i));
            deck.set(i, temp);
        }


    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return deck.toString();
    }
}
