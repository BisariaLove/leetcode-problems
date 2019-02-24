package linkedlist;
/*
 * @author love.bisaria on 23/02/19
 *
 * Problem Description - https://leetcode.com/problems/merge-k-sorted-lists/
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null; // []
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        } );

        //initialize with the head of every list
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }

        ListNode newHead = queue.poll();

        ListNode current = newHead;
        if(current != null && current.next != null) queue.add(current.next); // [[]]

        while(! queue.isEmpty()){

            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if(node.next != null){
                queue.add(node.next);
            }

        }

        return newHead;
    }

    public void printList(ListNode head){
        ListNode current = head;

        while(current != null){
            System.out.println(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args){

        ListNode[] lists = new ListNode[3];

        ListNode head1 = new ListNode(1);
        ListNode current = head1;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = null;

        lists[0] = head1;

        ListNode head2 = new ListNode(1);
        current = head2;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);
        current = current.next;
        current.next = null;

        lists[1] = head2;

        ListNode head3 = new ListNode(2);
        current = head3;
        current.next = new ListNode(6);
        current = current.next;
        current.next = null;

        lists[2] = head3;

        MergeKLists object = new MergeKLists();


        ListNode mergedListHead = object.mergeKLists(lists);
        object.printList(mergedListHead);
    }
}
