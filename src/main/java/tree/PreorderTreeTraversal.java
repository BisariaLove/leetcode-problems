package tree;
/*
 * @author love.bisaria on 24/02/19
 *
 * Problem Description - https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTreeTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null){
            return new ArrayList();
        }

        List<Integer> list = new ArrayList();

        Stack<TreeNode> stack = new Stack();

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode current = stack.pop();

            while(current != null){
                list.add(current.val);

                current = current.left;

                if(current != null) stack.push(current);
            }

            if(!stack.isEmpty()) current = stack.pop();

            if(current != null && current.right != null){
                stack.push(current.right);
            }

        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
