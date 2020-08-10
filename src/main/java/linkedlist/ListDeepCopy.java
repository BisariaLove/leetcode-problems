package linkedlist;

//https://leetcode.com/problems/copy-list-with-random-pointer/
import java.util.*;

public class ListDeepCopy {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node random, Node next) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    class Solution {

        Map<Node, Node> visited = new HashMap();

        public Node getClonedNode(Node node) {

            if(node != null) {
                if(! this.visited.containsKey(node)) {
                    this.visited.put(node, new Node(node.val, null, null));
                }

                return this.visited.get(node);
            }

            return null;
        }

        public Node copyRandomList(Node head) {

            if(head == null) return null;

            Node oldNode = head;

            Node newNode = new Node(oldNode.val);
            this.visited.put(oldNode, newNode);

            while(oldNode != null) {
                newNode.random = this.getClonedNode(oldNode.random);
                newNode.next = this.getClonedNode(oldNode.next);

                oldNode = oldNode.next;
                newNode = newNode.next;
            }

            return this.visited.get(head);
        }
    }
}
