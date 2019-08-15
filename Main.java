package sample;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main

{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        // Initializes the random number to be guessed by the user
        guessNumber:
        while (true) {
            int min = 1;
            int max = 100;
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            int guesses = 0;

            //Allows the user to input a their guess
            guessingGame:
            while (true) {
                System.out.println("This code will pick a random number between 1 and 100");
                System.out.println("Please guess the number or else");
                guesses ++;
                int guess = in.nextInt();

                //Tests to see if user is correct or not
                if (guess == randomNum) {
                    System.out.println("You are correct!");
                    System.out.println("And it only took you " + guesses + " guesses!");
                    System.out.println("You must be psychic!");
                    break guessingGame;
                } else {
                    if (guess > randomNum) {
                        System.out.println("Your guess is too high");
                    } else {
                        if (guess < randomNum) {
                            System.out.println("Your guess is too low");
                        }
                    }

                    // Determines whether to guess another number or escape the loop
                    System.out.println("Would you like to make another guess? Type yes if you would like to continue");

                    String answer = in.next();
                    answer = answer.toLowerCase();
                    switch (answer) {
                        case "no":
                            break guessingGame;
                        case "yes":
                            continue;
                    }
                }
            }

            //Determines whether to escape the game entirely

            System.out.println("Would you like to try a new number? Type yes if you would like to continue");
            String answer = in.next();
            answer = answer.toLowerCase();
            switch (answer) {
                case "no":
                    break guessNumber;
                case "yes":
                    continue;
            }
        }
    }
}
