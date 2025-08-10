import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        
        // input from the user  and a way to pick a random number.
        Scanner keyboard = new Scanner(System.in);
        Random numberPicker = new Random();

        // This will keep track of if the user wants to keep playing.
        boolean playingTheGame = true;

        System.out.println("Hello! Let's play a number guessing game. It's a classic!");

        while (playingTheGame) {
            
            int minimumNumber = 1;
            int maximumNumber = 100;
            int theSecretNumber = numberPicker.nextInt(maximumNumber - minimumNumber + 1) + minimumNumber;
            int guessesTaken = 0;
            int maxGuesses = 8; 
            boolean didTheyWin = false;

            System.out.println(" I've just picked a number between " + minimumNumber + " and " + maximumNumber + ".");
            System.out.println("You have " + maxGuesses + " chances to guess it." );

            // This is the main part of the game loop where the guessing happens.
            while (guessesTaken < maxGuesses) {
                System.out.print("What's your guess? ");
                int usersGuess = keyboard.nextInt();
                guessesTaken++;

                if (usersGuess == theSecretNumber) {
                    System.out.println("Whoa, you got it! The number was " + theSecretNumber + " all along.");
                    System.out.println("You found it in only " + guessesTaken + " tries. Nice work!");
                    didTheyWin = true;
                    break; 
                } else if (usersGuess < theSecretNumber) {
                    System.out.println("Nope, that's too low. Try guessing a higher number.");
                } else { 
                    System.out.println("Hmm, that's too high. My number is smaller than that.");
                }

                
                if (guessesTaken < maxGuesses) { 
                    System.out.println("You've used " + guessesTaken + " out of " + maxGuesses + " guesses. Keep going!");
                }
            } 

           
            if (!didTheyWin) {
                System.out.println("you're out of guesses. The number was " + theSecretNumber + ".");
            }

            // Let's ask if they want to play again.
            System.out.print("Want to give it another shot? (yes/no): ");
            String playAgainAnswer = keyboard.next();
            playingTheGame = playAgainAnswer.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! Come back any time.");
        keyboard.close(); 
    }

}
