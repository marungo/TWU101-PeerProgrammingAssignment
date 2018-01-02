package com.thoughtworks.tw101.introductory_programming_exercises;

/*
DISPENSABLE 1: there's a three-line for-loop that is
used several times to print out the triangle rows.

D1 Refactor: extracted that code to a simple printTriangle()
method that uses buildIndexRange() so that we can print
triangle in ascending or descending order.

DISPENSABLE 2: there's a lot of duplicate code in
drawDiamond() and in drawDiamondWithYourName()

D2 Refactor: I made one method to account for both, using boolean to turn on
and off name.
*/

import java.util.stream.IntStream;

public class DiamondExercises {
    public static void main(String[] args) {
        drawAnIsoscelesTriangle(3);
        drawADiamond(8);
        drawADiamondWithYourName(3);
    }

    private static void printTriangle(StringBuffer[] tri, int[] indices) {
        for (int i: indices) {
            System.out.println(tri[i]);
        }
    }

    private static int[] buildIndexRange(int from, int to, boolean descending) {
        if (!descending) return IntStream.range(from, to).toArray();
        return IntStream.range(from,to).map(i -> to - i + from - 1).toArray();
    }

//    Isosceles Triangle
//    Given a number n, print a centered triangle. Example for n=3:
//              *
//             ***
//            *****
    private static void drawAnIsoscelesTriangle(int n) {
        StringBuffer[] triangle = getIsoscelesTriangle(n);
        printTriangle(triangle, buildIndexRange(0,triangle.length, false));
    }

//    refactor code for diamonds
    private static void drawADiamondWithOptionalName(int n, boolean name) {
        StringBuffer[] triangle = getIsoscelesTriangle(n);
        printTriangle(triangle, buildIndexRange(0,triangle.length-1, false));

        if (name) System.out.println("shlok");
        else System.out.println(triangle[triangle.length-1]);

        printTriangle(triangle, buildIndexRange(0,triangle.length-1, true));
    }

//    Diamond
//    Given a number n, print a centered diamond. Example for n=3:
//              *
//             ***
//            *****
//             ***
//              *

    private static void drawADiamond(int n) {
        drawADiamondWithOptionalName(n, false);
    }


//    Diamond with Name
//    Given a number n, print a centered diamond with your name in place of the middle line. Example for n=3:
//
//             *
//            ***
//           Bill
//            ***
//             *
    private static void drawADiamondWithYourName(int n) {
        drawADiamondWithOptionalName(n,true);
    }

    private static StringBuffer[] getIsoscelesTriangle(int n) {
        StringBuffer[] triangle = new StringBuffer[n];
        for (int i = 0; i<n ; i++) {
            int numSpaces = n-i-1;  //empty spaces increase by one starting from bottom row to top
            int numStars = (2*i)+1; //always the odd numbers

            StringBuffer currRow = new StringBuffer();
            addEmptySpaces(numSpaces,currRow);
            addStars(numStars,currRow);
            triangle[i] = currRow;
        }
        return triangle;
    }


    private static void addEmptySpaces(int spaces, StringBuffer currRow){
        for (int j = 0; j < spaces ; j++) {
            currRow.append(" "); //  add the blank space
        }
    }

    private static void addStars(int numStars, StringBuffer currRow) {
        for (int i = 0; i < numStars ; i++) {
            currRow.append("*");
        }
    }
}
