package tree;
/*
 * @author love.bisaria on 25/02/19
 *
 *
 */

public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }
}
