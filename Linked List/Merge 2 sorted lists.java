class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode cur = head;
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    while (cur1 != null && cur2 != null) {
      if (cur1.val < cur2.val) {
        cur.next = cur1;
        cur1 = cur1.next;
      } else {
        cur.next = cur2;
        cur2 = cur2.next;
      }
      cur = cur.next;
    }
    while (cur1 != null) {
      cur.next = cur1;
      cur1 = cur1.next;
      cur = cur.next;
    }
    while (cur2 != null) {
      cur.next = cur2;
      cur2 = cur2.next;
      cur = cur.next;
    }
    return head.next;
  }
}
