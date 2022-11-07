package com.dcc;

import java.util.LinkedList;

/**
 * Given a list of words, find all pairs of unique indices
 * such that the concatenation of the two words is a 
 * palindrome.
 * 
 * For example, given the list
 * ["code", "edoc", "da", "d"] return
 * [(0, 1), (1,0), (2, 3)]
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Input for prompt
        String[] arr = {"code", "edoc", "da", "d"};
        // Create new list for output
        LinkedList<Integer[]> finalList = new LinkedList<Integer[]>();
        // Populate the list
        finalList = listOfPals(arr);

        if(finalList.isEmpty()) {
            System.out.println("No palindrome detected");
        }
        // Display unique indecies
        for (Integer[] elem: finalList ) {
            System.out.printf("\n%d, %d", elem[0], elem[1]);
        }
        System.out.println();
    }

    // Checks to see if palindrom
    public static LinkedList<Integer[]> listOfPals(String[] words) {
        // Create empty array for indecies
        LinkedList<Integer[]> listOfIndecies = new LinkedList<Integer[]>();
        // Iterate through list of words
        for (int i = 0; i < words.length; i++) {
            // If out of bounds break
            if (i+1 >= words.length) {
                break;
            }

            // Iterate and compare
            for (int j = 0; j < words.length; j++) {
                // Create temp array
                Integer[] tempArr = new Integer[2];
                // Disregard the same word twice
                if (words[i] == words[j]) {
                    continue;
                }
                // Send words to newWord()
                String tempString = "";
                tempString = newWord(words[i], words[j]);
                // Check is actual palindrome
                Boolean isPal = false;
                isPal = isPalindrome(tempString);

                // Send indecies to list
                if (isPal) {
                    // creates array of [i, j] and adds to list
                    tempArr[0] = i;
                    tempArr[1] = j;
                    listOfIndecies.add(tempArr);
                }
                
            }
        }
        return listOfIndecies;
    }
    
    // Concatenate 2 words
    public static String newWord(String wordOne, String wordTwo) {
        String temp = "";
        temp = wordOne + wordTwo;
        return temp;
    }

    // Check if palindrome
    public static Boolean isPalindrome(String word) {
        // Prime the var
        Boolean isPalindrome = true;
        // Make a reverse counter
        int backCount = word.length() - 1;

        // Iterate through letters in word
        for (int i = 0; i < word.length(); i++) {
            // If two indexed chars don't match, break and set flag
            if (word.charAt(i) != word.charAt(backCount)) {
                isPalindrome = false;
                break;
            }
            // Decrement to the next letter back
            backCount--;
        }

        return isPalindrome;
    }
}
