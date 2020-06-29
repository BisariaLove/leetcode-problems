package tree;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
import java.util.*;


public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        Queue<NodeNumber> queue = new LinkedList();

        queue.add(new NodeNumber(root, root.val));
        queue.add(new NodeNumber(null, -1));

        while(queue.size() > 0) {
            NodeNumber cur = queue.remove();

            if(cur.curNum == -1) {
                if(queue.size() > 0) queue.add(new NodeNumber(null, -1));
            } else {

                if(cur.node.left == null && cur.node.right == null) {
                    sum += cur.curNum;
                    continue;
                }

                if(cur.node.left != null) {
                    queue.add(new NodeNumber(cur.node.left, cur.curNum* 10 + cur.node.left.val));
                }

                if(cur.node.right != null) {
                    queue.add(new NodeNumber(cur.node.right, cur.curNum * 10 + cur.node.right.val));
                }
            }

        }

        return sum;
    }
}

class NodeNumber {

    TreeNode node;
    int curNum;

    public NodeNumber(TreeNode node, int curNum) {

        this.node = node;
        this.curNum = curNum;
    }
}