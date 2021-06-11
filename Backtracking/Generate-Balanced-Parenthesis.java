import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", n, 0, 0);
        return list;
    }
    private void backtrack(List<String> list, String temp, int n, int open, int close) {
        if (temp.length() == n * 2) {
            list.add(temp);
            return;
        }
        // This is the condition for checking if the decision of parenthesis selection is valid or not.
        // I think I will have to remember it only.
        if (open < n) backtrack(list, temp + "(", n, open + 1, close);
        if (close < open) backtrack(list, temp + ")", n, open, close + 1);
    }
}
