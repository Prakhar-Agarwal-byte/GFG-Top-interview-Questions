import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        solve(0, s, new ArrayList<>(), list);
        return list;
    }
    private void solve(int index, String org, List<String> tempList, List<List<String>> list) {
        if (index >= org.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < org.length(); i++) {
            if (isPalindrome(org.substring(index, i+1))) {
                tempList.add(org.substring(index, i+1));
                solve(i + 1, org, tempList, list);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
