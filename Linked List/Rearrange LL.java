class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode oddH = head;
    ListNode evenH = head.next;
    ListNode oddCur = oddH;
    ListNode evenCur = evenH;
    while (oddCur != null && evenCur != null) {
      oddCur.next = evenCur.next;
      if (oddCur.next == null) break;
      oddCur = oddCur.next;
      evenCur.next = oddCur.next;
      evenCur = evenCur.next;
    }
    oddCur.next = evenH;
    return head;
  }
}
