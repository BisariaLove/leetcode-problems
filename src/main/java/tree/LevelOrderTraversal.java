package tree;
/*
 * @author love.bisaria on 25/02/19
 *
 * Problem Description - https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();
        levelOrderRecursive(root, 0, result);

        return result;
    }


    public void levelOrderRecursive(TreeNode node, int level, List<List<Integer>> result){

        if(level >= result.size()){
            result.add(level, new ArrayList());
        }

        List<Integer> lis = result.get(level);

        lis.add(node.val);

        if(node.left != null){
            levelOrderRecursive(node.left, level+1, result);
        }

        if(node.right != null){
            levelOrderRecursive(node.right, level+1, result);
        }


        return;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        TreeNode current = root.right;
        current.left = new TreeNode(15);
        current.right = new TreeNode(7);


        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> result = traversal.levelOrder(root);

        System.out.println("Result : " + result);
    }
}

