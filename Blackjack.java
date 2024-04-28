/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description:  This program  implements a simplified version of the Blackjack game. 
                It includes fields for a Deck, a Hand for the player, another for the dealer,
                and a variable reshuffleCutoff indicating the number of cards below which the deck should be reshuffled.
                The class includes methods for initializing the game, resetting the game state, dealing cards to players, 
                managing player turns, handling dealer turns, setting the reshuffle cutoff value, and retrieving the reshuffle cutoff value. It also has a toString method
                that represents the state of the game. It shows the player and dealer hands as well as their current total value.

                I have 2 methods that run the game. I have a game method to play a single game automatically. I also have the Interactivegame method that
                will be used in my BlackjackInteractive class to run a version of Blackjack where the user can play on the terminal. They both take in the parameter
                verbose which is a boolean.
 */

import java.util.Scanner;

public class Blackjack {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private int reshuffleCutoff;

    /**
     * Constructs a Blackjack game with the specified reshuffle cutoff.
     * @param reshuffleCutoff the number of cards below which the deck must be reshuffled
     */
    public Blackjack(int reshuffleCutoff) {
        this.reshuffleCutoff = reshuffleCutoff;
        playerHand = new Hand();
        dealerHand = new Hand();
        deck = new Deck();
        deck.shuffle();
    }

    /**
     * Constructs a Blackjack game with a default reshuffle cutoff value.
     */
    public Blackjack() {
        this(30);
    
    }

    /**
     * Resets the game, clearing hands and reshuffling the deck if needed.
     */
    public void reset() {
        if (deck.size() < reshuffleCutoff) {
            deck.build();
            deck.shuffle();
        }
        else {
            playerHand.reset();;
            dealerHand.reset();
        
            
        }
    }

    /**
     * Deals two cards to both the player and the dealer from the deck.
     */
    public void deal() {
        for (int i=0;i <2;i++){
            playerHand.add(deck.deal());
            dealerHand.add(deck.deal());
        }
        

    }

    /**
     * Conducts the player's turn, drawing cards until reaching 16 or busting.
     * @return true if the player's turn completes without busting, false otherwise
     */
    public boolean playerTurn() {

        while (playerHand.getTotalValue() < 16) {

            // Draw a card for the player
            Card drawnCard = deck.deal();
            playerHand.add(drawnCard);

            if(playerHand.getTotalValue() >21) {
                return false;
            }

        }
        
        return true;
        
    }

    /**
     * Conducts the dealer's turn, drawing cards until reaching 17 or busting.
     * @return true if the dealer's turn completes without busting, false otherwise
     */
    public boolean dealerTurn() {

        while (dealerHand.getTotalValue() < 17) {
            
            // Draw a card for the player
            Card drawnCard = deck.deal();
            dealerHand.add(drawnCard);

            if(dealerHand.getTotalValue() >21) {
                return false;
            }

        }
        
        return true;
        
    }

    /**
     * Sets a new reshuffle cutoff value.
     * @param cutoff the new reshuffle cutoff value
     */
    public void setReshuffleCutoff(int cutoff) {
        this.reshuffleCutoff = cutoff;
    }

    /**
     * Returns the current reshuffle cutoff value.
     * @return the current reshuffle cutoff value
     */
    public int getReshuffleCutoff() {
        return this.reshuffleCutoff;
    
    }

    /**
     * Returns a string representation of the game state.
     * @return a string representing the state of the game
     */
    public String toString() {
        String result = "Player's Hand: " + playerHand + "\n" +
                        "Player's Hand Total Value: " + playerHand.getTotalValue() + "\n\n" +
                        "Dealer's Hand: " + dealerHand + "\n" +
                        "Dealer's Hand Total Value: " + dealerHand.getTotalValue() + "\n";
    
    return result;
    }

    public Hand getPlayerHand(){
        return playerHand;
    }

    public Hand getDealerHand(){
        return dealerHand;
    }



