class Solution {
  public static void removeLoop(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        break;
    }
    if (slow == fast) {
      slow = head;
      if (slow != fast) {
        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }
        fast.next = null;
      } else {
        while (fast.next != slow) {
          fast = fast.next;
        }
        fast.next = null;
      }
    }
  }
}
