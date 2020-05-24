package arrays;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelt {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forwardSums = new int[n];
        int[] backwardSums= new int[n];

        forwardSums[0] = 1;

        for(int i=1; i< n ; i++) {
            forwardSums[i] = nums[i-1] * forwardSums[i-1];
        }

        backwardSums[(nums.length -1)] = 1;

        for(int i= (nums.length -2) ; i >=0 ; i--) {
            backwardSums[i] = nums[i+1] *backwardSums[i+1] ;

        }

        int[] result = new int[n];

        for(int i=0; i<n ; i++) {
            result[i] = forwardSums[i] * backwardSums[i];
        }

        return result;
    }
}
