package dynamicProgramming;

//https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];

        for(int x=1; x<=n; x++) {
            int minVal = x;
            int y=1, sq=1;

            while(sq <= x) {
                minVal = Math.min(minVal, 1+dp[x-sq]);
                y++;
                sq  = y*y;
            }

            dp[x] = minVal;
        }
        return  dp[n];
    }
}
