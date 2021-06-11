import java.util.ArrayList;

class Solution {
    public ArrayList<String> permutation(String S) {
        ArrayList<String> list = new ArrayList<>();
        backtrack("", S, list);
        return list;
    }

    private void backtrack(String temp, String S, ArrayList<String> list) {
        if (temp.length() == S.length()) {
            list.add(temp);
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (temp.contains(String.valueOf(S.charAt(i)))) continue;
            temp += S.charAt(i);
            backtrack(temp, S, list);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
