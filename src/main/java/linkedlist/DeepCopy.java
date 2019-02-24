package linkedlist;
/*
 * @author love.bisaria on 23/02/19
 *
 * Program Description - https://leetcode.com/problems/copy-list-with-random-pointer/
 */

public class DeepCopy {

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node p = head;

        //create copy nodes and intsert them in the list
        while(p!= null){
            Node copy = copyNode(p);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        //set the randome pointers
        p=head;
        while(p!=null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        //separate the lists
        p = head;
        Node newHead = (p!=null) ? p.next: null;

        while(p != null){
            Node copy = p.next;
            p.next = copy.next;
            p = p.next;

            copy.next = (p!=null) ? p.next: null;
        }

        return newHead;
    }


    public Node copyNode(Node node){
        Node copy = new Node();
        copy.val = node.val;

        return copy;
    }


}
