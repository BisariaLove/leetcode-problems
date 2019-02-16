package linkedlist;
/*
 * @author love.bisaria on 16/02/19
 *
 * Problem Description - https://leetcode.com/problems/reverse-linked-list/
 *
 */

public class LinkedListReverse {

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while(current != null){

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        return previous;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}