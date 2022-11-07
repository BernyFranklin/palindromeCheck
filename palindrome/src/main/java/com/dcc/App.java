package com.dcc;

import java.util.LinkedList;

/**
 * Given a lost of words, find all pairs of unique indices
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
        String[] arr = {"code", "edoc", "da", "d"};
        listOfPals(arr);
    }

    // Checks to see if palindrom
    public static LinkedList<Integer> listOfPals(String[] words) {
        // Create empty array for indecies
        LinkedList<Integer> listOfIndecies = new LinkedList<Integer>();
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
                Boolean isPal = false;
                isPal = isPalindrome(tempString);
                System.out.println(isPal);
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
