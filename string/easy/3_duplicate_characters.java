/*
 You are given a string ‘S’ of length ‘N’. You have to return all the characters in the string that are duplicated and their frequency.

Example:-
N = 5
S = ‘GEEK’

ANSWER:- The answer should be [(‘E’,2)] because ‘E’ is the only character that is duplicated and has frequency 2.
 */



import java.util.* ;
import java.io.*; 
import java.util.*;
/****
 * Following is the java Pair class
 * class Pair{
    char alphabet;
    int count;
    Pair(char ch, int x){
        this.alphabet = ch;
        this.count = x;
    }
}
 */


public class Solution {

    public static ArrayList<Pair> duplicate_char(String s, int n) {
        
        // Assuming ASCII characters, create an array to store the frequency of each character
        int[] arr = new int[128];

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        // Create an ArrayList to store characters with frequency greater than 1
        ArrayList<Pair> ans = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (arr[i] > 1) { // If frequency of character at index i is greater than 1
                ans.add(new Pair((char) i, arr[i])); // Add the character and its frequency to the ArrayList
            }
        }
        return ans;

    }
}