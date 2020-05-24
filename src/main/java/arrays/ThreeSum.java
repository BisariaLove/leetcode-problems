package arrays;
import java.util.*;
// https://leetcode.com/problems/3sum/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for(int  i=0; i< nums.length && nums[i]<=0; ++i) {
            if(i == 0 || nums[i-1] != nums[i])
                twoSum(nums, i, result);
        }

        return result;
    }

    private void twoSum(int[] nums, int i,List<List<Integer>> result) {
        int lo = i+1;
        int high = nums.length -1;


        while(lo < high) {
            int sum = nums[i] + nums[lo] + nums[high];

            if(sum < 0 || ((lo > i+1) && nums[lo] == nums[lo-1]))
                lo++;

            else if(sum > 0 || ((high < nums.length -1) && nums[high] == nums[high+1]))
                high--;

            else
                result.add(Arrays.asList(nums[i], nums[lo++], nums[high--]));
        }
    }
}
