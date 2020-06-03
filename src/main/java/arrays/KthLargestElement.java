package arrays;

import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-an-array

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue() ;

        for(int num : nums) {
            queue.add(num);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }
}
