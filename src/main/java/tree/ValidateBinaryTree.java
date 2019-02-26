package tree;
/*
 * @author love.bisaria on 24/02/19
 *
 * Problem Description - https://leetcode.com/problems/validate-binary-search-tree/
 */

public class ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {
        return valid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean valid(TreeNode node, Double low, Double max){

        if(node == null) return true;
        return (node.val > low)
                && (node.val < max)
                && valid(node.left, low, new Double(node.val))
                && valid(node.right, new Double(node.val), max);
    }
}
