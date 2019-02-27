package tree;
/*
 * @author love.bisaria on 26/02/19
 *
 * Program Description - https://leetcode.com/problems/balanced-binary-tree/
 */

public class CheckBalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return maxDepth(root)!=-1;
    }

    public int maxDepth(TreeNode node){
        if(node == null) return 0;

        int L = maxDepth(node.left);
        if(L == -1) return -1;
        int R = maxDepth(node.right);
        if(R==-1) return -1;

        return (Math.abs(R-L) <= 1) ? Math.max(R,L) + 1 : -1;
    }
}
