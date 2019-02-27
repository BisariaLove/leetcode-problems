package tree;
/*
 * @author love.bisaria on 26/02/19
 *
 * Program Description - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrToBST(nums, 0, nums.length -1);
    }

    public TreeNode arrToBST(int[] nums, int start, int end){
        if(start>end) return null;

        int mid = (start +  end)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrToBST(nums, start, mid-1);
        root.right = arrToBST(nums, mid+1, end);

        return root;
    }
}
