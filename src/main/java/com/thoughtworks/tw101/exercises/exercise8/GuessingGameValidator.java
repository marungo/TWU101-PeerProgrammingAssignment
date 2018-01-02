package com.thoughtworks.tw101.exercises.exercise8;

public class GuessingGameValidator {
    private int randomNumber;

    public GuessingGameValidator(int rando) {
        randomNumber = rando;
    }

    protected boolean isValidInteger(String guess) {
        try {
            Integer.parseInt(guess);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Input entered is not a valid integer. Try again.");
            return false;
        }
    }

    protected boolean isWithinValidRange(int potentialGuess) {
        if (potentialGuess > 0 && potentialGuess <= 100) {
            return true;
        } else {
            System.out.println("The number entered is not within 1-100. Try again.");
            return false;
        }
    }

    protected boolean check(int guess){
        if (guess == randomNumber) return true;
        else {
            if (guess > randomNumber) System.out.println("you guessed too high!");
            else System.out.println("you guessed too low!");

            return false;
        }
    }

}
