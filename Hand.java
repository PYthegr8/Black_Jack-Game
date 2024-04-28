/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description:  This program creates a Hand ArrayList to hold a set of Card objects. The class has the following methods: 
                reset() to empty the Hand ArrayList, add(), to add a card, size() to get the size of the hand, getCard to get the card of index i
                getTtoalValue() to get the sum of values of the cards in the Hand and a toString method. i PERSONALLY ADDED A isEmpty() method to check if the 
                Hand is empty or not
 */

import java.util.ArrayList;

public class Hand {

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();

    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        hand.clear();
        
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        hand.add(card);
        
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum = 0;

        for (int i = 0;i< hand.size();i++) {
            Card cd = hand.get(i);
            sum+= cd.getValue();
        }
        
        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        return hand + " : "+ getTotalValue();
    }


    /**
     * Returns a  boolean whether the hand is empty or not.
     * @return a boolean
     */
    public boolean isEmpty(){
        return hand.isEmpty();
    }
}
