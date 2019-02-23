package string;
/*
 * @author love.bisaria on 23/02/19
 *
 * Problem Description - https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuffer buffer = new StringBuffer();

        for(int i=words.length -1 ; i>=0 ; i--){
            buffer.append(words[i]);
            buffer.append(" ");
        }

        return buffer.toString().trim();

    }
}
