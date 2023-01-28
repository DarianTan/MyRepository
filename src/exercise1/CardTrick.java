package exercise1;
import java.util.Random;
import java.util.Scanner;


/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author Darian Tan January 27, 2023
 */
public class CardTrick {

    public static void main(String[] args) {

        printRandomHand();
        System.out.println("\nWelcome to my Card Game! ! !\n");
        startOfGame();
    }

    /**
     * prints a hand of randomly generated cards.
     */
    private static void printRandomHand() {
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            Random ran = new Random();
            card.setValue(card.randomCard());
            card.setSuit(Card.SUITS[ran.nextInt(3)]);
            hand[i] = card;
        }

        System.out.println("You were given the following random stack: ");

        for (Card myDeck : hand) {
            int newCards = myDeck.getValue();
            String mySuit = myDeck.getSuit();
            System.out.printf("\t %d of %s\n", newCards, mySuit);
        }
    }

    private static void startOfGame() {
        Card[] hand = new Card[7];
        Card card = new Card();

        Scanner sc = new Scanner(System.in);

        System.out.print("Pick a card, any card!\nEnter the Card: ");
        int playerCards = sc.nextInt();

        for (int i = 0; i < hand.length; i++) {
            Random ran = new Random();

        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
            card.setValue(playerCards);
            card.setSuit(Card.SUITS[ran.nextInt(3)]);
            hand[i] = card;
        }

        // If the guess is successful, invoke the printInfo() method below.

        String cardString = "";
        switch(playerCards) {
            case 1:
                cardString = "Ace";
                break;
            case 11:
                cardString = "Jack";
                break;
            case 12:
                cardString = "Queen";
                break;
            case 13:
                cardString = "King";
                break;
            case 14:
                cardString = "Joker";
                break;
        }

        System.out.println("\nPick a Suit.");
        System.out.println("1 = Hearts, 2 = Diamonds, 3 = Spades, 4 = Clubs");
        System.out.print("Suit: ");
        int playerSuit = sc.nextInt();

        while(playerSuit > 4) {
            System.out.printf("%d is not part of the "
                    + "Suite!\n", playerSuit);
            System.out.print("Try again: ");
            playerSuit = sc.nextInt();

            if (playerSuit < 4) {
                continue;
            }
        }

        String suitString = "";
        switch(playerSuit) {
            case 1:
                suitString = "Hearts";
                break;
            case 2:
                suitString = "Diamonds";
                break;
            case 3:
                suitString = "Spades";
                break;
            case 4:
                suitString = "Clubs";
                break;
        }

        if (playerCards < 2 || playerCards > 10) {
            System.out.printf("\nYou picked a %s "
                    + "of %s", cardString, suitString);
        } else { // anything between 2 and 10
            System.out.printf("\nYou picked a %d "
                    + "of %s", playerCards, suitString);
        }

        System.out.println("\nLet's see if your card is in the magic "
                + "hand!\n");

        for (Card myDeck : hand) {
            while (myDeck.getValue() > 14) {
                System.out.printf("Oh no! Unfortunately your %d was not "
                        + "in the magic hand!\nTry again: ", playerCards);
                playerCards = sc.nextInt();
                if (playerCards < 14) {
                    continue;
                }
            }
        }
        printInfo();
        sc.close(); // we're done using the userInput, close() stream
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {

        System.out.println("You have guessed right!");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            Thread.sleep(1000); // waits for the congratulations to display longer
        } catch(InterruptedException ex) {
            Thread.interrupted();
            System.out.println("Caught Thread Exception: " + ex.toString());
        }

        System.out.println();

        System.out.println("My name is Darian Tan.");
        System.out.println("Just call me by my first name.\n");

        System.out.println("My career ambitions:");
        System.out.println("-- Owning my own business.");
        System.out.println("-- Learn how to invest my money properly via. "
                + "stocks, etc.");	
        System.out.println("-- Work hard on my side hustles and doing what I "
                + "love (ie. my hobbies)\n");
	
        System.out.println("Here Are My Hobbies Listed Down Below:");
        System.out.println("Video Games");
        System.out.println("Basketball");
        System.out.println("Watching TV Shows / Movies (on my spare time)");
        System.out.println("Reading about how to start investing (soon enough "
                + "begin trading)");
        System.out.println("Editing Videos (ie. Anime Music Videos [AMV "
                + "style])\n\nThank you for playing my Card Game. . .");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        System.exit(0);

    
    }
}