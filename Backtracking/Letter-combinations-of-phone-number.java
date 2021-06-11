import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(0, "", digits, list, map);
        return list;
    }

    private void backtrack(int start, String temp, String digits, List<String> list, HashMap<Character, String> map) {
        if (temp.length() == digits.length()) {
            list.add(temp);
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            for (char ch: map.get(digits.charAt(i)).toCharArray()) {
                temp += ch;
                backtrack(i+1, temp, digits, list, map);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }
}
