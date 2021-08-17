/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    Node cur = head;
    while (cur != null) {
      Node dCp = new Node(cur.val);
      Node next = cur.next;
      cur.next = dCp;
      dCp.next = next;
      cur = next;
    }
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    cur = head;
    Node d = new Node(0);
    Node dCur = d;
    while (cur != null) {
      dCur.next = cur.next;
      dCur = dCur.next;
      Node next = cur.next.next;
      cur.next = next;
      cur = next;
    }
    return d.next;
  }
}
