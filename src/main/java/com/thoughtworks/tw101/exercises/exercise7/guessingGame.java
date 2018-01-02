package com.thoughtworks.tw101.exercises.exercise7;

import java.util.Random;
import java.util.Scanner;

//on fail make sure to close scanner

public class guessingGame {
    private int randomNumber;
    private Scanner scanner;
    private int guess;
    public boolean gameOver = false;

    public guessingGame() {
        randomNumber = getRandomNumber();
        scanner = new Scanner(System.in);
    }


    public int getRandomNumber() {
        Random r = new Random();
        int random = r.nextInt(99);
        random += 1;
        return random;
    }

    public void promptUserForGuess() {
        askForGuess();
        recieveGuess();
    }
    void recieveGuess() {
        boolean validInput = false;
        int potentialGuess;
        do {
            if (scanner.hasNextInt()) {
                potentialGuess = scanner.nextInt();
                if (isWithinValidRange(potentialGuess)) {
                    guess = potentialGuess;
                    validInput = true;
                }
                else {
                    invalidPosInt();
                }
            }
            else {
                invalidPosInt();
            }
        } while (!validInput);
        System.out.println(guess);

    }

    void compare(){
        if (guess == randomNumber) {
            System.out.println("you guessed right! you win!");
            gameOver = true;
            return;
        }
        if (guess>randomNumber){
            System.out.println("you guessed too high!");
        }
        else{
            System.out.println("you guessed too low!");
        }
    }

    boolean isWithinValidRange(int potentialGuess) {
        if (potentialGuess > 0 && potentialGuess < 100) {
            return true;
        }
        else{
            return false;
        }
    }

    void askForGuess() {
        System.out.println("Please enter a valid positive integer");
    }

    void invalidPosInt() {
        askForGuess();
        scanner.next();
    }
}

