import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> st;
    int count;
    ArrayList<Integer> list;

    public StockSpanner() {
        st = new Stack<>();
        count = 0;
        list = new ArrayList<>();
    }

    public int next(int price) {
        while (!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
        }
        int res = 0;
        if (st.isEmpty()) res = count;
        else res = count - st.peek();
        
        st.push(count);
        list.add(count, price);
        count++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
