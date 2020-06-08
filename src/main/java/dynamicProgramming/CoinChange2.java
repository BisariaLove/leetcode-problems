package dynamicProgramming;
import java.util.*;

//https://leetcode.com/problems/coin-change-2

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap();
        return change(amount, coins, 0, memo);
    }

    public int change(int amount, int[] coins, int index, Map<String, Integer> memo ) {
        String val = amount +","+index;

        if(memo.get(val) != null) return memo.get(val);

        if(amount ==0) return 1;
        if(amount < 0 || index >= coins.length) return 0;

        int res = 0;

        int coin = coins[index];

        int times = amount/coin;

        for(int j=0; j<=times; j++) {

            int remaining = amount - coin*j;

            res += change(remaining, coins, index+1, memo) ;

        }

        memo.put(amount+","+index, res);

        return res;
    }
}
