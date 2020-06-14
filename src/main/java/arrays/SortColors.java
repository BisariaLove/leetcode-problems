package arrays;

//https://leetcode.com/problems/sort-colors
//Explanation - https://www.youtube.com/watch?v=XOX1WvUMpwQ

public class SortColors {
    public void sortColors(int[] nums) {
        int p=0, p0=0, p2=nums.length-1;

        while(p<=p2) {
            if(nums[p] == 2) {
                swap(nums, p, p2);
                p2--;
            }
            else if(nums[p] == 0) {
                swap(nums, p, p0);
                p0++;
                p++;
            } else {
                p++;
            }
        }
    }

    private void swap(int[] nums , int p, int index) {
        int temp = nums[p];
        nums[p] = nums[index];
        nums[index] = temp;
    }
}