    public int game(boolean verbose){
        reset();
        deal();
        

        // Print initial hands
        if (verbose) {
            System.out.println("Initial Player's Hand: " + playerHand);
            System.out.println("Initial Player's Hand Total Value: " + playerHand.getTotalValue() + "\n");
            System.out.println("Initial Dealer's Hand: " + dealerHand);
            System.out.println("Initial Dealer's Hand Total Value: " + dealerHand.getTotalValue() + "\n");
        }

            
         // Player's turn
        boolean playerBusted = !playerTurn();
        
        // Dealer's turn
        boolean dealerBusted = !dealerTurn();
        
        // Determine game outcome
        int result;
        if (playerBusted) {
            result = -1; // Dealer wins
        } else if (dealerBusted) {
            result = 1; // Player wins
        } else if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {
            result = 1; // Player wins
        } else if (playerHand.getTotalValue() < dealerHand.getTotalValue()) {
            result = -1; // Dealer wins
        } else {
            result = 0; // Tie (push)
        }
        if (verbose) {
            System.out.println("Player's FinalHand: " + playerHand);
            System.out.println("Player's FinalHand Total Value: " + playerHand.getTotalValue() + "\n");
            System.out.println("Dealer's FinalHand: " + dealerHand);
            System.out.println("Dealer's FinalHand Total Value: " + dealerHand.getTotalValue() + "\n");
    
            if (result == -1) {
                System.out.println("Dealer wins!");
            } 
            else if (result == 0) {
                System.out.println("It's a tie!");
            } 
            else {
                System.out.println("Player wins!");
            }
        }
        
        return result;
    }



    public int Interactivegame(boolean verbose){

        boolean playerbust = false ;
        boolean dealerbust = false ;

        reset();
        deal();
        

        // Print initial hands
        if (verbose) {
            
            System.out.println("Your Initial Hand: " + playerHand);
            System.out.println("Your Hand Total Value: " + playerHand.getTotalValue() + "\n");
            System.out.println("Initial Dealer's Hand: " + dealerHand);
            System.out.println("Initial Dealer's Hand Total Value: " + dealerHand.getTotalValue() + "\n");
        }

        while (playerHand.getTotalValue() < 16) {

            System.out.print("Do you want to hit or stand: ");
            Scanner scannerx = new Scanner(System.in);
            String decision = scannerx.nextLine().toLowerCase();
            if ("hit".equals(decision)) {
            // Draw a card for the player
            Card drawnCard = deck.deal();
            playerHand.add(drawnCard);
            System.out.println("Your Hand: " + playerHand);

            }
            else{
                break;
            }
       
            if(playerHand.getTotalValue() >21) {
                playerbust = true;
            }
        }
        
            while (dealerHand.getTotalValue() < 17) {
            
                // Draw a card for the player
                Card drawnCard = deck.deal();
                dealerHand.add(drawnCard);
    
                if(dealerHand.getTotalValue() >21) {
                    dealerbust = true;
                }
    
            }

        
        // Determine game outcome
        int result;
        if (playerbust) {
            result = -1; // Dealer wins
        } else if (dealerbust) {
            result = 1; // Player wins
        } else if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {
            result = 1; // Player wins
        } else if (playerHand.getTotalValue() < dealerHand.getTotalValue()) {
            result = -1; // Dealer wins
        } else {
            result = 0; // Tie (push)
        }
        if (verbose) {
            System.out.println("Your FinalHand: " + playerHand);
            System.out.println("Your FinalHand Total Value: " + playerHand.getTotalValue() + "\n");
            System.out.println("Dealer's FinalHand: " + dealerHand);
            System.out.println("Dealer's FinalHand Total Value: " + dealerHand.getTotalValue() + "\n");
    
            if (result == -1) {
                System.out.println("Dealer wins!");
            } 
            if (result == 1) {
                System.out.println("YOU WIN!");
            } 
            else if (result == 0) {
                System.out.println("It's a tie!");
            } 
            
        }
        
    return result;
       
    }

    


public static void main(String[] args) {

    Blackjack blackjack = new Blackjack();
    blackjack.game(true); 
    // blackjack.Interactivegame(true); 
    
  
}

}