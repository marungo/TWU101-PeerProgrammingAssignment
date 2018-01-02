package com.thoughtworks.tw101.exercises.exercise8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
BLOATER 1: receiveGuess() method was receiving guess but also
validating that guess, and asking user to continue guessing if
guess wasn't valid.

B1 Refactor: I split up the work into 3 separate methods.
isValidInteger(), isWithinValidRange (a method Shlok was already using),
and ensureValidGuess() which continues to ask user for a new guess
while current guess doesn't pass both validators.

BLOATER 2: class is pretty big - could be split up into a couple of classes.

B2 Refactor: Split off a class called GuessingGameValidator which handles all of the
necessary validations that user's guesses have to pass.

OO Abuser: I couldn't find an obvious abuse of OOO, but I did notice that
receiveGuess() had a few if/else, try/catch, and do/while statements
that were calling different pieces of code from all over the class,
and were intertwined in a way that made it tough for ppl other than the
coder to parse.

OOA Refactor: In the midst of my refactor of B1, I cleaned up some of that
logic stream, and packaged the various cases that the method was handling
into more readable code. I think that solved the problem.

*/

//on fail make sure to close scanner


public class guessingGame {
    private GuessingGameValidator validator;
    private Scanner scanner;
    public boolean gameOver;
    private ArrayList<Integer> guesses;

    guessingGame() {
        validator = new GuessingGameValidator(getRandomNumber());
        scanner = new Scanner(System.in);
        gameOver = false;
        guesses = new ArrayList<>();
    }

    public void play(){
        int guess;
        while (!gameOver){
            System.out.println("Please enter a valid positive integer between 1 and 100");
            guess = ensureValidGuess();
            gameOver = validator.check(guess);
        }
        System.out.println("you guessed right! you win!");
        scanner.close();
        printGuesses();
    }


    private int getRandomNumber() {
        return new Random().nextInt(99) + 1;
    }

    private int ensureValidGuess() {
        String guess = scanner.next();
        while (true) {
            if (!validator.isValidInteger(guess) || !validator.isWithinValidRange(Integer.parseInt(guess)))
                guess = scanner.next();
            else {
                int guessInt = Integer.parseInt(guess);
                guesses.add(guessInt);
                return guessInt;
            }
        }
    }

    private void printGuesses(){
        System.out.println("Here are your guesses:");
        for (int i = 0; i < guesses.size() ; i++) {
            System.out.println("guess #" + i + " was: " + guesses.get(i));
        }
    }

}

