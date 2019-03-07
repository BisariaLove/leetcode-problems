package arrays;
/*
 * @author love.bisaria on 06/03/19
 *
 * Product Description - https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 */

public class MaxProductOf3 {

    public int maximumProduct(int[] nums) {

        int highest = Math.max(nums[0], nums[1]);
        int lowest = Math.min(nums[0], nums[1]);

        int highestProductOf2 = nums[0] * nums[1];
        int lowestProductOf2 = nums[0] * nums[1];

        int highestProductOf3 = nums[0] * nums[1] * nums[2];

        for(int i=2; i<nums.length; i++){
            int current = nums[i];

            highestProductOf3 = Math.max(Math.max(highestProductOf2 * current, highestProductOf3), lowestProductOf2 * current);

            highestProductOf2 = Math.max(highestProductOf2, Math.max(highest * current, lowest * current));
            lowestProductOf2 = Math.min(lowestProductOf2, Math.min(highest * current, lowest * current));

            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);

        }

        return highestProductOf3;

    }
}
