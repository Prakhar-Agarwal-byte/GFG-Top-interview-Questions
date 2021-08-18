class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode temp = head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      temp = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    temp.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(slow);
    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode d = new ListNode();
    ListNode cur = d;
    while (left != null && right != null) {
      if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }
    if (left == null)
      cur.next = right;
    else
      cur.next = left;
    return d.next;
  }
}
