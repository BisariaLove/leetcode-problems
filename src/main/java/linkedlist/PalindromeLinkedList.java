package linkedlist;
/*
 * @author love.bisaria on 16/02/19
 *
 * Problem Description - https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;

        ListNode mid = getMidOfList(head);

        ListNode newHead = reverseList(mid.next);
        ListNode current = head;

        while(newHead != null){
            if(newHead.val != current.val){
                return false;
            }

            newHead = newHead.next;
            current = current.next;
        }

        return true;

    }

    private ListNode getMidOfList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head){

        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while(current!=null){

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
