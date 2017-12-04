package com.thoughtworks.tw101.introductory_programming_exercises;

import com.intellij.jarRepository.services.artifactory.Endpoint;

public class DiamondExercises {
    public static void main(String[] args) {
        drawAnIsoscelesTriangle(3);
        drawADiamond(8);
        drawADiamondWithYourName(3);
    }

//    Isosceles Triangle
//    Given a number n, print a centered triangle. Example for n=3:
//              *
//             ***
//            *****
//
//              *
//             ***
//            *****
//           ******* n = 6
//          *********
//         ***********

    private static void drawAnIsoscelesTriangle(int n) {
        StringBuffer[] triangle = new StringBuffer[n];
        for (int i = 0; i<n ; i++) {
            int numSpaces = n-i-1;  //empty spaces increase by one starting from bottom row to top
            int numStars = (2*i)+1; //always the odd numbers

            StringBuffer currRow = new StringBuffer();
            addEmptySpaces(numSpaces,currRow);
            addStars(numStars,currRow);
            triangle[i] = currRow;
        }

        for (int i = 0; i <triangle.length ; i++) {
            System.out.println(triangle[i]);
        }
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

//    Diamond
//    Given a number n, print a centered diamond. Example for n=3:
//              *
//             ***
//            *****
//             ***
//              *
    private static void drawADiamond(int n) {
        StringBuffer topOfDiamond = new StringBuffer();
        for (int i = 0; i <n ; i++) {
            StringBuffer currRowOfStars = new StringBuffer();





            }


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

    }
}
