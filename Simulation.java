/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description:  This program  runs 1000 simulations of blackjack
 */

public class Simulation {
    public static void main(String[] args) {
        // Create a single Blackjack object
        Blackjack blackjack = new Blackjack();

        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        
        // Run 1000 games of Blackjack
        for (int i = 0; i < 1000; i++) {
            int result = blackjack.game(false);
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }
        
        // Print out the results
        System.out.println("Results:");
        System.out.println("Player wins: " + playerWins + " (" + (playerWins / 10.0) + "%)");
        System.out.println("Dealer wins: " + dealerWins + " (" + (dealerWins / 10.0) + "%)");
        System.out.println("Pushes: " + pushes + " (" + (pushes / 10.0) + "%)");
    }        
}
