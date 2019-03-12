package arrays;
/*
 * @author love.bisaria on 12/03/19
 *
 * Problem Description - https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairDiffK {


    static int pairs(int k, Integer[] arr) {

        Set<Integer> arrSet = new HashSet(Arrays.asList(arr));

        int count = 0;
        for(int element : arr){
            if(arrSet.contains(element+k)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){

        Integer[] arr = new Integer[]{1, 5, 3, 4, 2};
        pairs(2, arr);
    }
}
