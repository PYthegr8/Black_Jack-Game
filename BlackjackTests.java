/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea BlackjackTests
*/


public class BlackjackTests {

    public static void blackjackTests() {

        // Test case for constructor with reshuffleCutoff parameter
        Blackjack bj1 = new Blackjack(5);
        assert bj1.getReshuffleCutoff() == 5 : "Error in constructor with reshuffleCutoff parameter";

        // Test case for default constructor
        Blackjack bj2 = new Blackjack();
        assert bj2.getReshuffleCutoff() >= 30 : "Error in default constructor";

        // Test case for reset() method
        bj1.deal();
        bj1.reset();
        assert bj1.getPlayerHand().isEmpty() && bj1.getDealerHand().isEmpty() : "Error in reset() method";

        // Test case for deal() method
        bj1.reset();
        bj1.deal();
        assert bj1.getPlayerHand().size() == 2 && bj1.getDealerHand().size() == 2 : "Error in deal() method";

        // Test case for playerTurn() method
        bj1.reset();
        bj1.getPlayerHand().add(new Card(10));
        bj1.getPlayerHand().add(new Card(7)); // Total value = 17
        boolean playerBusted = bj1.playerTurn();
        assert !playerBusted : "Error in playerTurn() method";

        // Test case for dealerTurn() method
        bj1.reset();
        bj1.getDealerHand().add(new Card(10));
        bj1.getDealerHand().add(new Card(8)); // Total value = 18
        boolean dealerBusted = bj1.dealerTurn();
        assert !dealerBusted : "Error in dealerTurn() method";

        // Test case for setReshuffleCutoff() method
        bj1.setReshuffleCutoff(10);
        assert bj1.getReshuffleCutoff() == 10 : "Error in setReshuffleCutoff() method";

        // Test case for toString() method
        bj1.reset();
        bj1.getPlayerHand().add(new Card(10));
        bj1.getDealerHand().add(new Card(8));
        String gameString = bj1.toString();
        assert gameString.contains("Player's Hand:") && gameString.contains("Dealer's Hand:") &&
                gameString.contains("Player's Hand Total Value:") && gameString.contains("Dealer's Hand Total Value:") :
                "Error in toString() method";

        System.out.println("*** Done testing Blackjack! ***\n");
    }

    public static void main(String[] args) {
        blackjackTests();
    }
}
