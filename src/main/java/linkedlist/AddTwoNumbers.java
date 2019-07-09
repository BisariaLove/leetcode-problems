package linkedlist;

/*
* Problem Description - https://leetcode.com/problems/add-two-numbers/
* */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int carry = 0;

        ListNode h1 = l1;
        ListNode h2 = l2;

        ListNode result = new ListNode(0);
        ListNode h3 = result;

        while(h1 != null && h2 != null){

            sum = h1.val + h2.val + carry;

            h3.next = new ListNode(sum%10);

            carry = sum/10;

            h1 = h1.next;
            h2 = h2.next;
            h3 = h3.next;

        }

        while(h1 != null){

            sum = h1.val + carry;
            h3.next = new ListNode(sum%10);

            carry = sum/10;

            h1 = h1.next;
            h3 = h3.next;

        }

        while(h2 != null){

            sum = h2.val + carry;
            h3.next = new ListNode(sum%10);

            carry = sum/10;

            h2 = h2.next;
            h3 = h3.next;
        }

        if(carry >0) {
            h3.next = new ListNode(carry);
        }

        return result.next;
    }
}
