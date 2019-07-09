package arrays;

import java.util.HashMap;
import java.util.Map;

/*
* problem description - https://leetcode.com/problems/two-sum/
* */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> lookUpMap = new HashMap();

        int[] result = new int[2];

        for(int i=0 ; i<nums.length ; i++){
            if(lookUpMap.containsKey(target - nums[i])){
                return new int[]{lookUpMap.get(target - nums[i]), i};
            } else {
                lookUpMap.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
