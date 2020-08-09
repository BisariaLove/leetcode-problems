package linkedlist;
//https://leetcode.com/problems/merge-two-sorted-lists

public class Merging2Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        else if(l2 == null) return l1;

        ListNode cur1 = l1;
        ListNode cur2 = l2;


        ListNode newHead = null, current = null, node = null;

        if(cur1.val > cur2.val) {
            newHead = cur2;
            current = newHead;
            cur2 = cur2.next;
        } else {
            newHead = cur1;
            current = cur1;

            cur1 = cur1.next;
        }



        while(cur1 != null && cur2 != null) {

            if(cur1.val > cur2.val){
                node = cur2;
                cur2 = cur2.next;

            } else {
                node = cur1;
                cur1 = cur1.next;
            }

            current.next = node;
            current = current.next;
        }

        if(cur1 != null) current.next = cur1;
        else if(cur2 != null) current.next = cur2;

        return newHead;
    }
}
