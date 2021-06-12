// The logic here is that if the thief can only be caught by the leftmost police because its the nearest to it. If it is farther than k and is to left then police cannot catch 
//the thief. So we remove it from list. else if the thief is to the right than we have to remove the police so that some other police to the right can catcht the thief.


class Solution {
    static int catchThieves(char arr[], int n, int k) {
        Queue<Integer> thieves = new LinkedList<>();
        Queue<Integer> police = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') police.add(i);
            else thieves.add(i);
        }
        while (!thieves.isEmpty() && !police.isEmpty()) {
            if (Math.abs(thieves.peek() - police.peek()) <= k) {
                count++;
                thieves.poll();
                police.poll();
            } else if (thieves.peek() < police.peek()) {
                thieves.poll();
            } else {
                police.poll();
            }
        }
        return count;
    }
}
