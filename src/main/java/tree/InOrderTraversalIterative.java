package tree;
/*
 * @author love.bisaria on 25/02/19
 *
 * Problem Description - https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();

        List<Integer> lis = new ArrayList();

        Stack<TreeNode> stack = new Stack();

        TreeNode current = root;

        while(!stack.isEmpty() || current != null){

            while(current!=null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            lis.add(current.val);

            current = current.right;

        }

        return lis;

    }
}
