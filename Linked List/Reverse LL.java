/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;  
        
        ListNode curr = head.next;
        head.next = null;
        ListNode prev = head;
        
        while(curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}

// Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        
    }
}
