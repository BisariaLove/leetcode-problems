package string;
import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class AllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        int ns = s.length(), np=p.length();

        if(ns < np) return new ArrayList();

        Map<Character, Integer> sCount = new HashMap();
        Map<Character, Integer> pCount = new HashMap();

        for(char ch : p.toCharArray()) {
            int count = pCount.getOrDefault(ch,0);
            pCount.put(ch, ++count);
        }

        List<Integer> output = new ArrayList();

        for(int i=0; i<ns; i++) {

            char ch = s.charAt(i);

            int count = sCount.getOrDefault(ch,0);
            sCount.put(ch, ++count);

            if(i>=np) {
                ch = s.charAt(i-np);
                if(sCount.get(ch) == 1){
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }

            if (pCount.equals(sCount)) {
                output.add(i - np + 1);
            }
        }

        return output;

    }
}
