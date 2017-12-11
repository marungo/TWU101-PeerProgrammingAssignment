package com.thoughtworks.tw101.exercises.exercise3;

public class OddSum {

    public int of(int start, int end) {
        int oddSum = 0;
        for (int i = start+1; i < end; i++) {
            if (i%2 != 0){
                oddSum += i;
            }
        }
        return oddSum;
    }
}
