package dynamicProgramming;/*
 * @author love.bisaria on 02/03/19
 *
 * Help - https://www.youtube.com/watch?v=Fi5INvcmDos
 * Problem Description - https://leetcode.com/problems/longest-palindromic-substring/
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubstring {

    static private int lo, maxLen=1;
    //idea is at each character check the surrounding characters and expand the palindrome
    public static String longestPalindrome(String s) {

        if(s.length()<2) return s;
        
        for(int i=0; i<s.length(); i++){
            extendPalindrome(s, i, i); //odd sized palindrome
            extendPalindrome(s, i, i+1); //even sized palindrome
        }

        return (s.substring(lo, lo+maxLen));
    }

    public static void extendPalindrome(String s, int i, int j){

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        int currentLen = (j-1) - (i+1) + 1;

        if(maxLen < currentLen){
            lo = i+1;
            maxLen = currentLen;
        }
    }



    static Map<String, Integer> memoTable = new HashMap();
    //get length of the longest palindrome for a given string
    //memoization
    private static int longestPalindromeSubstringRecursive(char[] s, int start, int end){

        if(start > end){
            return 0;
        }

        if(start == end){
            return 1;
        }

        if(memoTable.get(String.valueOf(start) + "+" + String.valueOf(end)) != null){
            return memoTable.get(String.valueOf(start) + "+" + String.valueOf(end));
        }

        if(s[start] == s[end]){
            Integer val = 2 + longestPalindromeSubstringRecursive(s, start+1, end-1);;
            memoTable.put(String.valueOf(start) + "+" + String.valueOf(end), val);
            return val;
        } else {
            return Math.max(longestPalindromeSubstringRecursive(s, start+1, end), longestPalindromeSubstringRecursive(s, start, end-1));
        }

    }

    public static void main(String[] args){

        //System.out.println("Answer: " + longestPalindromeSubstringRecursive("abcbed".toCharArray(), 0, 5));

        System.out.println("Result : " + longestPalindrome("abcbed"));
    }
}
