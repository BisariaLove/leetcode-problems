package dynamicProgramming;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length ==0){
            return 0;
        }

        if(nums.length == 1) return 1;

        int[] result = new int[nums.length];

        int max = Integer.MIN_VALUE;

        for(int i=1; i<nums.length; i++) {

            for(int j=0; j<i; j++) {

                if(nums[j] < nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }

            }

            if(max < result[i]) max = result[i];
        }


        return max+1;

    }
}
