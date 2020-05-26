package arrays;

//https://leetcode.com/problems/subarray-sum-equals-k/

public class CountSubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {

        int totalWays = 0;

        for(int start = 0; start <nums.length; start++) {
            int sum=0;

            for(int end = start; end< nums.length; end++) {

                sum += nums[end];
                if(sum ==k) {
                    totalWays++;
                }
            }
        }
        return totalWays;
    }
}
