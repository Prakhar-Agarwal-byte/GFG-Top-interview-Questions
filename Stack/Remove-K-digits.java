import java.util.Stack;

class Solution {
  public String removeKdigits(String num, int k) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> st = new Stack<>();
    int count = 0;
    for (char ch : num.toCharArray()) {
      int dig = ch - '0';
      while (count < k && !st.isEmpty() && st.peek() > dig) {
        st.pop();
        count++;
      }
      if (!st.isEmpty() || dig != 0) {
        st.push(dig);
      }
    }
    while (!st.isEmpty() && count < k) {
      st.pop();
      count++;
      ;
    }
    if (st.isEmpty())
      return "0";
    while (!st.isEmpty()) {
      sb.insert(0, st.pop());
    }
    return sb.toString();
  }
}
