package arrays;
/*
 * @author love.bisaria on 08/03/19
 *
 * Problem Description - https://leetcode.com/problems/find-the-duplicate-number/
 */

public class FindDuplicatesInArray {

    public int findDuplicate(int[] nums) {

        int[] numCount = new int[nums.length];

        for(Integer num : nums){
            if(numCount[num] > 0) return num;
            numCount[num] ++;
        }

        return -1;
    }
}
