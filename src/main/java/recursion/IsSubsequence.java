package recursion;

//https://leetcode.com/problems/is-subsequence

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        return  isSubsequence(s.toCharArray(), t.toCharArray(), 0,0) == s.length();
    }

    private int isSubsequence(char[] s, char[] t, int sIndex, int tIndex) {

        if(sIndex >= s.length || tIndex >= t.length) return 0;

        int res=0;

        while(tIndex < t.length){

            if(t[tIndex] == s[sIndex]) {
                res =1;
                tIndex++;
                break;
            }

            tIndex++;
        }


        return res + isSubsequence(s, t, sIndex+1, tIndex);
    }
}
