public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    int count = 0;
    ListNode cur = head;
    while (cur != null && count < k) {
      cur = cur.next;
      count++;
    }
    if (count == k) {
      cur = reverseKGroup(cur, k);
      while (count-- > 0) {
        ListNode next = head.next;
        head.next = cur;
        cur = head;
        head = next;
      }
      head = cur;
    }
    return head;
  }
}
