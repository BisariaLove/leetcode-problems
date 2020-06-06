package string;

//https://leetcode.com/problems/reorganize-string
import java.util.*;

public class ReOrganizeString {

    //special attention here to
    // how you encode each value of count to store the count and char representation in int
    public String reorganizeString(String S) {

        int N = S.length();
        int[] count = new int[26];

        for(char c : S.toCharArray()) {
            count[c-'a'] += 100;
        }

        for (int i = 0; i < 26; ++i) count[i] += i;

        Arrays.sort(count);

        char[] ans = new char[N];
        int t=1;

        for(int code : count) {
            int ct = code/100;
            char ch = (char) ('a' + (code%100));

            if(ct > (N+1)/2) return "";

            for(int j=0; j<ct; j++) {
                if(t>=N) t=0;
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }
}
