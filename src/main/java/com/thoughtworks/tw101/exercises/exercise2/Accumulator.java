package com.thoughtworks.tw101.exercises.exercise2;

public class Accumulator {
    int incrementCount = 0;
    void increment(){
        incrementCount++;
    }

    void total() {
        System.out.println("increment() called " + incrementCount + " times.");
    }
}
