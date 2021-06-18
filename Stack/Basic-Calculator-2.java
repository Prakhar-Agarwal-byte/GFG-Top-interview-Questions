import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        return solvePostFix(postFix(s));
    }

    private int solvePostFix(List<Object> list) {
        Stack<Integer> st = new Stack();
        for (Object o : list) {
            if (o instanceof Integer) {
                st.push((Integer) o);
            } else {
                char ch = (Character) o;
                int b = st.pop();
                int a = st.pop();
                if (ch == '+') {
                    st.push(a + b);
                } else if (ch == '-') {
                    st.push(a - b);
                } else if (ch == '*') {
                    st.push(a * b);
                } else if (ch == '/') {
                    st.push(a / b);
                }
            }
        }
        return st.pop();
    }

    private List<Object> postFix(String s) {
        List<Object> list = new ArrayList();
        Stack<Character> st = new Stack();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                list.add(num);
                num = 0;
                while (!st.isEmpty() && prec(st.peek()) >= prec(ch)) {
                    list.add(st.pop());
                }
                st.push(ch);
            }
        }
        list.add(num);
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        return list;
    }

    private int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
