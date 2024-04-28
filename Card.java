/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description: This program creates a Card object, which should hold all information unique to the card such as its value between 2 and 11.
                Other methods such as a toString(a string representation of the card) and a getValue(value of the card) are included 
 */




public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {

        if (val >= 2 && value <= 11) {
            this.value = val;
        }
        // TBD
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
        // return this.card
        // TBD
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return String.format("%d", value);
        // TBD
    }
}
