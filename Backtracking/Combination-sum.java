import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(new ArrayList<>(), list, candidates, target, 0, 0);
        return list;
    }
    private void backtrack(List<Integer> tempList, List<List<Integer>> list, int[] candidates, int target, int curSum,int start) {
        if (curSum == target) {
            list.add((new ArrayList<>(tempList)));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] + curSum <= target) {
                    tempList.add(candidates[i]);
                    backtrack(tempList, list, candidates, target, curSum + candidates[i], i);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
