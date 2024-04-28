/*
 *Papa Yaw Owusu Nti
 *February 25th, 2024
 *CS 231 B
 *Project 1
 *Description:  This program runs a user interactive version of BlackJack on the terminal. I create a new instance of the blackJack class, 
                use the scanner class to request user input and print the user winnings and win percentage after the game
 */
import java.util.Scanner;

public class BlackJackInteractive {
    public static void main(String[] args) {
        System.out.println("HI, WELCOME TO THE CS231 CASIN0, TODAY WE'RE GOING TO PLAY BLACKJACK!");

        Blackjack blackjack = new Blackjack();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bet amount: $");
        double betAmount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Your current money: $" + betAmount);


        

        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
       
        while (true) {
            
            int result = blackjack.Interactivegame(true); ;
            if (result == 1) {
                playerWins++;
                System.out.println("You Now Have: $" + (betAmount *= 1.5));
            } else if (result == -1) {
                dealerWins++;
                // Player loses, lose 25% of the money until it's depleted
                System.out.println("You Now Have: $" + (betAmount -= betAmount*0.25));
            } else {
                pushes++;
            }
        
            // Prompt the user to play another game
            System.out.println("Do you want to play another game BLACKJACK? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!"yes".equals(playAgain)) {
                break;
            }
        }
        
        
        // Print out the results
        System.out.println("Results:");
        System.out.println("Player wins: " + playerWins + " (" + (playerWins / 10.0) + "%)");
        System.out.println("Dealer wins: " + dealerWins + " (" + (dealerWins / 10.0) + "%)");
        System.out.println("Pushes: " + pushes + " (" + (pushes / 10.0) + "%)");
        scanner.close();
    }     
       
}

