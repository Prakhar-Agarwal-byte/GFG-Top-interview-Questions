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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode();
        ListNode cur = head;
        int len = 1;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + cur.val;
            cur.val = sum % 10;
            int carry = sum / 10;
            cur.next = new ListNode(carry);
            len++;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int sum = cur1.val + cur.val;
            cur.val = sum % 10;
            int carry = sum / 10;
            cur.next = new ListNode(carry);
            len++;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int sum = cur2.val + cur.val;
            cur.val = sum % 10;
            int carry = sum / 10;
            cur.next = new ListNode(carry);
            len++;
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (len > 1 && cur.val == 0) {
            cur = head;
            while (cur.next.next != null) cur = cur.next;
            cur.next = null;
        }
        return head;
    }
}
