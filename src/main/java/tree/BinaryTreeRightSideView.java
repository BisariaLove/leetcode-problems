package tree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-right-side-view

public class BinaryTreeRightSideView {

    //Last node of every level
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList();

        if(root  == null) return result;

        Queue<List<TreeNode>> queue = new LinkedList();

        List<TreeNode> lis = new ArrayList() {{ add(root); }};

        queue.offer(lis);

        while(!queue.isEmpty()) {
            lis = queue.poll();

            List<TreeNode> cur = new ArrayList();
            int len = lis.size();

            for(int i=0; i<len; i++) {
                TreeNode node = lis.get(i);

                if(node.left != null) cur.add(node.left);
                if(node.right != null) cur.add(node.right);

                if(i == len-1) {
                    result.add(node.val);
                }
            }

            if(cur.size() >0) queue.offer(cur);
        }

        return result;
    }
}
