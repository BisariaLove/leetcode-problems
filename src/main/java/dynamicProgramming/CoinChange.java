package dynamicProgramming;

import java.util.*;
//https://leetcode.com/problems/coin-change/
//https://www.youtube.com/watch?v=jgiZlGzXMBw

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] ways = new int[amount+1];
        Arrays.fill(ways, amount+1);

        ways[0] = 0;

        for(int i=1; i<= amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(i - coins[j] >=0) {
                    ways[i] = Math.min(ways[i], ways[i-coins[j]] +1);
                }
            }
        }

        if(ways[amount] == amount+1)
            return -1;

        return ways[amount];

    }
}
