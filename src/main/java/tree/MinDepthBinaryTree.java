package tree;
/*
 * @author love.bisaria on 25/02/19
 *
 * Problem Description - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null) return minDepth(root.right) + 1;
        else if(root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}
