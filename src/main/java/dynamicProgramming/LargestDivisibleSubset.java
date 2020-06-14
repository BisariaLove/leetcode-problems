package dynamicProgramming;

// https://leetcode.com/problems/largest-divisible-subset
//Explanation - https://www.youtube.com/watch?v=8tDM_pfmlrw

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList(nums.length);
        List<Integer> max = new ArrayList();

        for(int i=0; i<nums.length; i++) {
            List<Integer> cur= new ArrayList<Integer>();
            cur.add(nums[i]);
            subsets.add( cur) ;
        }

        for(int i=(nums.length-1); i>=0; i--) {
            List<Integer> cur = new ArrayList();

            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] % nums[i] == 0) {
                    if(cur.size() < subsets.get(j).size()) {
                        cur = subsets.get(j);
                    }
                }
            }
            subsets.get(i).addAll(cur);

            if(max.size() < subsets.get(i).size()) max = subsets.get(i);

        }
        return max;
    }
}
