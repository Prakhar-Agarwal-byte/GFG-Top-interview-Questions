public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    int count = 0;
    ListNode cur = head;
    while (cur != null && count < k) {
      count++;
      cur = cur.next;
    }
    if (count < k)
      return head;
    count = 0;
    cur = head;
    ListNode prev = null, next = null;
    while (cur != null && count < k) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
      count++;
    }
    ListNode t = reverseKGroup(next, k);
    head.next = t;
    return prev;
  }
}
